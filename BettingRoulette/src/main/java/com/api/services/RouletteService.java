package com.api.services;

import java.util.List;

import com.api.models.Roulette;
import com.api.models.StatusEnum;

public interface RouletteService {

	public static final Byte UPPER_BOUND = 36;
	public static final Byte LOWER_BOUND = 0;
	public static final String NOT_FOUND_MESSAGE = "La ruleta con identificador %s no fue encontrada.";
	public static final String BAD_STATUS_MESSAGE = "La ruleta con identificador %s se encuentra %s.";

	public List<Roulette> findAll();

	public Roulette findById(String id);

	public String create(Roulette roulette);

	public void openBets(String id);

	public Roulette closeBets(String id);

	public void validateStatusRoulette(Roulette roulette, StatusEnum status);
}
