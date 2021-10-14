package vistas;

import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.awt.*;
import java.util.*;
//import org.jdatepicker.impl.DateComponentFormatter;
import com.toedter.calendar.JDateChooser;

public class Alta_Formulario extends JFrame {
	
	public JPanel panel;
	public JLabel lblTitle;
	public JTextField buscador;
	public JTextField nombre;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JButton lupe;
	private JButton btnRegistrar;
	private JButton btnVolver;
	private JLabel lblNewLabel;
	private JLabel lblResumen;
	
	public Alta_Formulario() {
		
		
		
		panel = new JPanel();
		panel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel.setForeground(new Color(154, 205, 50));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTitle = new JLabel("Alta Formulario");
		lblTitle.setBounds(259, 0, 154, 30);
		lblTitle.setForeground(new Color(154, 205, 50));
		lblTitle.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
		panel.add(lblTitle);
		
		buscador = new JTextField();
		buscador.setBounds(397, 64, 231, 30);
		buscador.setBackground(Color.LIGHT_GRAY);
		buscador.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		buscador.setOpaque(false); //Le quita la opacidad
		buscador.setForeground(Color.LIGHT_GRAY);
		buscador.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		PlaceHolder placeholderU = new PlaceHolder("Buscar casilla...", buscador);
		placeholderU.changeAlpha(0.75f);
	    placeholderU.changeStyle(Font.ITALIC | Font.BOLD);
		panel.add(buscador);
		buscador.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(117, 100, 210, 23);
		nombre.setBackground(Color.LIGHT_GRAY);
		nombre.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		nombre.setOpaque(false); //Le quita la opacidad
		nombre.setForeground(Color.LIGHT_GRAY);
		nombre.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		panel.add(nombre);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(397, 112, 231, 208);
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
		lupe.setBounds(599, 68, 29, 23);
		lupe.setOpaque(false);
		lupe.setBorder(null);
		panel.add(lupe);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(539, 347, 89, 23);
		panel.add(btnRegistrar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(48, 347, 89, 23);
		panel.add(btnVolver);
		
		lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblNewLabel.setBounds(48, 98, 84, 23);
		panel.add(lblNewLabel);
		
		lblResumen = new JLabel("Resumen");
		lblResumen.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblResumen.setBounds(48, 195, 84, 42);
		panel.add(lblResumen);
		
		JTextArea textArea = new JTextArea();
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		textArea.setBounds(48, 228, 279, 92);
		panel.add(textArea);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(117, 157, 210, 20);
		panel.add(dateChooser);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		lblFecha.setBounds(48, 155, 59, 23);
		panel.add(lblFecha);
		
		
		ArrayList<JCheckBox> casillas = new ArrayList<>();
		
		int y = 0;
		
		for(int i=0; i<=15; i++){
			chckbxNewCheckBox = new JCheckBox("Casilla");
			chckbxNewCheckBox.setBounds(0, y, 160, 23);
			//chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15))
			chckbxNewCheckBox.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			casillas.add(chckbxNewCheckBox);
			
			y += 30;
		}
		
		for(int i=0; i<casillas.size(); i++) {
			panel_1.add(casillas.get(i));
		}
		
		
		//chckbxNewCheckBox = new JCheckBox("New check box");
		//chckbxNewCheckBox.setBounds(28, 19, 160, 23);
		//panel_1.add(chckbxNewCheckBox);
		
		setVisible(true);
		this.setMinimumSize(new Dimension(670, 420));
		setLocationRelativeTo(null);
	}
}
