package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.ReferalLink;
import com.form.ReferalLinkExample;
import com.mapper.ReferalLinkMapper;

@Service
public class ReferalLinkServiceImpl implements ReferalLinkService{

	@Autowired
	private ReferalLinkMapper referalLinkMapper;
	
	@Override
	public List<ReferalLink> listAll() {
		ReferalLinkExample example = new ReferalLinkExample();
		return referalLinkMapper.selectByExample(example);
	}

	@Override
	public void update(ReferalLink link) {
		referalLinkMapper.updateByPrimaryKey(link);
	}

	@Override
	public void updateLinkText(Integer id, String text) {
		ReferalLink referalLink = get(id);
		referalLink.setText(text);
		referalLinkMapper.updateByPrimaryKey(referalLink);
	}

	@Override
	public void updateLinkLink(Integer id, String link) {
		ReferalLink referalLink = get(id);
		referalLink.setLink(link);
		referalLinkMapper.updateByPrimaryKey(referalLink);
	}

	@Override
	public ReferalLink get(Integer id) {
		return referalLinkMapper.selectByPrimaryKey(id);
	}

}
