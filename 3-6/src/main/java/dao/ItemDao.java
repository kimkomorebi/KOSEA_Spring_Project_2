package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findById(Integer id);
	void create(Item item);//상품 삽입
	void delete(Integer itemId);
	void update(Item item);// 상품변경
	List<Item> findByName(String name);//이름으로 상품 검색
}
