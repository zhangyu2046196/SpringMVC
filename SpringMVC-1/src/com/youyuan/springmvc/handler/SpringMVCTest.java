package com.youyuan.springmvc.handler;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.youyuan.springmvc.domain.User;

@SessionAttributes(value={"user"},types={String.class})
@RequestMapping("/springMVC")
@Controller
public class SpringMVCTest {
	
	public static final String SUCCESS="success";
	
	public static final String SUCCESS_1="success_1";
	
	
	/**
	 * 	@RequestMapping注解可以用在方法上也可以用在类上
	 * 	用在类上代表上一级地址
	 * 	例如:
	 * 	1、此类如果类上没有使用@RequestMapping注解,请求Url地址就是http://localhost:8080/SpringMVC-1/testRequestMapping
	 *	2、此类如果类上有使用@RequestMapping注解,请求Url地址就是http://localhost:8080/SpringMVC-1/springMVC/testRequestMapping
	 * @return
	 */
	@RequestMapping("/testRequestMapping")
	public String testRequestMapping(){
		System.out.println("测试RequestMappinng注解");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping注解的value属性指定请求Url,method属性指定请求方式
	 * @return
	 */
	@RequestMapping(value="/testMethod",method=RequestMethod.POST)
	public String testMethod(){
		System.out.println("测试RequestMapping的method属性");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping注解的params和heads属性
	 * 	params属性:可以是一个数组,支持简单的表达式例如params={"username","age!=10"}代表必须有username参数并且age参数的值不能为10
	 * 	headers属性:可以是一个数组,支持简单的表达式例如headers={"Connection=keep-alive"}代表请求头中Connection的参数值必须  是keey-alive
	 * @return
	 */
	@RequestMapping(value="/testParamsAndHeads",params={"username","age!=10"},headers={"Connection=keep-alive"})
	public String testParamsAndHeads(){
		System.out.println("测试RequestMapping的params和heads属性");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping直接支持Ant通配符地址访问
	 * 	如下:http://localhost:8080/SpringMVC-1/springMVC/testAntPath/*(代表任何字符)
	 * @return
	 */
	@RequestMapping("/testAntPath/*/abc")
	public String testAntPath(){
		System.out.println("测试RequestMapping支持Ant通配符地址");
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping注解中的@PathVariable注解可以请求地址中的占位符映射目标方法的指定参数
	 * 要求地址中占位符名字和@PathVariable的名字一样
	 * @param age
	 * @return
	 */
	@RequestMapping("/testPathVariable/{age}")
	public String testPathVariale(@PathVariable("age")Integer age){
		System.out.println("测试RequestMapping中请求地址占位符映射到目标方法指定参数"+age);
		return SUCCESS;
	}
	
	/**
	 * @RequestMapping注解中的@PathVariable注解可以请求地址中的占位符映射目标方法的指定参数
	 * 要求地址中占位符名字和@PathVariable的名字一样
	 * @param age
	 * @return
	 */
	@RequestMapping("/testPathVariable/{age}/plus")
	public String testPathVarialePlus(@PathVariable("age")Integer age){
		System.out.println("测试RequestMapping中请求地址占位符映射到目标方法指定参数"+age);
		return SUCCESS;
	}
	
	/**
	 * RestFul风格的请求Url包含请求方式Get、Post、Put、Delete
	 * 	     步骤如下:
	 * 		1、在web.xml文件中引入HiddenHttpMethodFilter过滤器
	 * 			<!-- 配置一个HiddenHttpMethodFilter 可以post请求改为POST、POST、DELETE请求方式 -->
			    <filter>
			    	<filter-name>hiddenHttpMethodFilter</filter-name>
			    	<filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
			    </filter>
			    
			    <filter-mapping>
			    	<filter-name>hiddenHttpMethodFilter</filter-name>
			    	<url-pattern>/*</url-pattern>
			    </filter-mapping>
			  
			2、在jsp页面隐藏传递一个_method的参数,值可以Get、Post、Put、Delete
				<input type="hidden" name="_method" value="PUT"/>
				
			3、使用@Pathvariable获取地址中占位符的值给目标方法的参数
				@PathVariable("id")Integer id
				
		RestFul风格Url类型(CRUD操作)
		/order     新增       POST方式
		/order/1        查找       GET方式
		/order/1        更新       PUT方式
		/order/1        删除       DELETE方式

	 * 
	 */
	
	@RequestMapping("/testRestGet/{id}")
	public String testRestGet(@PathVariable("id")Integer id){
		System.out.println("测试HiddenHttpMethodFilter的Get请求方式"+id);
		return SUCCESS;
	}
	
	@RequestMapping("/testRestPost")
	public String testRestPost(){
		System.out.println("测试HiddenHttpMethodFilter的Post请求方式");
		return SUCCESS;
	}
	
	@RequestMapping("/testRestPut/{id}")
	public String testRestPut(@PathVariable("id")Integer id){
		System.out.println("测试HiddenHttpMethodFilter的Put请求方式"+id);
		return SUCCESS;
	}
	
	@RequestMapping("/testRestDelete/{id}")
	public String restRestDelete(@PathVariable("id")Integer id){
		System.out.println("测试HiddenHttpMethodFilter的Delete请求方式"+id);
		return SUCCESS;
	}
	
	/**
	 * @RequestParam接收请求参数
	 * 	value:请求参数名要和传参的参数名一样
	 * 	required:参数是否必须   默认true
	 * 	defaultValue:默认值
	 * @param userName
	 * @param age
	 * @return
	 */
	@RequestMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value="userName")String userName,@RequestParam(value="age",required=true,defaultValue="0")Integer age){
		System.out.println("测试RequestParam userName:"+userName+" age:"+age);
		return SUCCESS;
	}
	
	/**
	 * @RequestHeader 接收请求头信息
	 * 	value:请求头名字
	 * 	required:请求头是否必传,默认值true
	 * 	defaultValue:默认值
	 * @param accept
	 * @return
	 */
	@RequestMapping("/testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept")String accept){
		System.out.println("测试RequestHeader accept:"+accept);
		return SUCCESS;
	}
	
	/**
	 * @CookieValue接收cookie信息
	 * value:cookie名称
	 * required:是否必传  默认true
	 * defaultValue:默认值
	 * @param jid
	 * @return
	 */
	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue(value="JSESSIONID")String jid){
		System.out.println("测试CookieValue jsessionid:"+jid);
		return SUCCESS;
	}
	
