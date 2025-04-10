package com.fullstack.controller;

import com.fullstack.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    List<Customer> customerList = Stream.of(new Customer(121, "SWARA", 9898989898L, 89000.00),
            new Customer(122, "RAM", 7798989898L, 79000.00),
            new Customer(123, "POOJA", 6898989898L, 99000.00),
            new Customer(124, "RUTUJA", 5898989898L, 49000.00),
            new Customer(125, "DIPAK", 9798989898L, 69000.00)).toList();

    @GetMapping("/findall")
    public ResponseEntity<List<Customer>> findAll() {
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Customer>> sortByName() {
        return ResponseEntity.ok(customerList.stream().sorted(Comparator.comparing(Customer::getCustName)).toList());
    }

    @GetMapping("/searchbyname")
    public ResponseEntity<List<Customer>> searchByName(@RequestParam(required = false, defaultValue = "SWARA") String custName) {
        return ResponseEntity.ok(customerList.stream().filter(cust -> cust.getCustName().equals(custName)).toList());
    }

    @GetMapping("/sortbyaccountbal")
    public ResponseEntity<List<Customer>> sortByAccou(@RequestParam(required = false, defaultValue = "SWARA") String custName) {
        return ResponseEntity.ok(customerList.stream().filter(cust -> cust.getCustName().equals(custName)).toList());
    }


}
