package dao;

import org.apache.ibatis.session.SqlSession;

import model.User;

public class UserDaoimpl implements UserDao {
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	public void create(User user) {
		session.insert("mapper.myhome.putUser",user);
	}

	public User findUser(User user) {
		return session.selectOne("mapper.myhome.getUser",user);
	}

}
