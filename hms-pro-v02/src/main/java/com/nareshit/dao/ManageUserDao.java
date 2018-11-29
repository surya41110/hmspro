package com.nareshit.dao;

import java.util.List;

import com.nareshit.domain.User;

public interface ManageUserDao {

	public User addUser(User hosp);
	public User getUserByid(int id);
	public List<User> getAllUsers();
	public List<User> searchUser(String name, String email);
	User authenticateUser(String username, String password);
	User getUserByUserName(String username);
	
}
