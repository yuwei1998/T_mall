package com.service;

import java.util.List;

import com.form.Category;
import com.form.Product;

public interface ProductService {

	void add(Product product);

	void delete(Integer id);

	void update(Product product);

	Product get(Integer id);

	List<Product> list(Integer category_id);

	/**
	 * 为多个分类填充产品集合
	 *
	 * @param categories
	 */
	void fill(List<Category> categories);

	/**
	 * 为一个分类填充产品集合
	 *
	 * @param category
	 */
	void fill(Category category);

	/**
	 * 为多个分类填充产品集合
	 *
	 * @param categories
	 */
	void fillByRow(List<Category> categories);

	/**
	 * 为产品填充ReviewCount字段
	 *
	 * @param product
	 */
	void setReviewCount(Product product);

	/**
	 * 根据keyword返回相应的产品集合
	 *
	 * @param keyword
	 * @return
	 */
	List<Product> search(String keyword);
}
