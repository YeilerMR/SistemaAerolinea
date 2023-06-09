package domain;

public class Tiquet {

	private String nTiquet;
	private String passport;
	private String nFlight;
	
	
	public Tiquet() {
		// TODO Auto-generated constructor stub
	}

	

	public Tiquet(String nTiquet, String passport, String nFlight) {
		//super();
		this.nTiquet = nTiquet;
		this.passport = passport;
		this.nFlight = nFlight;
	}



	public String getnTiquet() {
		return nTiquet;
	}


	public void setnTiquet(String nTiquet) {
		this.nTiquet = nTiquet;
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

	//falta toString
}
