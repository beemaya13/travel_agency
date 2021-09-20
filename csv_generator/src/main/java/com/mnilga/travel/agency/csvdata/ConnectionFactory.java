package com.mnilga.travel.agency.csvdata;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() throws SQLException {

        Connection connection;
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            Properties props = new Properties();
            try (InputStream in = CsvMain.class.getClassLoader().getResourceAsStream("database.properties")) {
                props.load(in);
            }
            String dbHost = props.getProperty("dbHost");
            String dbName = props.getProperty("dbName");
            String dbUrl = dbHost + "/" + dbName;
            String dbUser = props.getProperty("dbUser");
            String dbPassword = props.getProperty("dbPassword");
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage(), e);
        }
        return connection;
    }
}
