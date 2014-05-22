package net.a.g.rabbit.factory;

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
import java.util.logging.Level;
import java.util.logging.Logger;

import net.a.g.rabbit.command.Command;
import net.a.g.rabbit.command.Composite;
import net.a.g.rabbit.command.Display;
import net.a.g.rabbit.command.LeftRotation;
import net.a.g.rabbit.command.RightRotation;
import net.a.g.rabbit.command.Step;
import net.a.g.rabbit.etat.Orientation;
import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

/**
 * Factory globale du projet, creation des differentes objets Terrain, lapin
 * mais aussi des commandes Il s'agit d'un singleton
 * 
 * @author gautric
 * 
 */
public class ObjectFactory {

	/** Loggeur */
	private static final Logger LOG = Logger.getLogger(ObjectFactory.class
			.getName());

	/** Singleton */
	private static ObjectFactory instance = new ObjectFactory();

	/** Objet unique pour le display, DP Poids mouche */
	private static Command display = new Display();

	/** Objet unique pour une rotation gauche, DP Poids mouche */
	private static Command left = new LeftRotation();

	/** Objet unique pour une rotation droite, DP Poids mouche */
	private static Command right = new RightRotation();

	/** Objet unique pour le deplacement, DP Poids mouche */
	private static Command step = new Step();

	/** Constructeur privé, DP singleton */
	private ObjectFactory() {
	}

	/** Methode de recuperation de l'instance */
	public static ObjectFactory getInstance() {
		return instance;
	}

	/**
	 * Creation du terrain
	 * 
	 * @param x
	 *            abscisse max du terrain
	 * @param y
	 *            ordonnée max du terrain
	 * 
	 * @return Le terrain
	 * */
	public Board createBoard(int x, int y) {
		return Board.createBoard(x, y);
	}

	/**
	 * Methode factory pour creer le terrain.
	 * 
	 * @param x
	 *            abscisse position de la lapin
	 * @param y
	 *            ordonnée position de la lapin
	 * @param o
	 *            orientation de la lapin
	 * 
	 * @return La lapin
	 * @throws IllegalArgumentException
	 *             si orientation inconnue ou position deja prise
	 * */
	public Rabbit createRabbit(int x, int y, String o) {
		Rabbit ret = null;
		
		if (x < 0) {
			throw new IllegalArgumentException("Position X interdit <0");
		}
		
		if (y < 0) {
			throw new IllegalArgumentException("Position Y interdit <0");
		}
		
		Orientation orientation = Orientation.valueOf(o);	
		
		if (orientation == null) {
			throw new IllegalArgumentException("Orientation Inconnue");
		}

		ret = new Rabbit(x, y, orientation);

		return ret;
	}

	/**
	 * Methode factory pour creer le terrain.
	 * 
	 * @param x
	 *            abscisse position de la lapin
	 * @param y
	 *            ordonnée position de la lapin
	 * @param o
	 *            orientation de la lapin
	 * 
	 * @return La lapin
	 * @throws IllegalArgumentException
	 *             si orientation inconnue ou position deja prise
	 * */
	public void initializeBoardRabbit(Board b, Rabbit r) {

		if (!b.verifierPosition(r.getX(), r.getY())) {
			throw new IllegalArgumentException("Position impossible");
		}

		b.ajouterlapin(r);

	}

	/**
	 * Creation du programme pour une lapin
	 * 
	 * @param listeCommande
	 *            liste des commande sous la forme definie par la spécification
	 * @return command à executer
	 */
	public Command createProgam(String listeCommande) {
		Composite c = (Composite) createComposite();
		char[] listeC = listeCommande.toCharArray();
		for (int i = 0; i < listeC.length; i++) {
			switch (listeC[i]) {
			case 'A':
				c.add(createStep());
				break;
			case 'G':
				c.add(createLeftRotation());
				break;
			case 'D':
				c.add(createRightRotation());
				break;
			default:
				LOG.log(Level.WARNING, "La commande '" + listeC[i]
						+ "' est inconnue et sera ignorée");
				break;
			}
		}

		if (c.size() == 0) {
			LOG.log(Level.SEVERE, "Aucune commande à executer");
		} else {
			c.add(createDisplay());
		}
		return c;
	}

	/**
	 * Creation d'une commande composite Creerun objet composite à chaque fois,
	 * cas ne peut pas implementer DP poids mouche
	 * 
	 * @return Command composite
	 */
	public Command createComposite() {
		return new Composite();
	}

	/**
	 * Retourne l'instance pour une rotation gauche
	 * 
	 * @return Command LeftRotation
	 */
	public Command createLeftRotation() {
		return left;
	}

	/**
	 * Retourne l'instance pour une rotation droite
	 * 
	 * @return Command RightRotation
	 */
	public Command createRightRotation() {
		return right;
	}

	/**
	 * Retourne l'instance pour un deplacement
	 * 
	 * @return Command Step
	 */
	public Command createStep() {
		return step;
	}

	/**
	 * Retourne l'instance pour l'affichage de la position de la lapin
	 * 
	 * @return Command Display
	 */
	public Command createDisplay() {
		return display;
	}
}
