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
import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

/**
 * Classe de rotation gauche d'un lapin
 * 
 * @author gautric
 * 
 */
public class LeftRotation implements Command {

	/**
	 * {@inheritDoc} Effectue une rotation gauche de la lapin
	 */
	@Override
	public void execute(Rabbit t, Board b) {
		t.setOrientation(t.getOrientation().leftRotation());
	}
}