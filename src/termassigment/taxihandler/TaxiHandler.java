package termassigment.taxihandler;

import java.util.ArrayList;

import termassigment.taxicentral.Taxis;
import no.ntnu.item.arctis.runtime.Block;

public class TaxiHandler extends Block {
	
	
	public ArrayList<Taxis> taxiList = new ArrayList<Taxis>();
	public ArrayList<Taxis> available = new ArrayList<Taxis>();
	
	

	public void updateTaxi(String update){
		boolean newTaxi = true;
		String[] prop = update.split(";");
		for(Taxis taxi:taxiList){
			if(taxi.getAlias().equalsIgnoreCase(prop[0])){
				taxi.setStatus(prop[1]);
				taxi.setPosistion(prop[2]);
				newTaxi = false;
			}
		}
		if(newTaxi){taxiList.add(new Taxis(prop[0],prop[1],prop[2]));}
	}
	
	public ArrayList<Taxis> availableTaxis(){
		available = new ArrayList<Taxis>();
		for(Taxis taxi:taxiList){
			if(taxi.getStatus().equalsIgnoreCase("AVAILABLE")){
				available.add(taxi);
			}
		}
		return available;
	}
	
	public String orderUpdate(String orderStr){
		String[] prop = orderStr.split(";");
		if(prop[2].equalsIgnoreCase("CONFIRM") || prop[2].equalsIgnoreCase("DECLINE")){
			for(Taxis taxi:taxiList){
				if(taxi.getAlias().equalsIgnoreCase(prop[1])){
					taxi.setStatus("UNAVAILABLE");
				}
			}
		}
		return orderStr;
	}


}
