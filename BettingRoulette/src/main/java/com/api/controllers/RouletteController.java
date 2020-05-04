package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Roulette;
import com.api.services.RouletteService;

@RestController
@RequestMapping("/ruleta")
public class RouletteController {

	@Autowired
	private RouletteService rouletteService;

	@GetMapping
	public List<Roulette> findAll() {
		return rouletteService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String create() {
		return rouletteService.create(new Roulette());
	}

	@PutMapping("/{idRoulette}/abrirApuestas")
	@ResponseStatus(HttpStatus.CREATED)
	public void openBets(@PathVariable String idRoulette) {
		rouletteService.openBets(idRoulette);
	}

	@PutMapping("/{idRoulette}/cerrarApuestas")
	@ResponseStatus(HttpStatus.CREATED)
	public Roulette closeBets(@PathVariable String idRoulette) {
		return rouletteService.closeBets(idRoulette);
	}

}
