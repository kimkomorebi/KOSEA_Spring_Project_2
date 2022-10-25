package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDaoimpl implements UserDao {
	@Autowired
	private SqlSession session;

	public void create(User user) {
		session.insert("mapper.myhome.putUser",user);
	}

	public User findUser(User user) {
		return session.selectOne("mapper.myhome.getUser",user);
	}

}
