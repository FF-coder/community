package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello()
    {
        System.out.println("1");
        return "Hello Spring Boot!";
    }
    @Autowired
    private AlphaService alphaService;//注入业务组件

    @RequestMapping("/service")
    @ResponseBody
    public String ServiceStr()
    {
        return alphaService.selectDao();
    }


    @RequestMapping("/http")
    public void httpTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取request对象 调用其常用方法 打印请求行和请求头中的属性名：属性值等   偏底层
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        System.out.println(request.getHeaderNames());
        Enumeration enumeration=request.getHeaderNames();//迭代器
        while(enumeration.hasMoreElements())System.out.println(enumeration.nextElement()+":"+
                request.getHeader((String) enumeration.nextElement())); //消息头的属性名+属性值
        System.out.println(request.getParameter("code"));
        System.out.println(request.getParameter("name"));

        //获取response对象 返回响应数据 偏底层
        response.setContentType("text/html;charset=utf-8");//返回网页
        PrintWriter writer=response.getWriter();
        writer.write("<h>校园闲置物品分享平台<h>"); //会在浏览器的页面上显示该html对应的网页 ：校园闲置物品分享平台


    }

    //封装之后的处理请求方式 相对上面更简便
    //处理浏览器请求：1接收请求的数据（基于request） 2向浏览器返回响应数据（基于response）
    //1
    //这两种请求方法（GET和POST）的共同点是：都是将数据传送到服务器
    //GET请求 常用于获取数据
    //testGET?name=xxx&limit=xx
    @RequestMapping(path ="/testGET",method= RequestMethod.GET)
    @ResponseBody
    public String GETTest1(@RequestParam(name = "name",required = false,defaultValue = "CYF") String name1, int limit){
        System.out.println(name1+","+limit);
        return "test GET";
    }

    //通过路径来查询
    //testGET/{id}
    @RequestMapping(path = "/testGET/{id}",method = RequestMethod.GET)
    @ResponseBody
    public  String GetByPath(@PathVariable("id") int id1) //必须要加@PathVariable来注入
    {
        System.out.println("id="+id1);
        return "get by path ";
    }
    //1.2 POST请求 浏览器向服务器提交数据时用POST
    @RequestMapping(path ="/testPOST" ,method = RequestMethod.POST)
    @ResponseBody
    public String saveForm(String name ,int age){
        //直接在参数里放与html表单中的参数名一致的名字 就能自动传过来
        System.out.println(name);
        System.out.println(age);
        return "POST ";
    }
    //2给浏览器响应数据
    //2.1响应html数据
    //2.1.1方法一
    @RequestMapping(path = "/teacher", method=RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("name","CYF");
        mav.addObject("age",21);//thymeleaf默认用html所以可省略.html
        mav.setViewName("demo/view");//把mav中的数据传给 放置在tempalate/demo/view.html的动态值中（替换掉
        return mav;
    }
    //2.1.2方法二 ：用Model
    @RequestMapping(path = "/student",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","CYF");
        model.addAttribute("age",21);
        return "/demo/view";
    }

    //2.2响应JSON数据  通常用于异步请求中
    //Java->JSON->JS
    @RequestMapping(path = "/responseJSON",method = RequestMethod.GET)
    @ResponseBody //必须加 否则默认返回的是html
    //这里返回值为map类型 为属性名 属性值的格式 所以DispatcherServlet可以自动把map转为JSON格式发给浏览器
    public Map<String, Object> getEmp(){
        Map<String ,Object> emp=new HashMap<>();
        emp.put("name","CYF");
        emp.put("salary","1000000");
        return emp;
    }
    //list 的话则返回 [{},{}]的格式
    @RequestMapping(path = "/responseJSONlist",method = RequestMethod.GET)
    @ResponseBody //必须加 否则默认返回的是html
    //这里返回值为map类型 为属性名 属性值的格式 所以DispatcherServlet可以自动把map转为JSON格式发给浏览器
    public List<Map<String, Object> >getEmps(){
        List list=new ArrayList<>();
        Map<String ,Object> emp=new HashMap<>();
        emp.put("name","CYF");
        emp.put("salary","1000000");
        list.add(emp);
        emp.put("name","CYF2");
        emp.put("salary","2000000");
        list.add(emp);
        return list;
    }

}

