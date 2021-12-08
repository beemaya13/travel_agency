package com.mnilga.travel.agency.application.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mnilga.travel.agency.application.dto.UserDto;
import com.mnilga.travel.agency.application.model.User;
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
@TestPropertySource("/application-test.properties")
class UserControllerTest {

    private static UserDto expectedUserDto;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private UserServiceImpl userServiceMock;

    @BeforeAll
    public static void initProcedure() {
        expectedUserDto = new UserDto();
        expectedUserDto.setId(USER_ID);
        expectedUserDto.setEmail(EMAIL);
        expectedUserDto.setFirstName(FIRST_NAME);
        expectedUserDto.setLastName(LAST_NAME);
        expectedUserDto.setSex(User.Sex.FEMALE.name());
        expectedUserDto.setRoleDto(createRoleDto());
        expectedUserDto.setAddressDto(createAddressDto());
    }

    @Test
    void create() {
    }

    @Test
    void readById() throws Exception {
        when(userServiceMock.readById(USER_ID)).thenReturn(expectedUserDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                .get("http://localhost:8081/api/users/6478eef6-6358-40cb-a0b7-3e6fe372cc1a"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andReturn();

        mapper = new ObjectMapper();
        UserDto actual = mapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<>() {
        });

        assertNotNull(actual);
        assertUserDto(expectedUserDto, actual);
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAllUsers() { //method read
        List<UserDto> list = List.of(expectedUserDto);
    }

    @Test
    void patch() {
    }
}