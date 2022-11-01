package dao;

import java.util.List;

import model.Drink;

public interface DrinkDao {
	List<Drink> getDrink();
	Drink findByNum(Integer drinkNum);
}
