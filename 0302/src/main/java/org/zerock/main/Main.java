package org.zerock.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.zerock.service.Chef;
import org.zerock.service.MenuService;
import org.zerock.service.Restaurant;
import org.zerock.ui.MenuUI;

public class Main {
	
	// bad code
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = null;
		ctx = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
//		System.out.println(ctx);
//		
//		//메뉴서비스를 주입한다.
//		MenuService service = (MenuService)ctx.getBean("m1");
//		
//		System.out.println(service);
//		
//		System.out.println(service.getAllMenus());
//		
//		//메뉴UI를 주입한다.
//		MenuUI ui = (MenuUI) ctx.getBean("mui");
//		
//		System.out.println(ui);
		
		Chef chef = ctx.getBean(Chef.class);
		
		System.out.println(chef);
		
		Restaurant res = ctx.getBean(Restaurant.class);
		
		System.out.println(res);
	}
}
