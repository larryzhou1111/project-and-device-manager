package cn.larryzhou.device.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.larryzhou.device.domain.Device;

public class DeviceDao {
    
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 添加设备
	 * */
	public void add(Device d){
		try{
			String sql = "insert into t_device values(?, ?, ?)";
			Object[] params = {d.getDid(),d.getDname(), d.getBirthday()};
			qr.update(sql,params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询所有
	 * */
	public List<Device> findAll(){
	    
		try{
			String sql = "select * from t_device";
			return qr.query(sql, new BeanListHandler(Device.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载设备
	 * 
	 * */
	public Device load(String did) {
	    
		try{
			String sql = "select * from t_device where did=?";
			return qr.query(sql, new BeanHandler<Device>(Device.class), did);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改设备信息
	 * */
	public void edit(Device d) {
	    
		try{
			String sql = "update t_device set dname=?,birthday=? where did=?";
			Object[] params = {d.getDname(),d.getBirthday(), d.getDid()};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 删除设备
	 * */
	public void delete(String did) {
	    
		try{
			String sql = "delete from t_device where did=?";
			qr.update(sql, did);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 高级查找
	 * */
	public List<Device> query(Device d) {
	    
		try{
			/**
			 * 1.给出sql模版
			 * 2.给出参数
			 * 3.调用qr得到List<Device>
			 * */
			StringBuilder sql = new StringBuilder("select * from t_device where 1=1");
			List<Object> params = new ArrayList<Object>();
			
			String dname = d.getDname();
			System.out.println(dname);
			
			if(dname != null && !dname.trim().isEmpty()){
			    
				sql.append(" and dname like ?");
				params.add("%"+dname+"%");
			}
			
			List<Device> dd = qr.query(sql.toString(), new BeanListHandler<Device>(Device.class), params.toArray());
			return dd;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}
