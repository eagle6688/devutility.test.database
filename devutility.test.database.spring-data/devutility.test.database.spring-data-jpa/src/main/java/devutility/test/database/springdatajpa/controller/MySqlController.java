package devutility.test.database.springdatajpa.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.internal.models.OperationResult;
import devutility.internal.text.format.DateFormatUtils;
import devutility.test.database.springdatajpa.dao.mysql.CustomerRepository;
import devutility.test.database.springdatajpa.dao.mysql.SimpleCustomerRepository;
import devutility.test.database.springdatajpa.dao.mysql.entity.Customer;
import devutility.test.database.springdatajpa.dao.mysql.entity.SimpleCustomer;

@RestController
@RequestMapping("/mysql")
public class MySqlController {
	private int pageSize = 10;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private SimpleCustomerRepository simpleCustomerRepository;

	@RequestMapping("/customer")
	public Customer findCustomer(String id) {
		return customerRepository.getOne(id);
	}

	@RequestMapping("/update-customer")
	public OperationResult updateCustomer(String id) {
		OperationResult result = new OperationResult();
		Customer customer = customerRepository.getOne(id);

		if (customer == null) {
			result.setErrorMessage(String.format("Customer with id %d not found!", id));
			return result;
		}

		customer.setName("Test-Customer");
		Customer updatedCustomer = customerRepository.save(customer);
		result.setData(updatedCustomer);
		return result;
	}

	@RequestMapping("/paging-customers")
	public List<Customer> pagingCustomers(int page) {
		Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Direction.DESC, "Created"));
		Page<Customer> customerPage = customerRepository.findAll(pageable);
		System.out.println(String.format("TotalElements: %d", customerPage.getTotalElements()));
		System.out.println(String.format("TotalPages: %d", customerPage.getTotalPages()));
		return customerPage.getContent();
	}

	@RequestMapping("/paging-simple-customers")
	public List<SimpleCustomer> pagingSimpleCustomers(int page) throws ParseException {
		Date startDate = DateFormatUtils.parse("2018-01-01", "yyyy-MM-dd");
		return simpleCustomerRepository.paging(startDate, (page - 1) * pageSize, pageSize);
	}
}