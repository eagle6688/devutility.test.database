package devutility.test.database.springdatamongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.MongoClient;

import devutility.internal.dao.models.DbInstance;

@Configuration
public class MongoDbConfig extends AbstractMongoConfiguration {
	private DbInstance dbInstance;
	private MongoClient mongoClient;

	public MongoDbConfig() {
		dbInstance = DbConfig.getSupportMDBInstance();
		mongoClient = DbConfig.getMongoClient(dbInstance);
	}

	@Override
	public MongoClient mongoClient() {
		return mongoClient;
	}

	@Override
	protected String getDatabaseName() {
		return dbInstance.getDatabase();
	}

	@Bean
	@Override
	public MappingMongoConverter mappingMongoConverter() throws Exception {
		MappingMongoConverter mappingMongoConverter = super.mappingMongoConverter();
		mappingMongoConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return mappingMongoConverter;
	}
}