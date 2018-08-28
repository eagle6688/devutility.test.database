package devutility.test.database.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.springdatajpa.dao.mysql.CustomerRepository;
import devutility.test.database.springdatajpa.dao.mysql.entity.Customer;

@RestController
@RequestMapping("/mysql")
public class MySqlController {
	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping("/customer")
	public Customer findCustomer(long id) {
		Customer customer = customerRepository.getOne(id);

		if (customer == null) {
			System.out.println("No customer!");
			return null;
		}

		System.out.println(customer.getName());
		return customer;
	}
}