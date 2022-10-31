package wargame;

import java.awt.*;      
import java.awt.event.*; 
import javax.swing.*; 

public class Carte extends JFrame implements IConfig{
	
	
	
	
	
	public Carte() {
		
		
		setSize(LARGEUR_CARTE*NB_PIX_CASE, HAUTEUR_CARTE*NB_PIX_CASE);    
		setTitle("Welecome to WayToLearnX!");
		setVisible(true);
		
		
	}

}
