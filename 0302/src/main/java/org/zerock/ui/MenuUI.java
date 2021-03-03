package org.zerock.ui;

import org.zerock.service.MenuService;

public class MenuUI {

	private MenuService service;
	
	//세터 생성(생성자)
	public void setService(MenuService service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "MenuUI [service=" + service + "]";
	}
	
	
	
	
}
