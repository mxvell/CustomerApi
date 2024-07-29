package ua.prachyk.usersAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.prachyk.usersAPI.dto.CustomerDTO;
import ua.prachyk.usersAPI.dto.CustomerUpdateDTO;
import ua.prachyk.usersAPI.exception.CustomerNotFoundException;
import ua.prachyk.usersAPI.mapping.ManagerMapping;
import ua.prachyk.usersAPI.model.Customer;
import ua.prachyk.usersAPI.repository.CustomerRepository;
import ua.prachyk.usersAPI.validator.CustomerValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("User with ID " + id + " not found."));
    }

    public List<CustomerDTO> findAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (Customer customer : customers) {
            customersDTO.add(ManagerMapping.convertToDto(customer));
        }
        return customersDTO;
    }

// NOT USING
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public CustomerDTO save(CustomerDTO customerDTO) {
        CustomerValidator.validateCustomerDTO(customerDTO);
        Customer customer = new Customer();
        customer.setFullName(customerDTO.getFullName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());
        customer.getCreated();
        customer.getUpdated();
        customer.isActive();
        Customer savedCustomer = customerRepository.save(customer);
        return ManagerMapping.convertToDto(savedCustomer);
    }

    public CustomerUpdateDTO update(CustomerUpdateDTO customerDTO) {
        CustomerValidator.isValidPhone(customerDTO.getPhone());
        Customer customer = customerRepository.findById(customerDTO.getId()).orElseThrow(() -> new CustomerNotFoundException("User with ID " + customerDTO.getId() + " not found."));
        customer.setFullName(customerDTO.getFullName());
        customer.setPhone(customerDTO.getPhone());
        Customer updatedCustomer = customerRepository.save(customer);
        return ManagerMapping.convertToUpdateDto(updatedCustomer);
    }

    public void softDeleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("User with ID " + id + " not found."));
        customer.setActive(false);
        customerRepository.save(customer);
    }
    public List<CustomerDTO> findAllActiveCustomers() {
        List<Customer> customers = customerRepository.findCustomerByActiveTrue();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (Customer customer : customers) {
            customersDTO.add(ManagerMapping.convertToDto(customer));
        }
        return customersDTO;
    }
}
