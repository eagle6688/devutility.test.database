package devutility.test.database.mybatis.dao.interfaces.product;

import com.fasterxml.jackson.core.JsonProcessingException;

import devutility.external.json.JsonUtils;
import devutility.internal.test.TestExecutor;
import devutility.test.database.mybatis.BaseTest;
import devutility.test.database.mybatis.dao.entities.Product;
import devutility.test.database.mybatis.dao.interfaces.ProductDao;

public class GetTest extends BaseTest {
	@Override
	public void run() {
		ProductDao productDao = applicationContext.getBean(ProductDao.class);
		Product product = productDao.get(1);

		try {
			println(JsonUtils.serialize(product));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(GetTest.class);
	}
}