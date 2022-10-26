package sales;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.ItemSet;
import model.User;

public interface SaleCatalog {
	Integer calculateTotal(ArrayList<ItemSet> itemList);
	List<Item> findAll();
	/** 해당 상품 번호의 상품 찾기 메소드 */
	Item findById(Integer id);
	User findUser(User user);//로그인에 사용할 메서드 선언
	void create(User user);//회원가입에 사용할 메서드 선언
}
