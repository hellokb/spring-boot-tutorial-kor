package kr.pe.tutorial.vo;

import lombok.Data;

@Data
public class PokemonVO {
	private int id;
	private String name;
	private double height;
	private double weight;
	private int hp;
	private int attack;
	private int defense;
	private int special_attack;
	private int special_defense;
	private int speed;
}
