package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.CityConverterToDto;
import com.mnilga.travel.agency.application.converter.CountryConverterToDto;
import com.mnilga.travel.agency.application.dto.CityDto;
import com.mnilga.travel.agency.application.model.City;
import com.mnilga.travel.agency.application.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertCity;
import static com.mnilga.travel.agency.application.util.AssertUtils.assertCityDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class CityServiceImplTest {
    @Mock
    private CountryServiceImpl countryService;
    @Mock
    private CityRepository cityRepositoryMock;
    @InjectMocks
    private CityServiceImpl cityService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static City expectedCity;
    private static CityDto expectedCityDto;

    {
        CityConverterToDto cityConverterToDto = new CityConverterToDto();
        cityConverterToDto.setCountryConverterToDto(new CountryConverterToDto());
        genericConversionService.addConverter(cityConverterToDto);
        conversionServiceSpy = spy(genericConversionService);
    }

    @BeforeEach
    public  void initProcedure() {
        expectedCity = createCity();
        expectedCityDto = createCityDto();
    }

    @Test
    void readById() {
        when(cityRepositoryMock.findById(CITY_ID)).thenReturn(Optional.of(expectedCity));

        CityDto actualCityDto = cityService.readById(CITY_ID);
        assertCityDto(expectedCityDto, actualCityDto);

        verify(cityRepositoryMock).findById(CITY_ID);
        verifyNoMoreInteractions(cityRepositoryMock);
    }

    @Test
    void findByName() {
        when(cityRepositoryMock.findByName(CITY_NAME)).thenReturn(Optional.of(expectedCity));

        City actualCity = cityService.findByName(CITY_NAME);
        assertCity(expectedCity, actualCity);

        verify(cityRepositoryMock).findByName(CITY_NAME);
        verifyNoMoreInteractions(cityRepositoryMock);
    }
}