package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.fakedata.model.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public abstract class Writer<E> {

    protected String file_path = "travel/src/main/resources/generatedData/";
    protected String file_name;
    protected String header;

    public void write(List<E> eList){
        Path path = Paths.get(file_path + file_name);
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){
            writer.write(header);

            for (int i = 0; i < eList.size() - 1 ; i++) {
                writer.write(prepareValue(eList.get(i)));
                writer.write(",");
                writer.newLine();
            }
            writer.write(prepareValue(eList.get(eList.size() - 1)) + ";");

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }

    protected abstract String prepareValue(E e);

}
