package com.challengeoh.EmployeeMicroservice.controller;

import com.challengeoh.EmployeeMicroservice.EmployeeMicroserviceApplication;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = EmployeeMicroserviceApplication.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeControllerTest {

    private String url;
    private String documentId;
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setUp() {
        this.url = "/api/employees";
        this.documentId = "74737699";
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void shouldTestAStore() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post(this.url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"documentId\": "+ this.documentId +"," +
                                " \"firstName\": \"Esteban\", " +
                                "\"lastName\": \"Castillo\", " +
                                "\"age\": \"22\", " +
                                "\"dateOfBirth\": \"1999-05-12\", " +
                                "\"salary\": \"3500\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.documentId").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.dateOfBirth").exists())
                .andExpect(jsonPath("$.salary").exists())
                .andReturn();

    }

    @Test
    public void shouldTestBUpdate() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.put(this.url + "/" + this.documentId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"documentId\": "+ this.documentId +"," +
                                " \"firstName\": \"Esteban\", " +
                                "\"lastName\": \"Castillo\", " +
                                "\"age\": \"25\", " +
                                "\"dateOfBirth\": \"1999-05-12\", " +
                                "\"salary\": \"4500\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.documentId").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.dateOfBirth").exists())
                .andExpect(jsonPath("$.salary").exists())
                .andReturn();

    }

    @Test
    public void shouldTestCIndex() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andReturn();
    }

    @Test
    public void shouldTestDShow() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(this.url + "/" + this.documentId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.documentId").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.dateOfBirth").exists())
                .andExpect(jsonPath("$.salary").exists())
                .andReturn();
    }

    @Test
    public void shouldTestEDestroy() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.delete(this.url + "/" + this.documentId)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.documentId").exists())
                .andExpect(jsonPath("$.firstName").exists())
                .andExpect(jsonPath("$.lastName").exists())
                .andExpect(jsonPath("$.age").exists())
                .andExpect(jsonPath("$.dateOfBirth").exists())
                .andExpect(jsonPath("$.salary").exists())
                .andReturn();
    }
}
