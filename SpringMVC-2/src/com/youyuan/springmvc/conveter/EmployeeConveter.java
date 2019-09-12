package com.youyuan.springmvc.conveter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.youyuan.springmvc.bean.Department;
import com.youyuan.springmvc.bean.Employee;
import com.youyuan.springmvc.dao.DepartmentDao;

/**
 * 自定义类型转换器需要实现Converter接口
 * @author zhangyu
 * @date 2018-4-8 上午9:50:59
 */
@Component
public class EmployeeConveter implements Converter<String, Employee> {
	
	@Autowired
	private DepartmentDao departmentDao;

	@Override
	public Employee convert(String source) {
		if(source!=null && !"".equals(source)){
			String[] args=source.split("\\-");
			if(args!=null && args.length==6){
				Integer guid=Integer.parseInt(args[0]);
				String userName=args[1];
				String passWord=args[2];
				String email=args[3];
				Integer gender=Integer.parseInt(args[4]);
				Department dept=departmentDao.getById(Integer.parseInt(args[5]));
				return new Employee(guid, userName, passWord, email, gender, dept);
			}
		}
		return null;
	}

}
