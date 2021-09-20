package com.mnilga.travel.agency.csvdata;
import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CsvGenerator {

    public static void writeCsv(Path path, ResultSet resultSet, Boolean includeColumnNames) {
        CSVWriter csvWriter;
        try {
            csvWriter = new CSVWriter(new FileWriter(path.toString()));
            csvWriter.writeAll(resultSet, includeColumnNames);
            csvWriter.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
