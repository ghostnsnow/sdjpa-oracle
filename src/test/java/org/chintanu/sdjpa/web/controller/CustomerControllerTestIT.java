package org.chintanu.sdjpa.web.controller;

import org.assertj.core.api.Assertions;
import org.chintanu.sdjpa.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
class CustomerControllerTestIT {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void countByFirstNm() throws Exception {

        BDDMockito.given(customerService.countByFirstName(BDDMockito.anyString())).willReturn(65);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/countByFirstNm/Abigail"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        Assertions.assertThat(new Integer(result.getResponse().getContentAsString())).isEqualTo(65);
    }
}