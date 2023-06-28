package presentation;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class GUI_Passenger extends JFrame {

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lGPassenger;
	private JLabel lPassport;
	private JLabel lName;
	private JLabel lLastName;
	private JLabel lDateBirth;
	private JLabel lEmail;
	private JLabel lPhone;
	
	private JTextField txtPassport;
	private JTextField txtName;
	private JTextField txtLastName;
	private JTextField txtDateBirth;
	private JTextField txtEmail;
	private JTextField txtPhone;
	
	private JButton bAdd;
	private JButton bModify;
	private JButton bConsult;
	private JButton bDelete;
	private JLabel lInfo;
	
	private LogicXML lXML;
	
	private DefaultTableModel dtmPassenger;
	private JTable tPassenger;
	private JScrollPane scpPassenger;
	
	private String [][]dataPassenger;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Passenger frame = new GUI_Passenger();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_Passenger(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1131, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);

		if (lXML.checkTypeUser(user)) {
			contentPane.add(getBModify());
			contentPane.add(getBDelete());
		}
		
		setDTMPassenger(dataPassenger,getColumnsName());
		setTPassenger(dtmPassenger);
		setSCPPassenger(tPassenger);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLGPassenger());
		contentPane.add(getLPassport());
		contentPane.add(getLName());
		contentPane.add(getLLastName());
		contentPane.add(getLDateBirth());
		contentPane.add(getLEmail());
		contentPane.add(getLPhone());
		contentPane.add(getTxtPassport());
		contentPane.add(getTxtName());
		contentPane.add(getTxtLastName());
		contentPane.add(getTxtDateBirth());
		contentPane.add(getTxtEmail());
		contentPane.add(getTxtPhone());
		contentPane.add(getBAdd());
		
		contentPane.add(getBConsult());
		
		contentPane.add(getLInfo());
		contentPane.add(getSCPPassenger());
		setVisible(true);
	}

	public JLabel getLGPassenger() {
		if (lGPassenger == null) {
			lGPassenger = new JLabel("Gestion de Pasajeros");
			lGPassenger.setForeground(new Color(255, 255, 255));
			lGPassenger.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGPassenger.setBounds(214, 23, 199, 35);
		}
		return lGPassenger;
	}
	public JLabel getLPassport() {
		if (lPassport == null) {
			lPassport = new JLabel("# Pasaporte:");
			lPassport.setForeground(new Color(255, 255, 255));
			lPassport.setFont(new Font("Tahoma", Font.BOLD, 15));
			lPassport.setBounds(38, 85, 104, 35);
		}
		return lPassport;
	}
	public JLabel getLName() {
		if (lName == null) {
			lName = new JLabel("Nombre:");
			lName.setForeground(new Color(255, 255, 255));
			lName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lName.setBounds(38, 147, 104, 35);
		}
		return lName;
	}
	public JLabel getLLastName() {
		if (lLastName == null) {
			lLastName = new JLabel("Apellido:");
			lLastName.setForeground(new Color(255, 255, 255));
			lLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
			lLastName.setBounds(38, 206, 104, 35);
		}
		return lLastName;
	}
	public JLabel getLDateBirth() {
		if (lDateBirth == null) {
			lDateBirth = new JLabel("F. Nacimiento:");
			lDateBirth.setForeground(new Color(255, 255, 255));
			lDateBirth.setFont(new Font("Tahoma", Font.BOLD, 15));
			lDateBirth.setBounds(314, 85, 120, 35);
		}
		return lDateBirth;
	}
	public JLabel getLEmail() {
		if (lEmail == null) {
			lEmail = new JLabel("Correo:");
			lEmail.setForeground(new Color(255, 255, 255));
			lEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
			lEmail.setBounds(314, 147, 120, 35);
		}
		return lEmail;
	}
	public JLabel getLPhone() {
		if (lPhone == null) {
			lPhone = new JLabel("Telefono:");
			lPhone.setForeground(new Color(255, 255, 255));
			lPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
			lPhone.setBounds(314, 206, 120, 35);
		}
		return lPhone;
	}
	public JTextField getTxtPassport() {
		if (txtPassport == null) {
			txtPassport = new JTextField();
			txtPassport.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPassport.setForeground(new Color(255, 255, 255));
			txtPassport.setBackground(new Color(41, 90, 45));
			txtPassport.setBounds(164, 85, 114, 35);
			txtPassport.setColumns(10);
		}
		return txtPassport;
	}
	public JTextField getTxtName() {
		if (txtName == null) {
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtName.setForeground(new Color(255, 255, 255));
			txtName.setBackground(new Color(41, 90, 45));
			txtName.setColumns(10);
			txtName.setBounds(164, 149, 114, 35);
		}
		return txtName;
	}
	public JTextField getTxtLastName() {
		if (txtLastName == null) {
			txtLastName = new JTextField();
			txtLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtLastName.setForeground(new Color(255, 255, 255));
			txtLastName.setBackground(new Color(41, 90, 45));
			txtLastName.setColumns(10);
			txtLastName.setBounds(164, 208, 114, 35);
		}
		return txtLastName;
	}
	public JTextField getTxtDateBirth() {
		if (txtDateBirth == null) {
			txtDateBirth = new JTextField();
			txtDateBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtDateBirth.setForeground(new Color(255, 255, 255));
			txtDateBirth.setBackground(new Color(41, 90, 45));
			txtDateBirth.setColumns(10);
			txtDateBirth.setBounds(444, 85, 114, 35);
		}
		return txtDateBirth;
	}
	public JTextField getTxtEmail() {
		if (txtEmail == null) {
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtEmail.setForeground(new Color(255, 255, 255));
			txtEmail.setBackground(new Color(41, 90, 45));
			txtEmail.setColumns(10);
			txtEmail.setBounds(444, 147, 114, 35);
		}
		return txtEmail;
	}
	public JTextField getTxtPhone() {
		if (txtPhone == null) {
			txtPhone = new JTextField();
			txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPhone.setForeground(new Color(255, 255, 255));
			txtPhone.setBackground(new Color(41, 90, 45));
			txtPhone.setColumns(10);
			txtPhone.setBounds(444, 206, 114, 35);
		}
		return txtPhone;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");

			bAdd.setForeground(Color.WHITE);
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setFocusPainted(false);
			bAdd.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAdd.setBackground(BUTTON_GREEN);
			
			bAdd.setBounds(67, 303, 114, 48);
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
			
			bModify.setBounds(214, 303, 114, 48);
		}
		return bModify;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");

			bConsult.setForeground(Color.WHITE);
			bConsult.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsult.setFocusPainted(false);
			bConsult.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bConsult.setBackground(BUTTON_GREEN);
			
			bConsult.setBounds(363, 303, 114, 48);
		}
		return bConsult;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");

			bDelete.setForeground(Color.WHITE);
			bDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			bDelete.setFocusPainted(false);
			bDelete.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bDelete.setBackground(BUTTON_GREEN);
			
			bDelete.setBounds(214, 380, 114, 48);
		}
		return bDelete;
	}
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Información");
			lInfo.setForeground(new Color(255, 255, 255));
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
			lInfo.setBounds(785, 117, 148, 35);
		}
		return lInfo;
	}
	
	public void clearForm() {
		txtPassport.setText("");
		txtName.setText("");
		txtLastName.setText("");
		txtDateBirth.setText("");
		txtEmail.setText("");
		txtPhone.setText("");
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPPassenger(JTable tPassenger) {
		scpPassenger = new JScrollPane(tPassenger);
		scpPassenger.setBounds(631, 174, 447, 230);
		scpPassenger.setViewportView(getTPassenger());
	}
	public JScrollPane getSCPPassenger() {
		return scpPassenger;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMPassenger(String [][]dataPassengers,String[]columnName) {
		dtmPassenger= new DefaultTableModel(dataPassengers,columnName);
	}
	public DefaultTableModel getDTMPassenger() {
		return this.dtmPassenger;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTPassenger(DefaultTableModel dtmPassenger) {
		tPassenger=new JTable(dtmPassenger);
//		tPassenger.setForeground(new Color(0, 191, 255));
//		tPassenger.setBackground(new Color(139, 0, 0));
		tPassenger.setEnabled(false);
		tPassenger.getTableHeader().setReorderingAllowed(false);
		tPassenger.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTPassenger() {
		return this.tPassenger;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[]getColumnsName(){
		String columnsName[]= {"# Pasaporte","Nombre","Apellido",
								"F.Nacimiento","Correo","Telefono"};
		
		return columnsName;
	}
}//fin de GUI_Passenger

