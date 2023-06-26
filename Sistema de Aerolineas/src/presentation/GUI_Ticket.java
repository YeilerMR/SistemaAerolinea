package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import data.LogicXML;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.spi.AbstractResourceBundleProvider;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class GUI_Ticket extends JFrame {

	private JPanel contentPane;
	private JLabel lTitleTicket;
	private JLabel lNTicket;
	private JLabel lPassport;
	private JLabel lNFlight;
	private JTextField txtNTicket;
	private JComboBox comboPassport;
	private JComboBox comboFlight;
	private JLabel lInfo;
	
	private JButton bAdd;
	private JButton bModify;
	private JButton bConsult;
	private JButton bDelete;

	private LogicXML lXML;
	
	private DefaultTableModel dtmTicket;
	private JTable tTicket;
	private JScrollPane scpTicket;
	
	private String[][] dataTicket;
	private JLabel lTypeT;
	private JComboBox comboSTypes;
	private JMenuBar mbTicket;
	private JMenu mnTicket;
	private JMenuItem mntBuy;
	
	
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Ticket frame = new GUI_Ticket();
//					frame.
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_Ticket(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 896, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		if (lXML.checkTypeUser(user)) {

			contentPane.add(getBModify());
			contentPane.add(getBDelete());
			
		}
		
		setDTMTicket(dataTicket,getColumnsName());
		setTTicket(dtmTicket);
		setJMenuBar(getMenuBar_1());
		setSCPTicket(tTicket);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLTitleTicket());
		contentPane.add(getLNTicket());
		contentPane.add(getLPassport());
		contentPane.add(getLNFlight());
		contentPane.add(getTxtNTicket());
		contentPane.add(getComboPassport());
		contentPane.add(getComboFlight());
		contentPane.add(getLInfo());
		
		//contentPane.add(getSCPTicket());
		contentPane.add(getSCPTicket());
		contentPane.add(getBAdd());
		contentPane.add(getBConsult());
		contentPane.add(getLTypeT());
		contentPane.add(getComboSTypes());
		
		setVisible(true);
	}
	public JLabel getLTitleTicket() {
		if (lTitleTicket == null) {
			lTitleTicket = new JLabel("Gestion de Tiquetes");
			lTitleTicket.setFont(new Font("Tahoma", Font.BOLD, 18));
			lTitleTicket.setBounds(319, 23, 190, 42);
		}
		return lTitleTicket;
	}
	public JLabel getLNTicket() {
		if (lNTicket == null) {
			lNTicket = new JLabel("Numero de tiquete:");
			lNTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNTicket.setBounds(75, 117, 162, 42);
		}
		return lNTicket;
	}
	public JLabel getLPassport() {
		if (lPassport == null) {
			lPassport = new JLabel("Pasaportes:");
			lPassport.setFont(new Font("Tahoma", Font.BOLD, 15));
			lPassport.setBounds(75, 191, 162, 42);
		}
		return lPassport;
	}
	public JLabel getLNFlight() {
		if (lNFlight == null) {
			lNFlight = new JLabel("Numero de vuelos:");
			lNFlight.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNFlight.setBounds(75, 270, 162, 42);
		}
		return lNFlight;
	}
	public JTextField getTxtNTicket() {
		if (txtNTicket == null) {
			txtNTicket = new JTextField();
			txtNTicket.setBounds(256, 126, 115, 29);
			txtNTicket.setColumns(10);
		}
		return txtNTicket;
	}
	public JComboBox getComboPassport() {
		if (comboPassport == null) {
			comboPassport = new JComboBox();
			comboPassport.setBounds(256, 200, 115, 29);
		}
		return comboPassport;
	}
	public JComboBox getComboFlight() {
		if (comboFlight == null) {
			comboFlight = new JComboBox();
			comboFlight.setBounds(256, 279, 115, 29);
		}
		return comboFlight;
	}
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Información");
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lInfo.setBounds(599, 89, 94, 42);
		}
		return lInfo;
	}
	
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			bAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bAdd.setBounds(137, 404, 100, 29);
		}
		return bAdd;
	}
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");
			bModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bModify.setBounds(247, 404, 100, 29);
		}
		return bModify;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bConsult.setBounds(357, 404, 100, 29);
		}
		return bConsult;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bDelete.setBounds(247, 443, 100, 29);
		}
		return bDelete;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		txtNTicket.setText("");
		comboPassport.setSelectedIndex(0);
		comboFlight.setSelectedIndex(0);
		comboSTypes.setSelectedIndex(0);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMTicket(String dataTicket[][],String columnsName[]) {
		dtmTicket= new DefaultTableModel(dataTicket,columnsName);
	}
	public DefaultTableModel getDTMTicket(){
		return this.dtmTicket;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTTicket(DefaultTableModel dtmTicket) {
		tTicket= new JTable(dtmTicket);
		tTicket.setEnabled(false);
		tTicket.getTableHeader().setReorderingAllowed(false);
		tTicket.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTTicket() {
		return this.tTicket;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPTicket(JTable tTicket) {
		
		scpTicket = new JScrollPane(tTicket);
		scpTicket.setBounds(475, 142, 336, 167);
		
	}
	public JScrollPane getSCPTicket() {
		return this.scpTicket;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[] getColumnsName() {
		String[] columnsName= {"N°. de Tiquete","Pasaporte","N°. de Vuelo"};
		return columnsName;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillComboPassenger(ArrayList<String> passengers) {
		comboPassport.addItem("Vacio");
		for (String passenger : passengers) {
			comboPassport.addItem(passenger);
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillComboFlight(ArrayList<String> flights) {
		comboFlight.addItem("Vacio");
		for (String flight : flights) {
			comboFlight.addItem(flight);
		}
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillComboSTypes(ArrayList<String> seatsTypes) {
		comboSTypes.addItem("Vacio");
		for (String seats : seatsTypes) {
			comboSTypes.addItem(seats);
		}
	}
	public JLabel getLTypeT() {
		if (lTypeT == null) {
			lTypeT = new JLabel("Tipo de Asiento:");
			lTypeT.setFont(new Font("Tahoma", Font.BOLD, 15));
			lTypeT.setBounds(75, 340, 162, 42);
		}
		return lTypeT;
	}
	public JComboBox getComboSTypes() {
		if (comboSTypes == null) {
			comboSTypes = new JComboBox();
			comboSTypes.setBounds(256, 353, 115, 29);
		}
		return comboSTypes;
	}
	public JMenuBar getMenuBar_1() {
		if (mbTicket == null) {
			mbTicket = new JMenuBar();
			mbTicket.add(getMnTicket());
		}
		return mbTicket;
	}
	public JMenu getMnTicket() {
		if (mnTicket == null) {
			mnTicket = new JMenu("Opciones");
			mnTicket.add(getMntBuy());
		}
		return mnTicket;
	}
	public JMenuItem getMntBuy() {
		if (mntBuy == null) {
			mntBuy = new JMenuItem("Comprar Tiquete");
		}
		return mntBuy;
	}
}//GUI_Ticket
