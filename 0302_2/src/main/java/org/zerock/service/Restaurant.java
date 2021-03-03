package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class Restaurant {

	//스프링책57p
	//세터주입
	
	private final Chef chef;
	
	public String hello() {
		return chef.hello();
	}
}
