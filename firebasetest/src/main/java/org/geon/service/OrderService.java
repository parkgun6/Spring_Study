package org.geon.service;


import java.util.concurrent.ExecutionException;

import org.geon.domain.Order;

public interface OrderService {

	Order getOrder(String name) throws InterruptedException, ExecutionException;
	
	String insertOrder(Order order) throws InterruptedException, ExecutionException;
	
	String updateOrder(Order order) throws InterruptedException, ExecutionException;
	
	String deleteOrder(String name) throws InterruptedException, ExecutionException;
}
