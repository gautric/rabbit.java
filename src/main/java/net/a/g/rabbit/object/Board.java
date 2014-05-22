package net.a.g.rabbit.object;
/**
	Rabbit Program : Design Pattern Study Case
	Copyright (C) 2013 "gautric"
	
	This program is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.

	This program is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
	GNU General Public License for more details.

	You should have received a copy of the GNU General Public License
	along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
import java.util.TreeMap;
import java.util.logging.Logger;

/**
 * Classe Board caracterisant le terrain où sont posé les lapins
 * 
 * @author gautric
 * 
 */
public class Board {

	/** Un loggeur */
	private static final Logger LOG = Logger.getLogger(Board.class.getName());

	/** abscisse max du terrain */
	private int x;
	/** ordonnée max du terrain */
	private int y;

	/**
	 * Position et mapping des lapins sur le terrain La clé de la Map est la
	 * concatenation de la position de la lapin
	 * 
	 * par exemple lapin(1,5) la clé sera "1-5"
	 * 
	 **/
	private TreeMap<String, Rabbit> ensemble = new TreeMap<String, Rabbit>();

	/**
	 * Constructeur privé voir la methode statique createBoard.
	 * 
	 * @param x
	 *            abscisse max du terrain
	 * @param y
	 *            ordonnée max du terrain
	 * */
	private Board(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Methode factory pour creer le terrain.
	 * 
	 * @param x
	 *            abscisse max du terrain
	 * @param y
	 *            ordonnée max du terrain
	 * 
	 * @return Le terrain
	 * @throws IllegalArgumentException
	 *             si le x ou y < 0
	 * */
	public static Board createBoard(final int x, final int y) {
		if (x < 0) {
			throw new IllegalArgumentException("x < 0 interdit");
		}
		if (y < 0) {
			throw new IllegalArgumentException("y < 0 interdit");
		}

		return new Board(x, y);
	}

	/**
	 * Ajout d'un lapin sur le terrain. Verifie qu'aucune lapin n'est
	 * deja posée.
	 * 
	 * @param t
	 *            une lapin à poser
	 * 
	 * */
	public void ajouterlapin(Rabbit t) {
		if (verifierPosition(t.getX(), t.getY())) {
			ensemble.put(cleDePosition(t.getX(), t.getY()), t);
		} else {
			LOG.severe("Une lapin occupe deja la position");
		}
		LOG.fine("> " + t);
	}

	/**
	 * Verifie que la position est vide ou possible Si la position est
	 * 
	 * @param x
	 *            abscisse de la position à tester
	 * @param y
	 *            ordonnée de la position à tester
	 * 
	 * @return true si position vide, false sinon
	 * */
	public boolean verifierPosition(int x, int y) {
		if (x < 0 || x > this.x) {
			return false;
		}
		if (y < 0 || y > this.y) {
			return false;
		}
		return !ensemble.containsKey(cleDePosition(x, y));
	}

	/**
	 * Supprime/enleve la lapin du terrain
	 * 
	 * @param m
	 *            la lapin
	 * 
	 */
	public void supprimerlapin(Rabbit m) {
		ensemble.remove(cleDePosition(m.getX(), m.getY()));
	}

	/**
	 * Calcul la clé pour la TreeMap ensemble
	 * 
	 * par exemple cleDePosition(1,8) == "1-8"
	 * 
	 * 
	 * @param x
	 *            abscisse de la position
	 * @param y
	 *            ordonnée de la position
	 * @return Clé de la position
	 */
	private String cleDePosition(int x, int y) {
		StringBuilder sb = new StringBuilder().append(x).append("-").append(y);
		return sb.toString();
	}

	/**
	 * @return the x
	 */
	public int getSizeX() {
		return x;
	}

	/**
	 * @return the y
	 */
	public int getSizeY() {
		return y;
	}

	@Override
	public String toString() {
		return "" + getSizeX() + " " + getSizeY() + " " ;	
	}

}
