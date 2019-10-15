package com.service;

import java.util.List;

import com.form.Order;
import com.form.OrderItem;

public interface OrderService {

	String waitPay = "waitPay";
	String waitDelivery = "waitDelivery";
	String waitConfirm = "waitConfirm";
	String waitReview = "waitReview";
	String finish = "finish";
	String delete = "delete";

	Order get(int id);

	List<Order> listAll();

	List<Order> list(Integer user_id, String excludedStatus);

	List<Order> listByUserId(Integer user_id);

	void update(Order order);

	void add(Order order);

	float add(Order order, List<OrderItem> orderItems);
}
