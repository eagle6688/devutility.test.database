package devutility.test.database.springdatajpa.dao.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import devutility.test.database.springdatajpa.dao.mysql.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}