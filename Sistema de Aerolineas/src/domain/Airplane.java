package domain;

import java.util.ArrayList;

import javax.lang.model.element.NestingKind;

public class Airplane {

	private String registration;
	private String arrayAirlines;
	private String arrayModels;
	private String year;
	
	public Airplane() {
		
	}

	public Airplane(String registration, String arrayAirlines, String arrayModels, String year) {
		super();
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

	public String getArrayAirlines() {
		return arrayAirlines;
	}

	public void setArrayAirlines(String arrayAirlines) {
		this.arrayAirlines = arrayAirlines;
	}

	public String getArrayModels() {
		return arrayModels;
	}

	public void setArrayModels(String arrayModels) {
		this.arrayModels = arrayModels;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	public String []getDataName(){
		String[] dataName= {"registration","airlines","models","year"};
		return dataName;
	}
	public String []getData(){
		String []data= {registration,arrayAirlines,arrayModels,year};
		return data;
	}

	@Override
	public String toString() {
		return "\nPlaca del Avion: " + registration + "\nAerolinea: " + arrayAirlines + "\nModelo: "
				+ arrayModels + "\nAnnio: " + year ;
	}
	
	//Falta el toString
	
}
