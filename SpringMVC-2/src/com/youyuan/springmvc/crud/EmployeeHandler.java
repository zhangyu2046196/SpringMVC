package com.youyuan.springmvc.crud;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.youyuan.springmvc.bean.Employee;
import com.youyuan.springmvc.dao.DepartmentDao;
import com.youyuan.springmvc.dao.EmployeeDao;

/**
 * 员工处理器
 * @author zhangyu
 * @date 2018-4-5 下午8:42:20
 */
@RequestMapping("/springMVC")
@Component
public class EmployeeHandler {

	private static final String LIST="list";
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	/**
	 * 查询员工列表处理器
	 * @return
	 */
	@RequestMapping("/emps/getAll")
	public String getAll(Map<String, List<Employee>> map){
		map.put("emp_list", employeeDao.getAll());
		return LIST;
	}
	
	/**
	 * 添加员工页面,查询数据用于页面回显
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.GET)
	public String empInput(Map<String, Object> map){
		map.put("departments", departmentDao.getDeptAll());
		map.put("employee", new Employee());
		return "input";
	}
	
	/**
	 * 添加员工信息
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.POST)
	public String addEmp(Employee emp){
		System.out.println("添加员工信息,emp:"+emp);
		employeeDao.add(emp);
		return "redirect:/springMVC/emps/getAll";
	}
	
	/**
	 * 删除员工信息
	 * @return
	 */
	@RequestMapping(value="/emps/{guid}",method=RequestMethod.DELETE)
	public String delEmp(@PathVariable("guid")Integer guid){
		employeeDao.del(guid);
		return "redirect:/springMVC/emps/getAll";
	}
	
	/**
	 * 根据guid查询员工信息
	 * @return
	 */
	@RequestMapping(value="/emps/{guid}",method=RequestMethod.GET)
	public String editInput(@PathVariable("guid")Integer guid,Map<String, Object> map){
		map.put("employee", employeeDao.getById(guid));
		return "input";
	}
	
	@ModelAttribute
	public void updateNotLastName(@RequestParam(value="guid",required=false)Integer guid,Map<String, Object> map){
		if(guid!=null){
			map.put("employee", employeeDao.getById(guid));
		}
	}
	
	/**
	 * 更新员工信息
	 * @return
	 */
	@RequestMapping(value="/emps",method=RequestMethod.PUT)
	public String update(Employee emp){
		employeeDao.update(emp);
		return "redirect:/springMVC/emps/getAll";
	}
	
	/**
	 * @InitBinder注解用于设置数据绑定的参数,例如下面指定userName参数不绑定的bean的属性上,@InitBinder作用的方法上不能有返回值
	 * @param binder
	 */
//	@InitBinder
//	public void initBinder(WebDataBinder binder){
//		//binder.setDisallowedFields("userName");
//	}
}
