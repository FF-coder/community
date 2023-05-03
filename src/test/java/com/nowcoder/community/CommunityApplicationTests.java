package com.nowcoder.community;

import com.nowcoder.community.dao.AlphaDao;
import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class CommunityApplicationTests implements ApplicationContextAware{


//	@Autowired
//	@Qualifier("impl1")
//	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
//	@Test
//	public void contextLoads() {
//		System.out.println(applicationContext);//打印获取到的Spring容器
////		String implType=applicationContext.getBean(AlphaDao.class).select();
////		//从Spring容器中获取AlphaDao类型的bean 并调用其select方法
////		//当有两个bean时 获取最优先的一个 若没有优先之分则会歧义 报错
////		System.out.println(implType);
//		//先强制转换为AlphaDao的类型 再调用对应的select
//		//第一种：可以参数对bean进行类型转换
//		String impl1=applicationContext.getBean("impl1", AlphaDao.class).select();
//		System.out.println(impl1);
//		//第二种：可用（）对bean进行强制类型转换
//		AlphaDao I1= (AlphaDao) applicationContext.getBean("impl1");
//		String impl11= I1 .select();
//		System.out.println(impl11);
//	}
	@Test
	public void testBeanManagement()
	{
		AlphaService s1=applicationContext.getBean(AlphaService.class);
		System.out.println(s1);

		AlphaService s2=applicationContext.getBean(AlphaService.class);
		System.out.println(s2);
		//被Spring容器管理的bean默认是单例的 只实例化一次 销毁一次
		//若要用多例需要给bean注解上@Scope("prototype")

	}
	@Test
	public void testBean3(){
		SimpleDateFormat simpleDateFormat =
				applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}




	@Test
	public void TestDI(){
//		System.out.println(alphaDao);
		System.out.println(alphaService);
	}
}
