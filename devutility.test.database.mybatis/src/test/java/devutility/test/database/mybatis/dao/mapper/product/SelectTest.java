package devutility.test.database.mybatis.dao.mapper.product;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.core.JsonProcessingException;

import devutility.external.json.JsonUtils;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;
import devutility.test.database.mybatis.dao.MybatisFactory;
import devutility.test.database.mybatis.dao.entities.Product;
import devutility.test.database.mybatis.dao.mappers.ProductsMapper;

public class SelectTest extends BaseTest {
	@Override
	public void run() {
		SqlSession session = MybatisFactory.getSqlSession();
		ProductsMapper mapper = session.getMapper(ProductsMapper.class);
		Product product = mapper.select(1);

		try {
			println(JsonUtils.serialize(product));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(SelectTest.class);
	}
}