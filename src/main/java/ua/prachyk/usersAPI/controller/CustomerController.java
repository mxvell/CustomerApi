package ua.prachyk.usersAPI.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.prachyk.usersAPI.dto.CustomerDTO;
import ua.prachyk.usersAPI.dto.CustomerUpdateDTO;
import ua.prachyk.usersAPI.mapping.ManagerMapping;
import ua.prachyk.usersAPI.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;


    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public CustomerDTO getUserById(@PathVariable Long id) {
        return  ManagerMapping.convertToDto(customerService.findById(id));
    }

    @PostMapping("/")
    public ResponseEntity<CustomerDTO> create(@RequestBody @Valid CustomerDTO customer) {
          CustomerDTO customerDTO = customerService.save(customer);
          return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerUpdateDTO> update(@RequestBody @Valid CustomerUpdateDTO customer) {
        CustomerUpdateDTO customerDTO = customerService.update(customer);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}









