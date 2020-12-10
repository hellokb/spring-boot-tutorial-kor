package kr.pe.tutorial.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import kr.pe.tutorial.vo.PokemonVO;

@RestController
public class PokemonRestController {
	
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ModelAndView info(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		PokemonVO pokemonVO = new PokemonVO();
		pokemonVO.setId(1);
		pokemonVO.setName("이상해씨");
		pokemonVO.setHeight(0.7);
		pokemonVO.setWeight(6.9);
		pokemonVO.setHp(45);
		pokemonVO.setAttack(49);
		pokemonVO.setDefense(49);
		pokemonVO.setSpecial_attack(65);
		pokemonVO.setSpecial_defense(65);
		pokemonVO.setSpeed(45);
		mav.addObject("pokemon", pokemonVO);
		mav.addObject("toStringOfPokemon", pokemonVO.toString());
		mav.setViewName("jsonView");
		return mav;
	}
}
