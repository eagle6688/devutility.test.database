package devutility.test.database.mybatis.springboot.ds2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import devutility.test.database.mybatis.springboot.ds2.entities.Customer;

@Mapper
public interface CustomerMapper {
	Customer get(long id);

	List<Customer> list();
}