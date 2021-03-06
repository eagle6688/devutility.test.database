package devutility.test.database.springdatamongo.mongotemplate;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.MongoOperations;

import devutility.internal.test.TestExecutor;
import devutility.test.database.springdatamongo.BaseTest;
import devutility.test.database.springdatamongo.model.User;

public class InsertTest extends BaseTest {
	@Override
	public void run() {
		MongoOperations mongoOperations = (MongoOperations) applicationContext.getBean("mongoTemplate");

		User user = new User();
		user.setId(1);
		user.setName("Aldwin");
		user.setBirthday(LocalDate.now());

		mongoOperations.insert(user);
	}

	public static void main(String[] args) {
		TestExecutor.run(InsertTest.class);
	}
}