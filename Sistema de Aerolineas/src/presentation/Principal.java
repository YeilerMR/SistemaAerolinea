package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class Principal extends JFrame {
	
	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);

	private JPanel contentPane;
	private JButton bLogIn;
	private JButton bSignIn;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBLogIn());
		contentPane.add(getBSignIn());
		
		setVisible(true);
	}

	public JButton getBLogIn() {
		if (bLogIn == null) {
			bLogIn = new JButton("Iniciar sesion");
			bLogIn.setForeground(Color.WHITE);
			bLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
			bLogIn.setFocusPainted(false);
			bLogIn.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bLogIn.setBackground(BUTTON_GREEN);
			bLogIn.setBounds(146, 85, 109, 35);
		}
		return bLogIn;
	}
	public JButton getBSignIn() {
		if (bSignIn == null) {
			bSignIn = new JButton("Ingresar Usuario");
			bSignIn.setForeground(Color.WHITE);
			bSignIn.setFont(new Font("Tahoma", Font.BOLD, 15));
			bSignIn.setFocusPainted(false);
			bSignIn.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bSignIn.setBackground(BUTTON_GREEN);
			bSignIn.setBounds(116, 156, 170, 35);
		}
		return bSignIn;
	}
}
