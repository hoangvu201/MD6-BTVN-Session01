package ra.btvn01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.btvn01.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {


}
