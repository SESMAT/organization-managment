package com.ntg.organization.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntg.organization.organization.dto.CustomUser;
import com.ntg.organization.organization.entity.User;
import com.ntg.organization.organization.service.UserService;

@RestController
@RequestMapping("/user/v1")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/add")
	public User createNewUser(@RequestBody User user) {
		return userService.createNewUser(user);
	}
	
	@GetMapping(value = "/all")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(value = "/getFullName")
	public String getAuthUserFullName() {
		String fullName = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		CustomUser loginUser = (CustomUser) auth.getPrincipal();
		
		fullName = loginUser.getFirstName() + " " + loginUser.getLastName();
		
		return fullName;
	}
}
