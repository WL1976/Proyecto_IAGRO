package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class V_Alta_Usuario extends JFrame {

	private JPanel contentPane;
	public JLabel lblAltaDeUsuarios;
	public JTextField nombre;
	public JTextField apellido;
	public JTextField email;
	public JTextField nombreUsu;
	public JTextField contrasena;
	public JTextField cedula;
	public JTextField domicilio;
	public JTextField ciudad;
	public JTextField telefono;
	public JButton btnRegistrar;
	public JButton btnVolver;
	public JButton btnGuardar;

	/**
	 * Launch the application.
	 
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
		
		Color verde=new Color (166,187,95); //color verde 166,187,95 / a6bb5f 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 790, 426);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombre.setBounds(49, 116, 84, 23);
		panel.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setOpaque(false);
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBounds(113, 116, 118, 23);
		panel.add(nombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblApellido.setBounds(257, 116, 84, 23);
		panel.add(lblApellido);
		
		apellido = new JTextField();
		apellido.setOpaque(false);
		apellido.setForeground(Color.LIGHT_GRAY);
		apellido.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		apellido.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		apellido.setBackground(Color.LIGHT_GRAY);
		apellido.setBounds(321, 118, 118, 23);
		panel.add(apellido);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblEmail.setBounds(471, 116, 84, 23);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setOpaque(false);
		email.setForeground(Color.LIGHT_GRAY);
		email.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		email.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		email.setBackground(Color.LIGHT_GRAY);
		email.setBounds(522, 118, 200, 23);
		panel.add(email);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
		lblNombreDeUsuario.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombreDeUsuario.setBounds(49, 190, 141, 23);
		panel.add(lblNombreDeUsuario);
		
		nombreUsu = new JTextField();
		nombreUsu.setOpaque(false);
		nombreUsu.setForeground(Color.LIGHT_GRAY);
		nombreUsu.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		nombreUsu.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombreUsu.setBackground(Color.LIGHT_GRAY);
		nombreUsu.setBounds(189, 190, 118, 23);
		panel.add(nombreUsu);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblContrasea.setBounds(321, 190, 84, 23);
		panel.add(lblContrasea);
		
		contrasena = new JTextField();
		contrasena.setOpaque(false);
		contrasena.setForeground(Color.LIGHT_GRAY);
		contrasena.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		contrasena.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		contrasena.setBackground(Color.LIGHT_GRAY);
		contrasena.setBounds(402, 192, 118, 23);
		panel.add(contrasena);
		
		JLabel lblRol = new JLabel("Rol");
		lblRol.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblRol.setBounds(546, 190, 84, 23);
		panel.add(lblRol);
		
		JComboBox comboRol = new JComboBox();
		comboRol.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Investigador", "Aficionado"}));
		comboRol.setBounds(585, 193, 137, 22);
		panel.add(comboRol);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCedula.setBounds(49, 263, 141, 23);
		panel.add(lblCedula);
		
		cedula = new JTextField();
		cedula.setOpaque(false);
		cedula.setForeground(Color.LIGHT_GRAY);
		cedula.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		cedula.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		cedula.setBackground(Color.LIGHT_GRAY);
		cedula.setBounds(99, 265, 83, 23);
		panel.add(cedula);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblDomicilio.setBounds(189, 263, 141, 23);
		panel.add(lblDomicilio);
		
		domicilio = new JTextField();
		domicilio.setOpaque(false);
		domicilio.setForeground(Color.LIGHT_GRAY);
		domicilio.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		domicilio.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		domicilio.setBackground(Color.LIGHT_GRAY);
		domicilio.setBounds(257, 265, 110, 23);
		panel.add(domicilio);
		
		ciudad = new JTextField();
		ciudad.setOpaque(false);
		ciudad.setForeground(Color.LIGHT_GRAY);
		ciudad.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		ciudad.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		ciudad.setBackground(Color.LIGHT_GRAY);
		ciudad.setBounds(426, 265, 110, 23);
		panel.add(ciudad);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCiudad.setBounds(377, 263, 141, 23);
		panel.add(lblCiudad);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTelfono.setBounds(546, 263, 141, 23);
		panel.add(lblTelfono);
		
		telefono = new JTextField();
		telefono.setOpaque(false);
		telefono.setForeground(Color.LIGHT_GRAY);
		telefono.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		telefono.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		telefono.setBackground(Color.LIGHT_GRAY);
		telefono.setBounds(612, 265, 110, 23);
		panel.add(telefono);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(49, 351, 89, 23);
		panel.add(btnVolver);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(650, 351, 89, 23);
		panel.add(btnGuardar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(650, 351, 89, 23);
		panel.add(btnRegistrar);
		
		JPanel banner = new JPanel();
		banner.setBackground(verde);
		banner.setBounds(0, 0, 790, 64);
		panel.add(banner);
		banner.setLayout(null);
		
		lblAltaDeUsuarios = new JLabel("ALTA DE USUARIO");
		lblAltaDeUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeUsuarios.setBounds(231, 20, 328, 27);
		banner.add(lblAltaDeUsuarios);
		lblAltaDeUsuarios.setForeground(Color.WHITE);
		lblAltaDeUsuarios.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		this.setVisible(true);
	}
}
