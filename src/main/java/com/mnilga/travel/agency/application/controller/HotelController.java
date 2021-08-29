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
@RequestMapping("/hotels")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<HotelDto> create(@RequestBody @Valid Hotel hotel){
        if(hotel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HotelDto createdHotelDto = hotelService.create(hotel);
        return new ResponseEntity<>(createdHotelDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> readById(@PathVariable UUID id){
        if(id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        HotelDto hotelDto = hotelService.readById(id);
        if(hotelDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(hotelDto, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<HotelDto> update(@RequestBody @Valid Hotel hotel){
        if(hotel == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        HotelDto updatedHotel = hotelService.update(hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HotelDto> delete(@PathVariable UUID id){
        HotelDto hotelDto = hotelService.readById(id);
        if(hotelDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        hotelService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> getAllHotels(){
        List<HotelDto> hotelDtoList = hotelService.getAllHotels();
        if(hotelDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotelDtoList, HttpStatus.OK);
    }
}
