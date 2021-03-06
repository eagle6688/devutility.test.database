package devutility.test.database.springdatajpa.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableJpaRepositories(basePackages = "devutility.test.database.springdatajpa.dao.mysql", entityManagerFactoryRef = "entityManagerFactory2", transactionManagerRef = "transactionManager2")
public class DataSource2Configuration {
	@Bean
	@ConfigurationProperties("db2.mysql")
	public DataSource dataSource2() {
		return DruidDataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("db2.mysql.jpa")
	public Properties jpaProperties2() {
		return new Properties();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory2() {
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(dataSource2());
		localContainerEntityManagerFactoryBean.setPackagesToScan(new String[] { "devutility.test.database.springdatajpa.dao.mysql.entity" });
		localContainerEntityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		localContainerEntityManagerFactoryBean.setJpaPropertyMap(PropertiesUtils.toMap(jpaProperties2()));
		return localContainerEntityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager2() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory2().getObject());
		return transactionManager;
	}
}