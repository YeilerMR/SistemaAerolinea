package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import data.LogicXML;
import domain.Brand;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class GUI_Brand extends JFrame{

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lNombre;
	private JTextField txtNombre;
	private JLabel lGestionM;
	private JButton bAgregar;
	private JButton bModificar;
	private JButton bEliminar;
	private JButton bConsultar;
	
	private DefaultTableModel dtmBrand;
	private JScrollPane scpBrand;
	private JTable tBrand;
	
	private String [][]dataBrands;
	public String []columnName= {"Nombres"};
	
	private User user;
	private LogicXML lXML;
	private JTextField txtNew;
	private JLabel lNuevo;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Brand(User user) {
		
		this.user= user;
		this.lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);

		
		if (lXML.checkTypeUser(user)) {
			
			System.out.println(user.toString());
			contentPane.add(getBModificar());
			contentPane.add(getBEliminar());
			contentPane.add(getTxtNew());
			contentPane.add(getLNuevo());
		}
		
		setDTMBrand(dataBrands,columnName);
		setTBrand(dtmBrand);
		setSCPBrand(tBrand);
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNombre());
		contentPane.add(getTxtNombre());
		contentPane.add(getLGestionM());
		contentPane.add(getBAgregar());
		
		
		contentPane.add(getBConsultar());
		contentPane.add(getScpBrand());
		
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
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombre.setForeground(new Color(255, 255, 255));
			txtNombre.setBackground(new Color(41, 90, 45));
			txtNombre.setBounds(151, 80, 119, 45);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Marcas");
			lGestionM.setForeground(new Color(255, 255, 255));
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionM.setBounds(215, 10, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAgregar() {
		if (bAgregar == null) {
			bAgregar = new JButton("Agregar");

			bAgregar.setForeground(Color.WHITE);
			bAgregar.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAgregar.setFocusPainted(false);
			bAgregar.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAgregar.setBackground(BUTTON_GREEN);
			
			bAgregar.setBounds(54, 156, 119, 30);
		}
		return bAgregar;
	}

	public JButton getBModificar() {
		if (bAgregar==null) {
			bModificar = new JButton("Modificar");
			
			bModificar.setForeground(Color.WHITE);
			bModificar.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModificar.setFocusPainted(false);
			bModificar.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bModificar.setBackground(BUTTON_GREEN);
			
			bModificar.setBounds(187, 156, 119, 30);
		}
		return bModificar;
	}
	public JButton getBEliminar() {
		
		if (bEliminar == null) {
			bEliminar = new JButton("Eliminar");
			
			bEliminar.setForeground(Color.WHITE);
			bEliminar.setFont(new Font("Tahoma", Font.BOLD, 15));
			bEliminar.setFocusPainted(false);
			bEliminar.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bEliminar.setBackground(BUTTON_GREEN);
			
			bEliminar.setBounds(187, 215, 119, 30);
		}
		return bEliminar;
	}
	public JButton getBConsultar() {
		if (bConsultar == null) {
			bConsultar = new JButton("Consultar");
			
			bConsultar.setForeground(Color.WHITE);
			bConsultar.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsultar.setFocusPainted(false);
			bConsultar.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bConsultar.setBackground(BUTTON_GREEN);
			
			bConsultar.setBounds(316, 156, 119, 30);
		}
		return bConsultar;
	}
	
	
	public void clearForm() {
		txtNombre.setText("");
		txtNew.setText("");
	}
	
	public void showMessage(String message) {

		JOptionPane.showMessageDialog(null, message);
	}
	//---------------------------------------------------------------------------------------
	public void setDTMBrand(String [][]dataBrands, String[] columnName) {
		dtmBrand= new DefaultTableModel(dataBrands, columnName);
		
	}
	public DefaultTableModel getDTMBrand() {
		return this.dtmBrand;
	}
	//---------------------------------------------------------------------------------------
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPBrand(JTable tBrand) {
		
		scpBrand = new JScrollPane(tBrand);
		scpBrand.setBounds(187, 324, 131, 206);
		scpBrand.setViewportView(getTBrand());
		
	}
	public JScrollPane getScpBrand() {
		
		return this.scpBrand;
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTBrand(DefaultTableModel dtmBrand) {
		
		tBrand= new JTable(dtmBrand);
		tBrand.setEnabled(false);
		tBrand.getTableHeader().setReorderingAllowed(false);
		tBrand.getTableHeader().setResizingAllowed(false);
		
	}
	public JTable getTBrand() {
		
		return this.tBrand;
	}
	public JTextField getTxtNew() {
		if (txtNew == null) {
			txtNew = new JTextField();
			txtNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNew.setForeground(new Color(255, 255, 255));
			txtNew.setBackground(new Color(41, 90, 45));
			txtNew.setColumns(10);
			txtNew.setBounds(424, 78, 119, 45);
		}
		return txtNew;
	}
	public JLabel getLNuevo() {
		if (lNuevo == null) {
			lNuevo = new JLabel("Nuevo:");
			lNuevo.setForeground(new Color(255, 255, 255));
			lNuevo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNuevo.setBounds(325, 78, 89, 45);
		}
		return lNuevo;
	}
}
