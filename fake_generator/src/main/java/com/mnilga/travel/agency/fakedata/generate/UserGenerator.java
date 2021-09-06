package com.mnilga.travel.agency.fakedata.generate;

//import travel.src.main.java/com/mnilga/travel/agency/application/dto/UserDto.java

import com.mnilga.travel.agency.fakedata.model.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class UserGenerator extends Generator<User> {

    private static final long TIME = 1L;

    public User generate () {
        User user = new User();
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setDateUpdated(LocalDateTime.ofInstant(Instant.ofEpochSecond(faker.number().numberBetween(TIME, Instant.now().getEpochSecond())), ZoneId.systemDefault()));
        user.setSex(getSex(faker.bool().bool()));
        return user;
    }

    public static User.Sex getSex(boolean sex){
        return sex ? User.Sex.MALE :  User.Sex.FEMALE;
    }

}

