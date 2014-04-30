package termassigment.taxisimulator;

import no.ntnu.item.arctis.runtime.Block;

public class TaxiSimulator extends Block {

	public void printError(String error) {
		System.out.println(error);
	}

	public void printLocalError() {
		System.out.println("Local error in rout planner!");
	}

}
