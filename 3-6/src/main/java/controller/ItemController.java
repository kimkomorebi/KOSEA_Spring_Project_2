package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
	@RequestMapping(value="/item/register.html")
	public ModelAndView register(Item item, HttpServletRequest request) throws Exception {
		ServletContext ctx = request.getSession().getServletContext();
		String realPath = ctx.getRealPath("/upload");
		String encType = "euc-kr";
		int maxSize = 5 * 1024 * 1024;
		MultipartRequest multipart = new MultipartRequest(request,realPath,maxSize,encType, new DefaultFileRenamePolicy());
		String fileName = multipart.getFilesystemName("pictureUrl");//업로드 실행
		System.out.println("업로드한 경로"+realPath);
		item.setItemId(Integer.parseInt(
				multipart.getParameter("itemId")));
		item.setItemName(multipart.getParameter("itemName"));
		item.setPrice(Integer.parseInt(multipart.getParameter("price")));
		item.setPictureUrl(fileName);
		item.setInfo(multipart.getParameter("info"));
		this.itemDao.create(item);
		return index();//삽입 후 목록을 출력한다.
	}
	
	@RequestMapping(value="/item/create.html")
	public ModelAndView create(){
		ModelAndView mav = new ModelAndView("add");
		mav.addObject(new Item());
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
