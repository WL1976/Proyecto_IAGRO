package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;

public class V_AltaUsuario {

	public JFrame frame;
	public JTextField nombre;
	public JTextField apellido;
	public JTextField email;
	public JTextField nombreUsu;
	public JTextField contrasena;
	public JTextField cedula;
	public JTextField domicilio;
	public JTextField ciudad;
	public JTextField telefono;
	public JSpinner rol;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public V_AltaUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAltaDeUsuarios = new JLabel("Alta de usuario");
		lblAltaDeUsuarios.setForeground(new Color(154, 205, 50));
		lblAltaDeUsuarios.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		lblAltaDeUsuarios.setBounds(236, 11, 171, 30);
		frame.getContentPane().add(lblAltaDeUsuarios);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombre.setBounds(10, 90, 84, 23);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblApellido.setBounds(203, 90, 84, 23);
		frame.getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblEmail.setBounds(430, 90, 84, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombreDeUsuario.setBounds(10, 158, 141, 23);
		frame.getContentPane().add(lblNombreDeUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblContrasea.setBounds(250, 158, 84, 23);
		frame.getContentPane().add(lblContrasea);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblRol.setBounds(456, 158, 84, 23);
		frame.getContentPane().add(lblRol);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCedula.setBounds(10, 232, 84, 23);
		frame.getContentPane().add(lblCedula);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblDomicilio.setBounds(181, 232, 84, 23);
		frame.getContentPane().add(lblDomicilio);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCiudad.setBounds(377, 232, 84, 23);
		frame.getContentPane().add(lblCiudad);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTelfono.setBounds(538, 232, 84, 23);
		frame.getContentPane().add(lblTelfono);
		
		nombre = new JTextField();
		nombre.setOpaque(false);
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(76, 92, 117, 23);
		frame.getContentPane().add(nombre);
		
		apellido = new JTextField();
		apellido.setOpaque(false);
		apellido.setForeground(Color.LIGHT_GRAY);
		apellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		apellido.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		apellido.setBackground(Color.LIGHT_GRAY);
		apellido.setBounds(269, 94, 117, 21);
		frame.getContentPane().add(apellido);
		
		email = new JTextField();
		email.setOpaque(false);
		email.setForeground(Color.LIGHT_GRAY);
		email.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		email.setBackground(Color.LIGHT_GRAY);
		email.setBounds(475, 94, 190, 21);
		frame.getContentPane().add(email);
		
		nombreUsu = new JTextField();
		nombreUsu.setOpaque(false);
		nombreUsu.setForeground(Color.LIGHT_GRAY);
		nombreUsu.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombreUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombreUsu.setBackground(Color.LIGHT_GRAY);
		nombreUsu.setBounds(146, 162, 94, 21);
		frame.getContentPane().add(nombreUsu);
		
		contrasena = new JTextField();
		contrasena.setOpaque(false);
		contrasena.setForeground(Color.LIGHT_GRAY);
		contrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		contrasena.setBackground(Color.LIGHT_GRAY);
		contrasena.setBounds(339, 162, 107, 21);
		frame.getContentPane().add(contrasena);
		
		cedula = new JTextField();
		cedula.setOpaque(false);
		cedula.setForeground(Color.LIGHT_GRAY);
		cedula.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cedula.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		cedula.setBackground(Color.LIGHT_GRAY);
		cedula.setBounds(64, 236, 107, 21);
		frame.getContentPane().add(cedula);
		
		domicilio = new JTextField();
		domicilio.setOpaque(false);
		domicilio.setForeground(Color.LIGHT_GRAY);
		domicilio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		domicilio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		domicilio.setBackground(Color.LIGHT_GRAY);
		domicilio.setBounds(247, 235, 120, 21);
		frame.getContentPane().add(domicilio);
		
		ciudad = new JTextField();
		ciudad.setOpaque(false);
		ciudad.setForeground(Color.LIGHT_GRAY);
		ciudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		ciudad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		ciudad.setBackground(Color.LIGHT_GRAY);
		ciudad.setBounds(427, 236, 101, 21);
		frame.getContentPane().add(ciudad);
		
		telefono = new JTextField();
		telefono.setOpaque(false);
		telefono.setForeground(Color.LIGHT_GRAY);
		telefono.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		telefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		telefono.setBackground(Color.LIGHT_GRAY);
		telefono.setBounds(598, 235, 94, 21);
		frame.getContentPane().add(telefono);
		
		rol = new JSpinner();
		rol.setModel(new SpinnerListModel(new String[] {"Administrador", "Investigador", "Aficionado"}));
		rol.setBounds(498, 162, 165, 20);
		frame.getContentPane().add(rol);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 315, 89, 23);
		frame.getContentPane().add(btnVolver);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(603, 315, 89, 23);
		frame.getContentPane().add(btnRegistrar);
		frame.setBounds(100, 100, 718, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}