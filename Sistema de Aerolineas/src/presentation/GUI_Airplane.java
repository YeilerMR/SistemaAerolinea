package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import data.LogicXML;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI_Airplane extends JFrame{

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lRegistration;
	private JTextField txtRegistration;
	private JLabel lGestionM;
	private JButton bAdd;
	private JButton bModify;
	private JButton bDelete;
	private JButton bConsult;
	private JLabel lAirline;
	private JLabel lModels;
	private JLabel lYear;
	private JTextField txtYear;
	
	private LogicXML lXML;
	
	private DefaultTableModel dtmAirplane;
	private JTable tAirplane;
	private JScrollPane scpAirplane;
	
	private String [][]dataAirlines;
	
	private JComboBox comboAirline;
	private JComboBox comboModel;
	
	private JLabel lInfo;
	

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Airplane(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 948, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);
		
		if (lXML.checkTypeUser(user)) {
			contentPane.add(getBModify());
			contentPane.add(getBDelete());
		}

		setDTMAirplane(dataAirlines,getColumnsName());
		setTAirplane(dtmAirplane);
		setSCPAirplane(tAirplane);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLRegistration());
		contentPane.add(getTxtRegistration());
		contentPane.add(getLGestionM());
		contentPane.add(getBAdd());
		
		contentPane.add(getBConsult());
		contentPane.add(getLAirline());
		contentPane.add(getLModels());
		contentPane.add(getLYear());
		contentPane.add(getTxtYear());
		
		contentPane.add(getComboAirline());
		contentPane.add(getComboModel());
		
		contentPane.add(getLInfo());
		contentPane.add(getSCPAirplane());
		
		
		setVisible(true);
	}

	public JLabel getLRegistration() {
		if (lRegistration == null) {
			lRegistration = new JLabel("Matricula:");
			lRegistration.setForeground(new Color(255, 255, 255));
			lRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
			lRegistration.setBounds(54, 78, 119, 45);
		}
		return lRegistration;
	}
	public JTextField getTxtRegistration() {
		if (txtRegistration == null) {
			txtRegistration = new JTextField();
			txtRegistration.setBackground(new Color(41, 90, 45));
			txtRegistration.setForeground(new Color(255, 255, 255));
			txtRegistration.setBounds(295, 78, 119, 38);
			txtRegistration.setColumns(10);
		}
		return txtRegistration;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Aviones");
			lGestionM.setForeground(new Color(255, 255, 255));
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionM.setBounds(141, 23, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			//bAdd.addActionListener(this);
			bAdd.setForeground(Color.WHITE);
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setFocusPainted(false);
			bAdd.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAdd.setBackground(BUTTON_GREEN);

			bAdd.setBounds(54, 349, 119, 30);
		}
		return bAdd;
	}

	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");

			bModify.setForeground(Color.WHITE);
			bModify.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModify.setFocusPainted(false);
			bModify.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bModify.setBackground(BUTTON_GREEN);
			
			bModify.setBounds(187, 349, 119, 30);
		}
		return bModify;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");

			bDelete.setForeground(Color.WHITE);
			bDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			bDelete.setFocusPainted(false);
			bDelete.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bDelete.setBackground(BUTTON_GREEN);
			
			bDelete.setBounds(187, 408, 119, 30);
		}
		return bDelete;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");

			bConsult.setForeground(Color.WHITE);
			bConsult.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsult.setFocusPainted(false);
			bConsult.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bConsult.setBackground(BUTTON_GREEN);
			
			bConsult.setBounds(316, 349, 119, 30);
		}
		return bConsult;
	}
	protected void do_bAgregar_actionPerformed(ActionEvent e) {
	}
	public JLabel getLAirline() {
		if (lAirline == null) {
			lAirline = new JLabel("Aerolinea(s):");
			lAirline.setForeground(new Color(255, 255, 255));
			lAirline.setFont(new Font("Tahoma", Font.BOLD, 15));
			lAirline.setBounds(54, 133, 119, 45);
		}
		return lAirline;
	}
	public JLabel getLModels() {
		if (lModels == null) {
			lModels = new JLabel("Modelo(s): ");
			lModels.setForeground(new Color(255, 255, 255));
			lModels.setFont(new Font("Tahoma", Font.BOLD, 15));
			lModels.setBounds(54, 188, 193, 45);
		}
		return lModels;
	}
	public JLabel getLYear() {
		if (lYear == null) {
			lYear = new JLabel("Año:");
			lYear.setForeground(new Color(255, 255, 255));
			lYear.setFont(new Font("Tahoma", Font.BOLD, 15));
			lYear.setBounds(54, 243, 193, 45);
		}
		return lYear;
	}
	public JTextField getTxtYear() {
		if (txtYear == null) {
			txtYear = new JTextField();
			txtYear.setBackground(new Color(41, 90, 45));
			txtYear.setForeground(new Color(255, 255, 255));
			txtYear.setColumns(10);
			txtYear.setBounds(295, 250, 119, 38);
		}
		return txtYear;
	}
	public JComboBox getComboAirline() {
		if (comboAirline == null) {
			comboAirline = new JComboBox();
			comboAirline.setBackground(new Color(41, 90, 45));
			comboAirline.setForeground(new Color(255, 255, 255));
			comboAirline.setBounds(295, 142, 119, 30);
		}
		return comboAirline;
	}
	public JComboBox getComboModel() {
		if (comboModel == null) {
			comboModel = new JComboBox();
			comboModel.setBackground(new Color(41, 90, 45));
			comboModel.setForeground(new Color(255, 255, 255));
			comboModel.setBounds(295, 197, 119, 30);
		}
		return comboModel;
	}
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Información");
			lInfo.setForeground(new Color(255, 255, 255));
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lInfo.setBounds(638, 78, 187, 45);
		}
		return lInfo;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		txtRegistration.setText("");
		comboAirline.setSelectedIndex(0);
		comboModel.setSelectedIndex(0);
		txtYear.setText("");
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMAirplane(String [][]dataAirplanes, String[]columnName) {
		dtmAirplane= new DefaultTableModel(dataAirplanes, columnName);
	}
	public DefaultTableModel getDTMAirplane() {
		return this.dtmAirplane;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPAirplane(JTable tAirplane) {
		scpAirplane = new JScrollPane(tAirplane);
		scpAirplane.setBounds(511, 133, 374, 202);
		scpAirplane.setViewportView(getTAirplane());
	}
	public JScrollPane getSCPAirplane() {
		return this.scpAirplane;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTAirplane(DefaultTableModel dtmAirplane) {
		tAirplane= new JTable(dtmAirplane);
		tAirplane.setEnabled(false);
		tAirplane.getTableHeader().setReorderingAllowed(false);
		tAirplane.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTAirplane() {
		return this.tAirplane;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[]getColumnsName(){
		String columnsName[]= {"Matricula","Aerolinea","Modelo","Año"}; 
		return columnsName;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillComboAirlines(ArrayList<String> airlines) {
		comboAirline.addItem("Vacio");
		for (String airline : airlines) {
			comboAirline.addItem(airline);
		}
	}
	public void fillComboModels(ArrayList<String> models) {
		comboModel.addItem("Vacio");
		for (String model : models) {
			comboModel.addItem(model);
		}
	}
}
