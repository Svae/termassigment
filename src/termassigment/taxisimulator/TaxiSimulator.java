package termassigment.taxisimulator;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;

public class TaxiSimulator extends Block {
	
	public java.lang.String destination;

	public void printError(String error) {
		System.out.println(error);
	}

	public void printLocalError() {
		System.out.println("Local error in rout planner!");
	}

	public Journey setDestination(Journey journey) {
		destination = journey.toAddress;
		return journey;
	}

}
