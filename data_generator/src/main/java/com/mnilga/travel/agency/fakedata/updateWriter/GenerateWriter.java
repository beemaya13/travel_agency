package com.mnilga.travel.agency.fakedata.updateWriter;


import com.mnilga.travel.agency.fakedata.generate.Generator;
import com.mnilga.travel.agency.fakedata.write.Writer;

import java.util.ArrayList;
import java.util.List;

public class GenerateWriter<E> implements AbstractWriter{

    Generator<E> m_generator = null;
    Writer<E> m_writer = null;
    public GenerateWriter(Generator generator, Writer writer){

        m_generator = generator;
        m_writer = writer;
    }

    @Override
    public void write(int count) {
        List<E> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(m_generator.generate());
        }
        m_writer.write(list);

    }
}
