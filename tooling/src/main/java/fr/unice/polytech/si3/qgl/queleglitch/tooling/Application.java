package fr.unice.polytech.si3.qgl.queleglitch.tooling;

import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;

public class Application {
	
	public static void main(String [] args) {
		Cockpit cockpit = new Cockpit();
		System.out.println("An instance of my team player: " + cockpit);
		cockpit.initGame("{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":1000,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}},{\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"shape\":{\"type\":\"circle\",\"radius\":50}}]},\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":2,\"type\":\"oar\"},{\"x\":0,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":2,\"type\":\"oar\"},{\"x\":4,\"y\":0,\"type\":\"oar\"},{\"x\":4,\"y\":2,\"type\":\"oar\"}],\"shape\":{\"type\":\"rectangle\",\"width\":2,\"height\":4,\"orientation\":0}},\"sailors\":[{\"x\":0,\"y\":1,\"id\":2,\"name\":\"EdwardPouce\"},{\"x\":0,\"y\":1,\"id\":3,\"name\":\"TomPouce\"},{\"x\":1,\"y\":0,\"id\":4,\"name\":\"JackPouce\"},{\"x\":1,\"y\":0,\"id\":5,\"name\":\"FredPouce\"}]}");
		System.out.println("When called, it returns some JSON: " + cockpit.nextRound("{\"ship\":{\"type\":\"ship\",\"life\":100,\"position\":{\"x\":0,\"y\":0,\"orientation\":0},\"name\":\"Lescopaingsd'abord!\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":2,\"type\":\"oar\"},{\"x\":0,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":2,\"type\":\"oar\"},{\"x\":4,\"y\":0,\"type\":\"oar\"},{\"x\":4,\"y\":2,\"type\":\"oar\"}],\"shape\":{\"type\":\"rectangle\",\"width\":2,\"height\":4,\"orientation\":0}}}"));

		System.out.println(cockpit.getLogs());
	}
}