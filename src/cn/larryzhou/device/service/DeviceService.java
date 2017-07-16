package cn.larryzhou.device.service;

import java.util.List;

import cn.larryzhou.device.dao.DeviceDao;
import cn.larryzhou.device.domain.Device;
/**
 * 业务层
 * */
public class DeviceService {
    
	private DeviceDao deviceDao = new DeviceDao();
	/**
	 * 添加客户
	 * */
	public void add(Device d){
		deviceDao.add(d);
	}
	
	/**
	 * 查询所有
	 * */
	public List<Device> findAll(){
		return deviceDao.findAll();
	}

	/**
	 * 加载设备
	 * */
	public Device load(String did) {
		 return deviceDao.load(did);		
	}

	/**
	 * 修改设备
	 * */
	public void edit(Device d) {
		deviceDao.edit(d);
	}

	/**
	 * 删除设备
	 * */
	public void delete(String did) {
		deviceDao.delete(did);
	}

	/**
	 * 高级查找
	 * */
	public List<Device> query(Device d) {
		return deviceDao.query(d);
	}
}
