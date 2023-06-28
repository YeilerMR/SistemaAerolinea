package presentation;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import data.LogicXML;
import domain.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class GUI_Model extends JFrame{

	private static final Color BUTTON_GREEN = new Color(35, 134, 54);
	private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
	
	private JPanel contentPane;
	private JLabel lNombre;
	private JTextField txtNombre;
	private JLabel lGestionM;
	
	private JButton bAdd;
	private JButton bModify;
	private JButton bDelete;
	private JButton bConsult;
	
	private JLabel lBrands;
	private JLabel lseatsBClass;
	private JLabel lseatsTClass;
	private JLabel lseatsEconomic;
	private JLabel lInfo;
	
	//bussiness class
	private JTextField txtBClass;
	//turist class
	private JTextField txtTClass;
	//economic class
	private JTextField txtEconomic;
	
	private LogicXML lXML;
	
	private DefaultTableModel dtmModel;
	private JScrollPane scpModel;
	private JTable tModel;
	
	private String [][] dataModels;
	//public String []columnName;
	private JComboBox comboBrands;
	private JLabel lNew;
	private JTextField txtNew;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public GUI_Model(User user) {
		
		lXML= new LogicXML();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 868, 542);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.setBackground(BACKGROUND_COLOR);
		setLocationRelativeTo(null);
		
		if (lXML.checkTypeUser(user)) {
			contentPane.add(getBModify());
			contentPane.add(getBDelete());
			
			contentPane.add(getLNew());
			contentPane.add(getTxtNew());
		}

		setDTMModel(dataModels,getColumnsName());
		setTModel(dtmModel);
		setSCPModel(tModel);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLNombre());
		contentPane.add(getTxtNombre());
		contentPane.add(getLGestionM());
		contentPane.add(getBAdd());
		
		contentPane.add(getBConsult());
		contentPane.add(getLBrands());
		contentPane.add(getLseatsBClass());
		contentPane.add(getLseatsTClass());
		contentPane.add(getLseatsEconomic());
		contentPane.add(getTxtBClass());
		contentPane.add(getTxtTClass());
		contentPane.add(getTxtEconomic());
		contentPane.add(getSCPModel());
		contentPane.add(getLInfo());
		
		contentPane.add(getComboBrands());
		
		setVisible(true);
	}

	public JLabel getLNombre() {
		if (lNombre == null) {
			lNombre = new JLabel("Nombre: ");
			lNombre.setForeground(new Color(255, 255, 255));
			lNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNombre.setBounds(54, 78, 119, 45);
		}
		return lNombre;
	}
	public JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBackground(new Color(41, 90, 45));
			txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNombre.setForeground(new Color(255, 255, 255));
			txtNombre.setBounds(141, 80, 119, 45);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Modelos");
			lGestionM.setForeground(new Color(255, 255, 255));
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 18));
			lGestionM.setBounds(272, 10, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			
			bAdd.setForeground(Color.WHITE);
			bAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
			bAdd.setFocusPainted(false);
			bAdd.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bAdd.setBackground(BUTTON_GREEN);
			
			bAdd.setBounds(54, 406, 119, 30);
		}
		return bAdd;
	}
