package sales;

import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Item;
import model.ItemSet;
import model.Sale;
import model.SalesDetail;
import model.User;

public interface SaleCatalog {
	//계산하러 가기를 위한 메소드 시작
	/** 구매 후 종료 시키는 메소드 */
	void checkout(User user, Cart cart);
	/** 가장 큰 세일 아이디 찾기*/
	Integer findMaxSaleId();
	/** 세일 테이블 삽입 */
	void create(Sale sale);
	/** 세일 디테일 테이블 삽입 */
	void create(SalesDetail detail);
	//계산하러 가기를 위한 메소드 끝
	
	Integer calculateTotal(ArrayList<ItemSet> itemList);
	List<Item> findAll();
	Item findById(Integer id);
	User findUser(User user);//로그인에 사용할 메서드 선언
	void create(User user);//회원가입에 사용할 메서드 선언
	
}
