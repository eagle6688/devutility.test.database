package devutility.test.database.mybatis.spring.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisFactory {
	private static Object locker = new Object();
	private static final String resource = "mybatis-config.xml";
	private volatile static SqlSessionFactory sqlSessionFactory = null;

	private static SqlSessionFactory getSqlSessionFactory() {
		if (sqlSessionFactory != null) {
			return sqlSessionFactory;
		}

		synchronized (locker) {
			if (sqlSessionFactory == null) {
				try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
					sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return sqlSessionFactory;
	}

	public static SqlSession getSqlSession() {
		if (sqlSessionFactory == null) {
			sqlSessionFactory = getSqlSessionFactory();

			if (sqlSessionFactory == null) {
				return null;
			}
		}

		return sqlSessionFactory.openSession();
	}
}