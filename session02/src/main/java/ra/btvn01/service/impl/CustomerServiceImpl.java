package ra.btvn01.service.impl;

import ch.qos.logback.core.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn01.entity.Customer;
import ra.btvn01.entity.CustomerStatus;
import ra.btvn01.repository.CustomerRepository;
import ra.btvn01.service.CustomerService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> updateCustomer(Long id, Customer customerDetails) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFullname(customerDetails.getFullname());
            customer.setEmail(customerDetails.getEmail());
            customer.setPhone(customerDetails.getPhone());
            customer.setAddress(customerDetails.getAddress());
            customer.setStatus(customerDetails.getStatus());
            customer.setDateOfBirth(customerDetails.getDateOfBirth());
            customerRepository.save(customer);
            return Optional.of(customer);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customerRepository.delete(optionalCustomer.get());
            return true;
        }
        return false;
    }

    @Override
    public Optional<Customer> updateStatus(Long id, CustomerStatus status) {
        return customerRepository.findById(id).map(customer -> {
            customer.setStatus(status);
            customer.setUpdatedAt(LocalDateTime.now());
            return customerRepository.save(customer);
        });
    }

}
