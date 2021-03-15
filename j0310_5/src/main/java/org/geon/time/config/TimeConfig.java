package org.geon.time.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan(basePackages = "org.zerock.time.mapper")
@ComponentScan(basePackages = {"org.zerock.time.service"})
public class TimeConfig {

	
	
}
