package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Brand extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JLabel lNombre;
	private JTextField txtNombre;
	private JLabel lGestionM;
	private JButton bAgregar;
	private JButton bModificar;
	private JButton bEliminar;
	private JButton bConsultar;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Brand() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 567, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNombre());
		contentPane.add(getTxtNombre());
		contentPane.add(getLGestionM());
		contentPane.add(getBAgregar());
		contentPane.add(getBModificar());
		contentPane.add(getBEliminar());
		contentPane.add(getBConsultar());
		contentPane.add(getBtnExit());
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public JButton getBModificar() {
		if (bModificar == null) {
			bModificar = new JButton("Modificar");
			bModificar.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bModificar.setBounds(187, 156, 119, 30);
		}
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
	public JButton getBtnExit() {
		if (btnExit == null) {
			btnExit = new JButton("Salir");
			btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnExit.setBounds(398, 325, 119, 30);
		}
		return btnExit;
	}
	
	
	public void clearForm() {
		txtNombre.setText("");
	}
	
	public void showMessage(String message) {

		JOptionPane.showMessageDialog(null, message);
	}
}
