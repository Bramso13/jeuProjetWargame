package wargame;

import wargame.View.Carte;

public abstract class Soldat extends Element implements ISoldat {
	private final int POINTS_DE_VIE_MAX, PUISSANCE, TIR, PORTEE_VISUELLE;
	private int pointsDeVie;
	private Carte carte;
	private Position pos;
	private int tour;
	
	public Soldat() {
		this.POINTS_DE_VIE_MAX = 0;
		this.PUISSANCE = 0;
		this.TIR = 0;
		this.PORTEE_VISUELLE = 0;
		
	}
	
	public Soldat(Carte carte, int pts, int portee, int puiss, int tir, Position pos) {
		POINTS_DE_VIE_MAX = setPointsDeVie(pts);
		PORTEE_VISUELLE = portee; 
		PUISSANCE = puiss; 
		TIR = tir;
		this.carte = carte; 
		this.pos = pos;	
	}

	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public int setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
		return pointsDeVie;
	}

	public int getTour() {
		return tour;
	}

	public void setTour(int tour) {
		this.tour = tour;
	}

	public int getPOINTS_DE_VIE_MAX() {
		return POINTS_DE_VIE_MAX;
	}

	public int getPUISSANCE() {
		return PUISSANCE;
	}

	public int getTIR() {
		return TIR;
	}

	public int getPORTEE_VISUELLE() {
		return PORTEE_VISUELLE;
	}

	public Position getPosition() {
		return this.pos;
	}
	public void setPosition(Position po) {
		this.pos = po;
	}
	
	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return this.getPointsDeVie();
	}
	@Override
	public int getPortee() {
		// TODO Auto-generated method stub
		return this.getPORTEE_VISUELLE();
	}

	@Override
	public void joueTour(int tour) {
		// TODO Auto-generated method stub
		this.setTour(tour);
	}

	@Override
	public void combat(Soldat soldat) {
		// TODO Auto-generated method stu
		int m;
		if(soldat.getPosition().getX() == this.getPosition().getX()+1 
				|| soldat.getPosition().getX() == this.getPosition().getX()-1
				|| soldat.getPosition().getY() == this.getPosition().getY()+1
				|| soldat.getPosition().getY() == this.getPosition().getY()-1) {
			m = soldat.degat((int) Math.random()*this.getPUISSANCE());
			if(m == 1) this.degat((int) Math.random()*soldat.getPUISSANCE());
		}else {
			m = soldat.degat(this.getPUISSANCE());
			if(m == 1) this.degat(soldat.getPUISSANCE());
		}
	}

	@Override
	public void seDeplace(Position newPos) {
		// TODO Auto-generated method stub
		this.setPosition(newPos);
	}
	
	public int degat(int puissance) {
		
		this.setPointsDeVie(this.getPointsDeVie()-puissance);
		if(this.getPointsDeVie() <= 0) {
			return 0;
		}
		return 1;
	}

	
}

