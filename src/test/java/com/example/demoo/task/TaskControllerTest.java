package com.example.demoo.task;

import com.example.demoo.DemooApplication;
import com.example.demoo.dtos.AccountDto;
import com.example.demoo.dtos.TaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = DemooApplication.class
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TaskControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql("/AddTestData.sql")
    void shouldGetAllTasks() throws Exception {

        var result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].taskid").value(1))
                .andExpect(jsonPath("$[1].taskid").value(2))
                .andReturn();
    }

    @Test
    @Sql("/AddTestData.sql")
    void shouldCreateTaskWithId3() throws Exception {

        AccountDto dto = new AccountDto(1, "testaccount2", "test2", LocalDate.ofEpochDay(2022-05-28), "testaccount2@gmail.com");
        TaskDto taskToCreate = new TaskDto("TestTask1", "testdiscription1", false, LocalDate.ofEpochDay(2022-05-28), dto);
        // 2022-05-28

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        var result = mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/task/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskToCreate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        Integer expected3 = JsonPath.read(result.getResponse().getContentAsString(),"$.id");

        assertThat(expected3).isEqualTo(3);
    }

    @Test
    @Sql("/AddTestData.sql")
    public void shouldDeleteTask() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/task/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].taskid").doesNotExist())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].taskid").value(2))
                .andReturn();
    }


    @Test
    @Sql("/AddTestData.sql")
    void shouldUpdateTask() throws Exception {

        AccountDto dto = new AccountDto(1, "testaccount2", "test2", LocalDate.ofEpochDay(2022-05-28), "testaccount2@gmail.com");
        TaskDto taskToUpdate = new TaskDto(2,"TestTask1updated", "testdiscription1", false, LocalDate.ofEpochDay(2022-05-28), dto);
        // 2022-05-28

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

                mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/task/2")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(taskToUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[1].title").value("TestTask1updated"))
                .andReturn();

    }


    @Test
    @Sql("/AddTestData.sql")
    void shouldSelectTaskById() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/task/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taskid").value(2))
                .andExpect(jsonPath("$.title").value("7777"))
                .andReturn();

    }
}