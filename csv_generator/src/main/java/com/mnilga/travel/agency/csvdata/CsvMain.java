package com.mnilga.travel.agency.csvdata;
import picocli.CommandLine;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

@CommandLine.Command(name = "sectionDemo", description = "Section demo")
public class CsvMain implements Callable<Integer>{

    @CommandLine.Option(names = {"-l", "--location"}, description = "pass path with double quotes")
   // private String location = "./";
    private String location = "travel/src/main/resources/database/R3/csv/";

    @CommandLine.Option(names = {"-c", "--columns"}, description = "include column names in csv?")
    private Boolean includeColumnNames = true;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new CsvMain()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception {
        DbReader dbReader = new DbReader();
        ArrayList<String> tableNames = dbReader.readTableNames();
        dbReader.readTablesAndGenerateCsv(tableNames, location, includeColumnNames);
        return 0;
    }


//    public static void main(String[] args) throws Exception {
//
//        String file_path = "travel/src/main/resources/database/R3/csv/";
//        String file_name;
//        Path path = Paths.get(file_path + file_name);

//        CSVWriter writer = new CSVWriter(new FileWriter("users.csv"));
//        Boolean includeHeaders = true;
//        Statement statement;
//        ResultSet myResultSet;
//        Connection connection;
//        String url = "jdbc:postgresql://localhost:5432/travelagency";
//        String user = "postgres";
//        String password = "root";

//        try {
//            //Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, user, password);
//
//            if (connection != null) {
//
//                statement = connection.createStatement();
//                myResultSet = statement.executeQuery("select * from users;");
//
//                writer.writeAll(myResultSet, includeHeaders);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

//    public void sqlToCSV(Connection connection, String query, String filename) {
//        CSVWriter writer = new CSVWriter(new FileWriter("users.csv"), '\t');
//        Boolean includeHeaders = true;
//        Statement statement;
//        ResultSet myResultSet;

//            FileWriter fw = new FileWriter(filename + ".csv");
//
//            if (conn.isClosed()) st = conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//
//
//    }
//
//    public Connection getConnection() {
//
//        String url = "jdbc:postgresql://localhost:5432/travelagency";
//        String user = "postgres";
//        String password = "root";
//        Statement statement;
//        ResultSet myResultSet;
//        Connection connection = null;
//
//        try {
//            Class.forName("org.postgresql.Driver");
//            connection = DriverManager.getConnection(url, user, password);
//        } catch (SQLException | ClassNotFoundException throwables) {
//            throwables.printStackTrace();
//        }
//        return connection;
//    }
}