package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JButton bLogIn;
	private JButton bSignIn;

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.add(getBLogIn());
		contentPane.add(getBSignIn());
		
		setVisible(true);
	}

	public JButton getBLogIn() {
		if (bLogIn == null) {
			bLogIn = new JButton("Iniciar sesion");
		}
		return bLogIn;
	}
	public JButton getBSignIn() {
		if (bSignIn == null) {
			bSignIn = new JButton("Ingresar Usuario");
		}
		return bSignIn;
	}
}
