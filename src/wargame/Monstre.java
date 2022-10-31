package wargame;

import wargame.ISoldat.TypesH;
import wargame.View.Carte;

public abstract class Monstre extends Soldat {
	
	private String NOM;
	private TypesM TYPE;

	public Monstre(Carte carte, TypesM type, String nom, Position pos) {
		super(carte, type.getPoints(), type.getPortee(), type.getPuissance(), type.getTir(), pos);
		NOM = nom;
		TYPE = type;
	}
	
}
