package devutility.test.database.mybatis.springboot.ds1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import devutility.test.database.mybatis.springboot.ds1.entities.Items;

@Mapper
public interface ItemsMapper {
	Items get(String id);

	List<Items> list();
}