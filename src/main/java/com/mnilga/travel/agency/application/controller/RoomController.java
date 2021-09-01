package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private RoomService roomService;

    @Autowired
    public void setRoomService(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Room room) {
        if (room == null) {
            return new ResponseEntity<>("Room can't be null", HttpStatus.BAD_REQUEST);
        }
        RoomDto createdRoomDto;
        try {
            createdRoomDto = roomService.create(room);
        } catch (Exception e) {
            return new ResponseEntity<>("Room with such id already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createdRoomDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable UUID id) {
        if (id == null) {
            return new ResponseEntity<>("Room can't be null", HttpStatus.BAD_REQUEST);
        }

        RoomDto roomDto = roomService.readById(id);
        if (roomDto == null) {
            return new ResponseEntity<>("Room with such id not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Room room) {
        if (room == null) {
            return new ResponseEntity<>("Room can't be null", HttpStatus.BAD_REQUEST);
        }
        RoomDto updatedRoom;
        try {
            updatedRoom = roomService.update(room);
        } catch (Exception e) {
            return new ResponseEntity<>("Room with such id already exists!", HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            roomService.readById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("User with such id not found!", HttpStatus.NOT_FOUND);
        }
        roomService.delete(id);
        return new ResponseEntity<>("Room is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllRooms() {
        List<RoomDto> roomDtoList = roomService.getAllRooms();
        if (roomDtoList.isEmpty()) {
            return new ResponseEntity<>("There are no rooms to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roomDtoList, HttpStatus.OK);
    }
}
