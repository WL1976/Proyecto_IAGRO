package vistas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Estilos extends JFrame {
	
	public static void Frame(JFrame frame) {
		frame.setVisible(true);
		frame.setMinimumSize(new Dimension(806, 450));
		frame.setLocationRelativeTo(null);
	}

	public static void Panel(JPanel panel) {
		panel.setForeground(new Color(154, 205, 50));
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
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
