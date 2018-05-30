package controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.flower;
import entity.shoppingcart;
import entity.user;
import mapper.flowermapper;
import mapper.shoppingcartmapper;
import mapper.usermapper;
import sqlSession.sqlsesssion;

@Controller
@RequestMapping("/User")
public class UserController {

	public static int uid=0;
	 @RequestMapping("/")
	   public String index() {
		 
		   return "user/index";
	   }
	 @RequestMapping("/LoginTest")
	   public String logintest(user user,RedirectAttributes redirectAttributes) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 usermapper usermapper=sqlSession.getMapper(usermapper.class);
		 user user1=usermapper.findUser(user);
		 if(user1!=null) {
		   uid=user1.getId();
		  return "redirect:/User/Login";
		 }
		 else {
			 redirectAttributes.addFlashAttribute("err","用户不存在");
			 return "redirect:/User/";
		 }
	   }
	 @RequestMapping("/Login")
	   public String login(Model model) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		  flowermapper flowermapper=sqlSession.getMapper(flowermapper.class);
		  List<flower> flowers=flowermapper.getAllFlowers();
		  model.addAttribute("flowers", flowers);
		  return "user/login";
	   }
	 @RequestMapping("/Register")
	   public String register() {
		 
		   return "user/register";
	   }
	 @RequestMapping("/SaveRegister")
	   public String saveregister(user user,Model model,RedirectAttributes redirectAttributes) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 usermapper usermapper=sqlSession.getMapper(usermapper.class);
		user user1=usermapper.findUserByUserName(user.getUsername());
		if(user1==null) {
			usermapper.addUser(user);
			
			sqlSession.commit();
			user user2=usermapper.findUser(user);
			uid=user2.getId();
			redirectAttributes.addFlashAttribute("message", "恭喜你注册成功！");
			return "redirect:/User/Welcome";
		}
		else{
			model.addAttribute("err", "此用户已存在");
			return "user/register";
		}
	   }
	 @RequestMapping("/Welcome")
	   public String welcome() {
		   
		   return "user/welcome";
	   }
	 @RequestMapping("/ShoppingCart")
	   public String ShoppingCart(int flowerid) {
		 System.out.println(flowerid);
		 System.out.println(uid);
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		shoppingcartmapper shoppingcartmapper= sqlSession.getMapper(shoppingcartmapper.class);
		shoppingcart shoppingcart=shoppingcartmapper.getFlowerByUserIdAndFlowerId(uid, flowerid);
		if(shoppingcart!=null) {
			int a=shoppingcart.getCount();
			a++;
			shoppingcart.setCount(a);
			shoppingcartmapper.updateCount(shoppingcart);
			sqlSession.commit();
			 return "redirect:/User/Login";
		}
		else {
		 usermapper usermapper=sqlSession.getMapper(usermapper.class); 
		 user user=usermapper.getUserById(uid);
		 flowermapper flowermapper=sqlSession.getMapper(flowermapper.class); 
		 flower flower=flowermapper.getFlowerById(flowerid);
		 shoppingcart shoppingcart1=new shoppingcart(flowerid, flower.getName(), uid, user.getUsername());
		 shoppingcartmapper.addFlower(shoppingcart1);
		 sqlSession.commit();
		   return "redirect:/User/Login";
		} 
	   }
	 @RequestMapping("/ShopCar")
	   public String shopcar() {
		   return "redirect:/Shopping/";
	   }
	 @RequestMapping("/SearchFlower")
	   public String searchflower(String condition,Model model) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		 flowermapper flowermapper=sqlSession.getMapper(flowermapper.class);
		 List<flower> flowers=flowermapper.getFlowerByNameOrCategory(condition);
		 model.addAttribute("flowers", flowers);
		   return "user/search";
	   }
}

















