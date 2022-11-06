package wargame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import wargame.*;


public class PanneauJeu extends JFrame implements IConfig{
	
	private Carte carte;
	private int MIN_L = 1000;
	private int MIN_H = 1000;
	
	public PanneauJeu() {
	
		carte = new Carte();
		afficheInfo();
		creationCarte();
		
		setSize(MIN_L, MIN_H);    
		this.setResizable(true);
		setTitle("Welecome to WayToLearnX!");
		setVisible(true);
		
	}
	
	public void creationCarte() {
		
		
		
		
		JPanel panel = new JPanel();
		int minH = 0;
		int minL = 0;
		
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		
		
	  JPanel panelHaut = new JPanel(); 
	  JPanel panelBas = new JPanel();
	  
	  
	  panelHaut.setBackground(Color.red);
	  panelHaut.add(new JButton("je suis la"));
	  
	  g.fill = GridBagConstraints.HORIZONTAL;
	   g.anchor = GridBagConstraints.PAGE_START;
	    g.gridx = 0;
	    g.gridy = 0;
	   g.weighty = 10;
	   g.insets = new Insets(00,0,0,0);
	    this.add(panelHaut, g);
	    
		  
	    panelBas.setBackground(Color.blue);
		  panelBas.add(new JButton("je suis la"));
		  
		  g.fill = GridBagConstraints.HORIZONTAL;
		   g.anchor = GridBagConstraints.CENTER;
		    g.gridx = 0;
		    g.gridy = 0;
		   g.weighty = 10;
		   g.insets = new Insets(0,0,0,0);
		   this.add(panelBas, g);
		
		
		panel.setBackground(Color.black);
		
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
				
				
				JButton bouton = new JButton("i"+i);
				
				bouton.setPreferredSize(new Dimension(NB_PIX_CASE+10, NB_PIX_CASE+10));
				bouton.setAlignmentX(i*NB_PIX_CASE+minL);
				bouton.setAlignmentY(j*NB_PIX_CASE+minH);
				//bouton.setMargin(new Insets(-4, -4, -4, -4));
				bouton.setBorderPainted(false);
				bouton.setOpaque(true);
				bouton.setBackground(couleur);
			    bouton.setForeground(foreCouleur);
			    if(carte.getTabElement()[i][j] == null) {
			    	bouton.addActionListener(new BoutonActionListener(i, j, bouton));
			    }else {
			    	
			    	bouton.addActionListener(new BoutonActionListener(carte.getTabElement()[i][j]));
			    }
			    c.fill = GridBagConstraints.HORIZONTAL;
			   
			    c.gridx = i+1;
			    c.gridy = j;
			    panel.add(bouton, c);
			}
		}
		
		
		g.fill = GridBagConstraints.HORIZONTAL;
		   g.anchor = GridBagConstraints.PAGE_START;
	    g.gridx = 0;
	    g.gridy =1;
	    g.insets = new Insets(-30,0,0,0);
	    this.add(panel, g);
	    
	   
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
	
	public void afficheInfo() {
		
	}
	

}
