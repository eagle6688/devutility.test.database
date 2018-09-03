package devutility.test.database.mybatis.springboot.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.github.pagehelper.PageInterceptor;

@Configuration
@PropertySource("classpath:db.properties")
@MapperScan(basePackages = { "devutility.test.database.mybatis.springboot.ds2" }, sqlSessionFactoryRef = "sqlSessionFactory2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSource2Configuration {
	@Bean
	@ConfigurationProperties("db2.mysql")
	public DataSource dataSource2() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("db2.mysql")
	public Properties ormProperties2() {
		return new Properties();
	}

	@Bean
	public Interceptor pageHelperInterceptor2() {
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "mysql");

		Interceptor interceptor = new PageInterceptor();
		interceptor.setProperties(properties);
		return interceptor;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory2(DataSource dataSource2, Properties ormProperties2) throws Exception {
		String configLocation = ormProperties2.getProperty("mybatis.config-location");
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(configLocation);

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource2);
		sqlSessionFactoryBean.setConfigLocation(resources[0]);
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelperInterceptor2() });
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate2(SqlSessionFactory sqlSessionFactory2) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory2);
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager2(DataSource dataSource2) {
		return new DataSourceTransactionManager(dataSource2);
	}
}