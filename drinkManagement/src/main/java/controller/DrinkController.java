package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.DrinkDao;
import model.Drink;
import model.DrinkSet;

@Controller
public class DrinkController {
	@Autowired
	private DrinkDao drinkDao;
	
	@RequestMapping(value="/drink/cartAdd.html")
	public ModelAndView cartAdd(Integer drinkNum, Integer orderCount) {
		Drink drink = this.drinkDao.findByNum(drinkNum);
		ModelAndView mav = new ModelAndView("cart");
		DrinkSet ds = new DrinkSet(drink, orderCount);
		mav.addObject("drinkSet",ds);
		return mav;
	}
	
	@RequestMapping(value="/drink/index.html")
	public ModelAndView index() {
		List<Drink> drinkList = this.drinkDao.getDrink();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("drinkList", drinkList);
		return mav;
	}
	
}
