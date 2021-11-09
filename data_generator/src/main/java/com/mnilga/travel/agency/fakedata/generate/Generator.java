package com.mnilga.travel.agency.fakedata.generate;


import com.github.javafaker.Faker;

public abstract class Generator<E> {

    protected Faker faker = new Faker();
    public abstract E generate();
}
