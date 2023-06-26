package domain;

public class Buy {

	private String nBuyTicket;
	public Buy() {}
	public Buy(String nBuyTicket) {
		super();
		this.nBuyTicket = nBuyTicket;
	}
	public String getnBuyTicket() {
		return nBuyTicket;
	}
	public void setnBuyTicket(String nBuyTicket) {
		this.nBuyTicket = nBuyTicket;
	}
	
	public String[] getDataName() {
		String []dataName= {"nTicket"};
		return dataName;
	}
	public String[] getData() {
		String []data= {nBuyTicket};
		return data;
	}
	@Override
	public String toString() {
		return "Buy [nBuyTicket=" + nBuyTicket + "]";
	}
	
	

}
