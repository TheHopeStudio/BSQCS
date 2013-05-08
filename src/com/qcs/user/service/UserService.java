package com.qcs.user.service;

import java.util.List;

import com.qcs.base.pagination.PaginationInfo;
import com.qcs.base.pagination.PaginationResult;
import com.qcs.user.pojo.User;

public interface UserService {

	public User createManager(User user);

	public int add(User user);
	
	public int delete(User user);
	
	public int update(User user);
	
	public List<User> query(User user);
	
	public PaginationResult<User> query(User user,PaginationInfo pageInfo);

	public User login(User user);
}
