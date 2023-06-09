package data;

import domain.Brand;

/**
 * 
 * @author yeile
 * EN PROCESO
 */

public class LogicCRUD {

	public LogicCRUD() {
	
	}
	//Create
	public void create(String FileName, String elementType, String[] dataName, String[] data) {
		if (verifyTXT(data[0])) {
			//si entra es que se puede agregar
			//ahora hay que verificar si tiene el mismo nombre de algun otro elemento en el xml
			
		}
	}
	//Read
	//Update
	//Delete
	
	
	
	
	//verifyTXT
	public boolean verifyTXT(String dataTXT) {
		
		boolean valid= false;
		if (!dataTXT.equals("")) {
			valid= true;
		}
		return valid;
	}
}
