package devutility.test.database.mybatis.spring.service.placeorder;

import devutility.internal.test.TestExecutor;
import devutility.test.database.mybatis.spring.BaseTest;
import devutility.test.database.mybatis.spring.service.interfaces.PlaceOrderService;

public class PlaceTest extends BaseTest {
	@Override
	public void run() {
		PlaceOrderService placeOrderService = applicationContext.getBean(PlaceOrderService.class);

		try {
			placeOrderService.place(1, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.concurrentRun(10, PlaceTest.class, null);
	}
}