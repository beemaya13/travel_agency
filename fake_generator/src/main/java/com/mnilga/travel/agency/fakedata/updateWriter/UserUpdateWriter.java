package com.mnilga.travel.agency.fakedata.updateWriter;

import com.mnilga.travel.agency.application.model.User;

public class UserUpdateWriter extends UpdateWriter<User> {

    public UserUpdateWriter() {
        file_name = "relation_update.sql";
        header = "update users\n" +
                "    set role_id    = (SELECT id FROM roles order by random() limit 1),\n" +
                "        address_id = (SELECT id FROM addresses order by random() limit 1)\n" +
                "        WHERE users.role_id is null or users.address_id is null;";
    }
}

