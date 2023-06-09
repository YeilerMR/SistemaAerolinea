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

public class GUI_Airplane extends JFrame implements ActionListener{

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

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Airplane() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLRegistration());
		contentPane.add(getTxtRegistration());
		contentPane.add(getLGestionM());
		contentPane.add(getBAdd());
		contentPane.add(getBModify());
		contentPane.add(getBDelete());
		contentPane.add(getBConsult());
		contentPane.add(getLAirline());
		contentPane.add(getLModels());
		contentPane.add(getLYear());
		contentPane.add(getTxtYear());
		//setVisible(true);
	}

	public JLabel getLRegistration() {
		if (lRegistration == null) {
			lRegistration = new JLabel("Matricula:");
			lRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
			lRegistration.setBounds(54, 78, 119, 45);
		}
		return lRegistration;
	}
	public JTextField getTxtRegistration() {
		if (txtRegistration == null) {
			txtRegistration = new JTextField();
			txtRegistration.setBounds(295, 78, 119, 45);
			txtRegistration.setColumns(10);
		}
		return txtRegistration;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Modelos");
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionM.setBounds(141, 23, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			bAdd.addActionListener(this);
			bAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bAdd.setBounds(54, 349, 119, 30);
		}
		return bAdd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == getBAdd()) {
			do_bAgregar_actionPerformed(e);
		}
		// TODO Auto-generated method stub
		
	}
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");
			bModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bModify.setBounds(187, 349, 119, 30);
		}
		return bModify;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bDelete.setBounds(187, 408, 119, 30);
		}
		return bDelete;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bConsult.setBounds(316, 349, 119, 30);
		}
		return bConsult;
	}
	protected void do_bAgregar_actionPerformed(ActionEvent e) {
	}
	public JLabel getLAirline() {
		if (lAirline == null) {
			lAirline = new JLabel("Aerolinea(s):");
			lAirline.setFont(new Font("Tahoma", Font.BOLD, 15));
			lAirline.setBounds(54, 133, 119, 45);
		}
		return lAirline;
	}
	public JLabel getLModels() {
		if (lModels == null) {
			lModels = new JLabel("Modelo(s): ");
			lModels.setFont(new Font("Tahoma", Font.BOLD, 15));
			lModels.setBounds(54, 188, 193, 45);
		}
		return lModels;
	}
	public JLabel getLYear() {
		if (lYear == null) {
			lYear = new JLabel("Año:");
			lYear.setFont(new Font("Tahoma", Font.BOLD, 15));
			lYear.setBounds(54, 243, 193, 45);
		}
		return lYear;
	}
	public JTextField getTxtYear() {
		if (txtYear == null) {
			txtYear = new JTextField();
			txtYear.setColumns(10);
			txtYear.setBounds(295, 243, 119, 45);
		}
		return txtYear;
	}
}
