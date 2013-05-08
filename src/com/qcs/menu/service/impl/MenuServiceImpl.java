package com.qcs.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.menu.dao.MenuDao;
import com.qcs.menu.pojo.Menu;
import com.qcs.menu.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao;

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	@Override
	public List<Menu> query(Menu menu) {
		return menuDao.query(menu,true);
	}
	
}
