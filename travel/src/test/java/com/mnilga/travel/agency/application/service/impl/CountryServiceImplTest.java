package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.AddressConverterToDto;
import com.mnilga.travel.agency.application.converter.CountryConverterToDto;
import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.dto.CountryDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.model.Country;
import com.mnilga.travel.agency.application.repository.AddressRepository;
import com.mnilga.travel.agency.application.repository.CountryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Optional;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertCountry;
import static com.mnilga.travel.agency.application.util.AssertUtils.assertCountryDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryServiceImplTest {

    @Mock
    private CountryRepository countryRepositoryMock;
    @InjectMocks
    private CountryServiceImpl countryService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Country expectedCountry;
    private static CountryDto expectedCountryDto;

    {
        CountryConverterToDto countryConverterToDto = new CountryConverterToDto();
        genericConversionService.addConverter(countryConverterToDto);
        conversionServiceSpy = spy(genericConversionService);

    }

    @BeforeEach
    public  void initProcedure() {
        expectedCountry = createCountry();
        expectedCountryDto = createCountryDto();
    }

    @Test
    void readById() {
        when(countryRepositoryMock.findById(COUNTRY_ID)).thenReturn(Optional.of(expectedCountry));

        CountryDto actualCountryDto = countryService.readById(COUNTRY_ID);
        assertCountryDto(expectedCountryDto, actualCountryDto);

        verify(countryRepositoryMock).findById(COUNTRY_ID);
        verifyNoMoreInteractions(countryRepositoryMock);

    }

    @Test
    void findByName() {
        when(countryRepositoryMock.findByName(COUNTRY_NAME)).thenReturn(Optional.of(expectedCountry));

        Country actual = countryService.findByName(COUNTRY_NAME);
        assertCountry(expectedCountry, actual);

        verify(countryRepositoryMock).findByName(COUNTRY_NAME);
        verifyNoMoreInteractions(countryRepositoryMock);
    }
}