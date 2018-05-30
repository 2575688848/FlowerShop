package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import entity.user;

public interface usermapper {
   @Insert("insert into users(username,password) values(#{username},#{password})")
   public int addUser(user user);
   
   @Delete("delete from users where id=#{id}")
   public int deleteUser(int id);
   
   @Update("update users set username=#{username},password=#{password} where id=#{id}")
   public int updateUser(user user);
   
   @Select("select * from users where id=#{id}")
   public user getUserById(int id);
   
   @Select("select * from users where username=#{username} and password=#{password} ")
   public user findUser(user user);
   
   @Select("select * from users where username=#{username}")
   public user findUserByUserName(String username);
   
   @Select("select * from users")
   public List<user> getAllUsers();
}
