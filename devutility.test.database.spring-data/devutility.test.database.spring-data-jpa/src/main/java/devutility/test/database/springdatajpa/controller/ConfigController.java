package devutility.test.database.springdatajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
	@Autowired
	private DataSourceProperties dataSourceProperties1;

	@RequestMapping("/db1")
	public DataSourceProperties db1() {
		return dataSourceProperties1;
	}
}