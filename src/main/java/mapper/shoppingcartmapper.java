package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.flower;
import entity.shoppingcart;

public interface shoppingcartmapper {
	@Insert("insert into shoppingcart(flowerid,flowername,userid,username,count) values(#{flowerid},#{flowername},#{userid},#{username},#{count})")
	public int addFlower(shoppingcart shoppingcart);
	
	@Delete("delete from shoppingcart where id=#{id}")
	public int deleteFlower(int id);
	
	@Delete("delete from shoppingcart where userid=#{userid}")
	public int deleteByUserId(int userid);
	
	@Delete("delete from shoppingcart")
	public int deleteAllFlowers();
	
	@Select("select * from shoppingcart where userid=#{uid} and flowerid=#{flowerid}")
	public shoppingcart getFlowerByUserIdAndFlowerId(@Param("uid")int uid,@Param("flowerid")int flowerid);
	
	@Select("select * from shoppingcart where userid=#{userid}")
	public List<shoppingcart> getFlowersByUserId(int userid);
	
	@Update("update shoppingcart set count=#{count} where userid=#{userid} and flowerid=#{flowerid}")
	public int updateCount(shoppingcart shoppingcart);
	
	@Select("select * from shoppingcart where id=#{id}")
	public shoppingcart getFlowersById(int id);
	
	@Select("select * from shoppingcart")
	public List<shoppingcart> getAllFlowers();
}
