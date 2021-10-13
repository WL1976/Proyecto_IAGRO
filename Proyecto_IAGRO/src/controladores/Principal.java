package controladores;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import ventanas.Login;

public class Principal {

	public static void main(String[] args) throws ServiciosException {
		// TODO Auto-generated method stub

		//LOGIN

		Login login=new Login ();
		login.main(null);

	}

}
