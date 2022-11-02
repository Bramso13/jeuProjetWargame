package wargame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		Color foreCouleur = Color.BLUE;
		System.out.println("nb monstre "+Element.nb_monstre);
		for(int i=0;i<LARGEUR_CARTE;i++) {
			for(int j=0;j<HAUTEUR_CARTE;j++) {
				
				if(carte.getTabElement()[i][j] instanceof Obstacle) {
					
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
			    if(carte.getTabElement()[i][j] == null) {
			    	bouton.addActionListener(new BoutonActionListener(i, j, bouton));
			    }else {
			    	
			    	bouton.addActionListener(new BoutonActionListener(carte.getTabElement()[i][j]));
			    }
				panel.add(bouton);
			}
		}
		
		
		this.add(panel);
	}
	
	private static class BoutonActionListener implements ActionListener {
		
		private Element elem;
		private int x;
		private int y;
		private static int xBase=0;
		private static int yBase=0;
		private static int interupteur=0;
		private JButton b;
		private Color couleur = Color.black;
		
		BoutonActionListener(Element e){
			elem = e;
		}
		
		BoutonActionListener(int x, int y, JButton bouton){
			System.out.println("x "+x+" xBase "+xBase+" y "+y+" yBase "+yBase);
			this.x = x;
			this.y = y;
			this.b = bouton;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(elem != null)
				elem.test();
			else {
				this.b.setBackground(couleur);
				if(x == xBase && y==yBase) {
					BoutonActionListener.interupteur = 1-BoutonActionListener.interupteur;
					if(couleur.equals(Color.black)) {
						couleur = Color.white;
					}else {
						couleur = Color.black;
					}
					this.b.setBackground(couleur);
				}
				BoutonActionListener.xBase = x;
				BoutonActionListener.yBase = y;
				System.out.println("interupteur "+BoutonActionListener.interupteur);
			}
		}
		
	}
	

}
