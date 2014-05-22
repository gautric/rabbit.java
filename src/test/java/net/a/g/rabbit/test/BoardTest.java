package net.a.g.rabbit.test;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import net.a.g.rabbit.command.Command;
import net.a.g.rabbit.command.Composite;
import net.a.g.rabbit.factory.ObjectFactory;
import net.a.g.rabbit.object.Board;
import net.a.g.rabbit.object.Rabbit;

import org.junit.Test;

/**
 * Classe de test
 * 
 * @author gautric
 * 
 */
public class BoardTest {

	private static final Logger LOG = Logger.getLogger(BoardTest.class
			.getName());

	/** Instance de la factory */
	ObjectFactory factory = ObjectFactory.getInstance();

	/** Cas ou la creation du terrain est erroné coordonné negative */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardKONegativeValue() {

		factory.createBoard(-1, -1);

	}

	/** Cas ou la creation du terrain est erroné coordonné negative */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardKONegative2() {

		factory.createBoard(-1, 1);

	}

	/** Cas ou la creation du terrain est erroné coordonné negative */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardKONegative3() {

		factory.createBoard(1, -1);

	}

	/** Creation d'un terrain avec une case */
	@Test
	public void testBoardOK1Case() {
		assertNotNull(factory.createBoard(0, 0));
	}

	/** Creation d'un terrain avec 4 cases */
	@Test
	public void testBoardOK4Cases() {
		assertNotNull(factory.createBoard(1, 1));
	}

	/** Creation d'un lapin hors terrain */
	@Test(expected = IllegalArgumentException.class)
	public void testlapinKOHorsChamps() {

		// Creation des lapins
		factory.createRabbit(0, -1, "N");

	}

	/** Creation d'un lapin hors terrain */
	@Test(expected = IllegalArgumentException.class)
	public void testlapinKOHorsChampsY() {

		// Creation des lapins
		factory.createRabbit(-1, -1, "N");

	}

	/** Creation d'un lapin hors terrain */
	@Test(expected = IllegalArgumentException.class)
	public void testlapinKOHorsChampsXY() {

		// Creation des lapins
		factory.createRabbit(-1, 0, "N");

	}

	/** Creation d'un lapin hors terrain */
	@Test(expected = IllegalArgumentException.class)
	public void testlapinKOHorsTerrain() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(1, 1, "N");
		factory.initializeBoardRabbit(board, lapin);

	}

	/** Creation d'un lapin avec une orientation inconnue */
	@Test(expected = IllegalArgumentException.class)
	public void testlapinKOOrientationInconnu() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "K");
		factory.initializeBoardRabbit(board, lapin);

	}

	/** test de creation d'un lapin sur terrain d'une case */
	@Test
	public void testlapinOKTerrain1Case() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		assertEquals(0, board.getSizeX());
		assertEquals(0, board.getSizeY());

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "N");
		factory.initializeBoardRabbit(board, lapin);

		assertEquals(0, lapin.getX());
		assertEquals(0, lapin.getY());

	}

	/** test de deplacement d'un lapin hors terrain vers le nord */
	@Test
	public void testlapinKODeplacementYN() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "N");
		factory.initializeBoardRabbit(board, lapin);

		factory.createStep().execute(lapin, board);

		assertEquals(0, lapin.getX());
		assertEquals(0, lapin.getY());

	}

	/** test de deplacement d'un lapin hors terrain vers le sud */
	@Test
	public void testlapinOKDeplacementYS() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "S");
		factory.initializeBoardRabbit(board, lapin);

		factory.createStep().execute(lapin, board);

		assertEquals(0, lapin.getX());
		assertEquals(0, lapin.getY());

	}

	/** test de deplacement d'un lapin hors terrain vers l'ouest */
	@Test
	public void testlapinOKDeplacementXW() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "W");
		factory.initializeBoardRabbit(board, lapin);

		factory.createStep().execute(lapin, board);

		assertEquals(0, lapin.getX());
		assertEquals(0, lapin.getY());

	}

	/** test de deplacement d'un lapin hors terrain vers l'est */
	@Test
	public void testlapinOKDeplacementXE() {
		// Creation du terrain
		Board board = factory.createBoard(0, 0);

		// Creation des lapins
		Rabbit lapin = factory.createRabbit(0, 0, "E");
		factory.initializeBoardRabbit(board, lapin);

		factory.createStep().execute(lapin, board);

		assertEquals(0, lapin.getX());
		assertEquals(0, lapin.getY());

	}

	/**
	 * La cas d'une instruction inconnue ne leve pas d'erreur et est ignorée
	 */
	@Test
	public void testCommandeInconnue() {
		Composite programme = (Composite) factory
				.createProgam("ZER123340988FF°FC°CX°°C0X°MLMKF:::qsdq%^d");
		assertEquals(0, programme.size());
	}

	/**
	 * Cas nominal prévu par le document de spécification
	 */
	@Test
	public void testUseCaseNominal() {

		LOG.info("Debut du UseCase Nominal");

		// Creation du terrain
		Board board = factory.createBoard(5, 5);

		// Creation du lapin 1 et de son programme
		Rabbit lapin = factory.createRabbit(1, 2, "N");
		factory.initializeBoardRabbit(board, lapin);
		Command programme1 = factory.createProgam("GAGAGAGAA");

		// Creation du lapin 2 et de son programme
		Rabbit lapin2 = factory.createRabbit(3, 3, "E");
		factory.initializeBoardRabbit(board, lapin2);
		Command programme2 = factory.createProgam("AADAADADDA");

		// Execution des commandes pour les lapins
		LOG.info("Premier lapin");
		programme1.execute(lapin, board);
		LOG.info("Deuxiem lapin");
		programme2.execute(lapin2, board);

		LOG.info("Fin du UseCase Nominal");
		// Verification etat lapin 1
		assertEquals(1, lapin.getX());
		assertEquals(3, lapin.getY());
		assertEquals(net.a.g.rabbit.etat.Orientation.N, lapin.getOrientation());

		// Verification etat lapin 2
		assertEquals(5, lapin2.getX());
		assertEquals(1, lapin2.getY());
		assertEquals(net.a.g.rabbit.etat.Orientation.E, lapin2.getOrientation());

		LOG.info("Verification termine du UseCase Nominal");

	}
}
