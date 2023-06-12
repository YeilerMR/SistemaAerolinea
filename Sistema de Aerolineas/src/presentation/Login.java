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

public class Login extends JFrame {

	private JPanel contentPane;
	
    // Constantes para las dimensiones y colores de los componentes
    private static final int FRAME_WIDTH = 730;
    private static final int FRAME_HEIGHT = 550;
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
    private JLabel icUser;
    private JTextField txtNombreDeUsuario;
    private JPanel pPassword;
    private JLabel lbForgot;
    private JLabel icPassword;
    private JPasswordField passwordField;
    private JButton bLogin;
    private JTextArea taTip;
    private JPanel pTip;
	

	public Login() {
		
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
		                Login.this.setState(JFrame.ICONIFIED);
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
			mainContentPanel.add(getPTip());
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
			lbTitle = new JLabel("Inicia sesión en tu cuenta");
			lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
			lbTitle.setForeground(Color.WHITE);
			lbTitle.setFont(new Font("Calibri", Font.BOLD, 20));
			lbTitle.setBackground(new Color(230, 237, 243));
			lbTitle.setBounds(144, 50, 440, 25);
		}
		return lbTitle;
	}
	private JPanel getPPrincipal() {
		if (pPrincipal == null) {
			pPrincipal = new JPanel();
			pPrincipal.setLayout(null);
			pPrincipal.setBorder(new LineBorder(BUTTON_HOVER_COLOR));
			pPrincipal.setBackground(new Color(21, 26, 33));
			pPrincipal.setBounds(144, 110, 440, 245);
			pPrincipal.add(getPUser());
			pPrincipal.add(getPPassword());
			pPrincipal.add(getBLogin());
		}
		return pPrincipal;
	}
	private JPanel getPUser() {
		if (pUser == null) {
			pUser = new JPanel();
			pUser.setLayout(null);
			pUser.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(64, 64, 64)));
			pUser.setBackground(new Color(21, 26, 33));
			pUser.setBounds(25, 35, 390, 35);
			pUser.add(getIcUser());
			pUser.add(getTxtNombreDeUsuario());
		}
		return pUser;
	}
	private JLabel getIcUser() {
		if (icUser == null) {
			icUser = new JLabel("");
			icUser.setBounds(10, 9, 16, 16);
	        Image user16 = new ImageIcon(this.getClass().getResource(USER_W_IMAGE_PATH_16px)).getImage();
	        icUser.setIcon(new ImageIcon(user16));
		}
		return icUser;
	}
	public JTextField getTxtNombreDeUsuario() {
	    if (txtNombreDeUsuario == null) {
	        txtNombreDeUsuario = new JTextField();
	        txtNombreDeUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
	        txtNombreDeUsuario.setForeground(Color.WHITE);
	        txtNombreDeUsuario.setHorizontalAlignment(SwingConstants.LEFT);
	        txtNombreDeUsuario.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
	        txtNombreDeUsuario.setBackground(LIGHTER_BACKGROUND);
	        txtNombreDeUsuario.setBounds(36, 3, 352, 30);
	    }
	    return txtNombreDeUsuario;
	}

	private JPanel getPPassword() {
		if (pPassword == null) {
			pPassword = new JPanel();
			pPassword.setLayout(null);
			pPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.DARK_GRAY));
			pPassword.setBackground(new Color(21, 26, 33));
			pPassword.setBounds(25, 105, 390, 35);
			pPassword.add(getLbForgot());
			pPassword.add(getIcPassword());
			pPassword.add(getPasswordField());
		}
		return pPassword;
	}
	public JLabel getLbForgot() {
		if (lbForgot == null) {
			lbForgot = new JLabel("Forgot password? ");
			lbForgot.setVerticalAlignment(SwingConstants.TOP);
			lbForgot.setHorizontalAlignment(SwingConstants.RIGHT);
			lbForgot.setForeground(new Color(35, 134, 54));
			lbForgot.setFont(new Font("Tahoma", Font.ITALIC, 13));
			lbForgot.setBounds(193, 10, 195, 25);
		}
		return lbForgot;
	}
	private JLabel getIcPassword() {
		if (icPassword == null) {
			icPassword = new JLabel("");
			icPassword.setBounds(10, 9, 16, 16);
	        Image lock16 = new ImageIcon(this.getClass().getResource(LOCK_W_IMAGE_PATH_16px)).getImage();
	        icPassword.setIcon(new ImageIcon(lock16));
		}
		return icPassword;
	}
	public JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setHorizontalAlignment(SwingConstants.LEFT);
			passwordField.setForeground(Color.WHITE);
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 13));
			passwordField.setBorder(new CompoundBorder(new LineBorder(new Color(145, 145, 145), 0), new EmptyBorder(0, 0, 0, 5)));
			passwordField.setBackground(new Color(21, 26, 33));
			passwordField.setBounds(36, 3, 243, 30);
		}
		return passwordField;
	}
	public JButton getBLogin() {
		if (bLogin == null) {
			bLogin = new JButton("Iniciar sesión");
			bLogin.setForeground(Color.WHITE);
			bLogin.setFont(new Font("Calibri", Font.BOLD, 17));
			bLogin.setFocusPainted(false);
			bLogin.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
			bLogin.setBackground(BUTTON_GREEN);
			bLogin.setBounds(25, 172, 390, 50);

			 // Desactivar el efecto de enfoque
	        bLogin.setFocusPainted(false);

	        bLogin.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                // Cambiar el estilo del botón cuando el mouse entra en él
	                bLogin.setBackground(BUTTON_GREEN_SELECTED); // Puedes elegir el color que desees
	            }

	            @Override
	            public void mouseExited(MouseEvent e) {
	                // Restablecer el estilo del botón cuando el mouse sale de él
	                bLogin.setBackground(BUTTON_GREEN); // Restablece el color original
	            }
	        });
			
		}
		return bLogin;
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
	private JPanel getPTip() {
		if (pTip == null) {
			pTip = new JPanel();
	        pTip.setBorder(new LineBorder(BUTTON_HOVER_COLOR));
	        pTip.setBackground(LIGHTER_BACKGROUND);
	        pTip.setBounds(144, 370, 440, 70);
	        pTip.setLayout(new GridLayout(0, 1, 0, 0));
			pTip.add(getTaTip());
		}
		return pTip;
	}
}
