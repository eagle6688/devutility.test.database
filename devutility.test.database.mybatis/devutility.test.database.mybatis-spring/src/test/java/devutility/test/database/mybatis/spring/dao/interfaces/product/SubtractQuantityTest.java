package devutility.test.database.mybatis.spring.dao.interfaces.product;

import devutility.internal.test.TestExecutor;
import devutility.test.database.mybatis.spring.BaseTest;
import devutility.test.database.mybatis.spring.dao.interfaces.ProductDao;

public class SubtractQuantityTest extends BaseTest {
	@Override
	public void run() {
		ProductDao productDao = applicationContext.getBean(ProductDao.class);
		println(productDao.subtractQuantity(1, 2));
	}

	public static void main(String[] args) {
		TestExecutor.run(SubtractQuantityTest.class);
	}
}