package domain;

public class Flight {

	private int nFlight;
	private String departureCity;
	private String date;
	private String hour;
	private String arrivalCity;
	private String airplane;
	private double priceSeat;
	
	public Flight() {
		
	}

	public Flight(int nFlight, String departureCity, String date, String hour, String arrivalCity, String airplane,
			double priceSeat) {
		//super();
		this.nFlight = nFlight;
		this.departureCity = departureCity;
		this.date = date;
		this.hour = hour;
		this.arrivalCity = arrivalCity;
		this.airplane = airplane;
		this.priceSeat = priceSeat;
	}

	public int getnFlight() {
		return nFlight;
	}

	public void setnFlight(int nFlight) {
		this.nFlight = nFlight;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

	public double getPriceSeat() {
		return priceSeat;
	}

	public void setPriceSeat(double priceSeat) {
		this.priceSeat = priceSeat;
	}

	//falta el toString
}
