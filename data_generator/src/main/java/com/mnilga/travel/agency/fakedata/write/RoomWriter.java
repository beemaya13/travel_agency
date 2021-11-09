package com.mnilga.travel.agency.fakedata.write;

import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.model.User;

public class RoomWriter extends Writer<Room>{

    private static final String BODY = "('%s', '%s', '%s')";

    public RoomWriter(){
        file_name = "rooms.sql";
        header = "INSERT INTO ROOMS (room_number, room_type, price)\nVALUES ";
    }

    @Override
    protected String prepareValue(Room room){
        return String.format(BODY, room.getRoomNumber(), room.getRoomType(), room.getPrice());
    }
}
