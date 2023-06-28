package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Ticket extends JFrame {
	
	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	//private static final Color LIGHTER_BACKGROUND = new Color(21, 26, 33);

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
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);

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
			lTitleTicket.setForeground(new Color(255, 255, 255));
			lTitleTicket.setFont(new Font("Tahoma", Font.BOLD, 18));
			lTitleTicket.setBounds(319, 23, 190, 42);
		}
		return lTitleTicket;
	}
	public JLabel getLNTicket() {
		if (lNTicket == null) {
			lNTicket = new JLabel("Numero de tiquete:");
			lNTicket.setForeground(new Color(255, 255, 255));
			lNTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNTicket.setBounds(75, 117, 162, 42);
		}
		return lNTicket;
	}
	public JLabel getLPassport() {
		if (lPassport == null) {
			lPassport = new JLabel("Pasaportes:");
			lPassport.setForeground(new Color(255, 255, 255));
			lPassport.setFont(new Font("Tahoma", Font.BOLD, 15));
			lPassport.setBounds(75, 191, 162, 42);
		}
		return lPassport;
	}
	public JLabel getLNFlight() {
		if (lNFlight == null) {
			lNFlight = new JLabel("Numero de vuelos:");
			lNFlight.setForeground(new Color(255, 255, 255));
			lNFlight.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNFlight.setBounds(75, 270, 162, 42);
		}
		return lNFlight;
	}
	public JTextField getTxtNTicket() {
		if (txtNTicket == null) {
			txtNTicket = new JTextField();
			
			txtNTicket.setFont(new Font("Tahoma", Font.PLAIN, 13));
			txtNTicket.setForeground(Color.WHITE);
			txtNTicket.setHorizontalAlignment(SwingConstants.LEFT);
			txtNTicket.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
			txtNTicket.setBackground(new Color(41, 90, 45));
			
			txtNTicket.setBounds(256, 126, 115, 29);
			txtNTicket.setColumns(10);
		}
		return txtNTicket;
	}
	public JComboBox getComboPassport() {
		if (comboPassport == null) {
			comboPassport = new JComboBox();
			comboPassport.setForeground(new Color(255, 255, 255));
			comboPassport.setBackground(new Color(41, 90, 45));
			comboPassport.setBounds(256, 200, 115, 29);
		}
		return comboPassport;
	}
	public JComboBox getComboFlight() {
		if (comboFlight == null) {
			comboFlight = new JComboBox();
			comboFlight.setForeground(new Color(255, 255, 255));
			comboFlight.setBackground(new Color(41, 90, 45));
			comboFlight.setBounds(256, 279, 115, 29);
		}
		return comboFlight;
	}
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Información");
			lInfo.setForeground(new Color(255, 255, 255));
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lInfo.setBounds(599, 89, 94, 42);
		}
		return lInfo;
	}
	
	public JButton getBAdd() {
		if (bAdd == null) {
			//Cambia color del boton
			bAdd = new JButton("Agregar");
			bAdd.setForeground(Color.WHITE);
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setFocusPainted(false);
			bAdd.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAdd.setBackground(BUTTON_GREEN);
			
//			.setForeground(Color.WHITE);
//			.setFont(new Font("Tahoma", Font.BOLD, 15));
//			.setFocusPainted(false);
//			.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
//			.setBackground(BUTTON_GREEN);
			
			bAdd.setBounds(137, 404, 100, 29);
		}
		return bAdd;
	}
	public JButton getBModify() {
		if (bModify == null) {
			//Cambia color de boton
			bModify = new JButton("Modificar");
			bModify.setForeground(Color.WHITE);
			bModify.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModify.setFocusPainted(false);
			bModify.setBorder(new LineBorder(Color.DARK_GRAY,1,true));
			bModify.setBackground(BUTTON_GREEN);
			
			bModify.setBounds(247, 404, 100, 29);
		}
		return bModify;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			//Cambia color de boton
			bConsult = new JButton("Consultar");
			bConsult.setForeground(Color.WHITE);
			bConsult.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsult.setFocusPainted(false);
			bConsult.setBorder(new LineBorder(Color.DARK_GRAY,1,true));
			bConsult.setBackground(BUTTON_GREEN);
			
			bConsult.setBounds(357, 404, 100, 29);
		}
		return bConsult;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			//Cambia color de boton
			bDelete = new JButton("Eliminar");
			
			bDelete.setForeground(Color.WHITE);
			bDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			bDelete.setFocusPainted(false);
			bDelete.setBorder(new LineBorder(Color.DARK_GRAY,1,true));
			bDelete.setBackground(BUTTON_GREEN);
			
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
			lTypeT.setForeground(new Color(255, 255, 255));
			lTypeT.setFont(new Font("Tahoma", Font.BOLD, 15));
			lTypeT.setBounds(75, 340, 162, 42);
		}
		return lTypeT;
	}
	public JComboBox getComboSTypes() {
		if (comboSTypes == null) {
			comboSTypes = new JComboBox();
			comboSTypes.setForeground(new Color(255, 255, 255));
			comboSTypes.setBackground(new Color(41, 90, 45));
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
