package domain;

public class Buy {

	private String nBuyTicket;
	private String hourBuy;
	private String dateBuy;
	
	public Buy() {}
	public Buy(String nBuyTicket, String hourBuy, String dateBuy) {
		super();
		this.nBuyTicket = nBuyTicket;
		this.hourBuy= hourBuy;
		this.dateBuy= dateBuy;
	}
	public String getnBuyTicket() {
		return nBuyTicket;
	}
	public void setnBuyTicket(String nBuyTicket) {
		this.nBuyTicket = nBuyTicket;
	}
	public String getHourBuy() {
		return hourBuy;
	}
	public void setHourBuy(String hourBuy) {
		this.hourBuy= hourBuy;
	}
	public String getDateBuy() {
		return dateBuy;
	}
	public void setDateBuy(String dateBuy) {
		this.dateBuy= dateBuy;
	}
	
	public String[] getDataName() {
		String []dataName= {"nTicket","hourB","dateB"};
		return dataName;
	}
	public String[] getData() {
		String []data= {nBuyTicket,hourBuy,dateBuy};
		return data;
	}
	@Override
	public String toString() {
		return "Buy [nBuyTicket=" + nBuyTicket + "]";
	}
	
	

}
