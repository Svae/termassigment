package termassigment.taxihandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiHandler extends Block {
	
	
	public ArrayList<Taxis> taxis = new ArrayList<Taxis>();
	
	public void addTaxis(String taxi){
		Taxis newTaxi = new Taxis(taxi,"AVAIABLE", "Tiller, Trondheim, Norway");	
		taxis.add(newTaxi);
	}
	
	public void updateTaxi(String update){
		String[] prop = update.split(";");
		for(Taxis taxi:taxis){
			if(taxi.getAlias().equalsIgnoreCase(prop[0])){
				taxi.setStatus(prop[1]);
				taxi.setPosistion(prop[2]);
			}
		}
	}
	
	public ArrayList<String>

}
