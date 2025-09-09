package ra.btvn01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn01.entity.Customer;
import ra.btvn01.entity.CustomerStatus;
import ra.btvn01.response.ApiDataResponse;
import ra.btvn01.service.CustomerService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Customer>>> getAll() {
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Get customers successfully!",
                        customerService.getAllCustomers(),
                        null,
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Customer>> getById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .map(customer -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Get customer successfully!",
                                customer,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Customer not found",
                                null,
                                "Customer with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Customer>> create(@RequestBody Customer customer) {
        Customer saved = customerService.createCustomer(customer);
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Customer created successfully!",
                        saved,
                        null,
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Customer>> update(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer)
                .map(updated -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Customer updated successfully!",
                                updated,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Customer not found",
                                null,
                                "Customer with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Void>> delete(@PathVariable Long id) {
        if (customerService.deleteCustomer(id)) {
            return new ResponseEntity<>(
                    new ApiDataResponse<>(
                            true,
                            "Customer deleted successfully!",
                            null,
                            null,
                            HttpStatus.NO_CONTENT
                    ),
                    HttpStatus.NO_CONTENT
            );
        }
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        false,
                        "Customer not found",
                        null,
                        "Customer with id " + id + " not found",
                        HttpStatus.NOT_FOUND
                ),
                HttpStatus.NOT_FOUND
        );
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ApiDataResponse<Customer>> updateStatus(
            @PathVariable Long id,
            @RequestBody Map<String, String> body) {

        try {
            CustomerStatus newStatus = CustomerStatus.valueOf(body.get("status"));

            return customerService.updateStatus(id, newStatus)
                    .map(updated -> new ResponseEntity<>(
                            new ApiDataResponse<>(
                                    true,
                                    "Customer status updated successfully!",
                                    updated,
                                    null,
                                    HttpStatus.OK
                            ),
                            HttpStatus.OK
                    ))
                    .orElse(new ResponseEntity<>(
                            new ApiDataResponse<>(
                                    false,
                                    "Customer not found",
                                    null,
                                    "Customer with id " + id + " not found",
                                    HttpStatus.NOT_FOUND
                            ),
                            HttpStatus.NOT_FOUND
                    ));
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(
                    new ApiDataResponse<>(
                            false,
                            "Invalid status value",
                            null,
                            "Allowed values: ACTIVE, INACTIVE, SUSPENDED",
                            HttpStatus.BAD_REQUEST
                    ),
                    HttpStatus.BAD_REQUEST
            );
        }
    }

}