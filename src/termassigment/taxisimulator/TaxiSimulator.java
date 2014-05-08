package termassigment.taxisimulator;

import no.ntnu.item.arctis.runtime.Block;
import no.ntnu.item.ttm4115.simulation.routeplanner.Journey;

public class TaxiSimulator extends Block {
	
	public java.lang.String destination, alias;
	public no.ntnu.item.ttm4115.simulation.routeplanner.Journey journey;

	public void printError(String error) {
		System.out.println(error);
	}

	public void printLocalError() {
		System.out.println("Local error in route planner!");
	}


	


}
