package com.youyuan.springmvc.bean;

import java.io.Serializable;

/**
 * 员工bean
 * @author zhangyu
 * @date 2018-4-5 下午8:24:38
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer guid;
	private String userName;
	private String passWord;
	private String email;
	private Integer gender;
	private Department dept;
	public Employee() {

	}
	public Employee(Integer guid, String userName, String passWord,
			String email, Integer gender, Department dept) {
		super();
		this.guid = guid;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}
	public Integer getGuid() {
		return guid;
	}
	public void setGuid(Integer guid) {
		this.guid = guid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [guid=" + guid + ", userName=" + userName
				+ ", passWord=" + passWord + ", email=" + email + ", gender="
				+ gender + ", dept=" + dept + "]";
	}
}
