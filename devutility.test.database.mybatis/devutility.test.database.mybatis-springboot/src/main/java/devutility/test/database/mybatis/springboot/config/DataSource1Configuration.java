package devutility.test.database.mybatis.springboot.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@PropertySource("classpath:db.properties")
@MapperScan(basePackages = { "devutility.test.database.mybatis.springboot.ds1.mappers" }, sqlSessionFactoryRef = "sqlSessionFactory1", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSource1Configuration {
	@Primary
	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSource dataSource1() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory1(DataSource dataSource1) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource1);
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