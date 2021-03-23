package fr.unice.polytech.si3.qgl.queleglitch.tooling;

import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;

public class Application {
	
	public static void main(String [] args) {
		Cockpit cockpit = new Cockpit();
		System.out.println("An instance of my team player: " + cockpit);

		cockpit.initGame("{\"goal\": {\"mode\": \"REGATTA\",\"checkpoints\": [{\"position\": {\"x\": -200,\"y\": 0,\"orientation\": 0},\"shape\": {\"type\": \"circle\",\"radius\": 100}},{\"position\": {\"x\": 1000,\"y\": 0,\"orientation\": 0},\"shape\": {\"type\": \"circle\",\"radius\": 100}}]},\"ship\": {\"type\": \"ship\",\"life\": 100,\"position\": {\"x\": 0,\"y\": 0,\"orientation\": 0},\"name\": \"Les copaings d'abord!\",\"deck\": {\"width\": 3,\"length\": 6},\"entities\": [{\"x\": 1,\"y\": 0,\"type\": \"oar\"},{\"x\": 1,\"y\": 2,\"type\": \"oar\"},{\"x\": 3,\"y\": 0,\"type\": \"oar\"},{\"x\": 3,\"y\": 2,\"type\": \"oar\"},{\"x\": 4,\"y\": 0,\"type\": \"oar\"},{\"x\": 4,\"y\": 2,\"type\": \"oar\"},{\"x\": 2,\"y\": 1,\"type\": \"sail\",\"openned\": false},{\"x\": 5,\"y\": 0,\"type\": \"rudder\"}],\"shape\": {\"type\": \"rectangle\",\"width\": 3,\"height\": 6,\"orientation\": 0}},\"sailors\": [{\"x\": 0,\"y\": 0,\"id\": 0,\"name\": \"Edward Teach\"},{\"x\": 0,\"y\": 1,\"id\": 1,\"name\": \"Edward Pouce\"},{\"x\": 0,\"y\": 2,\"id\": 2,\"name\": \"Tom Pouce\"},{\"x\": 1,\"y\": 0,\"id\": 3,\"name\": \"Jack Teach\"},{\"x\": 1,\"y\": 1,\"id\": 4,\"name\": \"Jack Teach\"},{\"x\": 1,\"y\": 2,\"id\": 5,\"name\": \"Jack Teach\"}]}");
		System.out.println("When called, it returns some JSON: " + cockpit.nextRound("{\"ship\":{\"type\":\"ship\",\"position\":{\"x\":0.0,\"y\":0.0,\"orientation\":0.0},\"name\":\"queleglitch\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"life\":300,\"shape\":{\"type\":\"rectangle\",\"width\":2.0,\"height\":4.0,\"orientation\":0.0}},\"visibleEntities\":[{\"type\":\"stream\",\"position\":{\"x\": 500,\"y\":0,\"orientation\": 0 },\"shape\":{\"type\":\"rectangle\",\"width\": 50,\"height\":500,\"orientation\":0},\"strength\":40}],\"wind\":{\"orientation\":0.0,\"strength\":0.0}}"));

		System.out.println(cockpit.getLogs());
	}
}