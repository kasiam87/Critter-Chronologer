package com.udacity.jdnd.course3.critter.presentation.user;

import com.udacity.jdnd.course3.critter.persistence.Customer;
import com.udacity.jdnd.course3.critter.persistence.Pet;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerConverter {

    public Customer toDomain(CustomerDTO customerDTO){
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setName(customerDTO.getName());
        customer.setNotes(customerDTO.getNotes());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        if (customerDTO.getPetIds() != null) {
            customer.setPets(customerDTO.getPetIds().stream().map(id -> {
                Pet pet = new Pet();
                pet.setId(id);
                return pet;
            }).collect(Collectors.toSet()));
        }
        return customer;
    }

    public CustomerDTO fromDomain(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        customerDTO.setNotes(customer.getNotes());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        if (customerDTO.getPetIds() != null) {
            customerDTO.setPetIds(
                    customer.getPets()
                            .stream()
                            .map(Pet::getId)
                            .collect(Collectors.toList())
            );
        }
        return customerDTO;
    }
}
