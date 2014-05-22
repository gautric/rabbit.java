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

import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

/**
 * Classe d'affichage d'un lapin
 * 
 * @author gautric
 * 
 */
public class Display implements Command {

	/** Loggeur */
	private static final Logger LOG = Logger.getLogger(Display.class.getName());

	/**
	 * {@inheritDoc} Affiche la position de la lapin passée en parametre.
	 */
	@Override
	public void execute(Rabbit t, Board b) {
		LOG.info("Position : " + t.toString());
	}

}
