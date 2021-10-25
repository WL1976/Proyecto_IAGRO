package vistas;

import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.MatteBorder;

import com.entities.Departamento;
import com.exception.ServiciosException;

import controladores.ControllerEstacion;
import controladores.ControllerUsuario;

import java.awt.*;
import java.util.*;
//import org.jdatepicker.impl.DateComponentFormatter;
import java.util.List;

public class AltaEstacion extends JFrame {

	private JPanel panel;
	public JLabel lblAltaEstacion;
	private JPanel banner;
	public JTextField buscador;
	public JTextField textnombre;
	private JButton lupe;
	public JButton btnRegistrar;
	public JButton btnVolver;
	private JLabel lblNewLabel;
	private JLabel lblNombre;
	private JLabel lblCalidadAgua;
	private JLabel lblHumedadRelativa;
	public static JComboBox comboDpto;
	public JTextField textLatitud;
	public JTextField textLongitud;
	public JTextField textCalidadAgua;
	public JTextField textHumedadRelativa;
	private JLabel lblcreador;
	public JLabel lblNombreUser;
	public JButton btnGuardar;

	public  AltaEstacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaEstacion.class.getResource("/vistas/Logo_original.png")));


		Color azul=new Color (104,171,196); //color azul 104,171,196 / 68abc4
		Color verde=new Color (166,187,95); //color verde 166,187,95 / a6bb5f 
		panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setForeground(new Color(154, 205, 50));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		panel.setLayout(null);

		banner = new JPanel();
		banner.setBounds(0, 0, 656, 64);
		panel.add(banner);
		banner.setBackground(verde);
		banner.setLayout(null);

		textnombre = new JTextField();
		textnombre.setBounds(100, 110, 116, 23);
		textnombre.setBackground(Color.LIGHT_GRAY);
		textnombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textnombre.setOpaque(false); //Le quita la opacidad
		textnombre.setForeground(Color.LIGHT_GRAY);
		textnombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		panel.add(textnombre);

		lupe = new JButton("");
		lupe.setEnabled(false);
		lupe.setBackground(Color.WHITE);
		lupe.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lupe.setIcon(new ImageIcon("C:\\Users\\Admin.DESKTOP-0Q23CA9\\Downloads\\lupa.png"));
		lupe.setBounds(599, 68, 29, 23);
		lupe.setOpaque(false);
		lupe.setBorder(null);
		panel.add(lupe);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(539, 347, 89, 23);
		panel.add(btnRegistrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(539, 347, 89, 23);
		panel.add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(48, 347, 89, 23);
		panel.add(btnVolver);

		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombre.setBounds(28, 110, 62, 23);
		panel.add(lblNombre);

		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblDepartamento.setBounds(255, 110, 101, 23);
		panel.add(lblDepartamento);

		comboDpto = new JComboBox();
		comboDpto.setBounds(393, 110, 130, 23);
		panel.add(comboDpto);
		
		JLabel lblLatitud = new JLabel("Latitud");
		lblLatitud.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblLatitud.setBounds(10, 180, 55, 23);
		panel.add(lblLatitud);

		JLabel lblLongitud = new JLabel("Longitud");
		lblLongitud.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblLongitud.setBounds(209, 180, 62, 23);
		panel.add(lblLongitud);

		lblCalidadAgua = new JLabel("Calidad del Agua");
		lblCalidadAgua.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblCalidadAgua.setBounds(28, 254, 122, 23);
		panel.add(lblCalidadAgua);

		lblHumedadRelativa = new JLabel("Humedad Relativa");
		lblHumedadRelativa.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblHumedadRelativa.setBounds(270, 254, 128, 23);
		panel.add(lblHumedadRelativa);

		textLatitud = new JTextField();
		textLatitud.setOpaque(false);
		textLatitud.setForeground(Color.LIGHT_GRAY);
		textLatitud.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textLatitud.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textLatitud.setBackground(Color.LIGHT_GRAY);
		textLatitud.setBounds(88, 180, 62, 23);
		panel.add(textLatitud);

		textLongitud = new JTextField();
		textLongitud.setOpaque(false);
		textLongitud.setForeground(Color.LIGHT_GRAY);
		textLongitud.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textLongitud.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textLongitud.setBackground(Color.LIGHT_GRAY);
		textLongitud.setBounds(296, 180, 62, 23);
		panel.add(textLongitud);

		textCalidadAgua = new JTextField();
		textCalidadAgua.setOpaque(false);
		textCalidadAgua.setForeground(Color.LIGHT_GRAY);
		textCalidadAgua.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textCalidadAgua.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textCalidadAgua.setBackground(Color.LIGHT_GRAY);
		textCalidadAgua.setBounds(177, 254, 62, 23);
		panel.add(textCalidadAgua);

		textHumedadRelativa = new JTextField();
		textHumedadRelativa.setOpaque(false);
		textHumedadRelativa.setForeground(Color.LIGHT_GRAY);
		textHumedadRelativa.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textHumedadRelativa.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textHumedadRelativa.setBackground(Color.LIGHT_GRAY);
		textHumedadRelativa.setBounds(425, 254, 62, 23);
		panel.add(textHumedadRelativa);

		lblcreador = new JLabel("Usuario Creador");
		lblcreador.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblcreador.setBounds(407, 180, 122, 23);
		panel.add(lblcreador);

		lblNombreUser = new JLabel("");
		lblNombreUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombreUser.setBounds(539, 180, 87, 23);
		panel.add(lblNombreUser);

		lblAltaEstacion = new JLabel("ALTA DE ESTACIÓN");
		lblAltaEstacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaEstacion.setBounds(179, 20, 328, 27);
		banner.add(lblAltaEstacion);
		lblAltaEstacion.setForeground(Color.WHITE);
		lblAltaEstacion.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		this.setVisible(true);


		//chckbxNewCheckBox = new JCheckBox("New check box");
		//chckbxNewCheckBox.setBounds(28, 19, 160, 23);
		//panel_1.add(chckbxNewCheckBox);

		setVisible(false);
		this.setMinimumSize(new Dimension(670, 420));
		setLocationRelativeTo(null);
	}
}
