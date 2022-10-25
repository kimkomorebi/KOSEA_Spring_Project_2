package sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dao.UserDao;
import model.Item;
import model.User;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
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
