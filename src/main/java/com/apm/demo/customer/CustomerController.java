package com.apm.demo.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

   private final CustomerService customerService;

    @GetMapping("/name/{name}")
    public List<CustomerEntity> findByName(final String name) {
        return customerService.findByName(name);
    }

    @GetMapping("/count")
    public Long findByName() {
        return customerService.count();
    }

}
