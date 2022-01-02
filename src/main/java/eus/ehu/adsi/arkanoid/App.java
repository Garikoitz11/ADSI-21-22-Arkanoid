package eus.ehu.adsi.arkanoid;

public class App {
	
	public static Menu menu;
	public static Arkanoid arkanoid;
	
	public static void main(String[] args) {
		menu=new Menu();
		arkanoid=new Arkanoid();
		
		EME();
		
	}
	
	public static void EME() { //para futuro
		arkanoid.setVisible(false);
		menu.setVisible(true);
		
		while(menu.getActivo()==false){
			arkanoid.setVisible(false);
		}
		
		arkanoid.setVisible(true);
		
		arkanoid.run();
	}

}