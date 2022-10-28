package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.ItemDao;
import model.Item;

@Controller
public class ItemController {
	@Autowired
	private ItemDao itemDao;
	
	@RequestMapping(value="/item.confirm.html")
	public ModelAndView confirm(Integer itemId) {
		ModelAndView mav = new ModelAndView("delete");
		Item item = this.itemDao.findById(itemId);
		mav.addObject(item);//검색결과를 jsp에 주입한다.
		mav.addObject("imageName", item.getItemName());
		return mav;
	}
	
	@RequestMapping(value="/item/index.html")
	public ModelAndView index() {
		List<Item> itemList = this.itemDao.findAll();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList",itemList);
		return mav;
	}
}
