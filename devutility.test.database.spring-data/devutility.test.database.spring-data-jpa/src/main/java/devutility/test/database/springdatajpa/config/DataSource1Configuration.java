package devutility.test.database.springdatajpa.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "devutility.test.database.springdatajpa.dao.mssql", entityManagerFactoryRef = "entityManagerFactory1", transactionManagerRef = "transactionManager1")
public class DataSource1Configuration {
	@Primary
	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSourceProperties dataSourceProperties1() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSource dataSource1() {
		return dataSourceProperties1().initializeDataSourceBuilder().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource1());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "devutility.test.database.springdatajpa.dao.mssql.entity" });
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap());
		return localContainerEntityManagerFactoryBean;
	}

	private HashMap<String, Object> jpaPropertyMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
		return map;
	}

	@Bean
	public PlatformTransactionManager transactionManager1() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory1().getObject());
		return transactionManager;
	}
}