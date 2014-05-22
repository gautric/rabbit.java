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
import net.a.g.rabbit.etat.Orientation;

/**
 * Classe lapin
 * 
 * @author gautric
 * 
 */
public class Rabbit {

	/** Id de la lapin */
	private int id;

	/** abscisse de la position de la lapin */
	private int x;
	/** ordonnée de la position de la lapin */
	private int y;
	/** Orientation de la lapin */
	private Orientation orientation;

	/** Nombre Totale d'instance de lapin créer */
	private static int nb = 0;

	/**
	 * Construteur
	 * 
	 * 
	 * @param x
	 *            abscisse de la position de la lapin
	 * @param y
	 *            ordonnée de la position de la lapin
	 * @param o
	 *            orientation de la lapin
	 */
	public Rabbit(int x, int y, Orientation o) {
		this.x = x;
		this.y = y;
		this.orientation = o;
		this.id = Rabbit.nb++;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return the orientation
	 */
	public Orientation getOrientation() {
		return orientation;
	}

	/**
	 * @param orientation
	 *            the orientation to set
	 */
	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "[" + id + "] " + getX() + " " + getY() + " " + getOrientation();
	}

}
