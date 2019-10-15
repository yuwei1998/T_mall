package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.ProductImage;
import com.form.ProductImageExample;
import com.mapper.ProductImageMapper;

@Service
public class ProductImageServiceImpl implements ProductImageService{

	@Autowired
	private ProductImageMapper productImageMapper;
	
	@Override
	public void add(ProductImage image) {
		productImageMapper.insert(image);		
	}

	@Override
	public void deleteByProductId(Integer product_id) {
		ProductImageExample example = new ProductImageExample();
		example.or().andProduct_idEqualTo(product_id);
		List<ProductImage> productImages = list(product_id);		
		for (int i = 0; i < productImages.size(); i++) {
			productImageMapper.deleteByPrimaryKey(productImages.get(i).getId());
		}
	}

	@Override
	public void update(ProductImage image) {
		productImageMapper.updateByPrimaryKey(image);
	}

	@Override
	public ProductImage get(Integer id) {
		return productImageMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductImage> list(Integer product_id) {
		ProductImageExample example = new ProductImageExample();
		example.or().andProduct_idEqualTo(product_id);
		List<ProductImage> productImages = productImageMapper.selectByExample(example);
		return productImages;
	}

}
