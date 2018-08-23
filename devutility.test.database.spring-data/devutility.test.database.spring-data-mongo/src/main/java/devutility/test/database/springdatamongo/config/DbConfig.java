package devutility.test.database.springdatamongo.config;

import com.mongodb.MongoClient;

import devutility.external.mongo.MongoDbUtils;
import devutility.internal.dao.DbInstanceUtils;
import devutility.internal.dao.models.DbInstance;

public class DbConfig {
	public static final String CONFIG = "dbconfig.properties";

	public static DbInstance getSupportMDBInstance() {
		return DbInstanceUtils.getInstance(CONFIG, "supportmdb");
	}

	public static MongoClient getMongoClient(DbInstance dbInstance) {
		if (dbInstance == null) {
			return null;
		}

		return MongoDbUtils.mongoClient(dbInstance);
	}
}