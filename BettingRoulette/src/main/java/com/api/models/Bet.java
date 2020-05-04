package com.api.models;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RedisHash
@JsonInclude(Include.NON_EMPTY)
public class Bet {

	private String id;
	private User user;
	private Double quantity;
	private Byte number;
	private ResultsEnum result;

	public Bet(User user, Double quantity, Byte number) {
		this.user = user;
		this.quantity = quantity;
		this.number = number;
	}

	public String getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Byte getNumber() {
		return number;
	}

	public ResultsEnum getResult() {
		return result;
	}

	public void setResult(ResultsEnum result) {
		this.result = result;
	}

	public enum ResultsEnum {
		PERDIDA, GANADA
	}
}
