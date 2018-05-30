package sqlSession;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlsesssion {
     public static SqlSession getSqlSession() {
    	 String resource = "mybatis/mybatis-config.xml";
  	   InputStream inputStream=null;
  	try {
  		inputStream = Resources.getResourceAsStream(resource);
  	} catch (IOException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
  	   SqlSessionFactory sqlSessionFactory =
  	   new SqlSessionFactoryBuilder().build(inputStream);
  	   return sqlSessionFactory.openSession();
  	   
     }
}
