package wargame.View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import wargame.*;


public class PanneauJeu extends JFrame implements IConfig{
	
	private Carte carte;
	private int MIN_L = 1000;
	private int MIN_H = 700;
	public Soldat mySold;
	private JPanel side = null;
	
	
	public PanneauJeu() {
	
		carte = new Carte();
		this.setLayout(new GridBagLayout());
		creationCarte(null);
		afficheInfo(new Heros());
		

		
        
        this.pack();
		
		setSize(MIN_L, MIN_H);    
		this.setResizable(true);
		setTitle("Welecome to WayToLearnX!");
		setVisible(true);
		
	}
	
	public void infoElement(JPanel side, Soldat sol) {
		
		JPanel info = new JPanel(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.VERTICAL;
		g.gridheight = 10;
        g.weighty = 0.0;
        
        g.gridheight = 10;
        g.gridx = 0;
        g.gridy = 6;
        side.add(info, g);
        
        JLabel bouton = new JLabel("A");
        bouton.setHorizontalAlignment(SwingConstants.CENTER);
		bouton.setOpaque(true);
		g.fill = GridBagConstraints.VERTICAL;
		g.ipadx = 40;
		g.ipady = 40;
        g.weighty = 0.0;
        
        g.gridheight = 10;
        g.gridx = 0;
        g.gridy = 0;
		
		if(sol instanceof Monstre) {
			
			bouton.setText("M");
			bouton.setForeground(Color.white);
			bouton.setBackground(COULEUR_MONSTRES);
		}else {
			bouton.setText("H");
			bouton.setBackground(COULEUR_HEROS);
		}
		info.add(bouton, g);
		
		
		
		JLabel pointVie = new JLabel(sol.getPointsDeVie()+"/"+sol.getPOINTS_DE_VIE_MAX());
		
		g.fill = GridBagConstraints.VERTICAL;
		g.ipadx = 0;
		g.ipady = 0;
		g.gridheight = 1;
        g.weighty = 0.0;
        g.gridx = 1;
        g.gridy = 1;
        g.insets = new Insets(0, 0, 0, 0);
        info.add(pointVie, g);
        
        g.gridx = 1;
        g.gridy = 0;
        info.add(new JLabel("Point de vie :"), g);
        g.gridx = 1;
        g.gridy = 2;
        info.add(new JLabel("Puissance :"), g);
        g.gridx = 1;
        g.gridy = 4;
        info.add(new JLabel("Tir :"), g);
        g.gridx = 1;
        g.gridy = 6;
        info.add(new JLabel("Portée :"), g);
        
        JLabel puissance = new JLabel(sol.getPUISSANCE()+"");
		
		g.fill = GridBagConstraints.VERTICAL;
        g.weighty = 0.0;
        g.gridx = 1;
        g.gridy = 3;
        
        info.add(puissance, g);
        
        JLabel tir = new JLabel(sol.getTIR()+"");
		
		g.fill = GridBagConstraints.VERTICAL;
        g.weighty = 0.0;
        g.gridx = 1;
        g.gridy = 5;
        
        info.add(tir, g);
        
        JLabel portee = new JLabel(sol.getPORTEE_VISUELLE()+"");
		
		g.fill = GridBagConstraints.VERTICAL;
        g.weighty = 0.0;
        g.gridx = 1;
        g.gridy = 7;
        
        info.add(portee, g);
	}
	
	public void afficheInfo(Soldat sol) {
		
		if(this.side != null)
			this.remove(this.side);
		GridBagConstraints g = new GridBagConstraints();
		g.fill = GridBagConstraints.VERTICAL;
        g.ipadx = 0;
        g.weighty = 0.0;
        
        g.gridheight = LARGEUR_CARTE;
        g.gridx = 0;
        g.gridy = 0;
		JPanel side = new JPanel(new GridBagLayout());
		
		side.setBackground(Color.black);
		this.add(side, g);
		
		g.fill = GridBagConstraints.VERTICAL;
		
        g.gridx = 0;
        g.gridy = 1;
        //g.weighty = 0.33;
        //g.weightx = 1;
        g.gridheight = 1;
		JLabel titleSide = new JLabel("Nombre d'héros :");
		
		titleSide.setForeground(Color.white);
		side.add(titleSide, g);
		
		g.fill = GridBagConstraints.VERTICAL;
		
        g.gridx = 0;
        g.gridy = 2;
        //g.weighty = 0.33;
        //g.weightx = 1;
        g.gridheight = 1;
		JLabel valeurHeros = new JLabel(Element.nb_heros+"");
		
		valeurHeros.setForeground(Color.white);
		side.add(valeurHeros, g);
		
		g.fill = GridBagConstraints.VERTICAL;
		
        g.gridx = 0;
        g.gridy = 3;
        //g.weighty = 1;
        //g.weightx = 1;
		JLabel labelMonstre = new JLabel("Nombre de monstres :");
		
		labelMonstre.setForeground(Color.white);
		side.add(labelMonstre, g);
		
		g.fill = GridBagConstraints.VERTICAL;
		
        g.gridx = 0;
        g.gridy = 4;
        //g.weighty = 1;
        //g.weightx = 1;
		JLabel valeurMonstre = new JLabel(Element.nb_monstre+"");
		
		valeurMonstre.setForeground(Color.white);
		side.add(valeurMonstre, g);
		
		JButton bo = new JButton("Fin du tour");
		g.fill = GridBagConstraints.VERTICAL;
        g.gridx = 0;
        g.gridy = 5;
        //g.weighty = 1;
        //g.weightx = 1;
		side.add(bo, g);
		creationCarte(side);
		infoElement(side, sol);
		this.side = side;
		
	}
	
	public void creationCarte(JPanel comp) {
		
		
		
		
		JPanel panel = new JPanel();
		GridBagLayout mainGrid = new GridBagLayout();
		GridBagConstraints g = new GridBagConstraints();
		JPanel main = new JPanel(mainGrid);
		int minH = NB_PIX_CASE;
		int minL = NB_PIX_CASE;
		String name = "";
		int iMonstre=0, iHeros=1;
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
		
		
		
		if(comp != null) {
			
			g.fill = GridBagConstraints.VERTICAL;
			g.gridheight = 1;
	        g.gridx = 0;
	        g.gridy = 0;
	        //g.weighty = 1;
	        //g.weightx = 1;
			comp.add(main, g);
			minH = 5;
			minL = 5;
			
		}
		else
			this.setContentPane(main);
			
		
        main.setLayout(mainGrid);
        
        
		
		Color couleur = COULEUR_VIDE;
		
		Color foreCouleur = Color.BLUE;
		System.out.println("nb monstre "+Element.nb_monstre);
		for(int i=0;i<LARGEUR_CARTE;i++) {
			for(int j=0;j<HAUTEUR_CARTE;j++) {
				name = "";
				if(carte.getTabElement()[i][j] instanceof Obstacle) {
					
					couleur = Color.green;
					foreCouleur = Color.white;
				}
				if(carte.getTabElement()[i][j] instanceof Monstre) {
					name = alphabet[iMonstre];
					couleur = Color.blue;
					foreCouleur = Color.white;
					iMonstre++;
				}
				if(carte.getTabElement()[i][j] instanceof Heros) {
					name = ""+iHeros;
					couleur = Color.red;
					foreCouleur = Color.white;
					iHeros++;
				}
				if(carte.getTabElement()[i][j] == null) {
					couleur = Color.white;
					foreCouleur = Color.white;
				}
				
				
				g.fill = GridBagConstraints.VERTICAL;
				g.anchor = GridBagConstraints.CENTER;
				g.ipady = 0;
				JButton bouton = new JButton();
				JLabel label = new JLabel(name);
				label.setForeground(Color.white);
				
				
				
				bouton.add(label, g);
				bouton.setPreferredSize(new Dimension(minL, minH));
				
				bouton.setMargin(new Insets(-4, -4, -4, -4));
				bouton.setBorderPainted(false);
				bouton.setOpaque(true);
				bouton.setBackground(couleur);
			    bouton.setForeground(foreCouleur);
			    if(carte.getTabElement()[i][j] == null) {
			    	bouton.addActionListener(new BoutonActionListener(i, j, bouton));
			    }else {
			    	
			    	bouton.addActionListener(new BoutonActionListener(carte.getTabElement()[i][j], this));
			    }
			    g.ipady = 0;      //make this component tall
			    g.ipadx = 0;
		        g.weightx = 0.0;
		        g.gridheight = 1;
			    g.weightx = 0;
				g.weighty = 0;
			    g.gridx = i+1;
			    g.gridy = j;
			    mainGrid.setConstraints(bouton, g);
			    main.add(bouton, g);
			}
		}
		
		
	   
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
		private PanneauJeu pan;
		
		BoutonActionListener(Element e, PanneauJeu j){
			elem = e;
			if(e instanceof Soldat)
				j.mySold = (Soldat) e;
			pan = j;
			
		}
		
		BoutonActionListener(int x, int y, JButton bouton){
			System.out.println("x "+x+" xBase "+xBase+" y "+y+" yBase "+yBase);
			this.x = x;
			this.y = y;
			this.b = bouton;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if(elem != null) {
				pan.afficheInfo((Soldat) elem);
				elem.test();
			}
				
			
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
