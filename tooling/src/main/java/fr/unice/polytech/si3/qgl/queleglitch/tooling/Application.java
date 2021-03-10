package fr.unice.polytech.si3.qgl.queleglitch.tooling;

import fr.unice.polytech.si3.qgl.queleglitch.Cockpit;

public class Application {
	
	public static void main(String [] args) {
		Cockpit cockpit = new Cockpit();
		System.out.println("An instance of my team player: " + cockpit);
		cockpit.initGame("{\"goal\":{\"mode\":\"REGATTA\",\"checkpoints\":[{\"position\":{\"x\":-221.64276401564362,\"y\":-833.3333333333336,\"orientation\":0.0},\"shape\":{\"type\":\"circle\",\"radius\":100.0}},{\"position\":{\"x\":-200.0,\"y\":1000.0,\"orientation\":0.0},\"shape\":{\"type\":\"circle\",\"radius\":80.0}}]},\"ship\":{\"type\":\"ship\",\"position\":{\"x\":0.0,\"y\":0.0,\"orientation\":0.0},\"name\":\"queleglitch\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"life\":300,\"shape\":{\"type\":\"rectangle\",\"width\":2.0,\"height\":4.0,\"orientation\":0.0}},\"sailors\":[{\"x\":0,\"y\":0,\"id\":0,\"name\":\"Luffy Pouce\"},{\"x\":0,\"y\":1,\"id\":1,\"name\":\"Edward Teach\"},{\"x\":1,\"y\":0,\"id\":2,\"name\":\"Edward Teach\"},{\"x\":1,\"y\":1,\"id\":3,\"name\":\"Tom Teach\"}],\"shipCount\":1}");
		System.out.println("When called, it returns some JSON: " + cockpit.nextRound("{\"ship\":{\"type\":\"ship\",\"position\":{\"x\":0.0,\"y\":0.0,\"orientation\":0.0},\"name\":\"queleglitch\",\"deck\":{\"width\":2,\"length\":4},\"entities\":[{\"x\":1,\"y\":0,\"type\":\"oar\"},{\"x\":1,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":0,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"oar\"},{\"x\":3,\"y\":0,\"type\":\"oar\"},{\"x\":3,\"y\":1,\"type\":\"oar\"},{\"x\":2,\"y\":1,\"type\":\"sail\",\"openned\":false},{\"x\":5,\"y\":0,\"type\":\"rudder\"}],\"life\":300,\"shape\":{\"type\":\"rectangle\",\"width\":2.0,\"height\":4.0,\"orientation\":0.0}},\"visibleEntities\":[],\"wind\":{\"orientation\":0.0,\"strength\":0.0}}"));


		System.out.println(cockpit.getLogs());
	}
}