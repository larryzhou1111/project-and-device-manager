package cn.larryzhou.user.service;

import java.sql.SQLException;

import cn.larryzhou.user.dao.UserDao;
import cn.larryzhou.user.domain.User;

public class UserService {
    
	private UserDao userDao = new UserDao();

	/**
	 * 登录功能
	 * @param user
	 * @return
	 */
	public User login(User user) {
	    
		try {
			return userDao.findByLoginnameAndLoginpass(user.getLoginname(), user.getLoginpass());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
