package devutility.test.database.mybatis.spring.dao.interfaces;

import org.springframework.stereotype.Repository;

import devutility.test.database.mybatis.spring.dao.entity.Order;

@Repository
public interface OrderDao {
	Order get(long id);

	int insert(Order entity);
}