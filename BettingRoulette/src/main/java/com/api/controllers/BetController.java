package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Bet;
import com.api.services.BetService;

@RestController
@RequestMapping("/apuesta")
public class BetController {

	@Autowired
	private BetService betService;

	@PostMapping("/ruleta/{idRoulette}")
	@ResponseStatus(HttpStatus.CREATED)
	public void openUserBet(@RequestBody Bet bet, @PathVariable String idRoulette) {
		betService.openUserBet(bet, idRoulette);
	}
}
