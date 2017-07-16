package cn.larryzhou.user.domain;

public class User {
    
	// 对应数据库表
	private String uid;//主键
	private String loginname;//登录名
	private String loginpass;//登录密码
	private int status; //管理员等级，1代表教师管理员，0代表学生管理员
	private String verifyCode;//验证码
	
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpass() {
		return loginpass;
	}
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", loginname=" + loginname + ", loginpass="
				+ loginpass + ", status=" + status + ", verifyCode="
				+ verifyCode + "]";
	}
	
}
