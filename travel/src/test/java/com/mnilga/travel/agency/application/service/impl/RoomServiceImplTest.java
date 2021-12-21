package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.CityConverterToDto;
import com.mnilga.travel.agency.application.converter.CountryConverterToDto;
import com.mnilga.travel.agency.application.converter.HotelConverterToDto;
import com.mnilga.travel.agency.application.converter.RoomConverterToDto;
import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.dto.RoomDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.model.Room;
import com.mnilga.travel.agency.application.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertHotelDto;
import static com.mnilga.travel.agency.application.util.AssertUtils.assertRoomDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomServiceImplTest {
    @Mock
    private RoomRepository roomRepositoryMock;
    @Mock
    private HotelServiceImpl hotelServiceMock;
    @InjectMocks
    private RoomServiceImpl roomService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Room expectedRoom;
    private static RoomDto expectedRoomDto;

    {
        CityConverterToDto cityConverterToDto = new CityConverterToDto();
        cityConverterToDto.setCountryConverterToDto(new CountryConverterToDto());

        HotelConverterToDto hotelConverterToDto = new HotelConverterToDto();
        hotelConverterToDto.setCityConverterToDto(cityConverterToDto);

        RoomConverterToDto roomConverterToDto = new RoomConverterToDto();
        roomConverterToDto.setHotelConverterToDto(hotelConverterToDto);

        genericConversionService.addConverter(roomConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
    }

    @BeforeEach
    public  void initProcedure() {
        expectedRoom = createRoom();
        expectedRoomDto = createRoomDto();
    }

    @Test
    void createTest() {
        when(hotelServiceMock.findByName(HOTEL_NAME)).thenReturn(createHotel());
        when(roomRepositoryMock.save(expectedRoom)).thenReturn(expectedRoom);

        RoomDto actual = roomService.create(expectedRoom);
        assertRoomDto(expectedRoomDto, actual);

        verify(hotelServiceMock).findByName(HOTEL_NAME);
        verify(roomRepositoryMock).save(expectedRoom);
        verifyNoMoreInteractions(hotelServiceMock, roomRepositoryMock);

    }

    @Test
    void readByIdTest() {
    }

    @Test
    void updateTest() {
    }

    @Test
    void deleteTest() {
    }

    @Test
    void getAllRoomsTest() {
    }

    @Test
    void findRoomByIdTest() {
    }
}