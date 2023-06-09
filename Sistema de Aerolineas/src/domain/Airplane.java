package domain;

import java.util.ArrayList;

public class Airplane {

	private String registration;
	private ArrayList<Airline> arrayAirlines;
	private ArrayList<Model> arrayModels;
	private String year;
	
	public Airplane() {
		
	}

	public Airplane(String registration, ArrayList<Airline> arrayAirlines, ArrayList<Model> arrayModels, String year) {
		//super();
		this.registration = registration;
		this.arrayAirlines = arrayAirlines;
		this.arrayModels = arrayModels;
		this.year = year;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public ArrayList<Airline> getArrayAirlines() {
		return arrayAirlines;
	}

	public void setArrayAirlines(ArrayList<Airline> arrayAirlines) {
		this.arrayAirlines = arrayAirlines;
	}

	public ArrayList<Model> getArrayModels() {
		return arrayModels;
	}

	public void setArrayModels(ArrayList<Model> arrayModels) {
		this.arrayModels = arrayModels;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	//Falta el toString
	
}
