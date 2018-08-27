package devutility.test.database.springdatajpa.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "devutility.test.database.springdatajpa.dao.mysql", entityManagerFactoryRef = "entityManagerFactory2", transactionManagerRef = "transactionManager2")
public class DataSource2Configuration {
	@Bean
	@ConfigurationProperties("db2.mysql")
	public DataSourceProperties dataSourceProperties2() {
		return new DataSourceProperties();
	}

	@Bean
	@ConfigurationProperties("db2.mysql")
	public DataSource dataSource2() {
		return dataSourceProperties2().initializeDataSourceBuilder().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource2());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "devutility.test.database.springdatajpa.dao.mysql.entity" });
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(jpaPropertyMap());
		return localContainerEntityManagerFactoryBean;
	}

	private HashMap<String, Object> jpaPropertyMap() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return map;
	}

	@Bean
	public PlatformTransactionManager transactionManager2() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory2().getObject());
		return transactionManager;
	}
}