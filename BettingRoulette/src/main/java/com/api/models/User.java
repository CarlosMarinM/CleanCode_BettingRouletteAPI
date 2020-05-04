package com.api.models;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RedisHash
@JsonInclude(Include.NON_EMPTY)
public class User {

	private String id;

	public String getId() {
		return id;
	}

}
