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
	private JButton btnMPassenger;
	private JButton bTicket;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 561);
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
		contentPane.add(getBtnMPassenger());
		contentPane.add(getBTicket());
		setVisible(true);
	}
	public JButton getBtnMUser() {
		if (btnMUser == null) {
			btnMUser = new JButton("G. de Usuario");
			btnMUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMUser.setBounds(10, 54, 146, 39);
		}
		return btnMUser;
	}
	public JButton getBtnMbrand() {
		if (btnMbrand == null) {
			btnMbrand = new JButton("G. de Marca");
			btnMbrand.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMbrand.setBounds(10, 127, 146, 39);
		}
		return btnMbrand;
	}
	public JButton getBtnMModel() {
		if (btnMModel == null) {
			btnMModel = new JButton("G. de Modelo");
			btnMModel.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMModel.setBounds(201, 52, 146, 39);
		}
		return btnMModel;
	}
	public JButton getBtnMAirline() {
		if (btnMAirline == null) {
			btnMAirline = new JButton("G. de Aerolinea");
			btnMAirline.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMAirline.setBounds(201, 127, 146, 39);
		}
		return btnMAirline;
	}
	public JButton getBtnMAirplane() {
		if (btnMAirplane == null) {
			btnMAirplane = new JButton("G. de Aviones");
			btnMAirplane.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMAirplane.setBounds(378, 52, 146, 39);
		}
		return btnMAirplane;
	}
	public JButton getBtnMFlights() {
		if (btnMFlights == null) {
			btnMFlights = new JButton("G. de Vuelos");
			btnMFlights.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMFlights.setBounds(378, 127, 146, 39);
		}
		return btnMFlights;
	}
	public JButton getBtnMPassenger() {
		if (btnMPassenger == null) {
			btnMPassenger = new JButton("G. de Pasajeros");
			btnMPassenger.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnMPassenger.setBounds(559, 54, 146, 39);
		}
		return btnMPassenger;
	}
	public JButton getBTicket() {
		if (bTicket == null) {
			bTicket = new JButton("G. de Tiquetes");
			bTicket.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bTicket.setBounds(559, 127, 146, 39);
		}
		return bTicket;
	}
}
