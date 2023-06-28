package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.text.log.SysoLogger;

import javax.swing.JButton;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class GUI_Main extends JFrame {

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JButton btnMbrand;
	private JButton btnMModel;
	private JButton btnMAirline;
	private JButton btnMAirplane;
	private JButton btnMFlights;
	private JButton btnMPassenger;
	private JButton bTicket;
	private JMenuBar menuBar;
	private JMenu mnOptions;
	private JMenuItem mntPrintTickets;
	private JMenu mnHelp;
	private JMenuItem mntAbout;
	private JMenuItem mntConsultRecord;
	private JMenuItem mntConsultFlights;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 561);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnMbrand());
		contentPane.add(getBtnMModel());
		contentPane.add(getBtnMAirline());
		contentPane.add(getBtnMAirplane());
		contentPane.add(getBtnMFlights());
		contentPane.add(getBtnMPassenger());
		contentPane.add(getBTicket());
		contentPane.add(getLblNewLabel());
		setVisible(true);
	}
	public JButton getBtnMbrand() {
		if (btnMbrand == null) {
			btnMbrand = new JButton("G. de Marca");
			
			btnMbrand.setForeground(Color.WHITE);
			btnMbrand.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMbrand.setFocusPainted(false);
			btnMbrand.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMbrand.setBackground(BUTTON_GREEN);
			
			btnMbrand.setBounds(274, 275, 146, 39);
		}
		return btnMbrand;
	}
	public JButton getBtnMModel() {
		if (btnMModel == null) {
			btnMModel = new JButton("G. de Modelo");
			
			btnMModel.setForeground(Color.WHITE);
			btnMModel.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMModel.setFocusPainted(false);
			btnMModel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMModel.setBackground(BUTTON_GREEN);
			
			btnMModel.setBounds(80, 351, 146, 39);
		}
		return btnMModel;
	}
	public JButton getBtnMAirline() {
		if (btnMAirline == null) {
			btnMAirline = new JButton("G. de Aerolinea");
			
			btnMAirline.setForeground(Color.WHITE);
			btnMAirline.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMAirline.setFocusPainted(false);
			btnMAirline.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMAirline.setBackground(BUTTON_GREEN);
			
			btnMAirline.setBounds(80, 431, 146, 39);
		}
		return btnMAirline;
	}
	public JButton getBtnMAirplane() {
		if (btnMAirplane == null) {
			btnMAirplane = new JButton("G. de Aviones");

			btnMAirplane.setForeground(Color.WHITE);
			btnMAirplane.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMAirplane.setFocusPainted(false);
			btnMAirplane.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMAirplane.setBackground(BUTTON_GREEN);
			
			btnMAirplane.setBounds(274, 351, 146, 39);
		}
		return btnMAirplane;
	}
	public JButton getBtnMFlights() {
		if (btnMFlights == null) {
			btnMFlights = new JButton("G. de Vuelos");

			btnMFlights.setForeground(Color.WHITE);
			btnMFlights.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMFlights.setFocusPainted(false);
			btnMFlights.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMFlights.setBackground(BUTTON_GREEN);
			
			btnMFlights.setBounds(274, 431, 146, 39);
		}
		return btnMFlights;
	}
	public JButton getBtnMPassenger() {
		if (btnMPassenger == null) {
			btnMPassenger = new JButton("G. de Pasajeros");

			btnMPassenger.setForeground(Color.WHITE);
			btnMPassenger.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnMPassenger.setFocusPainted(false);
			btnMPassenger.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			btnMPassenger.setBackground(BUTTON_GREEN);
			
			btnMPassenger.setBounds(466, 351, 146, 39);
		}
		return btnMPassenger;
	}
	public JButton getBTicket() {
		if (bTicket == null) {
			bTicket = new JButton("G. de Tiquetes");

			bTicket.setForeground(Color.WHITE);
			bTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			bTicket.setFocusPainted(false);
			bTicket.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bTicket.setBackground(BUTTON_GREEN);
			
			bTicket.setBounds(466, 431, 146, 39);
		}
		return bTicket;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnOptions());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}
	public JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu("Opciones");
			mnOptions.add(getMntPrintTickets());
			mnOptions.add(getMntConsultRecord());
			mnOptions.add(getMntConsultFlights());
		}
		return mnOptions;
	}
	public JMenuItem getMntPrintTickets() {
		if (mntPrintTickets == null) {
			mntPrintTickets = new JMenuItem("Imprimir Tiquetes");
		}
		return mntPrintTickets;
	}
	public JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Ayuda");
			mnHelp.add(getMntAbout());
		}
		return mnHelp;
	}
	public JMenuItem getMntAbout() {
		if (mntAbout == null) {
			mntAbout = new JMenuItem("Acerca de");
		}
		return mntAbout;
	}
	public JMenuItem getMntConsultRecord() {
		if (mntConsultRecord == null) {
			mntConsultRecord = new JMenuItem("Historial de tiquetes");
		}
		return mntConsultRecord;
	}
	public JMenuItem getMntConsultFlights() {
		if (mntConsultFlights == null) {
			mntConsultFlights = new JMenuItem("Consultar Vuelos");
		}
		return mntConsultFlights;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yeile\\git\\ProyectoAerolineas\\Sistema de Aerolineas\\images\\LogoType.png"));
			lblNewLabel.setBounds(195, 26, 300, 200);
		}
		return lblNewLabel;
	}
	public void executeHTML(String url) {
		String osName= System.getProperty("os.name");
		
		try {
			if (osName.startsWith("Windows")) {
				Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+url);
			}else if(osName.startsWith("Mac OS X")) {
				Runtime.getRuntime().exec("open -a safari "+url);
				Runtime.getRuntime().exec("open "+url+"/index.html");
				Runtime.getRuntime().exec("open"+url);
			}else {
				System.out.println("Please open a browser and go to: "+url);
			}
		} catch (IOException e) {
			System.out.println("Failed to start a browser to open the url: "+url);
			e.printStackTrace();
		}
	}
}
