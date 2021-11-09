package com.mnilga.travel.agency.fakedata.generate;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import com.mnilga.travel.agency.application.model.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;

public class UserGenerator extends Generator<User> {

    private static final long TIME = 1631007709L;

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public User generate() {
        User user = new User();
        String email = fakeValuesService.bothify("????##@gmail.com");
        user.setEmail(email);
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setSex(getSex(faker.bool().bool()));
        user.setDateUpdated(LocalDateTime.ofInstant(Instant.ofEpochSecond(faker.number().numberBetween(TIME, Instant.now().getEpochSecond())), ZoneId.systemDefault()));
        return user;
    }

    public static User.Sex getSex(boolean sex) {
        return sex ? User.Sex.MALE : User.Sex.FEMALE;
    }

}

