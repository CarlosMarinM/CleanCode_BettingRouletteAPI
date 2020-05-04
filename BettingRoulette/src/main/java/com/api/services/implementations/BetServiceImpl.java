package com.api.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.api.models.Bet;
import com.api.models.Bet.ResultsEnum;
import com.api.models.Roulette;
import com.api.models.StatusEnum;
import com.api.services.BetService;
import com.api.services.RouletteService;
import com.api.services.UserService;
import com.api.services.repository.BetRepository;

@Service
public class BetServiceImpl implements BetService {

	@Autowired
	private RouletteService rouletteService;
	@Autowired
	private UserService userService;
	@Autowired
	private BetRepository betRepository;

	@Override
	public void openUserBet(Bet bet, String idRoulette) {
		Roulette roulette = rouletteService.findById(idRoulette);
		userService.findById(bet.getUser().getId());
		rouletteService.validateStatusRoulette(roulette, StatusEnum.ABIERTA);
		validateNumberDomain(bet.getNumber());
		addBetToRoulette(bet, roulette);
	}

	@Override
	public String create(Bet bet) {
		Bet createdBet = betRepository.save(bet);
		return createdBet.getId();
	}

	@Override
	public List<Bet> updateBettingResult(List<Bet> bets, Byte winningNumber) {
		return bets.stream().map(bet -> {
			bet.setResult(bet.getNumber() == winningNumber ? ResultsEnum.GANADA : ResultsEnum.PERDIDA);
			return bet;
		}).collect(Collectors.toList());
	}

	private void validateNumberDomain(Byte number) {
		if (number < RouletteService.LOWER_BOUND || number > RouletteService.UPPER_BOUND) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					String.format(NUMBER_OUT_DOMAIN_MESSAGE, RouletteService.LOWER_BOUND, RouletteService.UPPER_BOUND));
		}
	}

	private void addBetToRoulette(Bet bet, Roulette roulette) {
		create(bet);
		roulette.getBets().add(bet);
		rouletteService.create(roulette);
	}

}
