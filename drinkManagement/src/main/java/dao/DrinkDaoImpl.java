package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Drink;
@Repository
public class DrinkDaoImpl implements DrinkDao {
	@Autowired
	private SqlSession session;
	
	
	public Drink findByNum(Integer drinkNum) {
		return session.selectOne("mapper.myhome.addCart",drinkNum);
	}


	public List<Drink> getDrink() {
		return session.selectList("mapper.myhome.getDrinkList");
	}

}
