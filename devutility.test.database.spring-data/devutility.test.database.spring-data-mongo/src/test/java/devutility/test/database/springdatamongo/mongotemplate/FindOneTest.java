package devutility.test.database.springdatamongo.mongotemplate;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import devutility.internal.test.TestExecutor;
import devutility.test.database.springdatamongo.BaseTest;
import devutility.test.database.springdatamongo.model.User;

public class FindOneTest extends BaseTest {
	@Override
	public void run() {
		MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is("Aldwin"));

		User user = mongoOperations.findOne(query, User.class);
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			System.out.println(objectMapper.writeValueAsString(user));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(FindOneTest.class);
	}
}