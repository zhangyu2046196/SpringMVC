package com.youyuan.springmvc.bean;

import java.io.Serializable;

/**
 * 部门bean
 * @author zhangyu
 * @date 2018-4-5 下午8:26:41
 */
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer guid;
	private String deptName;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(Integer guid, String deptName) {
		super();
		this.guid = guid;
		this.deptName = deptName;
	}
	public Integer getGuid() {
		return guid;
	}
	public void setGuid(Integer guid) {
		this.guid = guid;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		return "Department [guid=" + guid + ", deptName=" + deptName + "]";
	}
}
