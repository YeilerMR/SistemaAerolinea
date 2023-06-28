package domain;

public class Ticket {

	private String nTicket;
	private String passport;
	private String nFlight;
	private String sType;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}

	

	public Ticket(String nTicket, String passport, String nFlight, String sType) {
		//super();
		this.nTicket = nTicket;
		this.passport = passport;
		this.nFlight = nFlight;
		this.sType= sType;
	}



	public String getnTicket() {
		return nTicket;
	}


	public void setnTicket(String nTicket) {
		this.nTicket = nTicket;
	}


	public String getPassport() {
		return passport;
	}


	public void setPassport(String passport) {
		this.passport = passport;
	}


	public String getnFlight() {
		return nFlight;
	}


	public void setnFlight(String nFlight) {
		this.nFlight = nFlight;
	}
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType= sType;
	}

	public String[] getDataName() {
		String[] dataName= {"nTicket","passport","nFlight","sType"};
		return dataName;
	}
	public String[] getData() {
		String[] data= {nTicket,passport,nFlight,sType};
		return data;
	}



	@Override
	public String toString() {
		return "Numero de Tiquete: " + nTicket + "\nPasaporte: " + passport + "\nVuelo: " + nFlight;
	}
	
	
	//falta toString
}
