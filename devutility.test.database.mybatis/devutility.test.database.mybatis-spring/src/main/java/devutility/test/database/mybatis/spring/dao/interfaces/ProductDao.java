package devutility.test.database.mybatis.spring.dao.interfaces;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import devutility.test.database.mybatis.spring.dao.entity.Product;

@Repository
public interface ProductDao {
	Product get(long id);

	int getQuantity(long id);

	int addQuantity(@Param("id") long id, @Param("quantity") int quantity);

	int subtractQuantity(@Param("id") long id, @Param("quantity") int quantity);
}