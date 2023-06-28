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

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI_Airline extends JFrame implements ActionListener{

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lNombre;
	private JTextField txtNombre;
	
	private JLabel lGestionAirline;
	
	private JButton bAdd;
	private JButton bModify;
	private JButton bDelete;
	private JButton bConsult;
	
	private JLabel lOperationCenters;
	private JTextField txtOperationCenter;

	private LogicXML lXML;
	private JLabel lNew;
	private JTextField txtNew;
	private JLabel lInfo;
	
	private DefaultTableModel dtmAirline;
	private JTable tAirline;
	private JScrollPane scpAirline;
	
	private String [][]dataAirline;
	//public String []columnName;
	
	public GUI_Airline(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);

		if (lXML.checkTypeUser(user)) {
			
			contentPane.add(getBModify());
			contentPane.add(getBDelete());
			
			contentPane.add(getLNew());
			contentPane.add(getTxtNew());
		}
		
		setDTMAirline(dataAirline,getColumnNames());
		setTAirline(dtmAirline);
		setSCPAirline(tAirline);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNombre());
		contentPane.add(getTxtNombre());
		contentPane.add(getLGestionAirline());
		contentPane.add(getBAdd());
		
		contentPane.add(getBConsult());
		contentPane.add(getLOperationCenters());
		contentPane.add(getTxtOperationCenter());
		
		contentPane.add(getLInfo());
		contentPane.add(getSCPAirline());
		
		setVisible(true);
	}

	public JLabel getLNombre() {
		if (lNombre == null) {
			lNombre = new JLabel("Nombre: ");
			lNombre.setForeground(new Color(255, 255, 255));
			lNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNombre.setBounds(54, 78, 119, 45);
		}
		return lNombre;
	}
	public JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBackground(new Color(41, 90, 45));
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombre.setForeground(new Color(255, 255, 255));
			txtNombre.setBounds(141, 80, 119, 45);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	public JLabel getLGestionAirline() {
		if (lGestionAirline == null) {
			lGestionAirline = new JLabel("Gestion de Aerolineas");
			lGestionAirline.setForeground(new Color(255, 255, 255));
			lGestionAirline.setFont(new Font("Tahoma", Font.BOLD, 18));
			lGestionAirline.setBounds(347, 10, 254, 61);
		}
		return lGestionAirline;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");

			bAdd.setForeground(Color.WHITE);
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setFocusPainted(false);
			bAdd.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAdd.setBackground(BUTTON_GREEN);
			
			bAdd.setBounds(54, 285, 119, 30);
		}
		return bAdd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");

			bModify.setForeground(Color.WHITE);
			bModify.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModify.setFocusPainted(false);
			bModify.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bModify.setBackground(BUTTON_GREEN);
			
			bModify.setBounds(187, 285, 119, 30);
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
			
			bDelete.setBounds(187, 344, 119, 30);
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
			
			bConsult.setBounds(316, 285, 119, 30);
		}
		return bConsult;
	}
	public JLabel getLOperationCenters() {
		if (lOperationCenters == null) {
			lOperationCenters = new JLabel("Centro de Operaciones:");
			lOperationCenters.setForeground(new Color(255, 255, 255));
			lOperationCenters.setFont(new Font("Tahoma", Font.BOLD, 15));
			lOperationCenters.setBounds(54, 180, 179, 45);
		}
		return lOperationCenters;
	}
	public JTextField getTxtOperationCenter() {
		if (txtOperationCenter == null) {
			txtOperationCenter = new JTextField();
			txtOperationCenter.setBackground(new Color(41, 90, 45));
			txtOperationCenter.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtOperationCenter.setForeground(new Color(255, 255, 255));
			txtOperationCenter.setColumns(10);
			txtOperationCenter.setBounds(295, 180, 119, 45);
		}
		return txtOperationCenter;
	}
	public JLabel getLNew() {
		if (lNew == null) {
			lNew = new JLabel("Nuevo: ");
			lNew.setForeground(new Color(255, 255, 255));
			lNew.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNew.setBounds(281, 78, 119, 45);
		}
		return lNew;
	}
	public JTextField getTxtNew() {
		if (txtNew == null) {
			txtNew = new JTextField();
			txtNew.setBackground(new Color(41, 90, 45));
			txtNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNew.setForeground(new Color(255, 255, 255));
			txtNew.setColumns(10);
			txtNew.setBounds(357, 78, 119, 45);
		}
		return txtNew;
	}
	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Tabla de Informacion");
			lInfo.setForeground(new Color(255, 255, 255));
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lInfo.setBounds(657, 78, 187, 45);
		}
		return lInfo;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		txtNombre.setText("");
		txtOperationCenter.setText("");
		txtNew.setText("");
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMAirline(String[][]dataAirlines, String[]columNames) {
		dtmAirline= new DefaultTableModel(dataAirlines,columNames);
	}
	public DefaultTableModel getDTMAirline() {
		return this.dtmAirline;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPAirline(JTable tAirline) {
		if (scpAirline == null) {
			scpAirline = new JScrollPane(tAirline);
			scpAirline.setBounds(568, 143, 359, 194);
			scpAirline.setViewportView(getTAirline());
		}
		//return scpAirline;
	}
	public JScrollPane getSCPAirline() {
		return this.scpAirline;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTAirline(DefaultTableModel dtmAirline) {
		tAirline= new JTable(dtmAirline);
		tAirline.setEnabled(false);
		tAirline.getTableHeader().setReorderingAllowed(false);
		tAirline.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTAirline() {
		return this.tAirline;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[] getColumnNames() {
		String columnNames[]= {"Nombre","Centro Operaciones"};
		
		return columnNames;
	}
}//fin de GUI_Airline
