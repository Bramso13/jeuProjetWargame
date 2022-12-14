package wargame;
import java.awt.Color;
import java.awt.Graphics;

import wargame.View.IConfig;


public class Obstacle extends Element{
	public enum TypeObstacle {
		ROCHER (COULEUR_ROCHER), FORET (COULEUR_FORET), EAU (COULEUR_EAU);
		private final Color COULEUR;
		TypeObstacle(Color couleur) { COULEUR = couleur; }
		public static TypeObstacle getObstacleAlea() {
			return values()[(int)(Math.random()*values().length)];
		}
	}
	
	
	private TypeObstacle TYPE;
	
	public Obstacle() {
		
	}
	
	
	Obstacle(TypeObstacle type, Position pos) { 
		TYPE = type; this.pos = pos; 
	}
	public String toString() { return ""+TYPE; }
	
	@Override
	public void test() {
		System.out.println("obstacle");
	}
}