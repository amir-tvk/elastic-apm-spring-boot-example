package com.apm.demo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
@Configuration
@RequiredArgsConstructor
public class InitData {

    private final CustomerRepository customerRepository;


    @Bean
    CommandLineRunner initFakeData() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {
                for (long i = 0; i < 1000; i++) {
                    CustomerEntity customerEntity = new CustomerEntity();
                    customerEntity.setName(generateRandomString(30));
                    customerEntity.setDescription(generateRandomString(250));
                    customerEntity.setCreated(LocalDateTime.now());
                    customerRepository.save(customerEntity);
                }
            }
        };
    }

    private static String generateRandomString(final int len) {
        Random random = new Random();
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        return random.ints(leftLimit, rightLimit + 1)
                .limit(len)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
