package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.Model;
import presentation.GUI_Model;

public class Controller_Model implements ActionListener{

	private Model model;
	private GUI_Model gui;
	
	
	public Controller_Model() {
		gui= new GUI_Model();
		
		initializer();
	}
	public void initializer() {
		gui.getBAdd().addActionListener(this);
		gui.getBModify().addActionListener(this);
		gui.getBConsult().addActionListener(this);
		gui.getBDelete().addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==gui.getBAdd()) {
			model= new Model();
		}
		if(e.getSource()==gui.getBModify()) {
			
		}
		if(e.getSource()==gui.getBConsult()) {
			
		}
		if(e.getSource()==gui.getBDelete()) {
			
		}
		
	}
}
