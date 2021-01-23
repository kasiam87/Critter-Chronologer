package com.udacity.jdnd.course3.critter.presentation.user;

import com.udacity.jdnd.course3.critter.persistence.Customer;
import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.service.AllCustomerFetchingService;
import com.udacity.jdnd.course3.critter.service.CustomerCreatingService;
import com.udacity.jdnd.course3.critter.service.EmployeeAvailabilitySettingService;
import com.udacity.jdnd.course3.critter.service.EmployeeCreatingService;
import com.udacity.jdnd.course3.critter.service.EmployeeFetchingService;
import com.udacity.jdnd.course3.critter.service.EmployeeNotFoundException;
import com.udacity.jdnd.course3.critter.service.OwnerByPetFetchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomerCreatingService customerCreatingService;

    @Autowired
    private AllCustomerFetchingService allCustomerFetchingService;

    @Autowired
    private EmployeeCreatingService employeeCreatingService;

    @Autowired
    private EmployeeFetchingService employeeFetchingService;

    @Autowired
    private OwnerByPetFetchingService ownerByPetFetchingService;

    @Autowired
    private EmployeeAvailabilitySettingService employeeAvailabilitySettingService;

    @Autowired
    private CustomerConverter customerConverter;

    @Autowired
    private EmployeeConverter employeeConverter;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){
        Customer customer = customerConverter.toDomain(customerDTO);
        Customer savedCustomer = customerCreatingService.invoke(customer);
        return customerConverter.fromDomain(savedCustomer);
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        return allCustomerFetchingService.invoke().stream().map(c -> customerConverter.fromDomain(c)).collect(Collectors.toList());
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        Customer customer = ownerByPetFetchingService.invoke(petId);
        return customerConverter.fromDomain(customer);
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeConverter.toDomain(employeeDTO);
        Employee savedEmployee = employeeCreatingService.invoke(employee);
        return employeeConverter.fromDomain(savedEmployee);
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Employee employee = employeeFetchingService.invoke(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        return employeeConverter.fromDomain(employee);
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeAvailabilitySettingService.invoke(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

}
