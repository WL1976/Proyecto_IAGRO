package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;

import com.entities.Usuario;
import com.servicios.UsuarioBeanRemote;

import ventanas.Login;
import ventanas.MenuPrincipal;

public class ControladorUsuario {

	public void loginUsuario (String nombreUsuario, String contraseña) throws NamingException {

		
			UsuarioBeanRemote user = (UsuarioBeanRemote)
					InitialContext.doLookup("IagroEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");

			Usuario u1=user.login1(nombreUsuario, contraseña);

			if (u1!=null) {

				JOptionPane.showMessageDialog(null, "Acceso Correcto");
				String tipo=PerfilIngreso(nombreUsuario, contraseña);
				MenuPrincipal menu=new MenuPrincipal();
				Login login=new Login ();
				login.setVisible(false);
				menu.perfil(tipo);
				menu.setVisible(true);
			
			
			}else {
					
				JOptionPane.showMessageDialog(null, "Datos ingresados no válidos, intente nuevamente");
			}
			
		
		
	}
	public  String PerfilIngreso (String nombreUsuario, String contraseña) throws NamingException {

		UsuarioBeanRemote user = (UsuarioBeanRemote)
				InitialContext.doLookup("IagroEJB/UsuarioBean!com.servicios.UsuarioBeanRemote");

		Usuario u2=user.login1(nombreUsuario, contraseña);
		String tipo=u2.getTipo();
		return tipo;

	}

}