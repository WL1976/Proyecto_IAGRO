package ventanas;

import java.awt.Color;



import java.awt.EventQueue;
import java.awt.Image;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;

import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import controladores.ControladorUsuario;

import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;



public class Login extends JFrame {

	private JFrame frameLogin;
	private JTextField textNombreDeUsuario;
	private JPasswordField Passcontraseña;
	//color #68abc4
	//letra Canter Light
	/**

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frameLogin = new JFrame();
		frameLogin.setResizable(false);
		frameLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("iagro_Menu.png")));
		frameLogin.setBounds(100, 100, 501, 442);
		frameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogin.getContentPane().setLayout(null);
		frameLogin.setLocationRelativeTo(null); 

		Color azul=new Color (104,171,196);

		//panel con logo IAGRO
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 487, 394);
		frameLogin.getContentPane().add(panel);
		panel.setBackground(Color.WHITE);
		frameLogin.setTitle("Login");
		JLabel Icon_Container = new JLabel("");	
		Icon_Container.setBounds(133, 11, 250, 101);
		//Image icon = new ImageIcon(this.getClass().getResource("final_v1.png")).getImage();
		Image icon = new ImageIcon(this.getClass().getResource("logo_2.png")).getImage();
		panel.setLayout(null);
		Icon_Container.setIcon(new ImageIcon(icon));
		panel.add(Icon_Container);

		//campo de texto para usuario
		textNombreDeUsuario = new JTextField();
		textNombreDeUsuario.setBounds(136, 151, 189, 30);
		textNombreDeUsuario.setForeground(azul);
		textNombreDeUsuario.setOpaque(false);
		textNombreDeUsuario.setBackground(new Color(104,171,196));
		textNombreDeUsuario.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(104, 171, 196))); 
		TextPrompt nombreDeUsuario = new TextPrompt("Nombre de Usuario", textNombreDeUsuario);
		nombreDeUsuario.changeAlpha(255f);
		nombreDeUsuario.changeStyle(Font.ITALIC | Font.BOLD);
		panel.add(textNombreDeUsuario);
		textNombreDeUsuario.setColumns(10);
		//Image icon_log = new ImageIcon(this.getClass().getResource("iAgro_utec.png")).getImage();

		//campo para contraseña
		Passcontraseña = new JPasswordField();
		Passcontraseña.setBounds(133, 223, 189, 30);
		Passcontraseña.setForeground(azul);
		Passcontraseña.setOpaque(false);
		Passcontraseña.setBackground(new Color(104,171,196));
		Passcontraseña.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(104, 171, 196))); 
		TextPrompt cont = new TextPrompt("Contraseña", Passcontraseña);
		cont.changeAlpha(255f);
		cont.changeStyle(Font.ITALIC | Font.BOLD);
		panel.add(Passcontraseña);

		//botón de imagen de ojo
		Image ojo = new ImageIcon(this.getClass().getResource("ojo_gris.png")).getImage();
		JButton btnojo = new JButton("");
		btnojo.setBackground(Color.WHITE);
		btnojo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				Passcontraseña.setEchoChar((char) 0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				Passcontraseña.setEchoChar('*');
			}
		});

		panel.add(btnojo);
		btnojo.setBounds(300, 223, 36, 35);
		btnojo.setIcon(new ImageIcon(ojo));
		btnojo.setHorizontalTextPosition(SwingConstants.RIGHT);
		btnojo.setForeground(new Color(255, 255, 255));
		//btnojo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnojo.setBorder(null);
		btnojo.setOpaque(false);	
		panel.add(btnojo);

		//boton login
		JButton login = new JButton("Ingresar");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nombre=textNombreDeUsuario.getText();
				String contras = String.valueOf(Passcontraseña.getPassword());

				ControladorUsuario ingresar=new ControladorUsuario ();
				try {
					ingresar.loginUsuario(nombre, contras);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Datos ingresados no válidos");
				}
				
			}
		
				});
		login.setBounds(169, 317, 127, 30);
		panel.add(login);
		login.setForeground(UIManager.getColor("Button.darkShadow"));
		login.setFont(new Font("Candara Light", Font.BOLD, 13));
		login.setBackground(Color.WHITE);
		login.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow"), 3, true));






		//botón con imagen de ingreso
		/*Image ingreso = new ImageIcon(this.getClass().getResource("login_3.png")).getImage();
		JButton btningreso = new JButton("");
		btningreso.setBackground(Color.WHITE);
		panel.add(btningreso);
		btningreso.setBounds(208, 321, 50, 50);
		btningreso.setIcon(new ImageIcon(ingreso));
		btningreso.setHorizontalTextPosition(SwingConstants.RIGHT);
		btningreso.setForeground(new Color(255, 255, 255,255));
		btningreso.setBorder(null);
		btningreso.setOpaque(true);	
		panel.add(btningreso);*/


			}


		}

