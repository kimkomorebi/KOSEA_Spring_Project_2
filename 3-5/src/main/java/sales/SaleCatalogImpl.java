package sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dao.UserDao;
import model.Item;
import model.ItemSet;
import model.User;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
	
	public Integer calculateTotal(ArrayList<ItemSet> itemList) {
		int totalAmount = 0;//총액을 위한 변수 선언
		for(ItemSet itemSet : itemList) {
			int price = itemSet.getItem().getPrice();
			int quantity = itemSet.getQuantity();
			totalAmount = totalAmount + (price * quantity);
		}
		return totalAmount;
	}

	public List<Item> findAll() {
		return itemDao.findAll();
	}

	public Item findById(Integer id) {
		return itemDao.findById(id);
	}

	public User findUser(User user) {
		return userDao.findUser(user);
	}

	public void create(User user) {
		userDao.create(user);
	}

}
