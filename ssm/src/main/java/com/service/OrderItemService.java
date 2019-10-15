package com.service;

import java.util.List;

import com.form.Order;
import com.form.OrderItem;

public interface OrderItemService {

	OrderItem getById(Integer id);

	void add(OrderItem orderItem);

	List<OrderItem> getByOrderId(Integer order_id);

	void update(OrderItem orderItem);

	/**
	 * 根据user_id来该用户下对应的所有订单项
	 *
	 * @param user_id
	 * @return
	 */
	List<OrderItem> listByUserId(Integer user_id);

	/**
	 * 返回当前user_id下的购物车订单列表
	 *
	 * @param user_id
	 * @return
	 */
	List<OrderItem> listForCart(Integer user_id);

	void delete(Integer id);

	/**
	 * 为List<Order>填充订单项
	 *
	 * @param orders
	 */
	void fill(List<Order> orders);

	/**
	 * 为Order填充订单项
	 *
	 * @param order
	 */
	void fill(Order order);
}
