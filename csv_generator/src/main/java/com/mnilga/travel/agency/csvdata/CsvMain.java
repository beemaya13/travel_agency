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
    private String location = "travel/src/main/resources/database/R3/csvInput/";

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
}