package cn.larryzhou.project.service;

import java.util.List;

import cn.larryzhou.device.dao.DeviceDao;
import cn.larryzhou.device.domain.Device;
import cn.larryzhou.project.dao.ProjectDao;
import cn.larryzhou.project.domain.Project;
/**
 * 业务层
 * */
public class ProjectService {
    
	private ProjectDao projectDao = new ProjectDao();
	/**
	 * 添加客户
	 * */
	public void add(Project p){
		projectDao.add(p);
	}
	
	/**
	 * 查询所有
	 * */
	public List<Project> findAllProject(){
		return projectDao.findAllProject();
	}

	/**
	 * 加载设备
	 * */
	public Project load(String pid) {
		 return projectDao.load(pid);		
	}

	/**
	 * 修改设备
	 * */
	public void edit(Project p) {
		projectDao.edit(p);
	}

	/**
	 * 删除设备
	 * */
	public void delete(String pid) {
		projectDao.delete(pid);
	}

	/**
	 * 高级查找
	 * */
	public List<Project> query(Project p) {
		return projectDao.query(p);
	}
}
