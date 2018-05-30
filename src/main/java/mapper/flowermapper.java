package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import entity.flower;



public interface flowermapper {
	
	@Insert("insert into flowers(name,category,price) values(#{name},#{category},#{price})")
	public int addFlower(flower flower);
	
	@Delete("delete from flowers where id=#{id}")
	public int deleteFlower(int id);
	
	@Update("update flowers set name=#{name},category=#{category},price=#{price} where id=#{id}")
	public int updateFlower(flower flower);
	
	@Select("select * from flowers where id=#{id}")
	public flower getFlowerById(int id);
	
	@Select("select * from flowers where name=#{name}")
	public flower getFlowerByFlowerName(String name);
	
	@Select("select * from flowers where name=#{name} or category=#{name}")
	public List<flower> getFlowerByNameOrCategory(String name);
	
	@Select("select * from flowers where category=#{category}")
	public List<flower> getFlowerByFlowerCategory(String category);
	
	@Select("select * from flowers")
	public List<flower> getAllFlowers();
}
