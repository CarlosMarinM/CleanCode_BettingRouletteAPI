package com.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.redis.core.RedisHash;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@RedisHash
@JsonInclude(Include.NON_EMPTY)
public class Roulette {

	private String id;
	private List<Bet> bets = new ArrayList<Bet>();
	private Byte winningNumber;
	private StatusEnum estado = StatusEnum.CREADA;

	public String getId() {
		return id;
	}

	public List<Bet> getBets() {
		return bets;
	}

	public void setBets(List<Bet> bets) {
		this.bets = bets;
	}

	public StatusEnum getEstado() {
		return estado;
	}

	public void setEstado(StatusEnum estado) {
		this.estado = estado;
	}

	public Byte getWinningNumber() {
		return winningNumber;
	}

	public void setWinningNumber(Byte winningNumber) {
		this.winningNumber = winningNumber;
	}

}
