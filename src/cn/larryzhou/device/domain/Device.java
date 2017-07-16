package cn.larryzhou.device.domain;

public class Device {
    
	private String did;
	private String dname;
	private String birthday;
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Device [did=" + did + ", dname=" + dname + ", birthday="
				+ birthday + "]";
	}
}
