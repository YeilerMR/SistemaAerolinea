package presentation;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.FlowLayout;

public class SignIn extends JFrame {

	private JPanel contentPane;
	
    // Constantes para las dimensiones y colores de los componentes
    private static final int FRAME_WIDTH = 830;
    private static final int FRAME_HEIGHT = 500;
    private static final Color BACKGROUND_COLOR = new Color(12, 16, 22);
    private static final Color DECORATED_BAR_COLOR = Color.BLACK;
    private static final Color BUTTON_HOVER_COLOR = new Color(55, 55, 55);
    private static final Color BUTTON_DEFAULT_COLOR = Color.BLACK;
    private static final Color LIGHTER_BACKGROUND = new Color(21, 26, 33);
    private static final Color BUTTON_GREEN = new Color(35, 134, 54);
    private static final Color BUTTON_GREEN_SELECTED = new Color(46, 160, 67);
    
    
    
    private int initialX;
    private int initialY;
    private boolean isFullScreen = false;
    private int originalWidth;
    private int originalHeight;
    private boolean isMousePressed = false;

    // Constantes para las rutas de las imágenes
    private static final String CLOSE_IMAGE_PATH = "/close.png";
    private static final String MINIMIZE_IMAGE_PATH = "/minus.png";
    private static final String EXPAND_IMAGE_PATH = "/expand.png";
    private static final String PLANE_IMAGE_PATH_16px = "/plane16.png";
    private static final String PLANE_IMAGE_PATH_32px = "/plane32.png";
    private static final String USER_W_IMAGE_PATH_16px = "/user16W.png";
    private static final String LOCK_W_IMAGE_PATH_16px = "/lock16W.png";
    private JPanel decoratedBarPanel;
    private JPanel rightPanel;
    private JPanel closeButtonPanel;
    private JLabel closeButton;
    private JPanel minimizeButtonPanel;
    private JLabel minimizeButton;
    private JPanel leftPanel;
    private JLabel lbLogo;
    private JPanel mainContentPanel;
    private JLabel lbTitle;
    private JPanel pPrincipal;
    private JPanel pUser;
    private JTextField tfUser;
    private JPanel pPassword;
    private JTextField tfPassword;
    private JButton bRegister;
    private JTextArea taTip;
    private JButton bSearch;
    private JButton bEdit;
    private JLabel lbUser;
    private JLabel lbPassword;
    private JPanel pType;
    private JComboBox cbType;
    private JPanel pStatus;
    private JComboBox cbStatus;
    private JLabel lbType;
    private JLabel lbStatus;
    private JButton bDelete;
    private JPanel pActions;
    private Component horizontalStrut_1;
    private Component horizontalStrut_2;
    private Component horizontalStrut_3;
	

	public SignIn() {
		
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
        setLocationRelativeTo(null); // Esto centra la ventana en la pantalla

        contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getDecoratedBarPanel(), BorderLayout.NORTH);
		contentPane.setBorder(new LineBorder(Color.BLACK));
		contentPane.add(getMainContentPanel(), BorderLayout.CENTER);
		
