package com.mnilga.travel.agency.apachebeam;

import org.apache.beam.sdk.transforms.DoFn;

public class SplitWordsFn extends DoFn<String, String[]> {

    public static final String SPLIT_PATTERN = ",";

    @ProcessElement
    public void processElement(@Element String line, OutputReceiver<String[]> outputReceiver) {
        String[] words = line.split(SPLIT_PATTERN);
        outputReceiver.output(words);
    }
}
