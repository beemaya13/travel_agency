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
    public ResponseEntity<RoomDto> create(@RequestBody @Valid Room room) {
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RoomDto createdRoomDto = roomService.create(room);
        return new ResponseEntity<>(createdRoomDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> readById(@PathVariable UUID id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        RoomDto roomDto = roomService.readById(id);
        if (roomDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(roomDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<RoomDto> update(@RequestBody @Valid Room room) {
        if (room == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        RoomDto updatedRoom = roomService.update(room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDto> delete(@PathVariable UUID id) {
        RoomDto roomDto = roomService.readById(id);
        if (roomDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        roomService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        List<RoomDto> roomDtoList = roomService.getAllRooms();
        if (roomDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(roomDtoList, HttpStatus.OK);
    }
}
