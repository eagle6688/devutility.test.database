package devutility.test.database.springdatajpa.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class PropertiesConfiguration {
	@Primary
	@Bean
	@ConfigurationProperties("db1.sqlserver")
	public DataSourceProperties dataSourceProperties1() {
		return new DataSourceProperties();
	}
}