package com.service;

import java.util.List;

import com.form.ProductImage;

public interface ProductImageService {

	void add(ProductImage image);

	void deleteByProductId(Integer product_id);

	void update(ProductImage image);

	ProductImage get(Integer id);

	List<ProductImage> list(Integer product_id);
}
