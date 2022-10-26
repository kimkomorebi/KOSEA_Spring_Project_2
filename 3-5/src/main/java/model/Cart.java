package model;

import java.util.ArrayList;

public class Cart {
	private ArrayList<ItemSet> itemList = new ArrayList<ItemSet>();

	public ArrayList<ItemSet> getItemList() {
		return itemList;
	}
	public void push(ItemSet pushedItemSet) {
		boolean itemExistInCart = false;//이미 있는 물건인지 검사
		Item pushedItem = pushedItemSet.getItem(); //Item DTO 객체 주입
		int pushedItemId = pushedItem.getItemId();//Item DTO에서의 상품번호
		for(ItemSet cartItemSet : this.itemList) {
			Item cartItem = cartItemSet.getItem();//Cart 클래스의 ArrayList<ItemSet>에서 접근한 item 객체 > 장바구니 상품
			int cartItemId = cartItem.getItemId();//Cart 클래스의 ArrayList<ItemSet>에서 접근한 item 객체 상품번호
			if(pushedItemId == cartItemId){
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				itemExistInCart = true;//이미 동일한 상품이 있다.
				break;//반복 중지
			}//이미 있는 상품 번호와 담으려는 상품 번호가 같은 경우
		}//for의 끝
		if( ! itemExistInCart) {
			this.itemList.add(pushedItemSet);//장바구니에 추가 동일 상품이 없을 때 false가 true로 바뀌어서 동작
		}
	}//메서드의 끝
	
	public void clearAll() {
		this.itemList = new ArrayList<ItemSet>();
	}//장바구니(itemList)를 비우는 메서드
	
	public boolean isEmpty() {
		if(this.itemList == null || this.itemList.isEmpty()) {
			return true; //비어있으면 true
		}
		return false;
	}//장바구니가 비어있는지 검사하는 메서드
}
