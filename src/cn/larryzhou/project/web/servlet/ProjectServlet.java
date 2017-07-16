package cn.larryzhou.project.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.larryzhou.device.domain.Device;
import cn.larryzhou.project.domain.Project;
import cn.larryzhou.project.service.ProjectService;

public class ProjectServlet extends BaseServlet {
    
	private ProjectService projectService = new ProjectService();
	/**
	 * 1.将device封装成bean对象
	 * 2.添加did
	 * 3.调用service的add方法
	 * 4.在request里封装成功信息
	 * 5.转发到msg页面
	 * */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		Project p = CommonUtils.toBean(request.getParameterMap(), Project.class);
		p.setPid(CommonUtils.uuid());
		projectService.add(p);
		request.setAttribute("msg", "恭喜，保存项目成功!");
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
	public String findAllProject(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		//System.out.println("zheli!!!!!!!!!!!!!!!");
		List<Project> p = projectService.findAllProject();
		
		request.setAttribute("projectList", projectService.findAllProject());
		
		return "f:/jsps/listProject.jsp";
	}
	
	/**
	 * 1.通过did
	 * 2.调用service的方法得到Project
	 * 3.将Project保存到request中
	 * 4.转发到edit.jsp中
	 * */
	public String preEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		String pid = request.getParameter("pid");
		Project p = projectService.load(pid);
		request.setAttribute("project", p);
		return "f:/jsps/editProject.jsp";
	}
	
	/**
	 * 1.参数转成Project
	 * 2.调用service的edit方法
	 * 3.保存成功信息到request中
	 * 4.转发到msg.jsp
	 * */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		//pid也被包含在了参数中
		Project p = CommonUtils.toBean(request.getParameterMap(), Project.class);
		projectService.edit(p);
		request.setAttribute("msg", "修改设备信息成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 1.得到did
	 * 2.调用service删除Project
	 * 3.保存删除设备成功信息到request
	 * 4.转发到msg.jsp
	 * */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		String pid = request.getParameter("pid");
		projectService.delete(pid);
		request.setAttribute("msg", "删除设备成功！");
		return "f:/msg.jsp";
	}
	
	/**
	 * 高级查找
	 * 1.将得到的Project条件封装到Project
	 * 2.调用service方法得到Project
	 * 3.封装Customer到request（Project）域中
	 * 4.转发到list.jsp
	 * */
	public String query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		Project p = CommonUtils.toBean(request.getParameterMap(), Project.class);
		List<Project> projectList = projectService.query(p);
		request.setAttribute("projectList", projectList);
		return "f:/jsps/listProject.jsp";
	}
}
