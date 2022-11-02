package wargame;

import wargame.View.*;

public class Heros extends Soldat implements ISoldat {

	
	private String NOM;
	private TypesH TYPE;
	
	public Heros() {
		
	}
	
	public Heros(Carte carte, TypesH type, String nom, Position pos) {
		super(carte, type.getPoints(), type.getPortee(), type.getPuissance(), type.getTir(), pos);
		NOM = nom;
		TYPE = type;
	}
	
	

}

