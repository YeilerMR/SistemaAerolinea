package domain;

public class Passenger {

	private String nPassport;
	private String name;
	private String lastName;
	private String dateBirth;
	private String email;
	private String phone;
	
	public Passenger() {
		
	}

	public Passenger(String nPassport, String name, String lastName, String dateBirth, String email, String phone) {
		//super();
		this.nPassport = nPassport;
		this.name = name;
		this.lastName = lastName;
		this.dateBirth = dateBirth;
		this.email = email;
		this.phone = phone;
	}

	public String getnPassport() {
		return nPassport;
	}

	public void setnPassport(String nPassport) {
		this.nPassport = nPassport;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	//falta toString
	
}
