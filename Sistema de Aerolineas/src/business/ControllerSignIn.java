package business;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import data.FilesXML;
import data.LogicXML;
import domain.User;
import presentation.SignIn;

public class ControllerSignIn implements ActionListener {

	// Declaración de instancias de clases y variables
	private SignIn signIn;
	private FilesXML filesXML;
	private LogicXML logicXML;
	private final String USER_NOT_FOUND_MESSAGE = "El usuario no existe.";

	public ControllerSignIn() {

		// Inicializo Instancias
		signIn = new SignIn();
		filesXML = new FilesXML();
		logicXML = new LogicXML();

		filesXML.createXML("Users", "Users.xml");

		//create admin user

		logicXML.createAdminUser();

		initializeActions();

	}

	public void initializeActions() {
		signIn.getBRegister().addActionListener(this);
		signIn.getBEdit().addActionListener(this);
		signIn.getBSearch().addActionListener(this);
		signIn.getBDelete().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == signIn.getBRegister()) {
			createOrUpdateUser(false);
		} else if (e.getSource() == signIn.getBEdit()) {
			createOrUpdateUser(true);
		} else if (e.getSource() == signIn.getBSearch()) {
			searchUser();
		} else if (e.getSource() == signIn.getBDelete()) {
			deleteUser();
		}
	}

private void createOrUpdateUser(boolean isUpdate) {
		User user = new User(signIn.getTfUser().getText(), signIn.getTfPassword().getText(),
				signIn.getCbType().getSelectedItem().toString(), signIn.getCbStatus().getSelectedItem().toString());

		boolean userExists = logicXML.checkUserExists("Users.xml", user.getUser());

		if (isUpdate) {
			if (userExists) {
				boolean success = filesXML.updateUser("Users.xml", "Users", user.getDataName(), user.getData());
				String message = success ? "El usuario ha sido actualizado exitosamente." : USER_NOT_FOUND_MESSAGE;
				JOptionPane.showMessageDialog(null, message);
				signIn.clearFields();
			} else {
				JOptionPane.showMessageDialog(null, USER_NOT_FOUND_MESSAGE);
			}
		} else {
			if (userExists) {
				JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe.");
			} else {
				filesXML.writeXML("Users.xml", "Users", user.getDataName(), user.getData());
				JOptionPane.showMessageDialog(null, "El usuario ha sido creado exitosamente.");
				signIn.clearFields();
			}
		}
	}

	private void searchUser() {			//FilePath	//elementType //data
		User user = filesXML.getUserInfo("Users.xml", "Users", signIn.getTfUser().getText());
		if (user != null) {
			signIn.getTfUser().setText(user.getUser());
			signIn.getTfPassword().setText(user.getPassword());
			signIn.getCbType().setSelectedItem(user.getType());
			signIn.getCbStatus().setSelectedItem(user.getState());

		} else {
			JOptionPane.showMessageDialog(null, USER_NOT_FOUND_MESSAGE);
		}
	}

	private void deleteUser() {

		boolean success = filesXML.deleteUser("Users.xml", "Users", signIn.getTfUser().getText());
		String message = success ? "El usuario ha sido eliminado exitosamente." : USER_NOT_FOUND_MESSAGE;
		signIn.clearFields();
		JOptionPane.showMessageDialog(null, message);

	}

}
