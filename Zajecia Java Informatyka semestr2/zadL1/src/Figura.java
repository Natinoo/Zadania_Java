

class Figura {
	
	//pola metody i kontruktory
	Point punkt;
	String kolor = "bialy";
	
	
	Figura(){
		punkt = new Point(0,0);
	}
	Figura(String kolor){
		this.kolor=kolor;
	}
	Figura(Point punkt){
		this.punkt=punkt;
	}
	String getKolor(){
		return kolor;
	}
	String opis(){
		return "Klasa Figura. Kolor obiektu: "+kolor;
	}
			
	
}
