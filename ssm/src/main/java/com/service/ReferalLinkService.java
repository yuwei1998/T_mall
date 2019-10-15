package com.service;

import java.util.List;

import com.form.ReferalLink;

public interface ReferalLinkService {

	List<ReferalLink> listAll();

	void update(ReferalLink link);

	void updateLinkText(Integer id, String text);

	void updateLinkLink(Integer id, String link);

	ReferalLink get(Integer id);
}
