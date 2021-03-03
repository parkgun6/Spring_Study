package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.zerock.domain.Menu;

import lombok.Data;

@Service
public interface MenuService {

	List<Menu> getAllMenus();
	
}
