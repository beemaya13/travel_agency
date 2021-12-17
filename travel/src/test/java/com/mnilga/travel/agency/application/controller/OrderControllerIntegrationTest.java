package com.mnilga.travel.agency.application.controller;

import com.mnilga.travel.agency.application.dto.OrderDto;
import com.mnilga.travel.agency.application.model.Order;
import com.mnilga.travel.agency.application.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertOrderDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestPropertySource("/application-test.properties")   //or
//@ActiveProfiles("test")
class OrderControllerIntegrationTest {

    private static Order expectedOrder;
    private static OrderDto expectedOrderDto;
    private static final String LOCALHOST = "http://localhost:8081/api/orders/";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

//    @Autowired
//    private OrderServiceImpl orderServiceMock;

    @BeforeAll
    public static void initProcedure() {
        expectedOrder = createOrder();
        expectedOrderDto = createOrderDto();
    }

    @Test
    @org.junit.jupiter.api.Order(1)
    void create() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(LOCALHOST)
                        .content(mapper.writeValueAsString(expectedOrder))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        OrderDto actual = mapper.readValue(jsonResponse, OrderDto.class);

        assertOrderDto(expectedOrderDto, actual);
    }

    @Test
    void readById() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST + ORDER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        OrderDto actual = mapper.readValue(jsonResponse, OrderDto.class);

        assertOrderDto(expectedOrderDto, actual);
    }

    @Test
    void update() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(LOCALHOST)
                        .content(mapper.writeValueAsString(expectedOrder))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        OrderDto actual = mapper.readValue(jsonResponse, OrderDto.class);

        assertOrderDto(expectedOrderDto, actual);
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(LOCALHOST + ORDER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void getAllOrders() throws Exception {

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<OrderDto> orderDtoList = mapper.readValue(jsonResponse,
                mapper.getTypeFactory().constructCollectionType(List.class, OrderDto.class));

        assertFalse(orderDtoList.isEmpty());
        assertEquals(1, orderDtoList.size());
        assertTrue(orderDtoList.contains(expectedOrderDto));
    }
}