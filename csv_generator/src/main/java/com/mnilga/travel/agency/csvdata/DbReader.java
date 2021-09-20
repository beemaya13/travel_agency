package com.mnilga.travel.agency.csvdata;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;


public class DbReader {

    private Connection connection;

    public DbReader() {
        try {
            connection = ConnectionFactory.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> readTableNames() {
        ArrayList<String> tableNames = new ArrayList<>();
        try {
            DatabaseMetaData dbmd = connection.getMetaData();
            String[] types = {"TABLE"};
            ResultSet rs = dbmd.getTables(null, null, "%", types);
            String tableName;
            while (rs.next()) {
                tableName = rs.getString("TABLE_NAME");
                tableNames.add(tableName);
            }
            tableNames.remove("DATABASECHANGELOG");
            tableNames.remove("DATABASECHANGELOGLOCK");
            tableNames.remove("sys_config");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableNames;
    }

    public void readTablesAndGenerateCsv(ArrayList<String> tableNames, String location, Boolean includeColumnNames) {
        try {
            for (String tableName : tableNames) {
                String pathToWrite = location + "\\" + tableName + ".csv";
                Path path = Paths.get(pathToWrite);
                String query = "select * from " + tableName;
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(query);
                CsvGenerator.writeCsv(path, rs, includeColumnNames);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
