package devutility.test.database.mybatis.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devutility.test.database.mybatis.springboot.ds1.entities.Items;
import devutility.test.database.mybatis.springboot.ds1.mappers.ItemsMapper;

@RestController
@RequestMapping("/ds1")
public class Ds1Controller {
	@Autowired
	private ItemsMapper itemsMapper;

	@RequestMapping("/item")
	public Items item(String id) {
		return itemsMapper.get(id);
	}
}