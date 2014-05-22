package net.a.g.rabbit.etat;
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

/**
 * Enumeration de l'orientation, permet de calculer rapidement la position pour
 * un futur déplacement
 * 
 * @author gautric
 * 
 */
public enum Orientation {
	/** NORTH. */
	N(0, +1),
	/** EAST. */
	E(+1, 0),
	/** WEST. */
	W(-1, 0),
	/** SOUTH. */
	S(0, -1);

	/** decalage en abscisse si deplacement */
	private int deltaX;
	/** decalage en ordonnée si deplacement */
	private int deltaY;

	/** Construteur */
	Orientation(final int deltaX, final int deltaY) {
		this.deltaX = deltaX;
		this.deltaY = deltaY;
	}

	/**
	 * @return the deltaX
	 */
	public int getDeltaX() {
		return deltaX;
	}

	/**
	 * @return the deltaY
	 */
	public int getDeltaY() {
		return deltaY;
	}

	/**
	 * Trouve l'etat de la lapin après une rotation droite (clockwise).
	 * Modifie l'orientation de la lapin
	 * 
	 */
	public Orientation rightRotation() {
		Orientation ret = null;
		switch (this) {
		case E: // East to South
			ret = S;
			break;
		case W: // West to North
			ret = N;
			break;
		case S: // South to West
			ret = W;
			break;
		case N: // North to East
			ret = E;
			break;
		}
		return ret;
	}

	/**
	 * Trouve l'etat de la lapin après une rotation gauche (clockwise).
	 * Modifie l'orientation de la lapin
	 * 
	 */
	public Orientation leftRotation() {
		Orientation ret = null;
		switch (this) {
		case E: // East to North
			ret = N;
			break;
		case W: // West to South
			ret = S;
			break;
		case S: // South to East
			ret = E;
			break;
		case N: // North to West
			ret = W;
			break;
		}
		return ret;
	}
}
