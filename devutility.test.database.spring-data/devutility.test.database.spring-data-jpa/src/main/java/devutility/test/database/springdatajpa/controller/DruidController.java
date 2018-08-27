package devutility.test.database.springdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.stat.DruidStatManagerFacade;

@RestController
@RequestMapping("/druid")
public class DruidController {
	@GetMapping("/stat")
	public Object stat() {
		return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
	}
}