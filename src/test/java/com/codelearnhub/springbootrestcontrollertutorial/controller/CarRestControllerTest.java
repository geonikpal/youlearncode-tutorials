package com.codelearnhub.springbootrestcontrollertutorial.controller;

import com.codelearnhub.springbootrestcontrollertutorial.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CarRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    @DisplayName("Test getting all cars")
    void getAll() throws Exception {

        var expectedResult = objectMapper.readValue(TestHelper.readFile("/get_all_cars.json"), List.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
                .andExpect(status().isOk()).andReturn();

        var actualResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Test getting car with id 1")
    void getById() throws Exception {
        var expectedResult = objectMapper.readValue(TestHelper.readFile("/get_car_id_1.json"), Car.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars/1"))
                .andExpect(status().isOk()).andReturn();

        var actualResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assertions.assertEquals(expectedResult, actualResult);

    }

    @Test
    @DisplayName("Test getting car with id 4 - does not exist")
    void getByIdNonExistent() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/cars/4"))
                .andExpect(status().isNotFound());

    }

    @Test
    @DisplayName("Update price of car with id 1 to 19000")
    @DirtiesContext
    void update() throws Exception {

        var requestBody = TestHelper.readFile("/update_car_with_id_1_request.json");
        var responseBody = TestHelper.readFile("/update_car_with_id_1_response.json");

        var expectedResult = objectMapper.readValue(responseBody, Car.class);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.put("/cars/1")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andReturn();

        var actualResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Create a new car")
    @DirtiesContext
    void create() throws Exception {
        var requestBody = TestHelper.readFile("/create_lamborghini_gallardo_response.json");
        var responseBody = TestHelper.readFile("/create_lamborghini_gallardo_response.json");

        var expectedResult = objectMapper.readValue(responseBody, Car.class);

        MvcResult mvcResult = mockMvc.perform(
                        MockMvcRequestBuilders.post("/cars")
                                .content(requestBody)
                                .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andExpect(status().isOk())
                .andReturn();

        var actualResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Car.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("Delete an existing car")
    @DirtiesContext
    void deleteAnExistingCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/cars/3"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Get all cars with price between 10000 and 20000 euro")
    void getCarsFilteredByPrice() throws Exception {
        var expectedResult = objectMapper.readValue(TestHelper.readFile("/get_cars_by_price.json"), List.class);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/cars?minPrice=10000&maxPrice=20000"))
                .andExpect(status().isOk()).andReturn();

        var actualResult = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), List.class);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}