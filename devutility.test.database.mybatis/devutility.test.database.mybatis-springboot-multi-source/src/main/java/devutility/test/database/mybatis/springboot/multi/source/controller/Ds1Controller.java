package devutility.test.database.mybatis.springboot.multi.source.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import devutility.test.database.mybatis.springboot.multi.source.ds1.entities.Items;
import devutility.test.database.mybatis.springboot.multi.source.ds1.mappers.ItemsMapper;

@RestController
@RequestMapping("/ds1")
public class Ds1Controller {
	@Autowired
	private ItemsMapper itemsMapper;

	@RequestMapping("/item")
	public Items item(String id) {
		return itemsMapper.get(id);
	}

	@RequestMapping("/items-page")
	public List<Items> itemsPage(int page) {
		Page<Items> itemsPage = PageHelper.startPage(page, 10).doSelectPage(() -> itemsMapper.list());
		System.out.println(itemsPage.getTotal());
		System.out.println(itemsPage.getPages());
		System.out.println(itemsPage.getPageSizeZero());
		return itemsPage;
	}
}