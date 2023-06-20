package domain;

public class Airline {
	
	private String name;
	private String operationCenter;

	public Airline() {
		
	}

	public Airline(String name, String operationCenter) {
		super();
		this.name = name;
		this.operationCenter = operationCenter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperationCenter() {
		return operationCenter;
	}

	public void setOperationCenter(String operationCenter) {
		this.operationCenter = operationCenter;
	}
	public String[] getDataName() {
		String[] dataName= {"name","operationC"};
		return dataName;
	}
	public String[] getData() {
		String[] data= {name,operationCenter};
		return data;
	}

	@Override
	public String toString() {
		return "Airline [name=" + name + ", operationCenter=" + operationCenter + "]";
	}
	
	
	
	//Falta el toString
}
