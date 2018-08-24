package devutility.test.database.springdatajpa.dao.mssql;

import org.springframework.data.jpa.repository.JpaRepository;

import devutility.test.database.springdatajpa.dao.mssql.entity.Items;

public interface ItemsRepository extends JpaRepository<Items, String> {

}