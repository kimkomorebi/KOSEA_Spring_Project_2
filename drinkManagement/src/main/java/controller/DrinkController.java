package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DrinkDao;
import model.Cart;
import model.Drink;
import model.DrinkSet;
import model.User;

@Controller
public class DrinkController {
	@Autowired
	private DrinkDao drinkDao;
	
	@RequestMapping(value="/drink/cartAdd.html")
	public ModelAndView cartAdd(Integer drinkNum, Integer orderCount, HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) {
			cart = new Cart();
		}
		Drink drink = this.drinkDao.findByNum(drinkNum);
		DrinkSet ds = new DrinkSet(drink, orderCount);
		cart.push(ds);
		session.setAttribute("CART_KEY", cart);
		session.setAttribute("ITEM_KEY", drink);
		session.setAttribute("COUNT_KEY", orderCount);
		
		ModelAndView mav = new ModelAndView("redirect:/drink/result.html");
		return mav;
	}
	@RequestMapping(value="/drink/result.html")
	public ModelAndView result(HttpSession session) {
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		Drink drink = (Drink)session.getAttribute("ITEM_KEY");
		Integer orderCount = (Integer)session.getAttribute("COUNT_KEY");
		ModelAndView mav = new ModelAndView("cart");
		mav.addObject("drinkSet",cart);
		return mav;
	}
	
	@RequestMapping(value="/drink/index.html")
	public ModelAndView index(HttpSession session) {
		User user = (User)session.getAttribute("USER_KEY");
		List<Drink> drinkList = this.drinkDao.getDrink();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("drinkList", drinkList);
		if(user != null) mav.addObject("login",user);
		return mav;
	}
	
}
