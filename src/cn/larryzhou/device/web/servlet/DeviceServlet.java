package cn.larryzhou.device.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.larryzhou.device.domain.Device;
import cn.larryzhou.device.service.DeviceService;

public class DeviceServlet extends BaseServlet {
    
	private DeviceService deviceService = new DeviceService();
	/**
	 * 1.将device封装成bean对象
	 * 2.添加did
	 * 3.调用service的add方法
	 * 4.在request里封装成功信息
	 * 5.转发到msg页面
	 * */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	     
		Device d = CommonUtils.toBean(request.getParameterMap(), Device.class);
		d.setDid(CommonUtils.uuid());
		deviceService.add(d);
		request.setAttribute("msg", "恭喜，保存设备成功!");
		return "f:/msg.jsp";
	}
	
	public String quit(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	    
		req.getSession().invalidate();
		return "r:/user/login.jsp";
	}
	
	/**
	 * 1.调用service方法得到List<Device>
	 * 2.将List保存到request域中
	 * 3.转发到list.jsp
	 * */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		request.setAttribute("deviceList", deviceService.findAll());
		return "f:/jsps/list.jsp";
	}
	
	/**
	 * 1.通过did
	 * 2.调用service的方法得到Device
	 * 3.将Device保存到request中
	 * 4.转发到edit.jsp中
	 * */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		String did = request.getParameter("did");
		Device d = deviceService.load(did);
		request.setAttribute("device",d);
		return "f:/jsps/edit.jsp";
	}
	
	/**
	 * 1.参数转成Device
	 * 2.调用service的edit方法
	 * 3.保存成功信息到request中
	 * 4.转发到msg.jsp
	 * */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		//did也被包含在了参数中
		Device d = CommonUtils.toBean(request.getParameterMap(), Device.class);
		deviceService.edit(d);
		request.setAttribute("msg", "修改设备信息成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 1.得到did
	 * 2.调用service删除Device
	 * 3.保存删除设备成功信息到request
	 * 4.转发到msg.jsp
	 * */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		String did = request.getParameter("did");
		deviceService.delete(did);
		request.setAttribute("msg", "删除设备成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 高级查找
	 * 1.将得到的Device条件封装到Device 
	 * 2.调用service方法得到Device
	 * 3.封装Customer到request（device）域中
	 * 4.转发到list.jsp
	 * */
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		Device d = CommonUtils.toBean(request.getParameterMap(), Device.class);
		List<Device> deviceList = deviceService.query(d);
		request.setAttribute("deviceList", deviceList);
		return "f:/jsps/list.jsp";
	}
}