//	.setForeground(Color.WHITE);
//	.setFont(new Font("Tahoma", Font.BOLD, 15));
//	.setFocusPainted(false);
//	.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
//	.setBackground(BUTTON_GREEN);

	
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");

			bModify.setForeground(Color.WHITE);
			bModify.setFont(new Font("Tahoma", Font.BOLD, 15));
			bModify.setFocusPainted(false);
			bModify.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bModify.setBackground(BUTTON_GREEN);

			bModify.setBounds(187, 406, 119, 30);
		}
		return bModify;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			
			bDelete.setForeground(Color.WHITE);
			bDelete.setFont(new Font("Tahoma", Font.BOLD, 15));
			bDelete.setFocusPainted(false);
			bDelete.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bDelete.setBackground(BUTTON_GREEN);
			
			bDelete.setBounds(187, 465, 119, 30);
		}
		return bDelete;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			
			bConsult.setForeground(Color.WHITE);
			bConsult.setFont(new Font("Tahoma", Font.BOLD, 15));
			bConsult.setFocusPainted(false);
			bConsult.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bConsult.setBackground(BUTTON_GREEN);
			
			bConsult.setBounds(316, 406, 119, 30);
		}
		return bConsult;
	}
	
	public JLabel getLBrands() {
		if (lBrands == null) {
			lBrands = new JLabel("Marcas:");
			lBrands.setForeground(new Color(255, 255, 255));
			lBrands.setFont(new Font("Tahoma", Font.BOLD, 15));
			lBrands.setBounds(54, 133, 119, 45);
		}
		return lBrands;
	}
	public JLabel getLseatsBClass() {
		if (lseatsBClass == null) {
			lseatsBClass = new JLabel("Asientos clase ejecutivo:");
			lseatsBClass.setForeground(new Color(255, 255, 255));
			lseatsBClass.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsBClass.setBounds(54, 188, 193, 45);
		}
		return lseatsBClass;
	}
	public JLabel getLseatsTClass() {
		if (lseatsTClass == null) {
			lseatsTClass = new JLabel("Asientos clase Turista:");
			lseatsTClass.setForeground(new Color(255, 255, 255));
			lseatsTClass.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsTClass.setBounds(54, 243, 193, 45);
		}
		return lseatsTClass;
	}
	public JLabel getLseatsEconomic() {
		if (lseatsEconomic == null) {
			lseatsEconomic = new JLabel("Asientos Economicos:");
			lseatsEconomic.setForeground(new Color(255, 255, 255));
			lseatsEconomic.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsEconomic.setBounds(54, 298, 193, 45);
		}
		return lseatsEconomic;
	}
	public JTextField getTxtBClass() {
		if (txtBClass == null) {
			txtBClass = new JTextField();
			txtBClass.setBackground(new Color(41, 90, 45));
			txtBClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtBClass.setForeground(new Color(255, 255, 255));
			txtBClass.setColumns(10);
			txtBClass.setBounds(295, 188, 119, 45);
		}
		return txtBClass;
	}
	public JTextField getTxtTClass() {
		if (txtTClass == null) {
			txtTClass = new JTextField();
			txtTClass.setForeground(new Color(255, 255, 255));
			txtTClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTClass.setBackground(new Color(41, 90, 45));
			txtTClass.setColumns(10);
			txtTClass.setBounds(295, 243, 119, 45);
		}
		return txtTClass;
	}
	public JTextField getTxtEconomic() {
		if (txtEconomic == null) {
			txtEconomic = new JTextField();
			txtEconomic.setBackground(new Color(41, 90, 45));
			txtEconomic.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtEconomic.setForeground(new Color(255, 255, 255));
			txtEconomic.setColumns(10);
			txtEconomic.setBounds(295, 298, 119, 45);
		}
		return txtEconomic;
	}

	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Tabla de Informacion");
			lInfo.setForeground(new Color(255, 255, 255));
			lInfo.setFont(new Font("Tahoma", Font.BOLD, 15));
			lInfo.setBounds(579, 78, 179, 45);
		}
		return lInfo;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void clearForm() {
		txtNombre.setText("");
		txtBClass.setText("");
		txtTClass.setText("");
		txtEconomic.setText("");
		comboBrands.setSelectedIndex(0);
		txtNew.setText("");
		//fillComboBox(null);
	}//limpia formulario
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setDTMModel(String[][]dataModels,String[]columnName) {
		
		dtmModel= new DefaultTableModel(dataModels,columnName);
	}
	public DefaultTableModel getDTMModel() {
		return this.dtmModel;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setSCPModel(JTable tModel) {
		
		scpModel = new JScrollPane(tModel);
		scpModel.setBounds(475, 149, 369, 193);
		scpModel.setViewportView(getTModel());
	}
	public JScrollPane getSCPModel() {
		return this.scpModel;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public void setTModel(DefaultTableModel dtmModel) {
		tModel= new JTable(dtmModel);
		tModel.setEnabled(false);
		tModel.getTableHeader().setReorderingAllowed(false);
		tModel.getTableHeader().setResizingAllowed(false);
	}
	public JTable getTModel() {
		return this.tModel;
	}
	//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	public String[]getColumnsName(){
		String columnsName[]= {"Nombre","Marca","C. Ejecutiva",
								"C. Turista","C. Económico"};
		return columnsName;
	}
	public JComboBox getComboBrands() {
		if (comboBrands == null) {
			comboBrands = new JComboBox();
			comboBrands.setBackground(new Color(41, 90, 45));
			comboBrands.setFont(new Font("Tahoma", Font.PLAIN, 14));
			comboBrands.setForeground(new Color(255, 255, 255));
			comboBrands.setBounds(295, 133, 119, 30);
		}
		return comboBrands;
	}
	public JLabel getLNew() {
		if (lNew == null) {
			lNew = new JLabel("Nuevo:");
			lNew.setForeground(new Color(255, 255, 255));
			lNew.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNew.setBounds(316, 78, 119, 45);
		}
		return lNew;
	}
	public JTextField getTxtNew() {
		if (txtNew == null) {
			txtNew = new JTextField();
			txtNew.setForeground(new Color(255, 255, 255));
			txtNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtNew.setBackground(new Color(41, 90, 45));
			txtNew.setColumns(10);
			txtNew.setBounds(393, 80, 119, 45);
		}
		return txtNew;
	}
	public void fillComboBox(ArrayList<String> brands) {
		comboBrands.addItem("Vacio");
		for (String brand : brands) {
			comboBrands.addItem(brand);
		}
	}
}
