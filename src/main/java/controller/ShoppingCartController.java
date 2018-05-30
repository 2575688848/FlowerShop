package controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.order;
import entity.shoppingcart;
import mapper.ordermapper;
import mapper.shoppingcartmapper;
import sqlSession.sqlsesssion;

@Controller
@RequestMapping("/Shopping")
public class ShoppingCartController {
	
	 @RequestMapping("/")
	   public String index(Model model) {
		 int userid=UserController.uid;
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 shoppingcartmapper shoppingcartmapper=sqlSession.getMapper(shoppingcartmapper.class);
		 List<shoppingcart> shoppingcarts=shoppingcartmapper.getFlowersByUserId(userid);
		 model.addAttribute("shopcarts", shoppingcarts);
		 return "shoppingcart/index";
	   }
	 @RequestMapping("/Confirm")
	   public String confirm(int id) {
		 
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 shoppingcartmapper shoppingcartmapper=sqlSession.getMapper(shoppingcartmapper.class);
		 shoppingcart shcart=shoppingcartmapper.getFlowersById(id);
		 order order=new order();
		 order.setFlowerid(shcart.getFlowerid());
		 order.setFlowername(shcart.getFlowername());
		 order.setUserid(shcart.getUserid());order.setUsername(shcart.getUsername());
		 order.setCount(shcart.getCount());
		 shoppingcartmapper.deleteFlower(id);
		 ordermapper ordermapper=sqlSession.getMapper(ordermapper.class);
		ordermapper.addOrder(order);
		sqlSession.commit();
		 return "redirect:/Shopping/";
	   }
	 @RequestMapping("/Cancel")
	   public String cancel(int id) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 shoppingcartmapper shoppingcartmapper=sqlSession.getMapper(shoppingcartmapper.class);
		shoppingcartmapper.deleteFlower(id);
		sqlSession.commit();
		 return "redirect:/Shopping/";
	   }
	 @RequestMapping("/DeleteAll")
	   public String deleteall() {
		 int userid=UserController.uid;
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 shoppingcartmapper shoppingcartmapper=sqlSession.getMapper(shoppingcartmapper.class);
		List<shoppingcart> shops=shoppingcartmapper.getFlowersByUserId(userid);
		shoppingcartmapper.deleteByUserId(userid);
		
		for(shoppingcart shcart:shops) {
			order order=new order();
			 order.setFlowerid(shcart.getFlowerid());
			 order.setFlowername(shcart.getFlowername());
			 order.setUserid(shcart.getUserid());order.setUsername(shcart.getUsername());
			 order.setCount(shcart.getCount());
			 ordermapper ordermapper=sqlSession.getMapper(ordermapper.class);
			ordermapper.addOrder(order);
		}
		sqlSession.commit();
		 return "redirect:/Shopping/";
	   }
}
