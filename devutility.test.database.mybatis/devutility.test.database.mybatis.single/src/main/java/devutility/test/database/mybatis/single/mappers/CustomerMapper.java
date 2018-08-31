package devutility.test.database.mybatis.single.mappers;

import org.apache.ibatis.annotations.Mapper;

import devutility.test.database.mybatis.single.entities.Customer;

@Mapper
public interface CustomerMapper {
	Customer get(long id);
}