package cliente;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class V_Alta_Usuario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField email;
	private JTextField nombreUsu;
	private JTextField contrasena;
	private JTextField cedula;
	private JTextField domicilio;
	private JTextField ciudad;
	private JTextField telefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_Alta_Usuario frame = new V_Alta_Usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public V_Alta_Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 710, 382);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombre.setBounds(10, 113, 84, 23);
		panel.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setOpaque(false);
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(74, 113, 118, 23);
		panel.add(nombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblApellido.setBounds(218, 113, 84, 23);
		panel.add(lblApellido);
		
		apellido = new JTextField();
		apellido.setOpaque(false);
		apellido.setForeground(Color.LIGHT_GRAY);
		apellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		apellido.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		apellido.setBackground(Color.LIGHT_GRAY);
		apellido.setBounds(282, 115, 118, 23);
		panel.add(apellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblEmail.setBounds(432, 113, 84, 23);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setOpaque(false);
		email.setForeground(Color.LIGHT_GRAY);
		email.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		email.setBackground(Color.LIGHT_GRAY);
		email.setBounds(483, 115, 200, 23);
		panel.add(email);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombreDeUsuario.setBounds(10, 187, 141, 23);
		panel.add(lblNombreDeUsuario);
		
		nombreUsu = new JTextField();
		nombreUsu.setOpaque(false);
		nombreUsu.setForeground(Color.LIGHT_GRAY);
		nombreUsu.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombreUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombreUsu.setBackground(Color.LIGHT_GRAY);
		nombreUsu.setBounds(150, 187, 118, 23);
		panel.add(nombreUsu);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblContrasea.setBounds(282, 187, 84, 23);
		panel.add(lblContrasea);
		
		contrasena = new JTextField();
		contrasena.setOpaque(false);
		contrasena.setForeground(Color.LIGHT_GRAY);
		contrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		contrasena.setBackground(Color.LIGHT_GRAY);
		contrasena.setBounds(363, 189, 118, 23);
		panel.add(contrasena);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblRol.setBounds(507, 187, 84, 23);
		panel.add(lblRol);
		
		JComboBox comboRol = new JComboBox();
		comboRol.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Investigador", "Aficionado"}));
		comboRol.setBounds(546, 190, 137, 22);
		panel.add(comboRol);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCedula.setBounds(10, 260, 141, 23);
		panel.add(lblCedula);
		
		cedula = new JTextField();
		cedula.setOpaque(false);
		cedula.setForeground(Color.LIGHT_GRAY);
		cedula.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cedula.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		cedula.setBackground(Color.LIGHT_GRAY);
		cedula.setBounds(60, 262, 83, 23);
		panel.add(cedula);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblDomicilio.setBounds(150, 260, 141, 23);
		panel.add(lblDomicilio);
		
		domicilio = new JTextField();
		domicilio.setOpaque(false);
		domicilio.setForeground(Color.LIGHT_GRAY);
		domicilio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		domicilio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		domicilio.setBackground(Color.LIGHT_GRAY);
		domicilio.setBounds(218, 262, 110, 23);
		panel.add(domicilio);
		
		ciudad = new JTextField();
		ciudad.setOpaque(false);
		ciudad.setForeground(Color.LIGHT_GRAY);
		ciudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		ciudad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		ciudad.setBackground(Color.LIGHT_GRAY);
		ciudad.setBounds(387, 262, 110, 23);
		panel.add(ciudad);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCiudad.setBounds(338, 260, 141, 23);
		panel.add(lblCiudad);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTelfono.setBounds(507, 260, 141, 23);
		panel.add(lblTelfono);
		
		telefono = new JTextField();
		telefono.setOpaque(false);
		telefono.setForeground(Color.LIGHT_GRAY);
		telefono.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		telefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		telefono.setBackground(Color.LIGHT_GRAY);
		telefono.setBounds(573, 262, 110, 23);
		panel.add(telefono);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 348, 89, 23);
		panel.add(btnVolver);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(611, 348, 89, 23);
		panel.add(btnRegistrar);
		
		JPanel banner = new JPanel();
		banner.setBackground(new Color(154, 205, 50));
		banner.setBounds(0, 0, 710, 64);
		panel.add(banner);
		banner.setLayout(null);
		
		JLabel lblAltaDeUsuarios = new JLabel("Alta de usuario");
		lblAltaDeUsuarios.setBounds(279, 11, 150, 30);
		banner.add(lblAltaDeUsuarios);
		lblAltaDeUsuarios.setForeground(Color.WHITE);
		lblAltaDeUsuarios.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
	}
}
