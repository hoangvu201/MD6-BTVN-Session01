package ra.btvn01.service;


import ra.btvn01.entity.Customer;
import ra.btvn01.entity.CustomerStatus;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Optional<Customer> getCustomerById(Long id);

    Customer createCustomer(Customer customer);

    Optional<Customer> updateCustomer(Long id, Customer customerDetails);

    boolean deleteCustomer(Long id);

    Optional<Customer> updateStatus(Long id, CustomerStatus status);


}
