package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.BevelBorder;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel panelAdministrador;
	private JPanel panelInvestigador;
	private JPanel panelAficionado;
	private JButton btnRegistro;
	private JButton btnFormularioInv;
	private JButton btnFormularioAdm;
	private Image form;
	private JButton btnRegistroInv;
	private JButton btnRegistroAdm;
	private JButton btnRegistroAfi;
	private Image reg;
	private JButton btnCasillasAdm;
	private JButton btnCasillasInv;
	private Image casilla;
	private JButton btnEstacionesAdm;
	private JButton btnEstacionesInv;
	private Image estaciones;
	private JButton btnUsuariosAdm;
	private Image usuarios;
	private JLabel Icon_menu;
	private Image menu;
	private JPanel panel_Superior;
	private JLabel logOut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/login/IaGRO_original.png")));

		Color azul=new Color (104,171,196); //color azul 104,171,196 / 68abc4
		Color verde=new Color (166,187,95); //color verde 166,187,95 / a6bb5f 
		setResizable(false);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);


		//Panel Principal
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 806, 426);
		contentPane.add(panel);

		//panel lateral Admin
		panelAdministrador = new JPanel();
		panelAdministrador.setToolTipText("Registros");
		panelAdministrador.setBounds(0, 59, 190, 356);
		panelAdministrador.setBackground(azul);
		panel.add(panelAdministrador);
		panelAdministrador.setLayout(null);

		//panel blanco lateral Investigador
		panelInvestigador = new JPanel();
		panelInvestigador.setBounds(547, 72, 158, 356);
		panelInvestigador.setBackground(azul);
		panel.add(panelInvestigador);
		panelInvestigador.setVisible(false);
		panelInvestigador.setLayout(null);


		//panel Aficionado
		panelAficionado = new JPanel();
		panelAficionado.setBounds(200, 59,158, 369);
		panelAficionado.setBackground(azul);
		panel.add(panelAficionado);
		panelAficionado.setLayout(null);
		panelAficionado.setVisible(false);


		//logo iagro
		JLabel Icon_Container = new JLabel("");
		Icon_Container.setBounds(383, 144, 145, 148);
		Image icon = new ImageIcon(this.getClass().getResource("iagro_Menu.png")).getImage();
		panel.setLayout(null);
		panel.setLayout(null);
		Icon_Container.setIcon(new ImageIcon(icon));
		panel.add(Icon_Container);


		//Botón Aficionado Registro 
		btnRegistroAfi = new JButton("Registros");
		btnRegistroAfi.setToolTipText("Registros");
		btnRegistroAfi.setFont(new Font("Voces", Font.BOLD, 14));
		btnRegistroAfi.setForeground(new Color(255, 255, 255));
		btnRegistroAfi.setBounds(0, 40, 148, 40);
		reg= new ImageIcon(this.getClass().getResource("Registros.png")).getImage();
		btnRegistroAfi.setIcon(new ImageIcon(reg));
		btnRegistroAfi.setBackground(Color.WHITE);
		btnRegistroAfi.setBorder(null);
		btnRegistroAfi.setOpaque(false);
		panelAficionado.add(btnRegistroAfi);


		//botones Admin

		btnFormularioAdm = new JButton("Formularios");
		btnFormularioAdm.setHorizontalAlignment(SwingConstants.LEADING);
		btnFormularioAdm.setToolTipText("Formularios");
		btnFormularioAdm.setFont(new Font("Voces", Font.BOLD, 14));
		btnFormularioAdm.setForeground(new Color(255, 255, 255));
		btnFormularioAdm.setBounds(22, 46, 146, 40);
		Image form = new ImageIcon(this.getClass().getResource("formulario.png")).getImage();
		btnFormularioAdm.setIcon(new ImageIcon("C:\\Users\\Estudio\\Desktop\\Imprimir\\Agosto\\iloveimg-resized\\formularios.png"));
		btnFormularioAdm.setBackground(Color.WHITE);
		btnFormularioAdm.setBorder(null);
		btnFormularioAdm.setOpaque(false);
		panelAdministrador.add(btnFormularioAdm);

		btnCasillasAdm = new JButton("Casillas");
		btnCasillasAdm.setHorizontalAlignment(SwingConstants.LEADING);
		btnCasillasAdm.setToolTipText("Casillas");
		btnCasillasAdm.setFont(new Font("Voces", Font.BOLD, 14));
		btnCasillasAdm.setForeground(new Color(255, 255, 255));
		btnCasillasAdm.setBounds(22, 97, 146, 40);
		casilla= new ImageIcon(this.getClass().getResource("casilla.png")).getImage();
		btnCasillasAdm.setIcon(new ImageIcon("C:\\Users\\Estudio\\Desktop\\Imprimir\\Agosto\\iloveimg-resized\\casillas.png"));
		btnCasillasAdm.setBackground(Color.WHITE);
		btnCasillasAdm.setBorder(null);
		btnCasillasAdm.setOpaque(false);
		panelAdministrador.add(btnCasillasAdm);

		btnRegistroAdm= new JButton("Registros");
		btnRegistroAdm.setHorizontalAlignment(SwingConstants.LEADING);
		btnRegistroAdm.setToolTipText("Registros");
		btnRegistroAdm.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRegistroAdm.setForeground(new Color(255, 255, 255));
		btnRegistroAdm.setBounds(22, 148, 146, 40);
		btnRegistroAdm.setIcon(new ImageIcon("C:\\Users\\Estudio\\Desktop\\Imprimir\\Agosto\\iloveimg-resized\\registros.png"));
		btnRegistroAdm.setBackground(Color.WHITE);
		btnRegistroAdm.setBorder(null);
		btnRegistroAdm.setOpaque(false);
		panelAdministrador.add(btnRegistroAdm);

		btnEstacionesAdm = new JButton("Estaciones");
		btnEstacionesAdm.setHorizontalAlignment(SwingConstants.LEADING);
		btnEstacionesAdm.setToolTipText("Estaciones");
		btnEstacionesAdm.setFont(new Font("Voces", Font.BOLD, 14));
		btnEstacionesAdm.setForeground(new Color(255, 255, 255));
		btnEstacionesAdm.setBounds(22, 207, 146, 40);
		estaciones= new ImageIcon(this.getClass().getResource("estaciones.png")).getImage();
		btnEstacionesAdm.setIcon(new ImageIcon("C:\\Users\\Estudio\\Desktop\\Imprimir\\Agosto\\iloveimg-resized\\estaciones.png"));
		btnEstacionesAdm.setBackground(Color.WHITE);
		btnEstacionesAdm.setBorder(null);
		btnEstacionesAdm.setOpaque(false);
		panelAdministrador.add(btnEstacionesAdm);

		btnUsuariosAdm = new JButton("Usuarios");
		btnUsuariosAdm.setHorizontalAlignment(SwingConstants.LEADING);
		btnUsuariosAdm.setToolTipText("Estaciones");
		btnUsuariosAdm.setFont(new Font("Voces", Font.BOLD, 14));
		btnUsuariosAdm.setForeground(new Color(255, 255, 255));
		btnUsuariosAdm.setBounds(22, 258, 146, 40);
		usuarios= new ImageIcon(this.getClass().getResource("usuarios.png")).getImage();
		btnUsuariosAdm.setIcon(new ImageIcon("C:\\Users\\Estudio\\Desktop\\Imprimir\\Agosto\\iloveimg-resized\\usuarios.png"));
		btnUsuariosAdm.setBackground(Color.WHITE);
		btnUsuariosAdm.setBorder(null);
		btnUsuariosAdm.setOpaque(false);
		panelAdministrador.add(btnUsuariosAdm);


		//Botones Investigador

		btnFormularioInv = new JButton("Formularios");
		btnFormularioInv.setToolTipText("Formularios");
		btnFormularioInv.setFont(new Font("Voces", Font.BOLD, 14));
		btnFormularioInv.setForeground(new Color(255, 255, 255));
		btnFormularioInv.setBounds(18, 35, 130, 40);
		btnFormularioInv.setIcon(new ImageIcon(form));
		btnFormularioInv.setBackground(Color.WHITE);
		btnFormularioInv.setBorder(null);
		btnFormularioInv.setOpaque(false);
		panelInvestigador.add(btnFormularioInv);

		btnRegistroInv = new JButton("Registros");
		btnRegistroInv.setToolTipText("Registros");
		btnRegistroInv.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnRegistroInv.setForeground(new Color(255, 255, 255));
		btnRegistroInv.setBounds(-8, 154, 156, 40);
		btnRegistroInv.setIcon(new ImageIcon(reg));
		btnRegistroInv.setBackground(Color.WHITE);
		btnRegistroInv.setBorder(null);
		btnRegistroInv.setOpaque(false);
		panelInvestigador.add(btnRegistroInv);

		btnCasillasInv = new JButton("Casillas");
		btnCasillasInv.setToolTipText("Casillas");
		btnCasillasInv.setFont(new Font("Voces", Font.BOLD, 14));
		btnCasillasInv.setForeground(new Color(255, 255, 255));
		btnCasillasInv.setBounds(2, 100, 130, 40);
		btnCasillasInv.setIcon(new ImageIcon(casilla));
		btnCasillasInv.setBackground(Color.WHITE);
		btnCasillasInv.setBorder(null);
		btnCasillasInv.setOpaque(false);
		panelInvestigador.add(btnCasillasInv);

		btnEstacionesInv = new JButton("Estaciones");
		btnEstacionesInv.setToolTipText("Estaciones");
		btnEstacionesInv.setFont(new Font("Voces", Font.BOLD, 14));
		btnEstacionesInv.setForeground(new Color(255, 255, 255));
		btnEstacionesInv.setBounds(0, 222, 156, 40);
		btnEstacionesInv.setIcon(new ImageIcon(estaciones));
		btnEstacionesInv.setBackground(Color.WHITE);
		btnEstacionesInv.setBorder(null);
		btnEstacionesInv.setOpaque(false);
		panelInvestigador.add(btnEstacionesInv);


		//panel superior azul
		panel_Superior = new JPanel();
		panel_Superior.setBounds(0, 0, 796, 84);
		panel_Superior.setBackground(azul);
		panel.add(panel_Superior);

		//icono HOME
		Icon_menu = new JLabel("");	
		Icon_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelAdministrador.setVisible(true);
				panelAficionado.setVisible(false);
				panelInvestigador.setVisible(false);
			}
		});
		Icon_menu.setBounds(10, 0, 90, 71);
		menu = new ImageIcon(this.getClass().getResource("menu.png")).getImage();
		panel.setLayout(null);
		panel_Superior.setLayout(null);
		Icon_menu.setIcon(new ImageIcon(menu));
		panel_Superior.add(Icon_menu);

		//icono Log Out
		logOut = new JLabel("");	
		logOut.setBounds(725, 11, 47, 49);
		Image log_out = new ImageIcon(this.getClass().getResource("exit.png")).getImage();
		panel.setLayout(null);
		panel_Superior.setLayout(null);
		logOut.setIcon(new ImageIcon(log_out));
		panel_Superior.add(logOut);


		JButton btnPrueba = new JButton("prueba");
		btnPrueba.setBounds(595, 349, 92, 40);
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdministrador.setVisible(false);
				panelInvestigador.setVisible(true);
				panelInvestigador.setBounds(0, 59, 158, 356);
				//panelAficionado.setVisible(true);
				//panelAficionado.setBounds(0, 59, 158, 356);
			}
		});
		btnPrueba.setForeground(Color.WHITE);
		btnPrueba.setFont(new Font("Verdana", Font.BOLD, 12));
		btnPrueba.setBackground(Color.GRAY);
		panel.add(btnPrueba);

		//panel de Monitoreo
		Image monitoreo= new ImageIcon(this.getClass().getResource("Monitoreo.png")).getImage();
		panel_Superior.setLayout(null);
		JLabel monitoreo1 = new JLabel("");
		monitoreo1.setBounds(208, -13, 460, 104);
		panel_Superior.add(monitoreo1);
		monitoreo1.setIcon(new ImageIcon(monitoreo));

	}
}
