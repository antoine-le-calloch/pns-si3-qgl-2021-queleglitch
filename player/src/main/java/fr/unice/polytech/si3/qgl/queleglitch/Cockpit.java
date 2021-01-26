package fr.unice.polytech.si3.qgl.queleglitch;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.regatta.cockpit.ICockpit;

/**
 * Classe utilisé pour faire la liasion entre le moteur du jeu et l'intelligence artificielle du programme
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Cockpit implements ICockpit {

	GameData gameData;
	ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * <p>Start a new game by decoding the Json in parameter</p>
	 * @param game
	 *          <b>A Json string which contains the informations of a game .</b>
	 */
	public void initGame(String game) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println("Init game input: " + game);
		try {
			gameData = objectMapper.readValue(game, GameData.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * <p>Use Json strings to play a round</p>
	 * @param round
	 *          <b>A Json string which contains the informations a new round.</b>
	 * @return <b>A Json string which contains the actions of all the sailors in a round.</b>
	 */
	public String nextRound(String round) {
		System.out.println("Next round input: " + round);
		ActionToProcess actionSailor1 = new ActionToProcess(gameData.getSailor(0), "OAR");
		ActionToProcess actionSailor2 = new ActionToProcess(gameData.getSailor(1), "OAR");

		try {
			return "[" + objectMapper.writeValueAsString(actionSailor1) + "," + objectMapper.writeValueAsString(actionSailor2) + "]";
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * <p>Add the information of a turn each round in the list.</p>
	 * @return <b>the list of information of a round</b>
	 */
	@Override
	public List<String> getLogs() {
		ArrayList<String> logs = new ArrayList<>();
		logs.add("NEW TURN");
		logs.add(gameData.getShip().toString());
		logs.add(" ---- ");
		logs.add(gameData.getSailor(0).toString());
		logs.add(" ---- ");
		logs.add(gameData.getSailor(1).toString());
		return logs;
	}
}
