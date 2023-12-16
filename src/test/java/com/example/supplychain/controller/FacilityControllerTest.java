package com.example.supplychain.controller;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.supplychain.model.Address;
import com.example.supplychain.model.Facility;
import com.example.supplychain.model.Supplier;
import com.example.supplychain.service.FacilityServiceInterface;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = FacilityController.class)
public class FacilityControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    @SpyBean
    FacilityServiceInterface service;

    @Test
    void testWhetherClassExists() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(new Facility("cd","Sai",new Address("aa","aa","aa","aa","aa"), new Supplier("aa","ss",new Address("aa","aa","aa","aa","aa"),"aa","aa","aa","aa","aa","aa"),new ArrayList<String>(Arrays.asList("aa"))));
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/facility/select/cd")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Facility op = new ObjectMapper().readValue(result, Facility.class);
        // .andReturn().getResponse().getContent;
        assertFalse(op.equals(null));

    }

    @Test
    void testDeleteWorks() throws Exception {
        Mockito.when(service.getById(Mockito.anyString())).thenReturn(new Facility("cd","Sai",new Address("aa","aa","aa","aa","aa"), new Supplier("aa","ss",new Address("aa","aa","aa","aa","aa"),"aa","aa","aa","aa","aa","aa"),new ArrayList<String>(Arrays.asList("aa"))));
        Mockito.when(service.deleteData("cd")).thenReturn(true);
        // (new Facility("ab","Sai",new Address("aa","aa","aa","aa","aa"), new Supplier("aa","ss",new Address("aa","aa","aa","aa","aa"),"aa","aa","aa","aa","aa","aa"),new ArrayList<String>(Arrays.asList("aa"))));
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facility/delete/ab")).andExpect(status().isOk()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        // .andReturn().getResponse().getContent;
        assertFalse(op.equals(null));

    }

    @Test
    void testDeleteNotWorks() throws Exception {
        Mockito.when(service.deleteData("ab")).thenReturn(true);
        // (new Facility("ab","Sai",new Address("aa","aa","aa","aa","aa"), new Supplier("aa","ss",new Address("aa","aa","aa","aa","aa"),"aa","aa","aa","aa","aa","aa"),new ArrayList<String>(Arrays.asList("aa"))));
        String result = mockMvc.perform(MockMvcRequestBuilders.delete("/facility/delete/ab")).andExpect(status().isNotFound()).andReturn().getResponse()
                .getContentAsString();
        System.out.println("___________");
        System.out.println(result);
        System.out.println("___________");

        Boolean op = new ObjectMapper().readValue(result, Boolean.class);
        // .andReturn().getResponse().getContent;
        assertFalse(op.equals(null));

    }

}