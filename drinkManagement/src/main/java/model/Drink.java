package model;

import java.util.ArrayList;

public class Drink {
	private Integer drinkNum;
	private String drinkName;
	private String drinkSize;
	private Integer price;
	private String origin;
	private String info;
	
	private Integer orderNum;
	//drinkNum
	private String orderTime;
	private Integer orderCount;
	private Integer totalPrice;
	private ArrayList<DrinkSet> drinkList = new ArrayList<DrinkSet>();
	
	public ArrayList<DrinkSet> getDrinkList() {
		return drinkList;
	}
	public Integer getDrinkNum() {
		return drinkNum;
	}
	public void setDrinkNum(Integer drinkNum) {
		this.drinkNum = drinkNum;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDrinkSize() {
		return drinkSize;
	}
	public void setDrinkSize(String drinkSize) {
		this.drinkSize = drinkSize;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
