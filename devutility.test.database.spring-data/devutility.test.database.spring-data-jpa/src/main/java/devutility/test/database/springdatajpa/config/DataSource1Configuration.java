package devutility.test.database.springdatajpa.config;

import java.util.Properties;

import javax.sql.DataSource;

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

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;

import devutility.internal.util.PropertiesUtils;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "devutility.test.database.springdatajpa.dao.mssql", entityManagerFactoryRef = "entityManagerFactory1", transactionManagerRef = "transactionManager1")
public class DataSource1Configuration {
	@Primary
	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSource dataSource1() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("db1.sqlserver.jpa")
	public Properties jpaProperties1() {
		return new Properties();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory1() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource1());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "devutility.test.database.springdatajpa.dao.mssql.entity" });
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(PropertiesUtils.toMap(jpaProperties1()));
		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager1() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory1().getObject());
		return transactionManager;
	}
}