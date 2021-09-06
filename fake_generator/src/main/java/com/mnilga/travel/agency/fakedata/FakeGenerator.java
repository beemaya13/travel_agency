package com.mnilga.travel.agency.fakedata;

import com.mnilga.travel.agency.fakedata.generate.Generator;
import com.mnilga.travel.agency.fakedata.generate.UserGenerator;
import com.mnilga.travel.agency.fakedata.model.User;
import com.mnilga.travel.agency.fakedata.write.UserWriter;
import com.mnilga.travel.agency.fakedata.write.Writer;

import java.util.ArrayList;
import java.util.List;


//todo parse args from command line -> picocli

public class FakeGenerator {
    public static void main(String[] args) {
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


        Generator generator = null;
        Writer writer = null;

        if(args.length < 2){
            System.out.println("Insufficient numbers of arguments. Provide <model_name> <number_of_samples>");
            System.exit(-1);
        }

        String model = args[0];
        int size = Integer.parseInt(args[1]);

        switch (model){
            case "user":
                generator = new UserGenerator();
                writer = new UserWriter();
                break;
//            case "address":
//                generator = new AddressGenerator();
//                writer = new AddressWriter();
//                break;
//            case "country":
//                generator = new CountryGenerator();
//                writer = new CountryWriter();
//                break;
//            case "city":
//                generator = new CityGenerator();
//                writer = new CityWriter();
//                break;
//            case "hotel":
//                generator = new HotelGenerator();
//                writer = new HotelWriter();
//                break;
//            case "room":
//                generator = new RoomGenerator();
//                writer = new RoomWriter();
//                break;
//            case "order":
//                generator = new OrderGenerator();
//                writer = new OrderWriter();
//                break;
            default:
                System.out.println("Unknown model name: " + args[0]);
                System.exit(-1);
        }
        generateSql(generator, writer, size);
    }

    //public static  <T> void generateSql(Generator<T> generator, Writer<T> writer, int count)
    public static  <T, G extends Generator<T>, W extends Writer<T>> void generateSql(G generator, W writer, int count){
        if(generator != null && writer != null && count>0) {
            List<T> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(generator.generate());
            }
            writer.write(list);
        }
    }
}
