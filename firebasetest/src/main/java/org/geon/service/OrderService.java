package org.geon.service;


import java.util.List;
import java.util.concurrent.ExecutionException;

import org.geon.domain.Order;

public interface OrderService {

	List<Order> getOrder(String store) throws InterruptedException, ExecutionException;
	
	String insertOrder(Order order) throws InterruptedException, ExecutionException;
	
	String updateOrder(Order order) throws InterruptedException, ExecutionException;
	
	String deleteOrder(String name) throws InterruptedException, ExecutionException;
}
