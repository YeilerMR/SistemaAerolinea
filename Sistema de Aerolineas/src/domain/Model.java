package domain;

import java.util.ArrayList;

public class Model {
	
	private String name;
	private String brand;
	private int seatsBClass;
	private int seatsTClass;
	private int seatsEconomics;
	
	public Model() {
		
	}
	
	public Model(String name, String brand, int seatsBClass, int seatsTClass, int seatsEconomics) {
		//super();
		this.name = name;
		this.brand = brand;
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

	public String getArrayBrands() {
		return brand;
	}

	public void setArrayBrands(String brand) {
		this.brand = brand;
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
	public String[] getDataName() {
		String[] dataName= {"name","brand","bClass","tClass","eClass"};
		return dataName;
	}
	public String[] getData() {
		//Debo agregar el array de brand
		String[] data= {name,String.valueOf(seatsBClass),String.valueOf(seatsTClass),String.valueOf(seatsEconomics)};
		return data;
	}
	//Falta el toString

	@Override
	public String toString() {
		return "Model [name=" + name + ", arrayBrands=" + brand + ", seatsBClass=" + seatsBClass
				+ ", seatsTClass=" + seatsTClass + ", seatsEconomics=" + seatsEconomics + "]";
	}
}//Fin de Model
