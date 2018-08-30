package devutility.test.database.mybatis.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class BaseTest extends devutility.internal.test.BaseTest {
	protected ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
}