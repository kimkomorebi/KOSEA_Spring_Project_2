package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import model.Cart;
import model.Item;
import model.ItemSet;
import sales.SaleCatalog;


@Controller
public class CartController {
	@Autowired
	private SaleCatalog saleCatalog;
	
	@RequestMapping(value="/cart/cartAdd.html")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session) {
		Item item = this.saleCatalog.findById(itemId);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null) cart = new Cart();
		ItemSet is = new ItemSet(item, quantity);
		cart.push(is);
		session.setAttribute("CART_KEY", cart);
		session.setAttribute("ITEM_KEY", item);
		session.setAttribute("NUMBER", quantity);
		//화면을 장바구니 결과로 바꾼다.
		return null;
	}
}
