package com.youyuan.springmvc.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Repository;

import com.youyuan.springmvc.bean.Department;

/**
 * 部门dao
 * @author zhangyu
 * @date 2018-4-7 下午7:23:59
 */
@Repository
public class DepartmentDao {

	private static Map<String, Department> deptMap=new HashMap<String, Department>();
	
	static{
		deptMap.put("1", new Department(1, "技术部"));
		deptMap.put("2", new Department(2, "客服部"));
	}
	
	public List<Department> getDeptAll(){
		List<Department> deptList=new ArrayList<Department>();
		for(Map.Entry<String, Department> entry:deptMap.entrySet()){
			deptList.add(entry.getValue());
		}		
		return deptList;
	}
	
	public Department getById(Integer guid){
		return deptMap.get(guid+"");
	}
}
