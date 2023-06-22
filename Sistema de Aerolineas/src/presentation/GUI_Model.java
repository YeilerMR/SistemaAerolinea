package presentation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class GUI_Model extends JFrame implements ActionListener{

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
			lNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNombre.setBounds(54, 78, 119, 45);
		}
		return lNombre;
	}
	public JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setBounds(141, 80, 119, 45);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}
	public JLabel getLGestionM() {
		if (lGestionM == null) {
			lGestionM = new JLabel("Gestion de Modelos");
			lGestionM.setFont(new Font("Tahoma", Font.BOLD, 15));
			lGestionM.setBounds(141, 23, 187, 45);
		}
		return lGestionM;
	}
	public JButton getBAdd() {
		if (bAdd == null) {
			bAdd = new JButton("Agregar");
			bAdd.addActionListener(this);
			bAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bAdd.setBounds(54, 406, 119, 30);
		}
		return bAdd;
	}

	
	public JButton getBModify() {
		if (bModify == null) {
			bModify = new JButton("Modificar");
			bModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bModify.setBounds(187, 406, 119, 30);
		}
		return bModify;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bDelete.setBounds(187, 465, 119, 30);
		}
		return bDelete;
	}
	public JButton getBConsult() {
		if (bConsult == null) {
			bConsult = new JButton("Consultar");
			bConsult.setFont(new Font("Tahoma", Font.PLAIN, 15));
			bConsult.setBounds(316, 406, 119, 30);
		}
		return bConsult;
	}
	
	public JLabel getLBrands() {
		if (lBrands == null) {
			lBrands = new JLabel("Marcas:");
			lBrands.setFont(new Font("Tahoma", Font.BOLD, 15));
			lBrands.setBounds(54, 133, 119, 45);
		}
		return lBrands;
	}
	public JLabel getLseatsBClass() {
		if (lseatsBClass == null) {
			lseatsBClass = new JLabel("Asientos clase ejecutivo:");
			lseatsBClass.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsBClass.setBounds(54, 188, 193, 45);
		}
		return lseatsBClass;
	}
	public JLabel getLseatsTClass() {
		if (lseatsTClass == null) {
			lseatsTClass = new JLabel("Asientos clase Turista:");
			lseatsTClass.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsTClass.setBounds(54, 243, 193, 45);
		}
		return lseatsTClass;
	}
	public JLabel getLseatsEconomic() {
		if (lseatsEconomic == null) {
			lseatsEconomic = new JLabel("Asientos Economicos:");
			lseatsEconomic.setFont(new Font("Tahoma", Font.BOLD, 15));
			lseatsEconomic.setBounds(54, 298, 193, 45);
		}
		return lseatsEconomic;
	}
	public JTextField getTxtBClass() {
		if (txtBClass == null) {
			txtBClass = new JTextField();
			txtBClass.setColumns(10);
			txtBClass.setBounds(295, 188, 119, 45);
		}
		return txtBClass;
	}
	public JTextField getTxtTClass() {
		if (txtTClass == null) {
			txtTClass = new JTextField();
			txtTClass.setColumns(10);
			txtTClass.setBounds(295, 243, 119, 45);
		}
		return txtTClass;
	}
	public JTextField getTxtEconomic() {
		if (txtEconomic == null) {
			txtEconomic = new JTextField();
			txtEconomic.setColumns(10);
			txtEconomic.setBounds(295, 298, 119, 45);
		}
		return txtEconomic;
	}

	public JLabel getLInfo() {
		if (lInfo == null) {
			lInfo = new JLabel("Tabla de Informacion");
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
			comboBrands.setBounds(295, 133, 119, 30);
		}
		return comboBrands;
	}
	public JLabel getLNew() {
		if (lNew == null) {
			lNew = new JLabel("Nuevo:");
			lNew.setFont(new Font("Tahoma", Font.BOLD, 15));
			lNew.setBounds(316, 78, 119, 45);
		}
		return lNew;
	}
	public JTextField getTxtNew() {
		if (txtNew == null) {
			txtNew = new JTextField();
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

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
}
