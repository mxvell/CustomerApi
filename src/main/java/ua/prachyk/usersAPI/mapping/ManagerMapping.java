package ua.prachyk.usersAPI.mapping;

import org.modelmapper.ModelMapper;
import ua.prachyk.usersAPI.dto.CustomerDTO;
import ua.prachyk.usersAPI.dto.CustomerUpdateDTO;
import ua.prachyk.usersAPI.model.Customer;

public class ManagerMapping {
    private static final ModelMapper modelMapper;
    static {
        modelMapper = new ModelMapper();
    }
     public static CustomerDTO convertToDto(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
     }
     public static CustomerUpdateDTO convertToUpdateDto(Customer customer) {
        return modelMapper.map(customer, CustomerUpdateDTO.class);
     }
}