		setVisible(true);
	}

	private JPanel getDecoratedBarPanel() {
		if (decoratedBarPanel == null) {
			decoratedBarPanel = new JPanel();
			decoratedBarPanel.setPreferredSize(new Dimension(730, 40));
			decoratedBarPanel.setBorder(new LineBorder(new Color(30, 30, 30)));
			decoratedBarPanel.setBackground(Color.BLACK);
			decoratedBarPanel.setLayout(new BorderLayout(0, 0));
			decoratedBarPanel.add(getRightPanel(), BorderLayout.EAST);
			decoratedBarPanel.add(getLeftPanel(), BorderLayout.WEST);
			
			 decoratedBarPanel.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mousePressed(MouseEvent e) {
		                initialX = e.getXOnScreen();
		                initialY = e.getYOnScreen();
		                if (isFullScreen) {
		                    setExtendedState(JFrame.NORMAL);
		                    setSize(originalWidth, originalHeight);
		                    isFullScreen = false;
		                }
		                isMousePressed = true;
		            }

		            @Override
		            public void mouseReleased(MouseEvent e) {
		                isMousePressed = false;
		            }
		        });
		        decoratedBarPanel.addMouseMotionListener(new MouseMotionAdapter() {
		            @Override
		            public void mouseDragged(MouseEvent e) {
		                if (isMousePressed) {
		                    int currentX = e.getXOnScreen();
		                    int currentY = e.getYOnScreen();
		                    int dX = currentX - initialX;
		                    int dY = currentY - initialY;
		                    setLocation(getX() + dX, getY() + dY);
		                    initialX = currentX;
		                    initialY = currentY;
		                }
		            }
		        });
			
		}
		return decoratedBarPanel;
	}
	private JPanel getRightPanel() {
		if (rightPanel == null) {
			rightPanel = new JPanel();
			rightPanel.setPreferredSize(new Dimension(80, 80));
			rightPanel.setBorder(null);
			rightPanel.setBackground(Color.BLACK);
			rightPanel.setLayout(new BorderLayout(0, 0));
			rightPanel.add(getCloseButtonPanel(), BorderLayout.EAST);
			rightPanel.add(getMinimizeButtonPanel(), BorderLayout.WEST);
		}
		return rightPanel;
	}
	private JPanel getCloseButtonPanel() {
		if (closeButtonPanel == null) {
			closeButtonPanel = new JPanel();
			closeButtonPanel.setPreferredSize(new Dimension(40, 40));
			closeButtonPanel.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new LineBorder(BUTTON_HOVER_COLOR)));
			closeButtonPanel.setBackground(Color.BLACK);
			closeButtonPanel.setLayout(new BorderLayout(0, 0));
			closeButtonPanel.add(getCloseButton(), BorderLayout.CENTER);
		}
		return closeButtonPanel;
	}
	private JLabel getCloseButton() {
		if (closeButton == null) {
			closeButton = new JLabel("");
	        closeButton.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                changeColor(closeButtonPanel, BUTTON_HOVER_COLOR);
	            }

	            @Override
	            public void mouseClicked(MouseEvent e) {
	                System.exit(0);
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                changeColor(closeButtonPanel, BUTTON_DEFAULT_COLOR);
	            }
	        });
	        closeButton.setHorizontalAlignment(SwingConstants.CENTER);
	        Image closeImage = new ImageIcon(this.getClass().getResource(CLOSE_IMAGE_PATH)).getImage();
	        closeButton.setIcon(new ImageIcon(closeImage));
		}
		return closeButton;
	}

	private JLabel getMinimizeButton() {
		if (minimizeButton == null) {
			
			minimizeButton = new JLabel("");
		    minimizeButton.addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseEntered(MouseEvent e) {
		                changeColor(minimizeButtonPanel, BUTTON_HOVER_COLOR);
		            }

		            @Override
		            public void mouseClicked(MouseEvent e) {
		                SignIn.this.setState(JFrame.ICONIFIED);
		            }

		            @Override
		            public void mouseExited(MouseEvent e) {
		                changeColor(minimizeButtonPanel, BUTTON_DEFAULT_COLOR);
		            }
		        });
		        minimizeButton.setHorizontalAlignment(SwingConstants.CENTER);
		        Image minimizeImage = new ImageIcon(this.getClass().getResource(MINIMIZE_IMAGE_PATH)).getImage();
		        minimizeButton.setIcon(new ImageIcon(minimizeImage));
		}
		return minimizeButton;
	}
	
	private JPanel getMinimizeButtonPanel() {
		if (minimizeButtonPanel == null) {
			minimizeButtonPanel = new JPanel();
			minimizeButtonPanel.setPreferredSize(new Dimension(40, 40));
			minimizeButtonPanel.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new LineBorder(BUTTON_HOVER_COLOR)));
			minimizeButtonPanel.setBackground(Color.BLACK);
			minimizeButtonPanel.setLayout(new BorderLayout(0, 0));
			minimizeButtonPanel.add(getMinimizeButton(), BorderLayout.CENTER);
		}
		return minimizeButtonPanel;
	}
    
	
	private JPanel getLeftPanel() {
		if (leftPanel == null) {
			
			leftPanel = new JPanel();
	        leftPanel.setBackground(Color.BLACK);
	        leftPanel.setBorder(null);
	        leftPanel.setPreferredSize(new Dimension(605, 125));
	        
	        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
	        
	        Component horizontalStrut = Box.createHorizontalStrut(15);
	        leftPanel.add(horizontalStrut);
	        leftPanel.add(getLbLogo());
			
		}
		return leftPanel;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("");
	        lbLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
	        lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
	        Image image = new ImageIcon(this.getClass().getResource(PLANE_IMAGE_PATH_16px)).getImage();
	        lbLogo.setIcon(new ImageIcon(image));
		}
		return lbLogo;
	}
	private JPanel getMainContentPanel() {
		if (mainContentPanel == null) {
			mainContentPanel = new JPanel();
			mainContentPanel.setBackground(BACKGROUND_COLOR);
			mainContentPanel.setLayout(null);
			mainContentPanel.add(getLbTitle());
			mainContentPanel.add(getPPrincipal());
			mainContentPanel.add(getPActions());
		}
		return mainContentPanel;
	}
	
	///////////////
	
    private void toggleFullScreen() {
        if (!isFullScreen) {
            originalWidth = getWidth();
            originalHeight = getHeight();
            setExtendedState(JFrame.MAXIMIZED_BOTH);
            isFullScreen = true;
        } else {
            setExtendedState(JFrame.NORMAL);
            setSize(originalWidth, originalHeight);
            isFullScreen = false;
        }
    }
    
    private void changeColor(Component component, Color color) {
        component.setBackground(color);
    }
	private JLabel getLbTitle() {
		if (lbTitle == null) {
			lbTitle = new JLabel("Sistema de registro de usuarios");
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setForeground(Color.WHITE);
			lbTitle.setFont(new Font("Calibri", Font.BOLD, 20));
			lbTitle.setBackground(new Color(230, 237, 243));
			lbTitle.setBounds(194, 50, 440, 25);
		}
		return lbTitle;
	}
	private JPanel getPPrincipal() {
		if (pPrincipal == null) {
			pPrincipal = new JPanel();
			pPrincipal.setLayout(null);
			pPrincipal.setBorder(new LineBorder(BUTTON_HOVER_COLOR));
			pPrincipal.setBackground(new Color(21, 26, 33));
			pPrincipal.setBounds(51, 110, 725, 208);
			pPrincipal.add(getPUser());
			pPrincipal.add(getPPassword());
			pPrincipal.add(getLbUser());
			pPrincipal.add(getLbPassword());
			pPrincipal.add(getPType());
			pPrincipal.add(getPStatus());
			pPrincipal.add(getLbType());
			pPrincipal.add(getLbStatus());
		}
		return pPrincipal;
	}
	private JPanel getPUser() {
		if (pUser == null) {
			pUser = new JPanel();
			pUser.setLayout(null);
			pUser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(64, 64, 64)));
			pUser.setBackground(new Color(21, 26, 33));
			pUser.setBounds(25, 55, 315, 35);
			pUser.add(getTfUser());
		}
		return pUser;
	}
	public JTextField getTfUser() {
	    if (tfUser == null) {
	        tfUser = new JTextField();
	        
	        tfUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        tfUser.setForeground(Color.WHITE);
	        tfUser.setHorizontalAlignment(SwingConstants.LEFT);
	        tfUser.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
	        tfUser.setBackground(LIGHTER_BACKGROUND);
	        
	        tfUser.setBounds(0, 3, 315, 30);
	    }
	    return tfUser;
	}

	private JPanel getPPassword() {
		if (pPassword == null) {
			pPassword = new JPanel();
			pPassword.setLayout(null);
			pPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
			pPassword.setBackground(new Color(21, 26, 33));
			pPassword.setBounds(25, 140, 315, 35);
			pPassword.add(getTfPassword());
		}
		return pPassword;
	}
	public JTextField getTfPassword() {
		if (tfPassword == null) {
			tfPassword = new JTextField();
			tfPassword.setHorizontalAlignment(SwingConstants.LEFT);
			tfPassword.setForeground(Color.WHITE);
			tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			tfPassword.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
			tfPassword.setBackground(new Color(21, 26, 33));
			tfPassword.setBounds(0, 3, 315, 30);
		}
		return tfPassword;
	}
	public JButton getBRegister() {
		if (bRegister == null) {
			bRegister = new JButton("Registrar");
			bRegister.setForeground(Color.WHITE);
			bRegister.setFont(new Font("Calibri", Font.BOLD, 17));
			bRegister.setFocusPainted(false);
			bRegister.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bRegister.setBackground(BUTTON_GREEN);
			bRegister.setPreferredSize(new Dimension(175, 50));

			 // Desactivar el efecto de enfoque
	        bRegister.setFocusPainted(false);

	        bRegister.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Cambiar el estilo del botón cuando el mouse entra en él
	                bRegister.setBackground(BUTTON_GREEN_SELECTED); // Puedes elegir el color que desees
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer el estilo del botón cuando el mouse sale de él
	                bRegister.setBackground(BUTTON_GREEN); // Restablece el color original
	            }
	        });
			
		}
		return bRegister;
	}
	private JTextArea getTaTip() {
		if (taTip == null) {
			taTip = new JTextArea();
			taTip.setWrapStyleWord(true);
			taTip.setEditable(false);
			taTip.setFocusable(false); // Desactivar la selección de texto
			taTip.setBounds(0, 0, 438, 68);
			taTip.setText("Por motivos de seguridad y control, es imprescindible que inicies sesión como administrador para gestionar usuarios.");
			taTip.setTabSize(0);
			taTip.setLineWrap(true);
			taTip.setForeground(Color.WHITE);
			taTip.setFont(new Font("Tahoma", Font.PLAIN, 11));
			taTip.setBorder(new EmptyBorder(20, 25, 15, 25));
			taTip.setBackground(new Color(21, 26, 33));
		}
		return taTip;
	}
	public JButton getBSearch() {
		if (bSearch == null) {
			bSearch = new JButton("Buscar");
			bSearch.setForeground(Color.WHITE);
			bSearch.setFont(new Font("Calibri", Font.BOLD, 17));
			bSearch.setFocusPainted(false);
			bSearch.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bSearch.setBackground(new Color(35, 134, 54));
			bSearch.setPreferredSize(new Dimension(175, 50));

			 // Desactivar el efecto de enfoque
	        bSearch.setFocusPainted(false);

	        bSearch.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Cambiar el estilo del botón cuando el mouse entra en él
	                bSearch.setBackground(BUTTON_GREEN_SELECTED); // Puedes elegir el color que desees
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer el estilo del botón cuando el mouse sale de él
	                bSearch.setBackground(BUTTON_GREEN); // Restablece el color original
	            }
	        });

		}
		return bSearch;
	}
	public JButton getBEdit() {
		if (bEdit == null) {
			bEdit = new JButton("Editar");
			bEdit.setForeground(Color.WHITE);
			bEdit.setFont(new Font("Calibri", Font.BOLD, 17));
			bEdit.setFocusPainted(false);
			bEdit.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bEdit.setBackground(new Color(35, 134, 54));
			bEdit.setPreferredSize(new Dimension(175, 50));

			 // Desactivar el efecto de enfoque
	        bEdit.setFocusPainted(false);

	        bEdit.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Cambiar el estilo del botón cuando el mouse entra en él
	                bEdit.setBackground(BUTTON_GREEN_SELECTED); // Puedes elegir el color que desees
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer el estilo del botón cuando el mouse sale de él
	                bEdit.setBackground(BUTTON_GREEN); // Restablece el color original
	            }
	        });

		}
		return bEdit;
	}
	public JLabel getLbUser() {
		if (lbUser == null) {
			lbUser = new JLabel("Nombre de usuario");
			lbUser.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbUser.setForeground(Color.WHITE);
			lbUser.setBounds(25, 30, 131, 14);
		}
		return lbUser;
	}
	public JLabel getLbPassword() {
		if (lbPassword == null) {
			lbPassword = new JLabel("Contraseña");
			lbPassword.setForeground(Color.WHITE);
			lbPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbPassword.setBounds(25, 116, 131, 14);
		}
		return lbPassword;
	}
	public JPanel getPType() {
		if (pType == null) {
			pType = new JPanel();
			pType.setLayout(null);
			pType.setBorder(null);
			pType.setBackground(new Color(21, 26, 33));
			pType.setBounds(385, 55, 315, 35);
			pType.add(getCbType());
		}
		return pType;
	}
	public JComboBox getCbType() {
		if (cbType == null) {
			cbType = new JComboBox();
			cbType.setForeground(Color.WHITE);
			cbType.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbType.setBorder(null);
			cbType.setBackground(new Color(21, 26, 33));
			cbType.setBounds(0, 3, 315, 30);
			cbType.addItem(" Colaborador");
			cbType.addItem(" Administrador");
			
		}
		return cbType;
	}
	public JPanel getPStatus() {
		if (pStatus == null) {
			pStatus = new JPanel();
			pStatus.setLayout(null);
			pStatus.setBorder(null);
			pStatus.setBackground(new Color(21, 26, 33));
			pStatus.setBounds(385, 140, 315, 35);
			pStatus.add(getCbStatus());
		}
		return pStatus;
	}
	public JComboBox getCbStatus() {
		if (cbStatus == null) {
			cbStatus = new JComboBox();
			cbStatus.setForeground(Color.WHITE);
			cbStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
			cbStatus.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
			cbStatus.setBackground(new Color(21, 26, 33));
			cbStatus.setBounds(0, 3, 315, 30);
			cbStatus.addItem(" Activo");
			cbStatus.addItem(" Inactivo");
		}
		return cbStatus;
	}
	public JLabel getLbType() {
		if (lbType == null) {
			lbType = new JLabel("Tipo de usuario");
			lbType.setForeground(Color.WHITE);
			lbType.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbType.setBounds(385, 30, 131, 14);
		}
		return lbType;
	}
	public JLabel getLbStatus() {
		if (lbStatus == null) {
			lbStatus = new JLabel("Estado");
			lbStatus.setForeground(Color.WHITE);
			lbStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbStatus.setBounds(385, 116, 131, 14);
		}
		return lbStatus;
	}
	public JButton getBDelete() {
		if (bDelete == null) {
			bDelete = new JButton("Eliminar");
			bDelete.setForeground(Color.WHITE);
			bDelete.setFont(new Font("Calibri", Font.BOLD, 17));
			bDelete.setFocusPainted(false);
			bDelete.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bDelete.setBackground(new Color(35, 134, 54));
			bDelete.setPreferredSize(new Dimension(175, 50));
			
			bDelete.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Cambiar el estilo del botón cuando el mouse entra en él
	                bDelete.setBackground(BUTTON_GREEN_SELECTED); // Cambia el color de fondo
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer el estilo del botón cuando el mouse sale de él
	                bDelete.setBackground(BUTTON_GREEN); // Cambia el color de fondo
	            }
	        });

		}
		return bDelete;
	}

	public void clearFields() {
		tfUser.setText("");
		tfPassword.setText("");
		cbType.setSelectedIndex(0);
		cbStatus.setSelectedIndex(0);
		tfUser.requestFocus();
	}
	public JPanel getPActions() {
		if (pActions == null) {
			pActions = new JPanel();
			pActions.setBackground(BACKGROUND_COLOR);
			pActions.setBounds(51, 350, 725, 50);
			pActions.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
			pActions.add(getBRegister());
			pActions.add(getHorizontalStrut_1());
			pActions.add(getBSearch());
			pActions.add(getHorizontalStrut_2());
			pActions.add(getBEdit());
			pActions.add(getHorizontalStrut_3());
			pActions.add(getBDelete());
		}
		return pActions;
	}
	public Component getHorizontalStrut_1() {
		if (horizontalStrut_1 == null) {
			horizontalStrut_1 = Box.createHorizontalStrut(8);
		}
		return horizontalStrut_1;
	}
	public Component getHorizontalStrut_2() {
		if (horizontalStrut_2 == null) {
			horizontalStrut_2 = Box.createHorizontalStrut(8);
		}
		return horizontalStrut_2;
	}
	public Component getHorizontalStrut_3() {
		if (horizontalStrut_3 == null) {
			horizontalStrut_3 = Box.createHorizontalStrut(8);
		}
		return horizontalStrut_3;
	}
}
