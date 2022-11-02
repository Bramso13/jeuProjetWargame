package wargame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;

import wargame.*;


public class PanneauJeu extends JFrame implements IConfig{
	
	private Carte carte;
	
	public PanneauJeu() {
	
		carte = new Carte();
		creationCarte();
		
		setSize(870, 580);    
		this.setResizable(true);
		setTitle("Welecome to WayToLearnX!");
		setVisible(true);
		
	}
	
	public void creationCarte() {
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, LARGEUR_CARTE*NB_PIX_CASE, HAUTEUR_CARTE*NB_PIX_CASE);
		
		Color couleur = COULEUR_VIDE;
		int o=0;
		Color foreCouleur = Color.BLUE;
		System.out.println("nb monstre "+Element.nb_monstre);
		for(int i=0;i<LARGEUR_CARTE;i++) {
			for(int j=0;j<HAUTEUR_CARTE;j++) {
				
				if(carte.getTabElement()[i][j] instanceof Obstacle) {
					o++;
					couleur = Color.green;
					foreCouleur = Color.white;
				}
				if(carte.getTabElement()[i][j] instanceof Monstre) {
					
					couleur = Color.blue;
					foreCouleur = Color.white;
				}
				if(carte.getTabElement()[i][j] instanceof Heros) {
					
					couleur = Color.red;
					foreCouleur = Color.white;
				}
				if(carte.getTabElement()[i][j] == null) {
					couleur = Color.white;
					foreCouleur = Color.white;
				}
				
				JButton bouton = new JButton();
				bouton.setPreferredSize(new Dimension(NB_PIX_CASE-1, NB_PIX_CASE-1));
				bouton.setAlignmentX(i*NB_PIX_CASE);
				bouton.setAlignmentY(j*NB_PIX_CASE);
				bouton.setMargin(new Insets(-4, -4, -4, -4));
				bouton.setBorderPainted(false);
				bouton.setOpaque(true);
				bouton.setBackground(couleur);
			    bouton.setForeground(foreCouleur);
				
				panel.add(bouton);
			}
		}
		System.out.println("o "+o);
		
		this.add(panel);
	}
	
	
	

}
