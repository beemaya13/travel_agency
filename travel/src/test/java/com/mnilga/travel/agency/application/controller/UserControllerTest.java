package com.mnilga.travel.agency.application.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
import com.mnilga.travel.agency.application.repository.UserRepository;
import com.mnilga.travel.agency.application.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import java.util.Optional;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertUserDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
//@TestPropertySource("/application-test.properties")   don't need for these tests
class UserControllerTest {
    private static User expectedUser;
    private static UserDto expectedUserDto;
    private static final String LOCALHOST = "http://localhost:8081/api/users/";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private UserServiceImpl userServiceMock;

    @BeforeAll
    public static void initProcedure() {
        expectedUser = createUser();
        expectedUserDto = createUserDto();
    }

    @Test
    void create() throws Exception {
        when(userServiceMock.create(expectedUser))
                .thenReturn(expectedUserDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(LOCALHOST)
                .content(mapper.writeValueAsString(expectedUser))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserDto actual = mapper.readValue(jsonResponse, UserDto.class);

        assertUserDto(expectedUserDto, actual);
    }

    @Test
    void readById() throws Exception {
        when(userServiceMock.readById(USER_ID)).thenReturn(expectedUserDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST + USER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserDto actual = mapper.readValue(jsonResponse, UserDto.class);

        assertUserDto(expectedUserDto, actual);
    }

    @Test
    void update() throws Exception {
        when(userServiceMock.update(expectedUser))
                .thenReturn(expectedUserDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.put(LOCALHOST)
                        .content(mapper.writeValueAsString(expectedUser))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserDto actual = mapper.readValue(jsonResponse, UserDto.class);

        assertUserDto(expectedUserDto, actual);
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(LOCALHOST + USER_ID)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();
    }

    @Test
    void getAllUsers() { //method read
        List<UserDto> list = List.of(expectedUserDto);
    }

    @Test
    void patch() {
    }
}