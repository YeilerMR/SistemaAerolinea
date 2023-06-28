package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class GUI_Buy extends JFrame {

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lNTicket;
	private JButton bBuy;
	private JComboBox comboTicket;
	private JLabel lHourDate;
	private JLabel lHour;
	private JLabel lDate;

	
	Calendar fullDate;
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
	 * Create the frame
	 * .
	 */
	public GUI_Buy() {
		
		fullDate= new GregorianCalendar();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNTicket());
		contentPane.add(getBBuy());
		contentPane.add(getComboTicket());
		contentPane.add(getLHourDate());
		contentPane.add(getLHour());
		contentPane.add(getLDate());
		setVisible(true);
	}

	public JLabel getLNTicket() {
		if (lNTicket == null) {
			lNTicket = new JLabel("N° de Tiquete:");
			lNTicket.setForeground(new Color(255, 255, 255));
			lNTicket.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNTicket.setBounds(21, 56, 135, 42);
		}
		return lNTicket;
	}
	public JButton getBBuy() {
		if (bBuy == null) {
			bBuy = new JButton("Comprar");
			
			bBuy.setForeground(Color.WHITE);
			bBuy.setFont(new Font("Tahoma", Font.BOLD, 15));
			bBuy.setFocusPainted(false);
			bBuy.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bBuy.setBackground(BUTTON_GREEN);

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
	public JLabel getLHourDate() {
		
		if (lHourDate == null) {
			lHourDate = new JLabel("Fecha y Hora");
			lHourDate.setBounds(261, 178, 69, 19);
		}
		return lHourDate;
	}
	public JLabel getLHour() {
		if (lHour == null) {
			lHour = new JLabel(getHour());
			lHour.setBounds(213, 207, 56, 19);
		}
		return lHour;
	}
	public JLabel getLDate() {
		if (lDate == null) {
			lDate = new JLabel(getDate());
			lDate.setBounds(287, 207, 56, 19);
		}
		return lDate;
	}
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String getDate() {
		String year= Integer.toString(fullDate.get(Calendar.YEAR));
		String month= Integer.toString(fullDate.get(Calendar.MONTH));
		String day= Integer.toString(fullDate.get(Calendar.DATE));
		
		String date= day+"/"+month+"/"+year;
		return date;
	}
	public String getHour() {
		String hour= Integer.toString(fullDate.get(Calendar.HOUR_OF_DAY)); 
		String minutes= Integer.toString(fullDate.get(Calendar.MINUTE)); 
		String seconds= Integer.toString(fullDate.get(Calendar.SECOND)); 
		
		String hourDate=hour+":"+minutes+":"+seconds;
		return hourDate;
	}
}
