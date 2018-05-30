package controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.flower;
import entity.user;
import mapper.flowermapper;
import mapper.usermapper;
import sqlSession.sqlsesssion;

@Controller
@RequestMapping("/Home")
public class HomeController {
  
   @RequestMapping("/")
   public String index(Model model) {
	  
	  SqlSession sqlSession=sqlsesssion.getSqlSession();
	  flowermapper flowermapper=sqlSession.getMapper(flowermapper.class);
	  List<flower> flowers=flowermapper.getAllFlowers();
	  model.addAttribute("flowers", flowers);
	  
	   return "home/index";
   }
   @RequestMapping("/AdminLogin")
   public String adminlogin(){
	  
	   	return "redirect:/Admin/";
//	   System.out.println(user);
//	   if(user.getUsername().equals("zz")) {
//		   redirectAttributes.addFlashAttribute("user",user);
//		   return "redirect:/Home/Welcome";
//		   }else {
//		   redirectAttributes.addFlashAttribute("errorMsg","用户名或密码错！");
//		   return "redirect:/Home/";
//		   } 
//   }
//  

   }
   @RequestMapping("/Welcome")
   public String welcome(){
   return "home/welcome";
   }
   @RequestMapping("/UserLogin")
   public String userlogin() {
	  
	  
	   return  "redirect:/User/";
   }
}
