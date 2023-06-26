package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GUI_Buy extends JFrame {

	private JPanel contentPane;
	private JLabel lNTicket;
	private JButton bBuy;
	private JComboBox comboTicket;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Buy frame = new GUI_Buy();
//					
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public GUI_Buy() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNTicket());
		contentPane.add(getBBuy());
		contentPane.add(getComboTicket());
		setVisible(true);
	}

	public JLabel getLNTicket() {
		if (lNTicket == null) {
			lNTicket = new JLabel("N° de Tiquete:");
			lNTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNTicket.setBounds(21, 56, 135, 42);
		}
		return lNTicket;
	}
	public JButton getBBuy() {
		if (bBuy == null) {
			bBuy = new JButton("Comprar");
			bBuy.setFont(new Font("Tahoma", Font.BOLD, 15));
			bBuy.setBounds(89, 139, 135, 42);
		}
		return bBuy;
	}
	public JComboBox getComboTicket() {
		if (comboTicket == null) {
			comboTicket = new JComboBox();
			comboTicket.setBounds(166, 65, 116, 29);
		}
		return comboTicket;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		comboTicket.setSelectedIndex(0);
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	public int showConfirm(String message) {
		int answer= JOptionPane.showConfirmDialog(null, "Seguro que quiere comprar el tiquete["+message+"]",
                "OK_CANCEL_OPTION", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
		return answer;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void fillComboTicket(ArrayList<String> tickets) {
		comboTicket.addItem("Vacio");
		for (String ticket : tickets) {
			comboTicket.addItem(ticket);
		}
	}
	
}
