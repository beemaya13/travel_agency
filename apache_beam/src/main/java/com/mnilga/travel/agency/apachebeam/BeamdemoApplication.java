package com.mnilga.travel.agency.apachebeam;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.TypeDescriptors;

public class BeamdemoApplication {

    public static void main(String[] args) {
        ParserCsvOptions options = PipelineOptionsFactory
                .fromArgs(args)
                .withoutStrictParsing()
                .as(ParserCsvOptions.class);

        Pipeline p = Pipeline.create(options);

        PCollection<String[]> pCollection = p.apply("Reading Text", TextIO.read().from(options.getInputFile()))
                .apply(new SplitWords());

        pCollection.apply("FormatResults", MapElements
                        .into(TypeDescriptors.strings())
                        .via((String[] array) ->
                                array[5] + "," + array[7]))
                .apply("WriteFile", TextIO.write().to(options.getOutputFile()).withSuffix("_name_role.csv"));

        pCollection.apply("FormatResults", MapElements
                        .into(TypeDescriptors.strings())
                        .via((String[] array) ->
                                array[6] + "," + array[4]))
                .apply("WriteFile", TextIO.write().to(options.getOutputFile()).withSuffix("_surname_email.csv"));

        p.run().waitUntilFinish();
    }

}