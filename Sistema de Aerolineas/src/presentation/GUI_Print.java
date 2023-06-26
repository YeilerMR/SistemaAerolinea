package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUI_Print extends JFrame {

	private JPanel contentPane;
	private JLabel lNTicket;
	private JTextField txtNTicket;
	private JButton bPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Print frame = new GUI_Print();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Print() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNTicket());
		contentPane.add(getTxtNTicket());
		contentPane.add(getBPrint());
	}

	public JLabel getLNTicket() {
		if (lNTicket == null) {
			lNTicket = new JLabel("N° de Tiquete:");
			lNTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNTicket.setBounds(21, 56, 135, 42);
		}
		return lNTicket;
	}
	public JTextField getTxtNTicket() {
		if (txtNTicket == null) {
			txtNTicket = new JTextField();
			txtNTicket.setBounds(166, 56, 135, 42);
			txtNTicket.setColumns(10);
		}
		return txtNTicket;
	}
	public JButton getBPrint() {
		if (bPrint == null) {
			bPrint = new JButton("Imprimir");
			bPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
			bPrint.setBounds(89, 139, 135, 42);
		}
		return bPrint;
	}
}
