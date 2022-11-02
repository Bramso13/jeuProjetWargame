package wargame.View;

import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*; 

import wargame.*;

public class Carte implements IConfig{
	
	
	
	private Element[][] tabElement = new Element[LARGEUR_CARTE][HAUTEUR_CARTE];
	
	public Carte() {
		
		
		randomElement();
		
		
	}
	
	public void randomElement() {
			
			int choix, pif=0;
			
			int x,y;
			
			for(int i=0;i<LARGEUR_CARTE;i++) {
				for(int j=0;j<HAUTEUR_CARTE;j++) {
					x=i;y=j;
					choix = (int) (Math.random()*4);
					
					if(pif != 0) {
						tabElement[x][y] = null;
						pif--;
					}
					if(pif == 0) {
						switch(choix) {
							case 0:
								if(Element.nb_obstacle < NB_OBSTACLES) {
									
									tabElement[x][y] = (Obstacle) new Obstacle();
									Element.nb_obstacle++;
									Element.nb_case++;
									pif = (int) Math.random()*30 + 10;
								}else {
									Element.nb_case++;
									tabElement[x][y] = null;
								}
								break;
							case 1:
								if(Element.nb_monstre < NB_MONSTRES) {
									
									tabElement[x][y] = (Monstre) new Monstre();
									Element.nb_monstre++;
									Element.nb_case++;
									pif = (int) Math.random()*30 + 5;
								}else {
									Element.nb_case++;
									tabElement[x][y] = null;
								}
								break;
							case 2:
								if(Element.nb_heros < NB_HEROS) {
									
									tabElement[x][y] = (Heros) new Heros();
									Element.nb_heros++;
									Element.nb_case++;
									pif = (int) Math.random()*30 + 4;
								}else {
									Element.nb_case++;
									tabElement[x][y] = null;
								}
								
								break;
							case 3:
								tabElement[x][y] = null;
								Element.nb_case++;
								break;
						}
					}
					
					
				}
			}
			
			
			
		}

	public Element[][] getTabElement() {
		return tabElement;
	}
	

}
