package com.youyuan.springmvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youyuan.springmvc.bean.Department;
import com.youyuan.springmvc.bean.Employee;

/**
 * 员工dao
 * @author zhangyu
 * @date 2018-4-5 下午8:29:04
 */
@Repository
public class EmployeeDao {

	private static Map<String, Employee> empMap=new HashMap<String, Employee>();
	
	static{
		empMap.put("1", new Employee(1, "E_AA", "123456", "E_AA@youyuan.com", 1, new Department(1, "技术部")));
		empMap.put("2", new Employee(2, "E_BB", "123456", "E_BB@youyuan.com", 0, new Department(2, "客服部")));
		empMap.put("3", new Employee(3, "E_CC", "123456", "E_CC@youyuan.com", 1, new Department(1, "技术部")));
		empMap.put("4", new Employee(4, "E_DD", "123456", "E_DD@youyuan.com", 0, new Department(2, "客服部")));
		empMap.put("5", new Employee(5, "E_EE", "123456", "E_EE@youyuan.com", 0, new Department(2, "客服部")));
		empMap.put("6", new Employee(6, "E_FF", "123456", "E_FF@youyuan.com", 1, new Department(1, "技术部")));
	}
	
	/**
	 * 查询员工列表
	 * @return
	 */
	public List<Employee> getAll(){
		List<Employee> empList=new ArrayList<>();
		for(Map.Entry<String, Employee> entry:empMap.entrySet()){
			empList.add(entry.getValue());
		}
		return empList;
	}
	
	/**
	 * 添加员工 信息
	 * @param emp
	 */
	public void add(Employee emp){
		empMap.put(emp.getGuid()+"", emp);
	}
	
	/**
	 * 根据guid查询
	 * @param guid
	 * @return
	 */
	public Employee getById(Integer guid){
		return empMap.get(guid+"");
	}
	
	/**
	 * 删除员工信息
	 * @param guid
	 */
	public void del(Integer guid){
		empMap.remove(guid+"");
	}
	
	/**
	 * 修改员工信息
	 * @param emp
	 */
	public void update(Employee emp){
		if(emp!=null){
			empMap.put(emp.getGuid()+"", emp);
		}
	}
}
