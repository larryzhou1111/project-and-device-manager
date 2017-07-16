package cn.larryzhou.user.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.larryzhou.user.domain.User;

/**
 * 用户模块持久层
 * @author larryzhou
 *
 */
public class UserDao {
    
	private QueryRunner qr = new TxQueryRunner();

	/**
	 * 按用户名和密码查询
	 * @param loginname
	 * @param loginpass
	 * @return
	 * @throws SQLException 
	 */
	public User findByLoginnameAndLoginpass(String loginname, String loginpass) throws SQLException {
		
	        String sql = "select * from t_user where loginname=? and loginpass=?";
		return qr.query(sql, new BeanHandler<User>(User.class), loginname, loginpass);
		
	}
	

}
