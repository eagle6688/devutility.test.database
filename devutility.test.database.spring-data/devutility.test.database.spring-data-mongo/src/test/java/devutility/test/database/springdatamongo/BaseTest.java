package devutility.test.database.springdatamongo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import devutility.test.database.springdatamongo.config.MongoDbConfig;

public abstract class BaseTest extends devutility.internal.test.BaseTest {
	protected ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MongoDbConfig.class);
}