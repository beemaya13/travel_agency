package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.CityConverterToDto;
import com.mnilga.travel.agency.application.converter.CountryConverterToDto;
import com.mnilga.travel.agency.application.converter.HotelConverterToDto;
import com.mnilga.travel.agency.application.dto.HotelDto;
import com.mnilga.travel.agency.application.model.Hotel;
import com.mnilga.travel.agency.application.repository.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.List;
import java.util.Optional;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertHotel;
import static com.mnilga.travel.agency.application.util.AssertUtils.assertHotelDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {
    @Mock
    private HotelRepository hotelRepositoryMock;
    @Mock
    private CityServiceImpl cityServiceMock;
    @InjectMocks
    private HotelServiceImpl hotelService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Hotel expectedHotel;
    private static HotelDto expectedHotelDto;

    {
        CityConverterToDto cityConverterToDto = new CityConverterToDto();
        cityConverterToDto.setCountryConverterToDto(new CountryConverterToDto());

        HotelConverterToDto hotelConverterToDto = new HotelConverterToDto();
        hotelConverterToDto.setCityConverterToDto(cityConverterToDto);

        genericConversionService.addConverter(hotelConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
    }

    @BeforeEach
    public  void initProcedure() {
        expectedHotel = createHotel();
        expectedHotelDto = createHotelDto();
    }


    @Test
    void createTest() {
        when(cityServiceMock.findByName(CITY_NAME)).thenReturn(createCity());
        when(hotelRepositoryMock.save(expectedHotel)).thenReturn(expectedHotel);

        HotelDto actual = hotelService.create(expectedHotel);
        assertHotelDto(expectedHotelDto, actual);

        verify(cityServiceMock).findByName(CITY_NAME);
        verify(hotelRepositoryMock).save(expectedHotel);
        verifyNoMoreInteractions(cityServiceMock, hotelRepositoryMock);

    }

    @Test
    void createShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> hotelService.create(null), "Hotel can't be null");
    }

    @Test
    void readByIdTest() {
        when(hotelRepositoryMock.findById(HOTEL_ID)).thenReturn(Optional.of(expectedHotel));

        HotelDto actual = hotelService.readById(HOTEL_ID);
        assertHotelDto(expectedHotelDto, actual);

        verify(hotelRepositoryMock).findById(HOTEL_ID);
        verifyNoMoreInteractions(hotelRepositoryMock);
    }

    @Test
    void updateTest() {
        InOrder inOrder = inOrder(hotelRepositoryMock, cityServiceMock, hotelRepositoryMock);

        when(hotelRepositoryMock.findByName(HOTEL_NAME)).thenReturn(Optional.ofNullable(expectedHotel));
        when(cityServiceMock.findByName(CITY_NAME)).thenReturn(createCity());
        when(hotelRepositoryMock.save(expectedHotel)).thenReturn(expectedHotel);

        HotelDto actual = hotelService.update(expectedHotel);
        assertHotelDto(expectedHotelDto, actual);

        inOrder.verify(hotelRepositoryMock).findByName(HOTEL_NAME);
        inOrder.verify(cityServiceMock).findByName(CITY_NAME);
        inOrder.verify(hotelRepositoryMock).save(expectedHotel);

        verifyNoMoreInteractions(hotelRepositoryMock, cityServiceMock, hotelRepositoryMock);

    }

    @Test
    void updateShouldThrowExceptionTest() {
        assertThrows(RuntimeException.class, () -> hotelService.update(null), "Hotel can't be null");
    }

    @Test
    void deleteTest() {
        when(hotelRepositoryMock.findById(HOTEL_ID)).thenReturn(Optional.of(expectedHotel));
        hotelService.delete(expectedHotel.getId());

        verify(hotelRepositoryMock).findById(HOTEL_ID);
        verify(hotelRepositoryMock).delete(expectedHotel);
        verifyNoMoreInteractions(hotelRepositoryMock);
    }

    @Test
    void getAllHotelsTest() {
        List<Hotel> hotels = List.of(expectedHotel);
        when(hotelRepositoryMock.findAll()).thenReturn(hotels);

        List<HotelDto> hotelsDtoList = hotelService.getAllHotels();
        assertFalse(hotelsDtoList.isEmpty());
        assertEquals(1, hotelsDtoList.size());

        verify(hotelRepositoryMock).findAll();
        verifyNoMoreInteractions(hotelRepositoryMock);
    }

    @Test
    void findByNameTest() {
        when(hotelRepositoryMock.findByName(HOTEL_NAME)).thenReturn(Optional.of(expectedHotel));

        Hotel actual = hotelService.findByName(HOTEL_NAME);
        assertHotel(expectedHotel, actual);

        verify(hotelRepositoryMock).findByName(HOTEL_NAME);
        verifyNoMoreInteractions(hotelRepositoryMock);
    }

    @Test
    void findHotelByIdTest() {
        when(hotelRepositoryMock.findById(HOTEL_ID)).thenReturn(Optional.of(expectedHotel));

        Hotel actual = hotelService.findHotelById(HOTEL_ID);
        assertHotel(expectedHotel, actual);

        verify(hotelRepositoryMock).findById(HOTEL_ID);
        verifyNoMoreInteractions(hotelRepositoryMock);
    }
}