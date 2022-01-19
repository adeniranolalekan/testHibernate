package com.example.testhibernate.cmd;
import com.example.testhibernate.domain.entity.User;
import com.example.testhibernate.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Optional;

@Component
public class DatabaseRunner implements CommandLineRunner{
    @Inject
    private UserRepository userRepository;
    @Override
    public void run(String... args) throws Exception {
        String login="vishnupriya@angleritech.com";
        String lowercaseLogin = login.toLowerCase();
        Optional<User> userFromDatabase = userRepository.findOneByLogin(lowercaseLogin);
        if (!userFromDatabase.isPresent()) {
            userFromDatabase = userRepository.findOneByEmailIgnoreCase(lowercaseLogin);
            System.out.println(userFromDatabase.get().getPassword());
        }
    }
}
