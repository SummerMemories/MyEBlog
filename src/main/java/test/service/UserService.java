package test.service;

import test.po.User;

public interface UserService {
	
	User checkUser(String username,String password);
	
	
}
