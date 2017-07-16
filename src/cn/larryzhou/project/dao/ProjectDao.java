package cn.larryzhou.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.jdbc.TxQueryRunner;
import cn.larryzhou.device.domain.Device;
import cn.larryzhou.project.domain.Project;

public class ProjectDao {
    
	private QueryRunner qr = new TxQueryRunner();
	/**
	 * 添加设备
	 * */
	public void add(Project p){
	    
		try{
			String sql = "insert into t_project(pid,pname,principal,tprice,balance,deadline) values(?,?,?,?,?,?)";
			Object[] params = {p.getPid(), p.getPname(), p.getPrincipal(), p.getTprice(), p.getBalance(), p.getDeadline()};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 查询所有
	 * */
	public List<Project> findAllProject(){
	    
		try{
			String sql = "select * from t_project";
			return qr.query(sql, new BeanListHandler(Project.class));
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 加载设备
	 * 
	 * */
	public Project load(String pid) {
	    
		try{
			String sql = "select * from t_project where pid=?";
			return qr.query(sql, new BeanHandler<Project>(Project.class), pid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

	/**
	 * 修改设备信息
	 * */
	public void edit(Project p) {
	    
		try{
			String sql = "update t_project set pname=?,principal=?,tprice=?,balance=?,deadline=? where pid=?";
			Object[] params = {p.getPname(), p.getPrincipal(), p.getTprice(), p.getBalance(), p.getDeadline(), p.getPid()};
			qr.update(sql, params);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 删除设备
	 * */
	public void delete(String pid) {
	    
		try{
			String sql = "delete from t_project where pid=?";
			qr.update(sql, pid);
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}

	/**
	 * 高级查找
	 * */
	public List<Project> query(Project p) {
	    
		try{
			/**
			 * 1.给出sql模版
			 * 2.给出参数
			 * 3.调用qr得到List<Device>
			 * */
			StringBuilder sql = new StringBuilder("select * from t_project where 1=1");
			List<Object> params = new ArrayList<Object>();
			
			String pname = p.getPname();			
			if(pname != null && !pname.trim().isEmpty()){
			    
				sql.append(" and pname like ?");
				params.add("%" + pname + "%");
			}
			
			String principal = p.getPrincipal();
			if(principal!=null && !principal.trim().isEmpty()){
			    
				sql.append(" and principal like ?");
				params.add("%" + principal + "%");
			}
			
			String deadline = p.getDeadline();
			if(deadline != null && !deadline.trim().isEmpty()){
			    
				sql.append(" and deadline like ?");
				params.add("%" + deadline + "%");
			}
			
			List<Project> pp = qr.query(sql.toString(), new BeanListHandler<Project>(Project.class), params.toArray());
			return pp;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
}