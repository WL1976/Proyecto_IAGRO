package vistas;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.entities.Casilla;
import com.servicios.CasillaBeanRemote;

import controladores.Constantes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;


public class AltaFormulario extends JFrame implements Constantes{

	private JPanel contentPane;
	public JPanel panel;
	public JLabel lblAltaDeFormulario;
	public JTextField buscador;
	public JTextField nombre;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	public JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JButton lupe;
	public JButton btnRegistrar;
	public JButton btnGuardar;
	public JButton btnVolver;
	private JLabel lblNewLabel;
	private JLabel lblResumen;
	public JTextArea textResumen;
	public JLabel lblfecha;
	public JLabel lblfechaHoy;
	public JLabel lblUser;
	public JTextField textUbicacion;
	public HashMap<Long, Casilla> map = new HashMap<>();

	public AltaFormulario() throws NamingException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaUsuario.class.getResource("/vistas/Logo_original.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 806, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);		


		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 792, 426);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel banner = new JPanel();
		banner.setBackground(verde);
		banner.setBounds(0, 0, 790, 64);
		panel.add(banner);
		banner.setLayout(null);

		lblAltaDeFormulario = new JLabel("ALTA DE FORMULARIO");
		lblAltaDeFormulario.setHorizontalAlignment(SwingConstants.CENTER);
		lblAltaDeFormulario.setBounds(231, 20, 328, 27);
		banner.add(lblAltaDeFormulario);
		lblAltaDeFormulario.setForeground(Color.WHITE);
		lblAltaDeFormulario.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		this.setVisible(true);

		buscador = new JTextField();
		buscador.setBounds(528, 88, 231, 30);
		buscador.setBackground(Color.LIGHT_GRAY);
		buscador.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		buscador.setOpaque(false); //Le quita la opacidad
		buscador.setForeground(Color.LIGHT_GRAY);
		buscador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		PlaceHolder BuscarCasilla = new PlaceHolder("Buscar casilla...", buscador);
		BuscarCasilla.changeAlpha(0.75f);
		BuscarCasilla.changeStyle(Font.ITALIC | Font.BOLD);
		panel.add(buscador);
		buscador.setColumns(10);

		nombre = new JTextField();
		nombre.setBounds(122, 123, 124, 23);
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombre.setOpaque(false); //Le quita la opacidad
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		panel.add(nombre);

		lblfechaHoy = new JLabel("");
		lblfechaHoy.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblfechaHoy.setBounds(122, 201, 276, 23);
		panel.add(lblfechaHoy);


		scrollPane = new JScrollPane();
		scrollPane.setBounds(528, 136, 231, 208);
		scrollPane.setBackground(Color.WHITE);
		panel.add(scrollPane);
		scrollPane.setOpaque(false);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(243, 132, 170, 163);
		panel_1.setPreferredSize(new Dimension(20,300));
		panel_1.setOpaque(false);

		scrollPane.setViewportView(panel_1);
		panel_1.setLayout(null);

