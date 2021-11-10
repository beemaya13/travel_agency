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
        HotelDto createdHotelDto = hotelService.create(hotel);
        return new ResponseEntity<>(createdHotelDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> readById(@PathVariable UUID id) {
        HotelDto hotelDto = hotelService.readById(id);
        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid Hotel hotel) {
        HotelDto updatedHotel = hotelService.update(hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        hotelService.delete(id);
        return new ResponseEntity<>("Hotel is successfully deleted!", HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllHotels() {
        List<HotelDto> hotelDtoList = hotelService.getAllHotels();
        return new ResponseEntity<>(hotelDtoList, HttpStatus.OK);
    }
}
