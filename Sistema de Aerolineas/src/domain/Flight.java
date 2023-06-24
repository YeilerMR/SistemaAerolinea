package domain;

public class Flight {

	private String nFlight;
	private String cityE;
	private String hourE;
	private String dateE;
	
	private String airplane;
	private String cityA;
	private String hourA;
	private String dateA;
	//private String arrivalCity;
	private int pClassB;
	private int pClassT;
	private int pClassE;
	
	public Flight() {
		
	}

	public Flight(String nFlight, String cityE, String hourE, String dateE, String airplane, String cityA, String hourA,
			String dateA, int pClassB, int pClassT, int pClassE) {
		super();
		this.nFlight = nFlight;
		this.cityE = cityE;
		this.hourE = hourE;
		this.dateE = dateE;
		this.airplane = airplane;
		this.cityA = cityA;
		this.hourA = hourA;
		this.dateA = dateA;
		this.pClassB = pClassB;
		this.pClassT = pClassT;
		this.pClassE = pClassE;
	}

	public String getnFlight() {
		return nFlight;
	}

	public void setnFlight(String nFlight) {
		this.nFlight = nFlight;
	}

	public String getCityE() {
		return cityE;
	}

	public void setCityE(String cityE) {
		this.cityE = cityE;
	}

	public String getHourE() {
		return hourE;
	}

	public void setHourE(String hourE) {
		this.hourE = hourE;
	}

	public String getDateE() {
		return dateE;
	}

	public void setDateE(String dateE) {
		this.dateE = dateE;
	}

	public String getAirplane() {
		return airplane;
	}

	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}

	public String getCityA() {
		return cityA;
	}

	public void setCityA(String cityA) {
		this.cityA = cityA;
	}

	public String getHourA() {
		return hourA;
	}

	public void setHourA(String hourA) {
		this.hourA = hourA;
	}

	public String getDateA() {
		return dateA;
	}

	public void setDateA(String dateA) {
		this.dateA = dateA;
	}

	public int getpClassB() {
		return pClassB;
	}

	public void setpClassB(int pClassB) {
		this.pClassB = pClassB;
	}

	public int getpClassT() {
		return pClassT;
	}

	public void setpClassT(int pClassT) {
		this.pClassT = pClassT;
	}

	public int getpClassE() {
		return pClassE;
	}

	public void setpClassE(int pClassE) {
		this.pClassE = pClassE;
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String []getDataName(){
		String[] dataName= {"nFlight","cityE","hourE","dateE",
				"airplane","cityA","hourA","dateA","pClassB",
				"pClassT","pClassE"};
		return dataName;
	}
	public String []getData(){
		String[] data= {nFlight,cityE,hourE,dateE,airplane,cityA,
					hourA,dateA,""+pClassB,""+pClassT,""+pClassE};
		return data;
	}

	@Override
	public String toString() {
		return "Flight [nFlight=" + nFlight + ", cityE=" + cityE + ", hourE=" + hourE + ", dateE=" + dateE
				+ ", airplane=" + airplane + ", cityA=" + cityA + ", hourA=" + hourA + ", dateA=" + dateA + ", pClassB="
				+ pClassB + ", pClassT=" + pClassT + ", pClassE=" + pClassE + "]";
	}
	
	
	
	//falta el toString
}
