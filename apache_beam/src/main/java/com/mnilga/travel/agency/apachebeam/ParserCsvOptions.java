package com.mnilga.travel.agency.apachebeam;

import org.apache.beam.sdk.options.Default;
import org.apache.beam.sdk.options.Description;
import org.apache.beam.sdk.options.PipelineOptions;

public interface ParserCsvOptions extends PipelineOptions {

    @Description("Path to the input file")
    @Default.String("travel/src/main/resources/database/R3/csvInput/users.csv")
    String getInputFile();
    void setInputFile(String value);

    @Description("Path to the output file")
    @Default.String("travel/src/main/resources/database/R3/csvOutput/users")
    String getOutputFile();
    void setOutputFile(String value);
}