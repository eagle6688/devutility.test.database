package devutility.test.database.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.springdatajpa.dao.mssql.ItemsRepository;
import devutility.test.database.springdatajpa.dao.mssql.entity.Items;

@RestController
@RequestMapping("/mssql")
public class MsSqlController {
	@Autowired
	private ItemsRepository itemsRepository;

	@RequestMapping("/item")
	public Items findItem(String id) {
		return itemsRepository.getOne(id);
	}
}