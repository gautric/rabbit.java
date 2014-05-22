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
import java.util.ArrayList;
import java.util.List;

import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

/**
 * Composite implementant le DP composite
 * 
 * @author gautric
 * 
 */
public class Composite implements Command {

	/** Liste des commandes du composite */
	private List<Command> list = new ArrayList<Command>();

	/**
	 * Ajout d'une commande au composite
	 * 
	 * @param c
	 *            commande à ajouter
	 */
	public void add(Command c) {
		list.add(c);
	}

	/**
	 * {@inheritDoc} Execute l'ensemble de commande du composite
	 */
	@Override
	public void execute(Rabbit t, Board b) {
		for (Command c : list) {
			c.execute(t, b);
		}
	}

	/**
	 * Nombre de commande disponible
	 * 
	 * @return nombre de commande
	 */
	public int size() {
		return list.size();
	}
}