package com.sc.entity;

import java.io.Serializable;

public class Users implements Serializable{
	
	private Integer uid;
	private String uname;
	private String upass;
	private Integer uage;
	
	
	public Users() {
		super();
	}


	public Users(Integer uid, String uname, String upass, Integer uage) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
		this.uage = uage;
	}

	

	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", uage=" + uage + "]";
	}


	public Integer getUid() {
		return uid;
	}


	public void setUid(Integer uid) {
		this.uid = uid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUpass() {
		return upass;
	}


	public void setUpass(String upass) {
		this.upass = upass;
	}


	public Integer getUage() {
		return uage;
	}


	public void setUage(Integer uage) {
		this.uage = uage;
	}
	
	

}
