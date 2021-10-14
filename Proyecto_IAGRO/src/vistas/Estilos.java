package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class Estilos extends JFrame {
	
	final static Color azul =new Color (104,171,196); //color azul 104,171,196 / 68abc4
	final static Color verde =new Color (166,187,95); //color verde 166,187,95 / a6bb5f 
	
	
	private static final long serialVersionUID = 8492273242509941831L;

	public static void Ventana(JFrame frame, JPanel contentPane, JPanel panel ) {
		
		frame.setResizable(false);
		frame.setTitle("Menu Principal");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 806, 450);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		frame.setLocationRelativeTo(null);


		//Panel Principal
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 806, 426);
		contentPane.add(panel);
	}

	public static void Panel(JPanel panel) {
		
		
	}
	
	
	public static void PanelSuperior(JPanel banner, JPanel panel ) {
				banner = new JPanel();
				banner.setBounds(0, 0, 806, 84);
				panel.setMinimumSize(new Dimension(806, 84));
				banner.setBackground(azul);
				panel.add(banner);
				banner.setVisible(true);
	}
	
	public static void Titulo(JLabel label) {
		//label.setBounds(259, 0, 154, 30);
		label.setMinimumSize(new Dimension(154, 30));
		label.setForeground(new Color(154, 205, 50));
		label.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 22));
	}
	
	public static void Label(JLabel label) {
		label.setMinimumSize(new Dimension(154, 30));
		label.setForeground(new Color(154, 205, 50));
		label.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	}
	
	public static void lineTextField(JTextField text) {
		//text.setBounds(117, 100, 210, 23);
		text.setMinimumSize(new Dimension(210, 23));
		text.setBackground(Color.LIGHT_GRAY);
		text.setBorder(new MatteBorder(0, 0, 2, 0, (Color) Color.LIGHT_GRAY));
		text.setOpaque(false); //Le quita la opacidad
		text.setForeground(Color.LIGHT_GRAY);
		text.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
	}
	
	public static void Boton(JButton boton) {
		
	}
	
	
}
