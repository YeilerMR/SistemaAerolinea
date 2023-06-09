package domain;

import java.util.ArrayList;

public class Model {
	
	private String name;
	private ArrayList<Brand> arrayBrands;
	private int seatsBClass;
	private int seatsTClass;
	private int seatsEconomics;
	
	public Model() {
		
	}
	
	public Model(String name, ArrayList<Brand> arrayBrands, int seatsBClass, int seatsTClass, int seatsEconomics) {
		//super();
		this.name = name;
		this.arrayBrands = arrayBrands;
		this.seatsBClass = seatsBClass;
		this.seatsTClass = seatsTClass;
		this.seatsEconomics = seatsEconomics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Brand> getArrayBrands() {
		return arrayBrands;
	}

	public void setArrayBrands(ArrayList<Brand> arrayBrands) {
		this.arrayBrands = arrayBrands;
	}

	public int getSeatsBClass() {
		return seatsBClass;
	}

	public void setSeatsBClass(int seatsBClass) {
		this.seatsBClass = seatsBClass;
	}

	public int getSeatsTClass() {
		return seatsTClass;
	}

	public void setSeatsTClass(int seatsTClass) {
		this.seatsTClass = seatsTClass;
	}

	public int getSeatsEconomics() {
		return seatsEconomics;
	}

	public void setSeatsEconomics(int seatsEconomics) {
		this.seatsEconomics = seatsEconomics;
	}
	
	//Falta el toString
	
}
