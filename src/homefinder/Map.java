package homefinder;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Map extends JPanel{
	private int sizeX;
	private int sizeY;
	
	public Map(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
	}
	public void paint(Graphics g) {
		    g.setColor(Color.black);
		    g.fillRect(10,10,this.sizeX,this.sizeY);
		    paintHome(g,1,1,45000,60000,0,400,0,400);
	}
	
	public void paintHome(Graphics g, int nbPieceMin, int nbPieceMax, int valeurBienMin, int valeurBienMax,int latMin,
			int latMax, int lonMin, int lonMax) {
		for (Home home: Home.homeList) {
			if(home.getNbPiece() <= nbPieceMax && home.getNbPiece() >= nbPieceMin && home.getValeurBien() >= valeurBienMin &&
					home.getValeurBien() <= valeurBienMax && home.getLat() <= latMax && home.getLat() >= latMin && home.getLon() <= lonMax
					&& home.getLon() >= lonMin) {
				g.setColor(Color.yellow);
		    	g.fillRect(home.getLat()*sizeX/400, home.getLon()*sizeY/600, 3, 3);
			}
		}
	}
}
