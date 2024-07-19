package ua.prachyk.usersAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.prachyk.usersAPI.model.Customer;
import ua.prachyk.usersAPI.service.CustomerService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getUserById(@PathVariable Long id) {
        Customer customer = userService.findById(id);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody Customer customer) {
        userService.registerUser(customer.getFirstName(), customer.getLastName(), customer.getEmail(),
                customer.getDateOfBirth(), customer.getAddress(), customer.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody Customer updateCustomer) {
        userService.updateUser(updateCustomer);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Void> updateEmail(@RequestBody Customer emailCustomer) {
        userService.findById(emailCustomer.getId());
        userService.updateEmail(emailCustomer);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/fields")
    public ResponseEntity<Void> updateUserFields(@RequestBody Customer customerUpdated) {
        userService.findById(customerUpdated.getId());
        userService.updateFields(customerUpdated);
        return ResponseEntity.ok().build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}









