package com.mnilga.travel.agency.application.controller;


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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;
import java.util.Map;

import static com.mnilga.travel.agency.application.util.AssertUtils.assertUserDto;
import static com.mnilga.travel.agency.application.util.TestDataFactory.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
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
    void getAllUsers() throws Exception { //method read
        List<UserDto> users = List.of(expectedUserDto);
        when(userServiceMock.getAllUsers()).thenReturn(users);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(LOCALHOST)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        List<UserDto> userDtoList = mapper.readValue(jsonResponse,
                mapper.getTypeFactory().constructCollectionType(List.class, UserDto.class));

        assertFalse(userDtoList.isEmpty());
        assertEquals(1, userDtoList.size());
        assertTrue(userDtoList.contains(expectedUserDto));
    }

    @Test
    void patch() throws Exception {
        Map<String, Object> patchedFields = createUserPatchFields();
        String patchedName = "patched_first_name";
        String patchedEmail = "patched_email";
        expectedUserDto.setFirstName(patchedName);
        expectedUserDto.setEmail(patchedEmail);

        when(userServiceMock.patch(patchedFields, USER_ID)).thenReturn(expectedUserDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.patch(LOCALHOST + USER_ID)
                        .content(mapper.writeValueAsString(patchedFields))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        UserDto actual = mapper.readValue(jsonResponse, UserDto.class);

        assertUserDto(expectedUserDto, actual);
        assertEquals(patchedFields.get("first_name"), actual.getFirstName());
        assertEquals(patchedFields.get("email"), actual.getEmail());
    }
}