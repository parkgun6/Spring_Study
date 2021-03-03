package org.zerock.service;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Chef {
	
	
	public String hello() {
		String hello = "hello";
		return hello;
	}
}
