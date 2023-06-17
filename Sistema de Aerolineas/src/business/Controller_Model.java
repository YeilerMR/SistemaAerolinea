package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.LogicXML;
import domain.Model;
import domain.User;
import presentation.GUI_Model;

public class Controller_Model implements ActionListener{

	private Model model;
	private GUI_Model gui;
	private LogicXML lXml;
	
	
	public Controller_Model(User user) {
		lXml= new LogicXML();
		gui= new GUI_Model(user);
		
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
			//Agregar un modelo
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
