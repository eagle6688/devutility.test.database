package devutility.test.database.mybatis.dao.interfaces;

import org.springframework.stereotype.Repository;

import devutility.test.database.mybatis.dao.entities.Order;

@Repository
public interface OrderDao {
	Order get(long id);

	int insert(Order entity);
}