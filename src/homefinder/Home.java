package homefinder;

import java.util.ArrayList;

public class Home {
	private int nbPiece;
	private int valeurBien;
	private int lat;
	private int lon;

	static ArrayList<Home> homeList = new ArrayList<Home>();

	public Home(int nbPiece, int valeurBien, int lat, int lon) {
		this.nbPiece = nbPiece;
		this.valeurBien = valeurBien;
		this.lat = lat;
		this.lon = lon;
	}

	static void fillHome(int nbHome) {

		for(int i = 0; i < nbHome; i++){
			int nbPiece = (int) (1 + (Math.random()* 4));
			int valeurBien = (int) (40000 + (Math.random()* 60000));
			int lat = (int) (Math.random()* 400);
			int lon = (int) (Math.random()* 600);
			homeList.add(new Home(nbPiece, valeurBien, lat, lon));
		}
	}
	
	public int getNbPiece() {
		return this.nbPiece;
	}
	
	public int getValeurBien() {
		return this.valeurBien;
	}
	
	public int getLat() {
		return this.lat;
	}
	
	public int getLon() {
		return this.lon;
	}

}
