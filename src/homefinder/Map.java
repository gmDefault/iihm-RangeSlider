package homefinder;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Map extends JPanel {

	private static final long serialVersionUID = 1L;
	private int sizeX;
	private int sizeY;

	private int nbPieceMin;
	private int nbPieceMax;
	private int valeurBienMin;
	private int valeurBienMax;

	/**
	 * Constructor
	 * 
	 * @param sizeX width in pixels
	 * @param sizeY height in pixels
	 */
	public Map(int sizeX, int sizeY) {
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.nbPieceMin = 0;
		this.nbPieceMax = 0;
		this.valeurBienMin = 0;
		this.valeurBienMax = 0;

	}

	public int getNbPieceMin() {
		return nbPieceMin;
	}

	public void setNbPieceMin(int nbPieceMin) {
		this.nbPieceMin = nbPieceMin;
	}

	public int getNbPieceMax() {
		return nbPieceMax;
	}

	public void setNbPieceMax(int nbPieceMax) {
		this.nbPieceMax = nbPieceMax;
	}

	public int getValeurBienMin() {
		return valeurBienMin;
	}

	public void setValeurBienMin(int valeurBienMin) {
		this.valeurBienMin = valeurBienMin;
	}

	public int getValeurBienMax() {
		return valeurBienMax;
	}

	public void setValeurBienMax(int valeurBienMax) {
		this.valeurBienMax = valeurBienMax;
	}

	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(10, 10, this.sizeX, this.sizeY);
		paintHome(g);
	}

	/**
	 * Fill the map (black rectangle) with homes (yellow squares of width 3*3)
	 * 
	 * @param g
	 */
	public void paintHome(Graphics g) {
		for (Home home : Home.homeList) {
			if (home.getNbPiece() <= nbPieceMax && home.getNbPiece() >= nbPieceMin
					&& home.getValeurBien() >= valeurBienMin && home.getValeurBien() <= valeurBienMax) {
				g.setColor(Color.yellow);
				g.fillRect(home.getLat() * sizeX / 400, home.getLon() * sizeY / 600, 3, 3);
			}
		}
	}

}
