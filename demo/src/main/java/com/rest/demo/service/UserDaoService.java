package com.rest.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.demo.entity.User;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();

	static {
		users.add(new User(1, "Joe", new Date()));
		users.add(new User(2, "Mike", new Date()));
		users.add(new User(3, "Bob", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}

	public User findById(Integer id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User save(User user) {
		int userCount = users.size();
			
		if(user.getId()== null) {
			user.setId(userCount++);
		}
		
		users.add(user);		
		return user;
	}
	
}
