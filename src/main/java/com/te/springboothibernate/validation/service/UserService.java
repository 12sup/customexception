package com.te.springboothibernate.validation.service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboothibernate.validation.custom.exception.UserNotFoundException;
import com.te.springboothibernate.validation.entity.User;
import com.te.springboothibernate.validation.entity.UserDto;
import com.te.springboothibernate.validation.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User saveUser(UserDto userDto) {
		User user = User.build(0, userDto.getName(), userDto.getEmail(), userDto.getMobile(), userDto.getGender(),
				userDto.getAge(), userDto.getNationality());
		return userRepository.save(user);

	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User findUserById(Integer userId) throws UserNotFoundException {
		User user = userRepository.findByUserId(userId);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("user not found that id:" + userId);
		}

	}
}
