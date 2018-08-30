package devutility.test.database.mybatis.spring.service.impls;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import devutility.test.database.mybatis.spring.dao.entity.Order;
import devutility.test.database.mybatis.spring.dao.interfaces.OrderDao;
import devutility.test.database.mybatis.spring.dao.interfaces.ProductDao;
import devutility.test.database.mybatis.spring.service.interfaces.PlaceOrderService;

@Service
public class PlaceOrderServiceImpl implements PlaceOrderService {
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private ProductDao productDao;

	@Override
	@Transactional
	public void place(long productId, int quantity) throws Exception {
		if (productDao.getQuantity(productId) < quantity) {
			throw new Exception("No enough quantity!");
		}

		if (productDao.subtractQuantity(productId, quantity) != 1) {
			throw new Exception("Product update failed!");
		}

		Order order = new Order();
		order.setProductId(productId);
		order.setUserId(1);
		order.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		order.setCreateTime(new Date());

		if (orderDao.insert(order) != 1) {
			throw new Exception("Insert Order failed!");
		}

		System.out.println(String.format("The id of new Order is: %d", order.getId()));
	}
}