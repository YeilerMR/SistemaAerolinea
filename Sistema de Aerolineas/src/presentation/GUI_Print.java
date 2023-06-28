package presentation;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.text.Document;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;


public class GUI_Print extends JFrame {

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lNTicket;
	private JTextField txtNTicket;
	private JButton bPrint;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GUI_Print() {
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
		contentPane.add(getTxtNTicket());
		contentPane.add(getBPrint());
		
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
	public JTextField getTxtNTicket() {
		if (txtNTicket == null) {
			txtNTicket = new JTextField();
			txtNTicket.setBackground(new Color(41, 90, 45));
			txtNTicket.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNTicket.setForeground(new Color(255, 255, 255));
			txtNTicket.setBounds(166, 56, 135, 42);
			txtNTicket.setColumns(10);
		}
		return txtNTicket;
	}
	public JButton getBPrint() {
		if (bPrint == null) {
			bPrint = new JButton("Imprimir");

			bPrint.setForeground(Color.WHITE);
			bPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
			bPrint.setFocusPainted(false);
			bPrint.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bPrint.setBackground(BUTTON_GREEN);
			
			bPrint.setBounds(89, 139, 135, 42);
		}
		return bPrint;
	}
	public void clearForm() {
		txtNTicket.setText("");
	}
	public void showMessage(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	public void printToPDF(String nTicket, String info) throws FileNotFoundException{
		File filePDF= new File(nTicket+".pdf");
		
		try (PdfWriter pdfWriter= new PdfWriter(filePDF)){
			
			PdfDocument pdfDocument= new PdfDocument(pdfWriter);
			Document document= new Document(pdfDocument);
			
			Paragraph p= new Paragraph(info);
			document.add(p);
			pdfDocument.close();
			
			showMessage("Se creo el pdf correctamente!");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}

}//Fin de GUI_Print
