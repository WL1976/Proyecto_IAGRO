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

	private JFrame frame;
	public JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V_AltaUsuario window = new V_AltaUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		
		textField = new JTextField();
		textField.setOpaque(false);
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(76, 92, 117, 23);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setOpaque(false);
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_1.setBackground(Color.LIGHT_GRAY);
		textField_1.setBounds(269, 94, 117, 21);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setOpaque(false);
		textField_2.setForeground(Color.LIGHT_GRAY);
		textField_2.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_2.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_2.setBackground(Color.LIGHT_GRAY);
		textField_2.setBounds(475, 94, 190, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setOpaque(false);
		textField_3.setForeground(Color.LIGHT_GRAY);
		textField_3.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_3.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_3.setBackground(Color.LIGHT_GRAY);
		textField_3.setBounds(146, 162, 94, 21);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setOpaque(false);
		textField_4.setForeground(Color.LIGHT_GRAY);
		textField_4.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_4.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_4.setBackground(Color.LIGHT_GRAY);
		textField_4.setBounds(339, 162, 107, 21);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setOpaque(false);
		textField_5.setForeground(Color.LIGHT_GRAY);
		textField_5.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_5.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_5.setBackground(Color.LIGHT_GRAY);
		textField_5.setBounds(64, 236, 107, 21);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setOpaque(false);
		textField_6.setForeground(Color.LIGHT_GRAY);
		textField_6.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_6.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_6.setBackground(Color.LIGHT_GRAY);
		textField_6.setBounds(247, 235, 120, 21);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setOpaque(false);
		textField_7.setForeground(Color.LIGHT_GRAY);
		textField_7.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_7.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_7.setBackground(Color.LIGHT_GRAY);
		textField_7.setBounds(427, 236, 101, 21);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setOpaque(false);
		textField_8.setForeground(Color.LIGHT_GRAY);
		textField_8.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textField_8.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textField_8.setBackground(Color.LIGHT_GRAY);
		textField_8.setBounds(598, 235, 94, 21);
		frame.getContentPane().add(textField_8);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerListModel(new String[] {"Administrador", "Investigador", "Aficionado"}));
		spinner.setBounds(498, 162, 165, 20);
		frame.getContentPane().add(spinner);
		
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