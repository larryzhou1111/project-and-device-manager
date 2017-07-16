package cn.larryzhou.user.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.larryzhou.user.domain.User;
import cn.larryzhou.user.service.UserService;

public class UserServlet extends BaseServlet {
    
	private UserService userService = new UserService();
	
	/**
	 * 登录功能
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 封装表单数据到User
		 * 2. 校验表单数据
		 * 3. 使用service查询，得到User
		 * 4. 查看用户是否存在，如果不存在：
		 *   * 保存错误信息：用户名或密码错误
		 *   * 保存用户数据：为了回显
		 *   * 转发到login.jsp
		 * 5. 如果存在，查看状态，如果状态为false：
		 *   * 保存错误信息：您没有激活
		 *   * 保存表单数据：为了回显
		 *   * 转发到login.jsp
		 * 6. 登录成功：
		 * 　　* 保存当前查询出的user到session中
		 *   * 保存当前用户的名称到cookie中，注意中文需要编码处理。
		 */
		/*
		 * 1. 封装表单数据到user
		 */
		User formUser = CommonUtils.toBean(req.getParameterMap(), User.class);
		/*
		 * 2. 校验
		 */
		Map<String,String> errors = validateLogin(formUser, req.getSession());
		if(errors.size() > 0) {
		    
			req.setAttribute("form", formUser);
			req.setAttribute("errors", errors);
			return "f:/user/login.jsp";
		}
		
		/*
		 * 3. 调用userService#login()方法
		 */
		User user = userService.login(formUser);
		/*
		 * 4. 开始判断
		 */
		if(user == null) {
		    
			req.setAttribute("msg", "用户名或密码错误！");
			req.setAttribute("user", formUser);
			return "f:/user/login.jsp";
			
		} else {
			if(user.getStatus() != 1) {	
			    
				// 保存信息和用户到session				
				req.getSession().setAttribute("sessionUser", user);
				return "f:/user/login.jsp";	
				
			} else {
				// 保存用户到session
				req.getSession().setAttribute("sessionUser", user);
				return "r:/index.jsp";//重定向到主页
			}
		}
	}
	
	/*
	 * 登录校验方法，内容等你自己来完成
	 */
	private Map<String,String> validateLogin(User formUser, HttpSession session) {
	    
		Map<String,String> errors = new HashMap<String,String>();
		return errors;
	}
	
	/**
	 * ajax验证码是否正确校验
	 * @param req
	 * @param resp
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String ajaxValidateVerifyCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		 * 1. 获取输入框中的验证码
		 */
		String verifyCode = req.getParameter("verifyCode");
		/*
		 * 2. 获取图片上真实的校验码
		 */
		String vcode = (String) req.getSession().getAttribute("vCode");
		/*
		 * 3. 进行忽略大小写比较，得到结果
		 */
		boolean b = verifyCode.equalsIgnoreCase(vcode);
		/*
		 * 4. 发送给客户端
		 */
		resp.getWriter().print(b);
		return null;
	}
	
}
