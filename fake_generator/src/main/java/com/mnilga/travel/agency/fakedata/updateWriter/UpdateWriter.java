package com.mnilga.travel.agency.fakedata.updateWriter;

import com.mnilga.travel.agency.application.model.User;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class UpdateWriter<E> implements AbstractWriter{

    protected String file_path = "travel/src/main/resources/database/R3/updatedData/";
    protected String file_name;
    protected String header;

    public void write(int count){
        Path path = Paths.get(file_path + file_name);
        try(BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)){

            for (int i = 0; i < count; i++) {
                writer.write(header);
                writer.newLine();
                writer.newLine();
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }
    }
}


