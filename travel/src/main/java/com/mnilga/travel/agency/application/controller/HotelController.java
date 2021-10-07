package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid Hotel hotel) {
        if (hotel == null) {
            return new ResponseEntity<>("Hotel can't be null", HttpStatus.BAD_REQUEST);
        }
        HotelDto createdHotelDto;
        try {
            createdHotelDto = hotelService.create(hotel);
        } catch (Exception e) {
            return new ResponseEntity<>("Hotel with such name already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createdHotelDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable UUID id) {
        if (id == null) {
            return new ResponseEntity<>("Hotel can't be null", HttpStatus.BAD_REQUEST);
        }

        HotelDto hotelDto = hotelService.readById(id);
        if (hotelDto == null) {
            return new ResponseEntity<>("Hotel with such id not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Hotel hotel) {
        if (hotel == null) {
            return new ResponseEntity<>("Hotel can't be null", HttpStatus.BAD_REQUEST);
        }
        HotelDto updatedHotel;
        try {
            updatedHotel = hotelService.update(hotel);
        } catch (Exception e) {
            return new ResponseEntity<>("Hotel with such name already exists!", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        try {
            hotelService.readById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Hotel with such id not found!", HttpStatus.NOT_FOUND);
        }
        hotelService.delete(id);
        return new ResponseEntity<>("Hotel is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllHotels() {
        List<HotelDto> hotelDtoList = hotelService.getAllHotels();
        if (hotelDtoList.isEmpty()) {
            return new ResponseEntity<>("There are no hotels to display!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotelDtoList, HttpStatus.OK);
    }
}
