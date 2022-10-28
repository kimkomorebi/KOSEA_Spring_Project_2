package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.SalesDetail;

@Repository
public class SaleDetailDaoImpl implements SaleDetailDao {
	@Autowired
	private SqlSession session;
	
	public void create(SalesDetail detail) {
		detail.setSaleId(detail.getSale().getSaleId());
		detail.setItemId(detail.getItem().getItemId());
		session.insert("mapper.mysale.putSaleDetail",detail);
		
	}

}
