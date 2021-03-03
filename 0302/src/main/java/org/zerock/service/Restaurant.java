package org.zerock.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Service
@ToString
@RequiredArgsConstructor
public class Restaurant {

	//스프링책57p
	//세터주입
	private final Chef chef;
}
