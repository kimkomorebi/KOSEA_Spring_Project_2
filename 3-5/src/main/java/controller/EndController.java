package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import exception.CartEmptyException;
import exception.LoginRequiredException;
import model.Cart;
import model.User;
import sales.SaleCatalog;

@Controller
public class EndController {
	@Autowired
	private SaleCatalog saleCatalog;
	/** 양쪽 테이블에 삽입 되면서 구매 종료되는 메소드 */
	@RequestMapping
	public ModelAndView end(HttpSession session) {
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser == null)
			throw new LoginRequiredException("로그인이 필요합니다.");
		Cart cart = (Cart) session.getAttribute("CART_KEY");
		if(cart == null || cart.isEmpty()) {
			throw new CartEmptyException("카트가 비었습니다");
		}
		this.saleCatalog.checkout(loginUser, cart);
		cart.clearAll();//구매가 종료되었으므로 장바구니를 비운다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		return mav;
	}
}
