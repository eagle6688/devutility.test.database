package devutility.test.database.mybatis.spring.dao.interfaces.order;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import devutility.internal.test.TestExecutor;
import devutility.test.database.mybatis.spring.BaseTest;
import devutility.test.database.mybatis.spring.dao.entities.Order;
import devutility.test.database.mybatis.spring.dao.interfaces.OrderDao;

public class InsertTest extends BaseTest {
	@Override
	public void run() {
		OrderDao orderDao = applicationContext.getBean(OrderDao.class);

		Order entity = new Order();
		entity.setProductId(1);
		entity.setUserId(1);
		entity.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
		entity.setCreateTime(new Date());

		println(orderDao.insert(entity));
		println(entity.getId());
	}

	public static void main(String[] args) {
		TestExecutor.run(InsertTest.class);
	}
}