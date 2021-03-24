package org.geon.service;



import java.util.concurrent.ExecutionException;

import org.geon.dao.OrderDAO;
import org.geon.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderDAO dao;
	
	@Override
	public Order getOrder(String store) throws InterruptedException, ExecutionException {
		return dao.getOrder(store);
	}
	@Override
	public String insertOrder(Order Order) throws InterruptedException, ExecutionException {
		return dao.insertOrder(Order);
	}
	@Override
	public String updateOrder(Order Order) throws InterruptedException, ExecutionException {
		return dao.updateOrder(Order);
	}
	@Override
	public String deleteOrder(String store) throws InterruptedException, ExecutionException {
		return dao.deleteOrder(store);
	}
}