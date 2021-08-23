package org.factoria.usermanagement.configuration;


import org.factoria.usermanagement.models.User;
import org.factoria.usermanagement.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Profile("local")
@Component
public class DataLoader {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    void cargarDatosDePrueba() {
        List<User> users = List.of(
                new User(1L, "javi", "javi@example.com"),
                new User(2L, "ana", "ana@example.com")
        );

        userRepository.saveAll(users);
    }
}
