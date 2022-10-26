package model;

import java.util.ArrayList;

public class Sale {
	private User user;
	private Integer saleId;
	private String userId;
	private String buy_date;
	private ArrayList<SalesDetail> salesDetailList = 
			new ArrayList<SalesDetail>();
	
	public void addSaleDetail(SalesDetail detail) {
		this.salesDetailList.add(detail);
	}
	
	
	public String getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getSaleId() {
		return saleId;
	}
	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ArrayList<SalesDetail> getSalesDetailList() {
		return salesDetailList;
	}
	public void setSalesDetailList(ArrayList<SalesDetail> salesDetailList) {
		this.salesDetailList = salesDetailList;
	}
}
