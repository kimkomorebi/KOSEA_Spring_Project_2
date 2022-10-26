package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Cart;
import model.ItemSet;
import model.User;
import sales.SaleCatalog;

@Controller
public class CheckoutController {
	@Autowired
	private SaleCatalog saleCatalog;
	
	/**체크아웃 메서드 총액 메서드*/
	@RequestMapping
	public ModelAndView checkout(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null) {//로그인 하지 않은 경우
			//예외를 발생시킨다.
		}
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {
			//예외를 발생시킨다.
		}//카트가 없거나 비어있는 경우
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		ArrayList<ItemSet> itemList = cart.getItemList();
		mav.addObject("itemList",itemList);
		Integer totalAmount = this.saleCatalog.calculateTotal(itemList);//총액
		mav.addObject("totalAmount",totalAmount);
		return mav;
	}
}
