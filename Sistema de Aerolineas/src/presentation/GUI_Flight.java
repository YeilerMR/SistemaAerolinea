package presentation;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import data.LogicXML;
import domain.User;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class GUI_Flight extends JFrame {

	private JPanel contentPane;
	private JLabel lTitle;
	private JLabel lNFlight;
	private JLabel lCityE;
	private JLabel lHourE;
	private JLabel lDateE;
	
	private JDateChooser dcDateE;
	private JDateChooser dcDateA;
	
	private JLabel lAirplane;
	private JLabel lCityA;
	private JLabel lHourA;
	private JLabel lDateA;
	
	private JButton bAdd;
	private JButton bModify;
	private JButton bConsult;
	private JButton bDelete;
	private JButton bNumber;
	
	private JLabel lTitlePrice;
	
	private JTextField txtNFlight;
	private JTextField txtCityE;
	private JTextField txtHourE;
	private JTextField txtCityA;
	private JTextField txtHourA;
	
	private JComboBox comboAirplane;
	
	private JLabel lClassB;
	private JLabel lClassT;
	private JLabel lClassE;
	
	private JTextField txtClassB;
	private JTextField txtClassT;
	private JTextField txtClassE;
	
	private LogicXML lXML;
	
	private DefaultTableModel dtmFligh;
	private JTable tFligh;
	private JScrollPane scpFlight;
	
	private String[][] dataFlight;
	private JLabel lInfo;
	
	
	
	public GUI_Flight(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1061, 729);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		if (lXML.checkTypeUser(user)) {
			contentPane.add(getBModify());
			contentPane.add(getBDelete());
		}
		//setTXTNFlight(randNum);
		
		setDTMFlight(dataFlight,getColumnsName());
		setTFlight(dtmFligh);
		setSCPFlight(tFligh);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLTitle());
		contentPane.add(getLNFlight());
		contentPane.add(getLCityE());
		contentPane.add(getLHourE());
		contentPane.add(getLDateE());
		contentPane.add(getDcDateE());
		contentPane.add(getLAirplane());
		contentPane.add(getLCityA());
		contentPane.add(getLHourA());
		contentPane.add(getLDateA());
		contentPane.add(getDcDateA());
		
		contentPane.add(getBAdd());
		contentPane.add(getBConsult());
		
		contentPane.add(getLTitlePrice());
		contentPane.add(getTxtNFlight());
		contentPane.add(getTxtCityE());
		contentPane.add(getTxtHourE());
		contentPane.add(getTxtCityA());
		contentPane.add(getTxtHourA());
		contentPane.add(getComboAirplane());
		
		contentPane.add(getLClassB());
		contentPane.add(getLClassT());
		contentPane.add(getLClassE());
		contentPane.add(getTxtClassB());
		contentPane.add(getTxtClassT());
		contentPane.add(getTxtClassE());
		contentPane.add(getSCPFlight());
		contentPane.add(getLInfo());
		contentPane.add(getBNumber());
		
		setVisible(true);
	}
	public JLabel getLTitle() {
		if (lTitle == null) {
			lTitle = new JLabel("Gestion de Vuelos\r\n");
			lTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
			lTitle.setBounds(175, 10, 138, 53);
		}
		return lTitle;
	}
	public JLabel getLNFlight() {
		if (lNFlight == null) {
			lNFlight = new JLabel("Numero de Vuelo:");
			lNFlight.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNFlight.setBounds(10, 73, 150, 53);
		}
		return lNFlight;
	}
	public JLabel getLCityE() {
		if (lCityE == null) {
			lCityE = new JLabel("Ciudad de Salida:");
			lCityE.setFont(new Font("Tahoma", Font.BOLD, 15));
			lCityE.setBounds(10, 148, 150, 53);
		}
		return lCityE;
	}
	public JLabel getLHourE() {
		if (lHourE == null) {
			lHourE = new JLabel("Hora de Salida:");
			lHourE.setFont(new Font("Tahoma", Font.BOLD, 15));
			lHourE.setBounds(10, 226, 150, 53);
		}
		return lHourE;
	}
	public JLabel getLDateE() {
		if (lDateE == null) {
			lDateE = new JLabel("Fecha de Salida:");
			lDateE.setFont(new Font("Tahoma", Font.BOLD, 15));
			lDateE.setBounds(10, 306, 150, 53);
		}
		return lDateE;
	}
	public JDateChooser getDcDateE() {
		if (dcDateE == null) {
			dcDateE = new JDateChooser();
			dcDateE.setBounds(175, 318, 118, 32);
		}
		return dcDateE;
	}
	public JLabel getLAirplane() {
		if (lAirplane == null) {
			lAirplane = new JLabel("Avion: ");
			lAirplane.setFont(new Font("Tahoma", Font.BOLD, 15));
			lAirplane.setBounds(398, 83, 54, 32);
		}
		return lAirplane;
	}
	public JLabel getLCityA() {
		if (lCityA == null) {
			lCityA = new JLabel("Ciudad de Arribo:");
			lCityA.setFont(new Font("Tahoma", Font.BOLD, 15));
			lCityA.setBounds(328, 148, 150, 53);
		}
		return lCityA;
	}
	public JLabel getLHourA() {
		if (lHourA == null) {
			lHourA = new JLabel("Hora de Arribo:");
			lHourA.setFont(new Font("Tahoma", Font.BOLD, 15));
			lHourA.setBounds(328, 226, 150, 53);
		}
		return lHourA;
	}
	public JLabel getLDateA() {
		if (lDateA == null) {
			lDateA = new JLabel("Fecha de Arribo:");
			lDateA.setFont(new Font("Tahoma", Font.BOLD, 15));
			lDateA.setBounds(328, 306, 150, 53);
		}
		return lDateA;
	}
	public JDateChooser getDcDateA() {
		if (dcDateA == null) {
			dcDateA = new JDateChooser();
			dcDateA.setBounds(476, 318, 118, 32);
		}
		return dcDateA;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setBounds(308, 395, 110, 32);
		}
		return bAdd;
	}
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");
			bModify.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModify.setBounds(463, 395, 110, 32);
		}
		return bModify;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsult.setBounds(614, 395, 110, 32);
		}
		return bConsult;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			bDelete.setBounds(463, 449, 110, 32);
		}
		return bDelete;
	}
	public JLabel getLTitlePrice() {
		if (lTitlePrice == null) {
			lTitlePrice = new JLabel("Montos de Acientos");
			lTitlePrice.setFont(new Font("Tahoma", Font.BOLD, 15));
			lTitlePrice.setBounds(744, 99, 161, 53);
		}
		return lTitlePrice;
	}
	public JTextField getTxtNFlight() {
		if (txtNFlight == null) {
			txtNFlight = new JTextField();
			txtNFlight.setEditable(false);
			txtNFlight.setBounds(175, 86, 102, 32);
			txtNFlight.setColumns(10);
		}
		return txtNFlight;
	}
	public JTextField getTxtCityE() {
		if (txtCityE == null) {
			txtCityE = new JTextField();
			txtCityE.setColumns(10);
			txtCityE.setBounds(175, 161, 102, 32);
		}
		return txtCityE;
	}
	public JTextField getTxtHourE() {
		if (txtHourE == null) {
			txtHourE = new JTextField();
			txtHourE.setColumns(10);
			txtHourE.setBounds(175, 239, 102, 32);
		}
		return txtHourE;
	}
	public JTextField getTxtCityA() {
		if (txtCityA == null) {
			txtCityA = new JTextField();
			txtCityA.setColumns(10);
			txtCityA.setBounds(476, 161, 102, 32);
		}
		return txtCityA;
	}
	public JTextField getTxtHourA() {
		if (txtHourA == null) {
			txtHourA = new JTextField();
			txtHourA.setColumns(10);
			txtHourA.setBounds(476, 239, 102, 32);
		}
		return txtHourA;
	}
	public JComboBox getComboAirplane() {
		if (comboAirplane == null) {
			comboAirplane = new JComboBox();
			comboAirplane.setBounds(476, 88, 118, 27);
		}
		return comboAirplane;
	}
	public JLabel getLClassB() {
		if (lClassB == null) {
			lClassB = new JLabel("Clase Ejecutivo:");
			lClassB.setFont(new Font("Tahoma", Font.BOLD, 15));
			lClassB.setBounds(648, 179, 130, 39);
		}
		return lClassB;
	}
	public JLabel getLClassT() {
		if (lClassT == null) {
			lClassT = new JLabel("Clase Turista:");
			lClassT.setFont(new Font("Tahoma", Font.BOLD, 15));
			lClassT.setBounds(648, 245, 130, 39);
		}
		return lClassT;
	}
	public JLabel getLClassE() {
		if (lClassE == null) {
			lClassE = new JLabel("Clase Economica:");
			lClassE.setFont(new Font("Tahoma", Font.BOLD, 15));
			lClassE.setBounds(648, 313, 138, 39);
		}
		return lClassE;
	}
	public JTextField getTxtClassB() {
		if (txtClassB == null) {
			txtClassB = new JTextField();
			txtClassB.setColumns(10);
			txtClassB.setBounds(823, 185, 102, 32);
		}
		return txtClassB;
	}
	public JTextField getTxtClassT() {
		if (txtClassT == null) {
			txtClassT = new JTextField();
			txtClassT.setColumns(10);
			txtClassT.setBounds(823, 247, 102, 32);
		}
		return txtClassT;
	}
	public JTextField getTxtClassE() {
		if (txtClassE == null) {
			txtClassE = new JTextField();
			txtClassE.setColumns(10);
			txtClassE.setBounds(823, 319, 102, 32);
		}
		return txtClassE;
	}
	
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Informacion");
			lInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lInfo.setBounds(467, 495, 138, 39);
		}
		return lInfo;
	}
	
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		txtNFlight.setText("");
		txtCityE.setText("");
		txtHourE.setText("");
		dcDateE.setDate(null);
		//reiniciar el jCalendar
		txtCityA.setText("");
		txtHourA.setText("");
		dcDateA.setDate(null);
		//++++++++++++++++++++++
		txtClassB.setText("");
		txtClassT.setText("");
		txtClassE.setText("");
		//++++++++++++++++++++++
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMFlight(String dataFlights[][], String []columnsName) {
		dtmFligh= new DefaultTableModel(dataFlights,columnsName);
	}
	public DefaultTableModel getDTMFlight() {
		return this.dtmFligh;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTFlight(DefaultTableModel dtmFlight) {
		tFligh= new JTable(dtmFlight);
		tFligh.setEnabled(false);
		tFligh.getTableHeader().setReorderingAllowed(false);
		tFligh.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTFlight() {
		return this.tFligh;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPFlight(JTable tFlight) {
		scpFlight = new JScrollPane(tFlight);
		scpFlight.setBounds(29, 544, 991, 127);
	}
	public JScrollPane getSCPFlight() {
		return this.scpFlight;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[] getColumnsName() {
		String[] columnsName= {"N. Vuelo","Ciudad Salida","Hora Salida",
				"Fecha Salida","Avion","Ciudad Arribo","Hora Arribo",
				"Fecha Arribo","Clase Ejecutivo","Clase Turista",
				"Clase Economica"};
		return columnsName;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillcomboAirplane(ArrayList<String> airplanes) {
		comboAirplane.addItem("Vacio");
		for (String airplane : airplanes) {
			comboAirplane.addItem(airplane);
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public JButton getBNumber() {
		if (bNumber == null) {
			bNumber = new JButton("N°");
			bNumber.setBounds(287, 85, 64, 32);
		}
		return bNumber;
	}
}
