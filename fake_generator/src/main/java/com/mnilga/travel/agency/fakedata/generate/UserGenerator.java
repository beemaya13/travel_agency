package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.User;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserGenerator extends Generator<User> {

    private static final long TIME = 1631007709L;

    public User generate () {
        User user = new User();
        user.setEmail(faker.internet().emailAddress());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setSex(getSex(faker.bool().bool()));
       // user.setDateUpdated(LocalDateTime.ofInstant(Instant.ofEpochSecond(faker.number().numberBetween(TIME, Instant.now().getEpochSecond())), ZoneId.systemDefault()));
        return user;
    }

    public static User.Sex getSex(boolean sex){
        return sex ? User.Sex.MALE :  User.Sex.FEMALE;
    }

}

