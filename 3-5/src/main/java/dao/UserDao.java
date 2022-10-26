package dao;

import model.User;

public interface UserDao {
	/** 아이디와 패스워드가 같은 애를 select */
	User findUser(User user);//로그인에 사용할 메서드 선언
	void create(User user);//회원가입에 사용할 메서드 선언
	
}
