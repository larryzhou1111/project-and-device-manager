package cn.larryzhou.project.domain;

public class Project {
    
	private String pid;
	private String pname;
	private String principal;
	private double tprice;
	private double balance;
	private String deadline;
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public double getTprice() {
		return tprice;
	}
	public void setTprice(double tprice) {
		this.tprice = tprice;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "Project [pid=" + pid + ", pname=" + pname + ", principal="
				+ principal + ", tprice=" + tprice + ", balance=" + balance
				+ ", deadline=" + deadline + "]";
	}
	

	

}
