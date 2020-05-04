package com.api.services.implementations;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.models.Bet;
import com.api.models.Roulette;
import com.api.models.StatusEnum;
import com.api.services.BetService;
import com.api.services.RouletteService;
import com.api.services.repository.RouletteRepository;

@Service
public class RouletteServiceImpl implements RouletteService {

	@Autowired
	private RouletteRepository rouletteRepository;
	@Autowired
	private BetService betService;

	@Override
	public List<Roulette> findAll() {
		List<Roulette> roulettes = (List<Roulette>) rouletteRepository.findAll();

		List<Roulette> requestedRoulettes = roulettes.stream().map(roulette -> {
			roulette.setBets(null);
			return roulette;
		}).collect(Collectors.toList());

		return requestedRoulettes;
	}

	@Override
	public Roulette findById(String id) {
		return rouletteRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(NOT_FOUND_MESSAGE, id)));
	}

	@Override
	public String create(Roulette roulette) {
		Roulette createdRoulette = rouletteRepository.save(roulette);
		return createdRoulette.getId();
	}

	@Override
	public void openBets(String id) {
		Roulette currentRoulette = findById(id);
		validateStatusRoulette(currentRoulette, StatusEnum.CREADA);
		currentRoulette.setEstado(StatusEnum.ABIERTA);
		rouletteRepository.save(currentRoulette);
	}

	@Override
	public Roulette closeBets(String id) {
		Roulette closedRoulette = findById(id);
		Random random = new Random();

		validateStatusRoulette(closedRoulette, StatusEnum.ABIERTA);

		Byte winningNumber = (byte) random.nextInt(UPPER_BOUND + 1);
		closedRoulette.setWinningNumber(winningNumber);

		List<Bet> updateBets = betService.updateBettingResult(closedRoulette.getBets(), winningNumber);
		closedRoulette.getBets().addAll(updateBets);

		closedRoulette.setEstado(StatusEnum.CERRADA);
		rouletteRepository.save(closedRoulette);

		return closedRoulette;
	}

	@Override
	public void validateStatusRoulette(Roulette roulette, StatusEnum status) {
		if (!roulette.getEstado().equals(status)) {
			throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED,
					String.format(BAD_STATUS_MESSAGE, roulette.getId(), roulette.getEstado()));
		}
	}

}
