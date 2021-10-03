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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuPrincipal.class.getResource("/login/IaGRO_original.png")));

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
		panel.setBounds(0, 0, 782, 400);
		contentPane.add(panel);


		//logo iagro
		JLabel Icon_Container = new JLabel("");
		Icon_Container.setBounds(354, 128, 160, 148);
		Image icon = new ImageIcon(this.getClass().getResource("iagro_Menu.png")).getImage();
		panel.setLayout(null);
		panel.setLayout(null);
		Icon_Container.setIcon(new ImageIcon(icon));
		panel.add(Icon_Container);


		//panel Aficionado
		JPanel panelAficionado = new JPanel();
		panelAficionado.setBounds(198, 101, 130, 104);
		panelAficionado.setBackground(Color.WHITE);
		panel.add(panelAficionado);
		panelAficionado.setLayout(null);
		panelAficionado.setVisible(false);

		//Botón Aficionado Registro 
		JButton btnRegistrosAfi = new JButton("Registros");
		btnRegistrosAfi.setBounds(0, 40, 130, 40);
		btnRegistrosAfi.setForeground(Color.WHITE);
		btnRegistrosAfi.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRegistrosAfi.setBackground(new Color(192, 192, 192));
		panelAficionado.add(btnRegistrosAfi);

		//panel blanco lateral Admin
		JPanel panelAdministrador = new JPanel();
		panelAdministrador.setBounds(10, 71, 148, 329);
		panelAdministrador.setBackground(azul);
		panel.add(panelAdministrador);
		panelAdministrador.setLayout(null);


		//botones Admin
	/*	JButton btnCasillasAdm = new JButton("Casillas");
		btnCasillasAdm.setBackground(Color.WHITE);
		btnCasillasAdm.setForeground(UIManager.getColor("Button.darkShadow"));
		btnCasillasAdm.setFont(new Font("Candara Light", Font.BOLD, 14));
		btnCasillasAdm.setBounds(10, 103, 130, 40);
		btnCasillasAdm.setBorder(new LineBorder(azul, 3, true));
		panelAdministrador.add(btnCasillasAdm);*/

		JButton btnFormularios = new JButton("Formularios");
		btnFormularios.setBackground(azul);
		btnFormularios.setForeground(Color.WHITE);
		btnFormularios.setFont(new Font("Voces", Font.BOLD, 15));
		btnFormularios.setBounds(10, 52, 130, 40);
		btnFormularios.setBorder(null);
		panelAdministrador.add(btnFormularios);


		JButton btnRegistros = new JButton("Registros");
		btnRegistros.setBackground(Color.WHITE);
		btnRegistros.setForeground(new Color(119, 136, 153));
		btnRegistros.setFont(new Font("Candara Light", Font.BOLD, 12));
		btnRegistros.setBounds(10, 154, 130, 40);
		btnRegistros.setBorder(new LineBorder(azul, 3, true));
		panelAdministrador.add(btnRegistros);

		JButton btnUsuariosAdmin = new JButton("Usuarios");
		btnUsuariosAdmin.setBackground(Color.WHITE);
		btnUsuariosAdmin.setForeground(UIManager.getColor("Button.darkShadow"));
		btnUsuariosAdmin.setFont(new Font("Candara Light", Font.BOLD, 12));
		btnUsuariosAdmin.setBounds(10, 256, 130, 40);
		btnUsuariosAdmin.setBorder(new LineBorder(azul, 3, true));
		panelAdministrador.add(btnUsuariosAdmin);

		
		JButton btnEstacionesAdmin = new JButton("Estaciones");
		btnEstacionesAdmin.setBackground(Color.WHITE);
		btnEstacionesAdmin.setForeground(new Color(128, 128, 128));
		btnEstacionesAdmin.setFont(new Font("Candara Light", Font.BOLD, 12));
		btnEstacionesAdmin.setBounds(10, 205, 130, 40);
		btnEstacionesAdmin.setBorder(new LineBorder(azul, 3, true));
		panelAdministrador.add(btnEstacionesAdmin);
		

		//panel blanco lateral Investigador
		JPanel panelInvestigador = new JPanel();
		panelInvestigador.setBounds(547, 101, 130, 226);
		panelInvestigador.setBackground(Color.WHITE);
		panel.add(panelInvestigador);
		panelInvestigador.setVisible(false);
		panelInvestigador.setLayout(null);

		JButton btnRegistrosInv = new JButton("Registros");
		btnRegistrosInv.setBounds(0, 119, 130, 40);
		btnRegistrosInv.setForeground(Color.WHITE);
		btnRegistrosInv.setFont(new Font("Verdana", Font.BOLD, 12));
		btnRegistrosInv.setBackground(new Color(192, 192, 192));
		panelInvestigador.add(btnRegistrosInv);

		JButton btnEstacionesInv = new JButton("Estaciones");
		btnEstacionesInv.setBounds(0, 172, 130, 40);
		btnEstacionesInv.setForeground(Color.WHITE);
		btnEstacionesInv.setBackground(new Color(192, 192, 192));
		panelInvestigador.add(btnEstacionesInv);
		btnEstacionesInv.setFont(new Font("Verdana", Font.BOLD, 12));

		JButton btnFormulariosInv = new JButton("Formularios");
		btnFormulariosInv.setBounds(0, 13, 130, 40);
		panelInvestigador.add(btnFormulariosInv);
		btnFormulariosInv.setForeground(Color.WHITE);
		btnFormulariosInv.setFont(new Font("Verdana", Font.BOLD, 12));
		btnFormulariosInv.setBackground(new Color(192, 192, 192));


		//botones Investigador
		/*JButton btnCasillasInv = new JButton("Casillas");
		btnCasillasInv.setBounds(0, 66, 130, 40);
		panelInvestigador.add(btnCasillasInv);
		btnCasillasInv.setForeground(Color.WHITE);
		btnCasillasInv.setFont(new Font("Verdana", Font.BOLD, 12));
		btnCasillasInv.setBackground(new Color(192, 192, 192));*/

		//panel superior verde
		JPanel panel_Superior = new JPanel();
		panel_Superior.setBounds(10, 11, 701, 60);
		panel_Superior.setBackground(azul);
		panel.add(panel_Superior);

		//icono HOME
		JLabel Icon_home = new JLabel("");	
		Icon_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelAdministrador.setVisible(true);
				panelAficionado.setVisible(false);
				panelInvestigador.setVisible(false);
			}
		});
		Icon_home.setBounds(10, 0, 60, 60);
		Image home = new ImageIcon(this.getClass().getResource("home_blanco.png")).getImage();
		panel.setLayout(null);
		panel_Superior.setLayout(null);
		Icon_home.setIcon(new ImageIcon(home));
		panel_Superior.add(Icon_home);

		//icono Log Out
		JLabel logOut = new JLabel("");	
		logOut.setBounds(654, 11, 37, 49);
		Image log_out = new ImageIcon(this.getClass().getResource("log_out_bl.png")).getImage();
		panel.setLayout(null);
		panel_Superior.setLayout(null);
		logOut.setIcon(new ImageIcon(log_out));
		panel_Superior.add(logOut);
		
		/*JLabel casillas = new JLabel("");	
		logOut.setBounds(0, 66, 32,32 );
		Image casillas1 = new ImageIcon(this.getClass().getResource("lista.png")).getImage();
		casillas.setIcon(new ImageIcon(casillas1));
		panelAdministrador.add(casillas);*/
	
		Image casillas = new ImageIcon(this.getClass().getResource("lista.png")).getImage();
		JButton btncasillas = new JButton("Casillas");
		btncasillas.setBackground(Color.WHITE);
		panelAdministrador.add(btncasillas);
		btncasillas.setBounds(0, 66, 32,32 );
		btncasillas.setIcon(new ImageIcon(casillas));
		btncasillas.setHorizontalTextPosition(SwingConstants.RIGHT);
		btncasillas.setForeground(new Color(255, 255, 255,255));
		btncasillas.setBorder(null);
		btncasillas.setOpaque(true);	
		
	

		JButton btnPrueba = new JButton("prueba");
		btnPrueba.setBounds(595, 349, 92, 40);
		btnPrueba.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAdministrador.setVisible(false);
				//panelInvestigador.setVisible(true);
				//panelInvestigador.setBounds(10, 106, 148, 255);
				panelAficionado.setVisible(true);
				panelAficionado.setBounds(10, 144, 130, 104);
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
		monitoreo1.setBounds(149, -12, 460, 104);
		panel_Superior.add(monitoreo1);
		monitoreo1.setIcon(new ImageIcon(monitoreo));
		
	}
}
