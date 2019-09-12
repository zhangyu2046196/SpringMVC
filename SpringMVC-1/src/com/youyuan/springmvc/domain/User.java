package com.youyuan.springmvc.domain;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String userName;
	private String passWord;
	private String email;
	private Integer age;
	private Address address;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String userName, String passWord, String email, Integer age) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.age = age;
	}

	public User(Integer id, String userName, String passWord, String email,
			Integer age) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", passWord=" + passWord
				+ ", email=" + email + ", age=" + age + ", address=" + address
				+ "]";
	}
}
