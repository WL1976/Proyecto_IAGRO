package vistas;

import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.entities.Departamento;
import com.exception.ServiciosException;

import controladores.ControllerEstacion;
import controladores.ControllerUsuario;

import java.awt.*;
import java.util.*;
//import org.jdatepicker.impl.DateComponentFormatter;
import java.util.List;

public class AltaCasilla extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	public JLabel lblAltaEstacion;
	private JPanel banner;
	public JTextField buscador;
	public JTextField textnombre;
	private JButton lupe;
	public JButton btnRegistrar;
	public JButton btnVolver;
	private JLabel lblNewLabel;
	private JLabel lblParametro;
	public  JComboBox comboDpto;
	private JLabel lblDescripcion;
	public JLabel lblNombreUser;
	public JButton btnGuardar;

	public  AltaCasilla() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaEstacion.class.getResource("/vistas/Logo_original.png")));


		Color azul=new Color (104,171,196); //color azul 104,171,196 / 68abc4
		Color verde=new Color (166,187,95); //color verde 166,187,95 / a6bb5f 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 790, 426);
		contentPane.add(panel);
		panel.setLayout(null);


		banner = new JPanel();
		banner.setBounds(0, 0, 790, 64);
		panel.add(banner);
		banner.setBackground(verde);
		banner.setLayout(null);

		textnombre = new JTextField();
		textnombre.setBounds(208, 111, 116, 23);
		textnombre.setBackground(Color.LIGHT_GRAY);
		textnombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textnombre.setOpaque(false); //Le quita la opacidad
		textnombre.setForeground(Color.LIGHT_GRAY);
		textnombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		panel.add(textnombre);

		lupe = new JButton("");
		lupe.setBounds(599, 68, 29, 23);
		lupe.setEnabled(false);
		lupe.setBackground(Color.WHITE);
		lupe.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lupe.setIcon(new ImageIcon("C:\\Users\\Admin.DESKTOP-0Q23CA9\\Downloads\\lupa.png"));
		lupe.setOpaque(false);
		lupe.setBorder(null);
		panel.add(lupe);

		btnRegistrar = new JButton("Agregar Casilla");
		btnRegistrar.setBounds(343, 373, 125, 27);
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setVerticalAlignment(SwingConstants.TOP);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) azul));
		btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnRegistrar.setBackground(azul);
		panel.add(btnRegistrar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(343, 373, 125, 27);
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setBorderPainted(false);
		btnGuardar.setVerticalAlignment(SwingConstants.TOP);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) azul));
		btnGuardar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnGuardar.setBackground(azul);
		panel.add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 369, 52, 35);
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setBorderPainted(false);
		btnVolver.setVerticalAlignment(SwingConstants.TOP);
		btnVolver.setForeground(Color.WHITE);
		Image volver = new ImageIcon(this.getClass().getResource("volver1.png")).getImage();
		btnVolver.setIcon(new ImageIcon(volver));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(false);
		panel.add(btnVolver);

		lblParametro = new JLabel("Parametro");
		lblParametro.setBounds(432, 109, 79, 23);
		lblParametro.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panel.add(lblParametro);

		JLabel lblUnidMedida = new JLabel("Unidad de Medida");
		lblUnidMedida.setBounds(381, 200, 130, 23);
		lblUnidMedida.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panel.add(lblUnidMedida);

		comboDpto = new JComboBox();
		comboDpto.setBounds(533, 111, 130, 23);
		panel.add(comboDpto);

		lblDescripcion = new JLabel("Descripci\u00F3n");
		lblDescripcion.setBounds(29, 286, 107, 23);
		lblDescripcion.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panel.add(lblDescripcion);

		lblNombreUser = new JLabel("");
		lblNombreUser.setBounds(541, 292, 87, 23);
		lblNombreUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		panel.add(lblNombreUser);

		lblAltaEstacion = new JLabel("ALTA DE CASILLA");
		lblAltaEstacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaEstacion.setBounds(231, 17, 328, 27);
		banner.add(lblAltaEstacion);
		lblAltaEstacion.setForeground(Color.WHITE);
		lblAltaEstacion.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(140, 286, 521, 64);
		panel.add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JComboBox comboDpto_1 = new JComboBox();
		comboDpto_1.setBounds(533, 200, 130, 23);
		panel.add(comboDpto_1);
		
		JLabel lblNombre = new JLabel("Nombre Casilla");
		lblNombre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNombre.setBounds(29, 116, 142, 23);
		panel.add(lblNombre);
		
		JLabel lblTipoDeValor = new JLabel("Tipo de Valor");
		lblTipoDeValor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblTipoDeValor.setBounds(29, 200, 142, 23);
		panel.add(lblTipoDeValor);
		
		JComboBox comboDpto_1_1 = new JComboBox();
		comboDpto_1_1.setBounds(154, 203, 130, 23);
		panel.add(comboDpto_1_1);
		this.setVisible(true);


		//chckbxNewCheckBox = new JCheckBox("New check box");
		//chckbxNewCheckBox.setBounds(28, 19, 160, 23);
		//panel_1.add(chckbxNewCheckBox);

		setVisible(false);
		this.setMinimumSize(new Dimension(670, 420));
		setLocationRelativeTo(null);
	}
}
