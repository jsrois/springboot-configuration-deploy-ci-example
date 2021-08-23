package org.factoria.usermanagement;

import org.factoria.usermanagement.models.User;
import org.factoria.usermanagement.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;


    @Test
    void devuelveLosUsuariosQueSeHanGuardado() throws Exception {

        List<User> users = List.of(
                new User(1L, "javi", "javi@example.com"),
                new User(2L, "ana", "ana@example.com")
        );

        userRepository.saveAll(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*]", hasSize(2)))
                .andExpect(jsonPath("$[0].name", equalTo("javi")))
                .andExpect(jsonPath("$[0].email", equalTo("javi@example.com")))
                .andExpect(jsonPath("$[1].name", equalTo("ana")))
                .andExpect(jsonPath("$[1].email", equalTo("ana@example.com")));
    }

}
