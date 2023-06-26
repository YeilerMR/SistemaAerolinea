package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import data.FilesXML;
import data.LogicXML;
import domain.User;
import presentation.Login;

public class ControllerLogIn implements ActionListener {

	// Declaración de instancias de clases y variables
	private final Login logIn;
	private final FilesXML fXML;
	private final LogicXML logicXML;

	public ControllerLogIn() {
		// Inicializo Instancias
		logIn = new Login();
		fXML = new FilesXML();
		logicXML = new LogicXML();


		fXML.createXML("Users", "Users.xml");

		//create admin user

		logicXML.createAdminUser();

		initializerAction();
	}

	public void initializerAction() {
		logIn.getBLogin().addActionListener(this);

		logIn.getLbForgot().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "Lo siento, esta opcion no esta disponible");
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == logIn.getBLogin()) {
			String username = logIn.getTxtNombreDeUsuario().getText();
			String password = new String(logIn.getPasswordField().getPassword());

			User user = fXML.getUserInfo("Users.xml", "Users", username);

			if (user != null && user.getPassword().equals(password)) {
				if (user.getState().equals(" Activo")) {
					String message = "";
					switch (user.getType()) {
						case " Colaborador":
							message = "Bienvenido, colaborador ";
							break;
						case " Administrador":
							message = "Bienvenido, administrador ";
							break;
						default:
							break;
					}
					JOptionPane.showMessageDialog(null, message);
				} else {
					JOptionPane.showMessageDialog(null, "El usuario está inactivo.");
				}
				//System.out.println("Entro al e.get del login");
				new Controller_Main(user);
				//logIn.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "El usuario o la contraseña son incorrectos.");
			}
		}
	}
}