		lupe = new JButton("");
		lupe.setEnabled(false);
		lupe.setBackground(Color.WHITE);
		lupe.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		lupe.setIcon(new ImageIcon("C:\\Users\\Admin.DESKTOP-0Q23CA9\\Downloads\\lupa.png"));
		lupe.setBounds(730, 92, 29, 23);
		lupe.setOpaque(false);
		lupe.setBorder(null);
		panel.add(lupe);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRegistrar.setBorderPainted(false);
		btnRegistrar.setVerticalAlignment(SwingConstants.TOP);
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) azul));
		btnRegistrar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnRegistrar.setBackground(azul);
		btnRegistrar.setBounds(308, 377, 125, 27);
		panel.add(btnRegistrar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGuardar.setBorderPainted(false);
		btnGuardar.setVerticalAlignment(SwingConstants.TOP);
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBorder(new MatteBorder(2, 2, 2, 2, (Color) azul));
		btnGuardar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		btnGuardar.setBackground(azul);
		btnGuardar.setBounds(308, 377, 125, 27);
		panel.add(btnGuardar);

		btnVolver = new JButton("Volver");
		btnVolver.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVolver.setBorderPainted(false);
		btnVolver.setVerticalAlignment(SwingConstants.TOP);
		btnVolver.setForeground(Color.WHITE);
		btnVolver.setBounds(10, 369, 52, 35);		
		Image volver = new ImageIcon(this.getClass().getResource("volver1.png")).getImage();
		btnVolver.setIcon(new ImageIcon(volver));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBorder(null);
		btnVolver.setOpaque(false);
		panel.add(btnVolver);

		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 121, 84, 23);
		panel.add(lblNewLabel);

		lblfecha = new JLabel("");
		lblfecha.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblfecha.setBounds(541, 292, 87, 23);
		panel.add(lblfecha);


		lblResumen = new JLabel("Resumen");
		lblResumen.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblResumen.setBounds(48, 235, 84, 36);
		panel.add(lblResumen);

		textResumen = new JTextArea();
		textResumen.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		textResumen.setBounds(48, 269, 429, 97);
		panel.add(textResumen);

		/*JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(117, 157, 210, 20);
		panel.add(dateChooser);*/

		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblFecha.setBounds(48, 201, 59, 23);
		panel.add(lblFecha);

		JLabel lblUbicacin = new JLabel("Ubicaci\u00F3n");
		lblUbicacin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblUbicacin.setBounds(48, 163, 84, 23);
		panel.add(lblUbicacin);

		textUbicacion = new JTextField();
		textUbicacion.setOpaque(false);
		textUbicacion.setForeground(Color.LIGHT_GRAY);
		textUbicacion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		textUbicacion.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		textUbicacion.setBackground(Color.LIGHT_GRAY);
		textUbicacion.setBounds(122, 157, 124, 23);
		panel.add(textUbicacion);

		JLabel lblUsuarioCre = new JLabel("Usuario");
		lblUsuarioCre.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblUsuarioCre.setBounds(283, 128, 59, 23);
		panel.add(lblUsuarioCre);

		lblUser = new JLabel("");
		lblUser.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblUser.setBounds(362, 128, 87, 23);
		panel.add(lblUser);



		////////////////////////////***************CASILLAS*****************/////////////////////////////////////


	}

	public void cargarCasillas() {

		ArrayList<JCheckBox> casillas = new ArrayList<>();

		
		try {
			CasillaBeanRemote casillaBean;
			casillaBean = (CasillaBeanRemote)
					InitialContext.doLookup(RUTA_CasillaBean);
			
			ArrayList<Casilla> allCasillas = (ArrayList<Casilla>) casillaBean.obtenerTodos();
			
			int y = 0;

			for(Casilla c: allCasillas){
				chckbxNewCheckBox = new JCheckBox(c.getNombre());
				chckbxNewCheckBox.setBounds(0, y, 160, 23);
				chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
				//Insertar casillas en panel
				panel_1.add(chckbxNewCheckBox);
				
				//Marcar casillas ya existentes
				if(map.containsKey(c.getIdCasilla())) {
					chckbxNewCheckBox.doClick();
				}

				//Generar evento de chequear/deschequear por casilla
				chckbxNewCheckBox.addItemListener(new ItemListener() {


					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if(e.getStateChange() == ItemEvent.SELECTED) {//agrega la casilla si se selecciona
							map.put(c.getIdCasilla(), c);
						} else {//quita la casilla si se deselecciona
							map.remove(c.getIdCasilla());
						};

						System.out.println("Cambio");


					}
				});



				y += 30;
			}

			setVisible(true);
			this.setMinimumSize(new Dimension(670, 420));
			setLocationRelativeTo(null);
		} catch (NamingException e1) {}

		


		
	}
}