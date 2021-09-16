package com.mnilga.travel.agency.fakedata;

import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.fakedata.generate.*;
import com.mnilga.travel.agency.fakedata.updateWriter.AbstractWriter;
import com.mnilga.travel.agency.fakedata.updateWriter.GenerateWriter;
import com.mnilga.travel.agency.fakedata.updateWriter.UpdateWriter;
import com.mnilga.travel.agency.fakedata.updateWriter.UserUpdateWriter;
import com.mnilga.travel.agency.fakedata.write.*;
import liquibase.pro.packaged.U;

import java.util.ArrayList;
import java.util.List;


//todo parse args from command line -> picocli

public class FakeGenerator {
    public static void main(String[] args) {

        Generator generator = null;
        Writer generWriter = null;
        AbstractWriter writer = null;

        if(args.length < 3){
            System.out.println("Insufficient numbers of arguments. Provide <model_name> <number_of_samples> <g|u>");
            System.exit(-1);
        }

        String model = args[0];
        int size = Integer.parseInt(args[1]);
        boolean generate = args[2].equals("g");

        switch (model){
            case "user":
                writer = generate ? new GenerateWriter(new UserGenerator(), new UserWriter()) : new UserUpdateWriter();
                break;
            case "address":
                generator = new AddressGenerator();
                generWriter = new AddressWriter();
                break;
            case "country":
                generator = new CountryGenerator();
                generWriter = new CountryWriter();
                break;
            case "city":
                generator = new CityGenerator();
                generWriter = new CityWriter();
                break;
            case "hotel":
                generator = new HotelGenerator();
                generWriter = new HotelWriter();
                break;
            case "room":
                generator = new RoomGenerator();
                generWriter = new RoomWriter();
                break;
            case "order":
                generator = new OrderGenerator();
                generWriter = new OrderWriter();
                break;
            default:
                System.out.println("Unknown model name: " + args[0]);
                System.exit(-1);
        }
        //generateSql(generator, writer, size);
        //generateUpdatedSql(updateWriter, size);
        if(null != writer){
            writer.write(size);
        }
    }

//    public static  <T, G extends Generator<T>, W extends Writer<T>> void generateSql(G generator, W writer, int count){
//        if(generator != null && writer != null && count>0) {
//            List<T> list = new ArrayList<>(count);
//            for (int i = 0; i < count; i++) {
//                list.add(generator.generate());
//            }
//            writer.write(list);
//        }
//    }
//
//    public static  <T, W extends UpdateWriter<T>> void generateUpdatedSql(W updatedWriter, int count){
//        if(updatedWriter != null && count>0) {
//            updatedWriter.write(count);
//        }
//    }
}




//        UserGenerator userGenerator = new UserGenerator();
//        UserWriter writer = new UserWriter();
//model = "user"
//        GENERATOR generator;
//        Writer writer;
//        switch(model){
//        case "user":  generator = new UserGenerator;  writer = new UserWriter(); break;
//        case "order":  generator = new OrderGenerator
//        }
//        generetor.generate()


