package com.qcs.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.common.utils.MD5Utils;
import com.qcs.user.dao.UserDao;
import com.qcs.user.pojo.User;
import com.qcs.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	
	@Override
	public User createManager(User user) {
		//正常状态
		user.setState("0");
		//管理员类型
		user.setType("2");
		//密码加密
		String md5 = MD5Utils.getMD5(user.getPassword().getBytes());
		user.setPassword(md5);
		//保存进数据库
		if(add(user) >0){
			return user;
		}
		return null;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int add(User user) {
		return userDao.add(user);
	}

	@Override
	public int delete(User user) {
		return userDao.delete(user);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);
	}

	public List<User> query(User user){
		return userDao.query(user);
	}

	@Override
	public PaginationResult<User> query(User user,PaginationInfo pageInfo) {
		return userDao.query(user, pageInfo);
	}

	@Override
	public User login(User user) {
		//密码加密
		String md5 = MD5Utils.getMD5(user.getPassword().getBytes());
		user.setPassword(md5);
		List<User> list = userDao.query(user);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void freeze(User user) {
		user.setState("1");
		update(user);
	}

	@Override
	public void unFreeze(User user) {
		user.setState("0");
		update(user);
	}

}
