package sales;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import dao.SaleDao;
import dao.SaleDetailDao;
import dao.UserDao;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SalesDetail;
import model.User;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private ItemDao itemDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleDetailDao saleDetailDao;
	
	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user,cart);
		entrySale(sale);
	}
	private void entrySale(Sale sale) {
		this.saleDao.create(sale);
		List<SalesDetail> saleDetailList = sale.getSalesDetailList();
		for(SalesDetail saleDetail : saleDetailList) {
			this.saleDetailDao.create(saleDetail);
		}//세일 정보를 삽입하고, 세일 상세 정보를 하나씩 삽입한다.
	}
	private Integer getNewSaleId() {
		int newSaleId = this.saleDao.findMaxSaleId() + 1;
		return newSaleId;
	}
	private Sale createSale(User user, Cart cart) {
		Sale sale = new Sale();
		sale.setSaleId(getNewSaleId());
		sale.setUser(user);
		sale.setUserId(user.getUserId());
		List<ItemSet> itemList = cart.getItemList();
		for(int i=0; i<itemList.size(); i++) {
			ItemSet itemSet = (ItemSet)itemList.get(i);
			int saleDetailId = i + 1; //세일 상세 정보 번호
			SalesDetail saleDetail = 
					createSaleDetail(sale, saleDetailId, itemSet);
			sale.addSaleDetail(saleDetail);
		}
		return sale;
	}
	private SalesDetail createSaleDetail(Sale sale, int saleDetailId, ItemSet itemSet) {
		return new SalesDetail(sale, saleDetailId, itemSet);
	}
	public Integer findMaxSaleId() {
		return saleDao.findMaxSaleId();
	}

	public void create(Sale sale) {
		saleDao.create(sale);
	}

	public void create(SalesDetail detail) {
		saleDetailDao.create(detail);
	}

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
