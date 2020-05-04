package com.api.services;

import java.util.List;

import com.api.models.Bet;

public interface BetService {

	public static final String NUMBER_OUT_DOMAIN_MESSAGE = "El número apostado debe estar entre $d y $d.";

	public void openUserBet(Bet bet, String id);

	public String create(Bet bet);

	public List<Bet> updateBettingResult(List<Bet> bets, Byte winningNumber);

}
