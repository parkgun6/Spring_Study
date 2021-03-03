package org.zerock.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zerock.service.Chef;
import org.zerock.service.Restaurant;

public class Main {
	
	// bad code
	public static void main(String[] args) throws Exception{
		
		ApplicationContext ctx = null;
		ctx = new AnnotationConfigApplicationContext(Chef.class);
		
		System.out.println(ctx);
		
		
		Restaurant res = ctx.getBean(Restaurant.class);
		
		System.out.println(res);
		
		res.hello();
		
		
		
		
		
	}
}