	/**
	 * 传递Pojo(javabean实体类参数)
	 * 要求:
	 * 	1、参数名和javabean的属性名一致,并且属性需要有set方法
	 * 	2、支持级联属性
	 * @param user
	 * @return
	 */
	@RequestMapping("/testPojo")
	public String testPojo(User user){
		System.out.println("测试Pojo 参数  user:"+user.toString());
		return SUCCESS;
	}
	
	/**
	 * 接收Servlet原生API的参数作为目标方法参数
	 * @param request
	 * @param response
	 */
	@RequestMapping("/testServletApi")
	public void testServletApi(HttpServletRequest request,HttpServletResponse response){
		System.out.println("测试ServletAPI作为目标参数,request:"+request+" response:"+response);
	}
	
	/**
	 * springMVC中目标方法的返回值可以是ModelAndView类型
	 * ModelAndView类型包含了视图解析器中的返回视图地址和返回数据信息
	 * 	view:视图名称
	 * 	model:返回信息封装到request作用域中
	 * @return
	 */
	@RequestMapping("/testModelAndView")
	public ModelAndView testModelAndView(){
		String viewName=SUCCESS;
		ModelAndView mv=new ModelAndView(viewName);
		mv.addObject("time", new Date());
		System.out.println("测试目标方法返回值ModelAndView类型,mode代表返回数据,view代表视图"+mv);
		return mv;
	}
	
