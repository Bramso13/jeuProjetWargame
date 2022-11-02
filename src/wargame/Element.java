package wargame;

import wargame.View.IConfig;

public abstract class Element implements IConfig{
	
	protected Position pos;
	public static int nb_monstre=0;
	public static int nb_obstacle=0;
	public static int nb_heros=0;
	public static int nb_case=0;
	
	
	public Element() {
		
	}
	
	
	public Element(Position pos) {
		
		this.pos = pos;
		
		
	}
	
	public Object clone(){  
	    try{  
	        return super.clone();  
	    }catch(Exception e){ 
	        return null; 
	    }
	}
	
	
	
	
	
	public static int getNb_monstre() {
		return nb_monstre;
	}





	public static int getNb_obstacle() {
		return nb_obstacle;
	}


	


	public static int getNb_heros() {
		return nb_heros;
	}


	

	public static int getNb_case() {
		return nb_case;
	}


	


	public void test() {
		System.out.println("element");
	}
}
