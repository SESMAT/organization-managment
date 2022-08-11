package com.ntg.organization.organization.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ntg.organization.organization.dto.CustomUser;
import com.ntg.organization.organization.entity.Role;
import com.ntg.organization.organization.entity.User;
import com.ntg.organization.organization.respository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUserName(username);

		if (user == null)
			throw new UsernameNotFoundException("User " + username + " Not found");

		return new CustomUser(user.getUserName(), 
				user.getPassword(),true, true, true,true,
				mapToGrantedAuthorities(user.getRoles()), user.getFirstName(), user.getLastName());

	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(Set<Role> roles) {	
		if(roles != null && !roles.isEmpty()) {
			return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		}
		
		return new ArrayList<GrantedAuthority>();

	}
	
	public User createNewUser(User user) {
		if(user != null) {
			user.setPassword(bcryptPasswordEncoder.encode(user.getPassword()));
			return userRepository.save(user);
		}
		
		return user;
	}

	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}
}
