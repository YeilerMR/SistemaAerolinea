package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GUI_Main extends JFrame {

	private JPanel contentPane;
	private JButton btnMUser;
	private JButton btnMbrand;
	private JButton btnMModel;
	private JButton btnMAirline;
	private JButton btnMAirplane;
	private JButton btnMFlights;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 502);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnMUser());
		contentPane.add(getBtnMbrand());
		contentPane.add(getBtnMModel());
		contentPane.add(getBtnMAirline());
		contentPane.add(getBtnMAirplane());
		contentPane.add(getBtnMFlights());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}
	public JButton getBtnMUser() {
		if (btnMUser == null) {
			btnMUser = new JButton("G. de Usuario");
			btnMUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMUser.setBounds(60, 27, 146, 39);
		}
		return btnMUser;
	}
	public JButton getBtnMbrand() {
		if (btnMbrand == null) {
			btnMbrand = new JButton("G. de Marca");
			btnMbrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMbrand.setBounds(60, 100, 146, 39);
		}
		return btnMbrand;
	}
	public JButton getBtnMModel() {
		if (btnMModel == null) {
			btnMModel = new JButton("G. de Modelo");
			btnMModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMModel.setBounds(60, 176, 146, 39);
		}
		return btnMModel;
	}
	public JButton getBtnMAirline() {
		if (btnMAirline == null) {
			btnMAirline = new JButton("G. de Aerolinea");
			btnMAirline.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMAirline.setBounds(60, 251, 146, 39);
		}
		return btnMAirline;
	}
	public JButton getBtnMAirplane() {
		if (btnMAirplane == null) {
			btnMAirplane = new JButton("G. de Aviones");
			btnMAirplane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMAirplane.setBounds(60, 324, 146, 39);
		}
		return btnMAirplane;
	}
	public JButton getBtnMFlights() {
		if (btnMFlights == null) {
			btnMFlights = new JButton("G. de Vuelos");
			btnMFlights.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMFlights.setBounds(60, 399, 146, 39);
		}
		return btnMFlights;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yeile\\Desktop\\Proyecto Aerolinea\\images\\Logo_Company .png"));
			lblNewLabel.setBounds(258, 27, 447, 411);
		}
		return lblNewLabel;
	}
}
