package controladores;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import vistas.Login;
import vistas.MenuPrincipal;

public class Main implements Constantes	{

	public static Usuario User;
	public static MenuPrincipal menuP;

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		V_login();
		menuP=new MenuPrincipal();

	}

	public static void V_login () throws NamingException { 
		Login login=new Login ();
		login.setVisible(true);

		//visualizar contraseña (ojo)
		login.btnojo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				login.Passcontraseña.setEchoChar((char) 0);
			}
			@Override
			public void focusLost(FocusEvent e) {
				login.Passcontraseña.setEchoChar('*');
			}
		});

		//Realizar Login
		login.btningresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String nombre=login.textNombreDeUsuario.getText();
				String contras = String.valueOf(login.Passcontraseña.getPassword());

				try {
					loginUsuario(nombre,contras);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Datos ingresados no válidos");
				}

			}
		});
	}

	//LOGIN
	public static void loginUsuario (String nombreUsuario, String contraseña) throws NamingException {

		UsuarioBeanRemote user = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		User=user.login1(nombreUsuario,contraseña);

		if (User!=null) {

			JOptionPane.showMessageDialog(null, "Acceso Correcto");
			String tipo=PerfilIngreso(nombreUsuario, contraseña);
			Login login=new Login ();
			login.setVisible(false);
			V_menu();

			menuP.setVisible(true);

		}else {

			JOptionPane.showMessageDialog(null, "Datos ingresados no válidos, intente nuevamente");
		}

	}

	//PERFIL PARA LOGIN
	public static String PerfilIngreso (String nombreUsuario, String contraseña) throws NamingException {

		UsuarioBeanRemote user = (UsuarioBeanRemote)
				InitialContext.doLookup("IagroEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");

		Usuario u2=user.login1(nombreUsuario, contraseña);
		String tipo=u2.getTipo();
		return tipo;

	}

	public static void V_menu() throws NamingException {

		//******************************Llamado a botones listado desde Menú******************************
		
		//MENU LISTADO USUARIOS DESDE ADMIN
		menuP.btnUsuariosAdm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {		
				try {
					ControllerUsuario.V_ListaUser();
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
				} catch (NamingException | ServiciosException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

	}
}
