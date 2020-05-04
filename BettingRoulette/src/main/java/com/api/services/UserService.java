package com.api.services;

import com.api.models.User;

public interface UserService {

	public static final String NOT_FOUND_MESSAGE = "El usuario con identificador %s no fue encontrado.";

	public String create(User user);

	public User findById(String id);
}
