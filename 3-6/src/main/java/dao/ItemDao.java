package dao;

import java.util.List;

import model.Item;

public interface ItemDao {
	List<Item> findAll();
	Item findById(Integer id);
	void create(Item item);//상품 삽입
}
