package devutility.test.database.springdatajpa.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public Customer findCustomer(long id) {
		return customerRepository.getOne(id);
	}

	@RequestMapping("/simple-customer")
	public List<SimpleCustomer> pagingSimpleCustomers(int page) throws ParseException {
		Date startDate = DateFormatUtils.parse("2018-01-01", "yyyy-MM-dd");
		return simpleCustomerRepository.paging(startDate, (page - 1) * pageSize, pageSize);
	}
}