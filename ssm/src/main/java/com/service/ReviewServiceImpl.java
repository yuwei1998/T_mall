package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.Review;
import com.form.ReviewExample;
import com.mapper.ReviewMapper;
import com.form.User;

@Service
public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private UserService userService;
	
	@Override
	public void add(Review review) {
		reviewMapper.insert(review);
	}

	@Override
	public void delete(int id) {
		reviewMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Review review) {
		reviewMapper.updateByPrimaryKeySelective(review);
	}
	@Override
	public Review get(int id) {
		return reviewMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Review> listByProductId(Integer product_id) {
		ReviewExample example = new ReviewExample();
		example.or().andProduct_idEqualTo(product_id);
		example.setOrderByClause("id desc");
		List<Review> reviews=reviewMapper.selectByExample(example);
		setUser(reviews);
		return reviews;
	}
	public void setUser(List<Review> reviews) {
		for (Review review : reviews) {
			setUser(review);
		}
	}

	private void setUser(Review review) {
		int user_id = review.getUser_id();
		User user = userService.get(user_id);
		review.setUser(user);
	}

	@Override
	public int getCount(int product_id) {
		return listByProductId(product_id).size();
	}

}
