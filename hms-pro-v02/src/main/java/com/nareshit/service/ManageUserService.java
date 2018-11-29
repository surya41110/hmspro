package com.nareshit.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nareshit.bean.UserBean;
import com.nareshit.domain.User;


public interface ManageUserService {

	
	Map<String, List<String>> authenticateUser(String username, String password);
}
