package domain;

public class Brand {

	private String name;
	
	public Brand() {
	}
	public Brand(String nombre) {
		this.name= nombre;
	}
	
	public void setNombre(String nombre) {
		this.name= nombre;
	}
	public String getNombre() {
		return this.name;
	}
	
	public String []getDataName(){
		String []dataName= {"name"};
		return dataName;
	}
	public String []getData(){
		String []data= {name};
		return data;
	}
	
	//Falta el toString
	
}//Marca
