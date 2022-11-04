package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class LoginUserImpl implements LoginUser {
@Autowired
private SqlSession session;

	public User loginUser(User user) {
		return session.selectOne("mapper.myhome.getUser",user);
	}

}
