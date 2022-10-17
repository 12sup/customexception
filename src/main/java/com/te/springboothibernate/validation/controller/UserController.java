package com.te.springboothibernate.validation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboothibernate.validation.custom.exception.UserNotFoundException;
import com.te.springboothibernate.validation.entity.User;
import com.te.springboothibernate.validation.entity.UserDto;
import com.te.springboothibernate.validation.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserDto userDto) {
		return new ResponseEntity<>(userService.saveUser(userDto), HttpStatus.CREATED);

	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(userService.getAllUser());

	}

	@GetMapping("/user3/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Integer userId) throws UserNotFoundException {
		return ResponseEntity.ok(userService.findUserById(userId));

	}
}