	/**
	 * SpringMVC中目标处理器方法的返回值可以map
	 * map作为参数传进来,返回值也在map中,会保存在request作用域
	 * @param map
	 * @return
	 */
	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map){
		map.put("names", Arrays.asList("Tom","Jerry","mali"));
		return SUCCESS;
	}
	
	/**
	 * springMVC处理模型数据类型
	 * 	ModelAndView         放到request作用域
	 * 	Map                  放到request作用域
	 * 	SessionAttribute     放到session作用域,@SessionAttributes只能在类上注解
	 * 		value:属性(字符串数组)指定参数名放到session作用域
	 * 		types:属性(字符串数组)指定参数值的类型放到session作用域
	 * 
	 * 	注意:@SessionAttributes在类上修饰,如果目标方法入参是POJO类型
	 *    @SessionAttributes的value属性值和POJO入参的第一个字母小写时必须有@ModelAttribute修饰的方法或者用@ModelAttribute修饰目标方法入参来改变作用域中key的名字
	 * @param map
	 * @return
	 */
	@RequestMapping("/testSessionAttribute")
	public String testSessionAttribute(Map<String, Object> map){
		map.put("user", new User("Tom", "123456", "tom@youyuan.com", 93));
		map.put("school", "有缘");
		map.put("age", 92);
		return SUCCESS;
	}
	
	@RequestMapping("/testModelAttribute")
	public String testModelAttribute(@ModelAttribute(value="abc")User user){
		System.out.println("测试ModelAttribute"+user.toString());
		return SUCCESS;
	}
	
	/**
	 * @ModelAttribute注解是在目标方法执行前执行
	 * 1、@ModelAttribute注解的方法是在springMVC目标方法调用之前执行
	 * 2、@ModelAttribute注解的方法执行查询数据库的操作后将结果放在了request作用域中
	 * 3、springMVC从request作用域中取出结果,将 目标方法传递的入参更新取出结果的属性后作为入参传递给目标方法
	 * 
	 * 注意:
	 * 	1、@ModelAttribute注解的方法中取出的结果,默认放在request作用域中的key的值的名字和目标方法POJO入参类型的第一个字母小写名字相同
	 * 	2、@ModelAttribute注解可以修饰目标方法入参,默认request作用域中存储的key为入参第一个字母小写,可以用(@ModelAttribute(value="abc")User user)指定放入request作用域中的key的值
	 * 	3、无论是否用@ModelAttribute修饰方法或修饰入参,默认都会在request作用域中存储一份key为入参POJO的第一个字母小写的数据
	 * @param id
	 * @param map
	 */
	@ModelAttribute
	public void getUser(@RequestParam(value="id",required=false,defaultValue="0")Integer id,Map<String, Object> map){
		if(id==1){
			System.out.println("从数据库中查询内容");
			//map.put("abc", new User(id,"Tom", "123456", "tom@youyuan.com", 92));//@ModelAttribute注解的方法放到request作用域中的key可以改成任意值,此时需要在目标方法入参用@ModelAttribute修饰,且value属性值要和@ModelAttribute注解的方法中request作用域中的key名字一致
			map.put("user", new User(id,"Tom", "123456", "tom@youyuan.com", 92));//默认@ModelAttribute注解的方法中放到request作用域中的key为目标方法POJO入参第一个字母小写
		}
	}
	
	/**
	 * 视图解析器运行流程
	 * 	不管目标方法返回值是String、ModelAndView、View类型,都会转换成ModelAndView类型,然后通过ViewResolover(视图解析器),将逻辑视图解析成物理视图(jsp、html)等
	 * @return
	 */
	@RequestMapping("/testViewAndViewResolover")
	public String testViewAndViewResolver(){
		System.out.println("测试视图解析器");
		return SUCCESS;
	}
	
	@RequestMapping("/testHelloView")
	public String testHelloView(){
		System.out.println("测试自定义视图, 实现View接口,视图名字就是视图类的第一个字母小写");
		return "helloView";
	}
	
	/**
	 * springMVC重定向,如果返回视图名字中包含forward:或redirect:就会重定向
	 * @return
	 */
	@RequestMapping("/testRedirect")
	public String testRedirect(){
		System.out.println("测试springMVC的重定向");
		//return "redirect:"+SUCCESS;
		
		return "redirect:/index.jsp";
	}

}
