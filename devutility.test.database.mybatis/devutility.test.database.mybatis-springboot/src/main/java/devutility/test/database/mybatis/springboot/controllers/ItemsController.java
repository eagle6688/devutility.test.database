package devutility.test.database.mybatis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.mybatis.springboot.ds1.entities.Items;
import devutility.test.database.mybatis.springboot.ds1.mappers.ItemsMapper;

@RestController
@RequestMapping("/items")
public class ItemsController {
	@Autowired
	private ItemsMapper itemsMapper;

	@RequestMapping("/get")
	public Items get(String id) {
		return itemsMapper.get(id);
	}
}