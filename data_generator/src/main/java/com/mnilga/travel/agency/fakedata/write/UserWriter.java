package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.User;



public class UserWriter extends Writer<User> {

    private static final String BODY = "('%s', '%s', '%s', '%s', '%s')";

    public UserWriter(){
        file_name = "users.sql";
        header = "INSERT INTO USERS (email, first_name, last_name, sex, date_updated)\nVALUES ";
    }

    @Override
    protected String prepareValue(User user){
        return String.format(BODY, user.getEmail(), user.getFirstName(),
                user.getLastName().replace("'", "''"), user.getSex(), user.getDateUpdated());
    }
}
