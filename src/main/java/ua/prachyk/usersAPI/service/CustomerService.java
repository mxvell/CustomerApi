package ua.prachyk.usersAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.prachyk.usersAPI.exception.CustomerNotFoundException;
import ua.prachyk.usersAPI.model.Customer;
import ua.prachyk.usersAPI.repository.CustomerRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("User with ID " + id + " not found."));
    }

    public void updateUser(Customer customerUpdated) {
        Customer customer = findById(customerUpdated.getId());
        customer.setFirstName(customerUpdated.getFirstName());
        customer.setLastName(customer.getLastName());
        customer.setEmail(customerUpdated.getEmail());
        customer.setDateOfBirth(customerUpdated.getDateOfBirth());
        customer.setAddress(customer.getAddress());
        customer.setPhone(customer.getPhone());
        customerRepository.save(customer);
    }

    public void updateEmail(Customer customerUpdated) {
        Customer customer = findById(customerUpdated.getId());
        customer.setEmail(customerUpdated.getEmail());
        customerRepository.save(customer);
    }

    public void updateFields(Customer customerUpdated) {
        Customer customer = findById(customerUpdated.getId());
        customer.setEmail(customerUpdated.getEmail());
        customer.setAddress(customerUpdated.getAddress());
        customer.setPhone(customerUpdated.getPhone());
        customerRepository.save(customer);
    }

    public void registerUser(String firstName, String lastName, String email,
                             LocalDate dateOfBirth, String address, String phone) {
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setDateOfBirth(dateOfBirth);
        customer.setAddress(address);
        customer.setPhone(phone);
        customerRepository.save(customer);
    }

    public List<Customer> findUsersByDateOfBirthBetween(LocalDate from, LocalDate to) {
        if (from.isAfter(to)) {
            throw new UsersByDateOfBirthBetweenException(from + " date must be less than " + to + " date");
        }
        return customerRepository.findByDateOfBirthBetween(from, to);
    }


    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }


}
