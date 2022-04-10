package com.apm.demo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    List<CustomerEntity> findByName(final String name) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return customerRepository.findByName(name);
    }

    public Long count() {
        return customerRepository.count();
    }
}
