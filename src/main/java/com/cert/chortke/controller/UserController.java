package com.cert.chortke.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cert.chortke.confg.UserProperties;
import com.cert.chortke.dto.User;
import com.cert.chortke.entities.UserEntity;
import com.cert.chortke.service.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {

	private UserRepository userRepository;
	private UserProperties userProperties;

	@Autowired
	public UserController(UserRepository userRepository, UserProperties userProperties) {
		this.userRepository = userRepository;
		this.userProperties = userProperties;

	}

	@RequestMapping(value = "/api/userlist", method = RequestMethod.GET)
	public List<UserEntity> getUsers() {

		List<UserEntity> userList = userRepository.findAll();

		if (userList != null)
			return userList;
		return new ArrayList<UserEntity>();

	}

	@RequestMapping(value = "/api/saveUser", method = RequestMethod.POST)
	public Long saveOrUpdate(/* @PathVariable("user") */ @RequestBody User user) {

		String userSecurity = userProperties.getUserSecurity();
		System.out.println(userSecurity);

		UserEntity entity = new UserEntity();
		entity.setUsername(user.getUsername());
		UserEntity result = userRepository.save(entity);
		if (result != null)
			return result.getId();
		return null;
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String getUserList(@PathVariable("username") String username, Model model) {

		List<UserEntity> userList = userRepository.findByUsername(username);

		if (userList != null)
			model.addAttribute("users", userList);

		return "userList";

	}

}
