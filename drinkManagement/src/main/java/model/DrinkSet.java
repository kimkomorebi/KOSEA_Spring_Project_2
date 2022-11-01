package model;

public class DrinkSet {
	private Integer orderCount; // 갯수
	private Drink drink; // 음료 객체
	public DrinkSet(Drink drink, Integer orderCount) {
		this.drink = drink;
		this.orderCount = orderCount;
	}
	public void addOrderCount(Integer addOrderCount) {
		orderCount = orderCount + addOrderCount;
	}
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Drink getDrink() {
		return drink;
	}
	public void setDrink(Drink drink) {
		this.drink = drink;
	}
	
	
}
