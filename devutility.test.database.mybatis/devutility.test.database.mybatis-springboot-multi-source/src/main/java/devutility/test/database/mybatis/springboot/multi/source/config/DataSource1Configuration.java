package devutility.test.database.mybatis.springboot.multi.source.config;

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
@MapperScan(basePackages = { "devutility.test.database.mybatis.springboot.multi.source.ds1" }, sqlSessionFactoryRef = "sqlSessionFactory1", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSource1Configuration {
	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSource dataSource1() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public Properties ormProperties1() {
		return new Properties();
	}

	@Bean
	public Interceptor pageHelperInterceptor1() {
		Properties properties = new Properties();
		properties.setProperty("helperDialect", "sqlserver2012");

		Interceptor interceptor = new PageInterceptor();
		interceptor.setProperties(properties);
		return interceptor;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory1(DataSource dataSource1, Properties ormProperties1) throws Exception {
		String configLocation = ormProperties1.getProperty("mybatis.config-location");
		Resource[] resources = new PathMatchingResourcePatternResolver().getResources(configLocation);

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource1);
		sqlSessionFactoryBean.setConfigLocation(resources[0]);
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelperInterceptor1() });
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate1(SqlSessionFactory sqlSessionFactory1) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory1);
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager1(DataSource dataSource1) {
		return new DataSourceTransactionManager(dataSource1);
	}
}