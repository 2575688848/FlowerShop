package controller;

import java.util.List;

import javax.jws.WebParam.Mode;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.flower;
import entity.order;
import mapper.flowermapper;
import mapper.ordermapper;
import sqlSession.sqlsesssion;

@Controller
@RequestMapping("/Admin")
public class AdminController {
	 @RequestMapping("/") 
	   public String index() {
		 return "admin/index";
	 }
	 @RequestMapping(value="/LoginTest" )
	   public String logintest(String username,String password,Model model,RedirectAttributes redirectAttributes) {
		 if(username.equals("ytp")&&password.equals("123"))
		 {
			 SqlSession sqlSession=sqlsesssion.getSqlSession();
			 flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
		List<flower>flowers=	flowermapper.getAllFlowers();
			 redirectAttributes.addFlashAttribute("flowers", flowers);
			 return "redirect:/Admin/Login";
		 }
		 else {
			 redirectAttributes.addFlashAttribute("err", "用户名或密码错误");
			 return "redirect:/Admin/";
		 }
	 }
	 @RequestMapping("/Login") 
	   public String login() {
		 return "admin/login";
	 }
	 @RequestMapping("/AddFlower") 
	   public String addflower() {
		 return "admin/add";
	 }
	 @RequestMapping("/SaveAdd") 
	   public String add(flower flower,RedirectAttributes redirectAttributes) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
			flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
			int a=flowermapper.addFlower(flower);
			sqlSession.commit();
			System.out.println(a);
			if(a!=0) {
				List<flower>flowers=flowermapper.getAllFlowers();
				redirectAttributes.addFlashAttribute("flowers", flowers);
				return "redirect:/Admin/Login";
			}
		 return "";
	 }
	 @RequestMapping("/DeleteFlower") 
	   public String deleteflower(Integer id,RedirectAttributes redirectAttributes) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
			flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
			System.out.println(id);
			int id1=id;
			flowermapper.deleteFlower(id1);
			sqlSession.commit();
			List<flower>flowers=flowermapper.getAllFlowers();
			redirectAttributes.addFlashAttribute("flowers", flowers);
			
				return "redirect:/Admin/Login";  
	 }
	 @RequestMapping("/EditFlower") 
	   public String editflower(int id,Model model) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
		flower flower=flowermapper.getFlowerById(id);
		 model.addAttribute("flower",flower);
		  return "admin/edit";
	 }
	 @RequestMapping("/EditSave") 
	   public String editsave(flower flower,RedirectAttributes redirectAttributes) {
		
		 System.out.println(flower);
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
		int a=flowermapper.updateFlower(flower);
		sqlSession.commit();
		List<flower>flowers=flowermapper.getAllFlowers();
		redirectAttributes.addFlashAttribute("flowers", flowers);
		
			return "redirect:/Admin/Login";  
	 }
	 @RequestMapping("/Search") 
	   public String search(String condition,Model model) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		flowermapper flowermapper= sqlSession.getMapper(flowermapper.class);
		List<flower> flowers=flowermapper.getFlowerByNameOrCategory(condition);
		 model.addAttribute("flowers",flowers);
		  return "admin/search";
	 }
	 
	 @RequestMapping("/UserOrders") 
	   public String userorders(Model model) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		ordermapper ordermapper= sqlSession.getMapper(ordermapper.class);
		List<order> orders=ordermapper.getAllOrders();
		 model.addAttribute("orders",orders);
		  return "admin/orders";
	 }
	 @RequestMapping("/ConfirmOrder") 
	   public String confirmorder(int id) {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		ordermapper ordermapper= sqlSession.getMapper(ordermapper.class);
		int a=ordermapper.deleteOrder(id);
		sqlSession.commit();
		  return "redirect:/Admin/UserOrders";
	 }
	 @RequestMapping("/DeleteOrderAll") 
	   public String deleteorderall() {
		 SqlSession sqlSession=sqlsesssion.getSqlSession();
		ordermapper ordermapper= sqlSession.getMapper(ordermapper.class);
		ordermapper.deleteAllOrder();
		sqlSession.commit();
		  return "redirect:/Admin/UserOrders";
	 }
}
