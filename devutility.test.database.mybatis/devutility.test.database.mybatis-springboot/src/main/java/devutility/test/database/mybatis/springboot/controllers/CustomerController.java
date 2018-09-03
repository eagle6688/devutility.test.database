package devutility.test.database.mybatis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.mybatis.springboot.entities.Customer;
import devutility.test.database.mybatis.springboot.mappers.CustomerMapper;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private CustomerMapper customerMapper;

	@RequestMapping("/get")
	public Customer get(long id) {
		return customerMapper.get(id);
	}
}