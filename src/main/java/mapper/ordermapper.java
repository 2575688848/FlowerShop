package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import entity.order;

public interface ordermapper {
	
	@Insert("insert into orders(flowerid,flowername,userid,username,count) values(#{flowerid},#{flowername},#{userid},#{username},#{count})")
	public int addOrder(order order);
	
	@Delete("delete from orders where id=#{id}")
	public int deleteOrder(int id);
	
	@Delete("delete from orders")
	public int deleteAllOrder();
	
	@Select("select * from orders where userid=#{id}")
	public List<order> getOrdersByUserId(int id);
	
	@Select("select * from orders")
	public List<order> getAllOrders();
}
