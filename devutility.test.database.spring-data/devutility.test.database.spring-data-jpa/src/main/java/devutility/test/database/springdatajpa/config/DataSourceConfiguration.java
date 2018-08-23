package devutility.test.database.springdatajpa.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class DataSourceConfiguration {
	@ConfigurationProperties("db1.sqlserver")
	public DataSourceProperties dataSourceProperties1() {
		return new DataSourceProperties();
	}
}