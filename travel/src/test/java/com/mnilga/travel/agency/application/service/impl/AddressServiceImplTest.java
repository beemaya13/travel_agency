package com.mnilga.travel.agency.application.service.impl;

import com.mnilga.travel.agency.application.converter.AddressConverterToDto;
import com.mnilga.travel.agency.application.dto.AddressDto;
import com.mnilga.travel.agency.application.model.Address;
import com.mnilga.travel.agency.application.repository.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import java.util.Optional;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertAddress;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {

    @Mock
    private AddressRepository addressRepositoryMock;
    @InjectMocks
    private AddressServiceImpl addressService;

    private GenericConversionService genericConversionService = new GenericConversionService();
    private ConversionService conversionServiceSpy;
    private static Address expectedAddress;
    private static AddressDto expectedAddressDto;

    {
        AddressConverterToDto addressConverterToDto = new AddressConverterToDto();
        genericConversionService.addConverter(addressConverterToDto);
        conversionServiceSpy = spy(genericConversionService);

    }

    @BeforeEach
    public  void initProcedure() {
        expectedAddress = createAddress();
        expectedAddressDto = createAddressDto();
    }

    @Test
    void findByIdTest() {
        when(addressRepositoryMock.findById(ADDRESS_ID)).thenReturn(Optional.ofNullable(expectedAddress));

        Address actualAddress = addressService.findById(ADDRESS_ID);
        assertAddress(expectedAddress, actualAddress);

        verify(addressRepositoryMock).findById(ADDRESS_ID);
        verifyNoMoreInteractions(addressRepositoryMock);

    }
}