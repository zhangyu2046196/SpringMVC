package com.youyuan.springmvc.conveter.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.youyuan.springmvc.bean.Employee;
import com.youyuan.springmvc.dao.EmployeeDao;

/**
 * 测试自定义类型转化器,自定义类型转化器实现Conveter接口
 * @author zhangyu
 * @date 2018-4-8 上午9:43:20
 */
@Controller
@RequestMapping("/springMVC")
public class SpringMVCTest {
	
	@Autowired
	private EmployeeDao employeeDao;

	/**
	 * 测试自定义转换器
	 * @return
	 */
	@RequestMapping(value="/testConveter",method=RequestMethod.POST)
	public String testConveter(@RequestParam(value="employee")Employee emp){
		employeeDao.add(emp);
		return "redirect:/springMVC/emps/getAll";
	}
	
}
