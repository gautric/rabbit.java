package net.a.g.rabbit.command;
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
import java.util.logging.Logger;

import net.a.g.rabbit.etat.Orientation;
import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

/**
 * Classe de deplacement d'un lapin
 * 
 * @author gautric
 * 
 */
public class Step implements Command {

	/** un loggeur */
	private static final Logger LOG = Logger.getLogger(Step.class.getName());

	/**
	 * {@inheritDoc} Controle la future position de la lapin sur le terrain.
	 * Si la place est vide alors effectue le deplacement de la lapin.
	 */
	@Override
	public void execute(Rabbit t, Board b) {
		// Calcul de la future position
		Orientation o = t.getOrientation();
		int newx = t.getX() + o.getDeltaX();
		int newy = t.getY() + o.getDeltaY();

		// Controle que la future position est libre ou possible
		if (b.verifierPosition(newx, newy)) {
			// Si libre ou possible
			b.supprimerlapin(t);
			t.setX(newx);
			t.setY(newy);
			b.ajouterlapin(t);
		} else {
			// Si occupé ou impossible
			LOG.warning("Pas de déplacement possible");
		}
	}
}