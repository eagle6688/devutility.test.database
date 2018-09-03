package devutility.test.database.mybatis.springboot.mappers;

import org.apache.ibatis.annotations.Mapper;

import devutility.test.database.mybatis.springboot.entities.Customer;

@Mapper
public interface CustomerMapper {
	Customer get(long id);
}