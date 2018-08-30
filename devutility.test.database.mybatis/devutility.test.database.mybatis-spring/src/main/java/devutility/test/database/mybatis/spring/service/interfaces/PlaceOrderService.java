package devutility.test.database.mybatis.spring.service.interfaces;

public interface PlaceOrderService {
	void place(long productId, int quantity) throws Exception;
}