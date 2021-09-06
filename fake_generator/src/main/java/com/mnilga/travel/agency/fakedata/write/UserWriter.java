package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.fakedata.model.User;


public class UserWriter extends Writer<User> {

    public UserWriter(){
        file_name = "users.sql";
        header = "INSERT INTO USERS (email, first_name, last_name, sex)\nVALUES ";
    }

    private static final String BODY = "('%s', '%s', '%s', '%s')";

    protected String prepareValue(User user){
        return String.format(BODY, user.getEmail(), user.getFirstName(), user.getLastName().replace("'", "''"), user.getSex());
    }
}
