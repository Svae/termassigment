package termassigment.taxidispatcher.component;

public class Order {

	private String user, taxiID, destination, message, status;
	private int orderID, userPos;
	
	public String getUser() {
		return user;
	}


	public String getTaxiID() {
		return taxiID;
	}


	public String getMessage() {
		return message;
	}


	public int getOrderID() {
		return orderID;
	}
	
	public String getStatus(){
		return status;
	}

	public Order(String user, String adress, String status){
		this.user = user;
		this.destination = destination;
		this.status = status;
		this.orderID = 0;
		this.message = "";
	}
	
	
	public String toString(){
		return "OrderID" + orderID + "	User: " + user + "	Status: " + status+"	Destination: " + destination + "	Message: " + message;
	}
	

	public void setOrderID(int orderID) {
		this.orderID = orderID;	
	}


	public void setStaus(String status) {
		this.status = status;
		
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDestination() {
		return destination;
	}


	public void setTaxi(String taxi) {
		this.taxiID = taxi;
		
	}


	public void setDestiantion(String adress) {
		this.destination = adress;
	}
	
}
