package com.tang.interviewprovider;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProviderControllerTest {

  private MockMvc mvc;

  @InjectMocks
  private ProviderController controller;

  @BeforeEach
  void setUp() {
    mvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  void getOk() throws Exception {
    mvc.perform(get("/menu")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"name\":\"French Fries\"}"));
  }

  @Test
  void getFrenchFriesOk() throws Exception {
    mvc.perform(get("/menu/frenchFries")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"price\":5}"));
  }

  @Test
  void getSoupNotFound() throws Exception {
    mvc.perform(get("/menu/soup")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isNotFound());
  }

  @Test
  void getCokeOk() throws Exception {
    mvc.perform(get("/order?name=coke&count=1")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"food\":{\"name\":\"coke\"},\"count\":1}"));
  }

  @Test
  void getDefaultOrderOk() throws Exception {
    mvc.perform(get("/order?count=2")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"food\":{\"name\":\"French Fries\"},\"count\":2}"));
  }

  @Test
  void getOrderBadRequest() throws Exception {
    mvc.perform(get("/order")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isBadRequest());
  }

  @Test
  void getCornOk() throws Exception {
    mvc.perform(get("/corn/3")
        .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk())
      .andExpect(content().string("{\"food\":{\"name\":\"corn\"},\"count\":3}"));
  }
}
