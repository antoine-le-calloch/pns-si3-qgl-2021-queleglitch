package fr.unice.polytech.si3.qgl.queleglitch;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.unice.polytech.si3.qgl.regatta.cockpit.ICockpit;

public class Cockpit implements ICockpit {

	GameData gameData;
	ObjectMapper objectMapper = new ObjectMapper();


	public void initGame(String game) {
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		System.out.println("Init game input: " + game);
		try {
			gameData = objectMapper.readValue(game, GameData.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

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

	@Override
	public List<String> getLogs() {
		ArrayList<String> logs = new ArrayList<>();
		logs.add("NEW TURN");
		logs.add(gameData.getShip().getStringPosition());
		logs.add(" ---- ");
		logs.add(gameData.getSailor(0).getInformations());
		logs.add(" ---- ");
		logs.add(gameData.getSailor(1).getInformations());
		return logs;
	}
}
