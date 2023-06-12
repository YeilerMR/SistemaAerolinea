package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import presentation.Principal;


public class Controller implements ActionListener {

	//Declaración de instancias de clases y variables
	private Principal gui;
	
	public Controller() {
		
		//Inicializo Instancias
		gui = new Principal();
		initializerAction();
		
	}

	public void initializerAction() {
	    gui.getBLogIn().addActionListener(this);
	    gui.getBSignIn().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	    if (e.getSource() == gui.getBLogIn()) {
	        
	    	new ControllerLogIn();
	    	gui.dispose();
	    	
	    }
	    
	    if(e.getSource() == gui.getBSignIn()) {
	    	
	    	new ControllerSignIn();
	    	gui.dispose();
	    	
	    }
	}

}