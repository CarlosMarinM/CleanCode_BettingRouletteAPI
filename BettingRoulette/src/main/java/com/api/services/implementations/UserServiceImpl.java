package com.api.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.models.User;
import com.api.services.UserService;
import com.api.services.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String create(User user) {
		User createdUser = userRepository.save(user);
		return createdUser.getId();
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(NOT_FOUND_MESSAGE, id)));
	}

}
