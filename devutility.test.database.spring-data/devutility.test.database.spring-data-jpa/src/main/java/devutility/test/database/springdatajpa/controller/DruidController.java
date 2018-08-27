package devutility.test.database.springdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

@RestController
public class DruidController {
	@GetMapping("/druid-stat")
	public Object stat() {
		return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
	}
}