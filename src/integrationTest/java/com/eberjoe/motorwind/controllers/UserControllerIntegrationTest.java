package com.eberjoe.motorwind.controllers;

import static com.eberjoe.motorwind.models.constants.Role.ADMIN;
import static com.eberjoe.motorwind.models.constants.Role.SUPER_ADMIN;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.eberjoe.motorwind.models.UserModel;
import com.eberjoe.motorwind.repositories.UserRepository;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class UserControllerIntegrationTest {

  @Autowired
  UserRepository userRepository;

  @Autowired
  WebApplicationContext wac;

  private MockMvc mockMvc;

  @BeforeEach
  @Transactional
  void setup() {
    mockMvc = MockMvcBuilders
        .webAppContextSetup(wac)
        .apply(springSecurity())
        .build();

    userRepository.save(
        UserModel.builder()
            .fullName("Alice")
            .email("alice@motorwind.com")
            .password("123")
            .build()
    );
    userRepository.save(
        UserModel.builder()
            .fullName("Bob")
            .email("bob@motorwind.com")
            .password("123")
            .role(ADMIN.toString())
            .build()
    );
    userRepository.save(
        UserModel.builder()
            .fullName("Chris")
            .email("chris@motorwind.com")
            .password("123")
            .role(SUPER_ADMIN.toString())
            .build()
    );
  }

  @Test
  void initCreationFormWithSpring() throws Exception {
    mockMvc.perform(get("/beers/new").with(httpBasic("spring", "guru")))
        .andExpect(status().isOk())
        .andExpect(view().name("beers/createBeer"))
        .andExpect(model().attributeExists("beer"));
  }

}
