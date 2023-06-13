package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
	private String []columnName= {"Nombres"};
	
	private User user;
	private LogicXML lXML;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Brand(User user,LogicXML lXML) {
		
		this.user= user;
		this.lXML= lXML;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		if (lXML.checkTypeUser(user)) {
			System.out.println(user.toString());
			contentPane.add(getBModificar());
			contentPane.add(getBEliminar());
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
			lNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNombre.setBounds(54, 78, 119, 45);
		}
		return lNombre;
	}
	public JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(295, 78, 119, 45);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Marcas");
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionM.setBounds(141, 23, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAgregar() {
		if (bAgregar == null) {
			bAgregar = new JButton("Agregar");
			bAgregar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bAgregar.setBounds(54, 156, 119, 30);
		}
		return bAgregar;
	}

	public JButton getBModificar() {
		bModificar = new JButton("Modificar");
		bModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bModificar.setBounds(187, 156, 119, 30);
		
		return bModificar;
	}
	public JButton getBEliminar() {
		
		if (bEliminar == null) {
			bEliminar = new JButton("Eliminar");
			bEliminar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bEliminar.setBounds(187, 215, 119, 30);
		}
		return bEliminar;
	}
	public JButton getBConsultar() {
		if (bConsultar == null) {
			bConsultar = new JButton("Consultar");
			bConsultar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bConsultar.setBounds(316, 156, 119, 30);
		}
		return bConsultar;
	}
	
	
	public void clearForm() {
		txtNombre.setText("");
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
}
