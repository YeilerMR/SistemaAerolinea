package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Airline extends JFrame implements ActionListener{

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

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Airline() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNombre());
		contentPane.add(getTxtNombre());
		contentPane.add(getLGestionAirline());
		contentPane.add(getBAdd());
		contentPane.add(getBModify());
		contentPane.add(getBDelete());
		contentPane.add(getBConsult());
		contentPane.add(getLOperationCenters());
		contentPane.add(getTxtOperationCenter());
		//setVisible(true);
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
	public JLabel getLGestionAirline() {
		if (lGestionAirline == null) {
			lGestionAirline = new JLabel("Gestion de Aerolineas");
			lGestionAirline.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionAirline.setBounds(141, 23, 187, 45);
		}
		return lGestionAirline;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			bAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
			bModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bModify.setBounds(187, 285, 119, 30);
		}
		return bModify;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bDelete.setBounds(187, 344, 119, 30);
		}
		return bDelete;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bConsult.setBounds(316, 285, 119, 30);
		}
		return bConsult;
	}
	public JLabel getLOperationCenters() {
		if (lOperationCenters == null) {
			lOperationCenters = new JLabel("Centro de Operaciones:");
			lOperationCenters.setFont(new Font("Tahoma", Font.BOLD, 15));
			lOperationCenters.setBounds(54, 180, 179, 45);
		}
		return lOperationCenters;
	}
	public JTextField getTxtOperationCenter() {
		if (txtOperationCenter == null) {
			txtOperationCenter = new JTextField();
			txtOperationCenter.setColumns(10);
			txtOperationCenter.setBounds(295, 180, 119, 45);
		}
		return txtOperationCenter;
	}
}
