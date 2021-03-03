package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.zerock.domain.Menu;

import lombok.Data;

//메뉴서비스를 상속받음
//얘는 반드시 스프링빈으로 등록이 되어야한다.
@Component
@Data
public class MenuServiceImpl implements MenuService {

	private List<Menu> menus;
	
	//생성자주입 세터주입 필드주입 주입방법이 여러가지가 있다.
	//생성자 주입방법
	public MenuServiceImpl(List<Menu> menus) {
		super();
		this.menus = menus;
	}
	
	
	
	@Override
	public List<Menu> getAllMenus() {
		// TODO Auto-generated method stub
		return this.menus;
	}

	

}
