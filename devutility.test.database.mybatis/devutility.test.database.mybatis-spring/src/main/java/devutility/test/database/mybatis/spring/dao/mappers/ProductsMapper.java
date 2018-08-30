package devutility.test.database.mybatis.spring.dao.mappers;

import org.apache.ibatis.annotations.Select;

import devutility.test.database.mybatis.spring.dao.entities.Product;

public interface ProductsMapper {
	@Select("SELECT * FROM Product WHERE id = #{id}")
	Product select(int id);
}