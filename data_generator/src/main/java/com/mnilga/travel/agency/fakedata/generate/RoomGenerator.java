package com.mnilga.travel.agency.fakedata.generate;

import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.model.User;

public class RoomGenerator extends Generator<Room> {
    @Override
    public Room generate() {
        Room room = new Room();
        room.setRoomNumber(faker.number().numberBetween(1, 1000));
        room.setRoomType(getRoomType(faker.number().numberBetween(1, 5)));
        room.setPrice(faker.number().randomDouble(0, 20, 5000));
        return room;
    }


    public static Room.RoomType getRoomType(int roomType) {
        switch (roomType) {
            default:
            case 1:
                return Room.RoomType.SINGLE;
            case 2:
                return Room.RoomType.DOUBLE;
            case 3:
                return Room.RoomType.DELUXE;
            case 4:
                return Room.RoomType.FAMILY;
        }
    }
}
