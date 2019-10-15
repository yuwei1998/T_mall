package com.service;

import java.util.List;

import com.form.Review;

public interface ReviewService {

	void add(Review review);

	void delete(int id);

	void update(Review review);

	Review get(int id);

	List<Review> listByProductId(Integer product_id);
	/**
	 * 返回当前产品下评论的数量
	 *
	 * @param product_id
	 * @return
	 */
	int getCount(int product_id);
}
