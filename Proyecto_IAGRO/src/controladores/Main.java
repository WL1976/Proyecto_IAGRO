package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.entities.Estado;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import vistas.Login;
import vistas.MenuPrincipal;



public class Main implements Constantes	{

	public static Usuario User;
	public static MenuPrincipal menuP;
	public static Login login;

	public static void main(String[] args) throws NamingException, ServiciosException {

		V_login();
		menuP=new MenuPrincipal();

	}

	public static void V_login () throws NamingException { 
		login=new Login ();
		login.setVisible(true);

		//visualizar contrase�a (ojo)
		login.btnojo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				login.Passcontrase�a.setEchoChar((char) 0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				login.Passcontrase�a.setEchoChar('*');
			}
		});

		//Realizar Login
		login.btningresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nombre=login.textNombreDeUsuario.getText();
				String contras = String.valueOf(login.Passcontrase�a.getPassword());
				

				try {
					loginUsuario(nombre,contras);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Datos ingresados no v�lidos");
				}

			}
		});
	}

	//LOGIN
	public static void loginUsuario (String nombreUsuario, String contrase�a) throws NamingException {

		UsuarioBeanRemote user = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		User=user.login1(nombreUsuario,contrase�a);
		user.buscarUser(nombreUsuario);

		if (User!=null && User.getEstado().equals(Estado.ACTIVO)) {

			String tipo=PerfilIngreso(nombreUsuario, contrase�a);
			menuP.perfil(tipo);
			V_menu();
			login.setVisible(false);
			menuP.setVisible(true);

		}else {

			JOptionPane.showMessageDialog(null, "Datos ingresados no v�lidos, intente nuevamente");
		}

	}

	//PERFIL PARA LOGIN
	public static String PerfilIngreso (String nombreUsuario, String contrase�a) throws NamingException {

		UsuarioBeanRemote user = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		Usuario u2=user.login1(nombreUsuario, contrase�a);
		String tipo=u2.getTipo();
		return tipo;

	}

	public static void V_menu() throws NamingException {

		//******************************Llamado a botones listado desde Men�******************************
		//MENU LISTADO USUARIOS DESDE ADMIN
		menuP.btnUsuariosAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				try {
					ControllerUsuario.V_ListaUser();
					menuP.setVisible(false);

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//MENU LISTADO ESTACIONES DESDE ADMIN	
		menuP.btnEstacionesAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerEstacion.V_ListaEst();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		//MENU LISTADO ESTACIONES DESDE INVE	
		menuP.btnEstacionesInv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerEstacion.V_ListaEst();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuP.btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showOptionDialog(null,
						"�Seguro que desea salir del sistema?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE,null, null, null);							//Si el usuario elige s� se borra la fila
				if (JOptionPane.YES_OPTION== confirm) {
					User = null;
					menuP.dispose();
					menuP.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					try {
						V_login();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		//FORMULARIO ADMIN E INVE
		menuP.btnFormularioAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerFormulario.V_ListaForm();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	
		menuP.btnFormularioInv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerFormulario.V_ListaForm();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//CASILLAS ADMIN E INVE
		menuP.btnCasillasAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerCasillas.V_ListaCasilla();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		menuP.btnCasillasInv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				try {
					ControllerCasillas.V_ListaCasilla();
					menuP.setVisible(false);
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

}
