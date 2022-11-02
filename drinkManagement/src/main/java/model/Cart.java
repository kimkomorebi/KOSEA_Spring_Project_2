package model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<DrinkSet> drinkList = new ArrayList<DrinkSet>();

	public ArrayList<DrinkSet> getDrinkList() {
		return drinkList;
	}
	
	public void push(DrinkSet pushedItemSet) {
		boolean itemExistInCart = false;//이미 있는 물건인지 검사
		Drink pushedItem = pushedItemSet.getDrink(); //Drink DTO 객체 주입
		int pushedItemId = pushedItem.getDrinkNum();//Drink DTO에서의 상품번호
		for(DrinkSet cartItemSet : this.drinkList) {
			Drink cartItem = cartItemSet.getDrink();//Cart 클래스의 ArrayList<ItemSet>에서 접근한 Item 객체 주입 > 장바구니 상품
			int cartItemId = cartItem.getDrinkNum();//Cart 클래스의 ArrayList<ItemSet>에서 접근한 Item 객체 상품번호
			if(pushedItemId == cartItemId){
				cartItemSet.addOrderCount(pushedItemSet.getOrderCount());
				itemExistInCart = true;//이미 동일한 상품이 있다.
				break;//반복 중지
			}//이미 있는 상품 번호와 담으려는 상품 번호가 같은 경우
		}//for의 끝
		if( ! itemExistInCart) {
			this.drinkList.add(pushedItemSet);//장바구니에 추가 동일 상품이 없을 때 false가 true로 바뀌어서 동작
		}
	}//메서드의 끝
}
