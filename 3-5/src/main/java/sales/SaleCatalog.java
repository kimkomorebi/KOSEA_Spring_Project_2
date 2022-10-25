package sales;

import java.util.List;

import model.Item;
import model.User;

public interface SaleCatalog {
	List<Item> findAll();
	Item findById(Integer id);
	User findUser(User user);//로그인에 사용할 메서드 선언
	void create(User user);//회원가입에 사용할 메서드 선언
}
