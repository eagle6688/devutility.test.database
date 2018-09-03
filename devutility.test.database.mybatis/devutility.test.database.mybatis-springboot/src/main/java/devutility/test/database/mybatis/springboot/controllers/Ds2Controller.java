package devutility.test.database.mybatis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.mybatis.springboot.ds2.entities.Customer;
import devutility.test.database.mybatis.springboot.ds2.mappers.CustomerMapper;

@RestController
@RequestMapping("/ds2")
public class Ds2Controller {
	@Autowired
	private CustomerMapper customerMapper;

	@RequestMapping("/customer")
	public Customer customer(long id) {
		return customerMapper.get(id);
	}
}