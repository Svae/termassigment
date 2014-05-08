package termassigment.taxicentral;

public class Taxis {

	private String alias, status, position, type;
	private int capacity;

	public String getAlias() {
		return alias;
	}

	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status){
		this.status = status;
	}
	public String getPosistion() {
		return position;
	}
	
	public void setPosistion(String pos){
		this.position = pos;
	}
	
	public Taxis(String alias, String status, String position){
		this.alias = alias;
		this.status = status;
		this.position = position;
		this.type = "";
		this.capacity = 0;
	}
	
	public String toString(){
		return "Alias: " + alias + " 	Status: " + status + " 	Position: " + position;
	}
	
}
