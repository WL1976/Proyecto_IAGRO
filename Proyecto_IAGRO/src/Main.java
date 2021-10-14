import java.util.List;

import javax.naming.NamingException;

import com.exception.ServiciosException;

public class Main {

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		
		Long id = (long) 1;
		String nombre = "Pepa";
		String apellido = "Etchepare";
		String mail = "karen@utec.com";
		String user = "karenet";
		String pass = "contra";
		
		ControllerUsuario.crear(apellido, nombre, mail, user, pass);
		ControllerUsuario.crear(apellido, nombre, mail, user, pass);
		ControllerUsuario.crear(apellido, nombre, mail, user, pass);
		ControllerUsuario.crear(apellido, nombre, mail, user, pass);
		//ControllerUsuario.actualizar(id, apellido, nombre, mail, user, pass);
		//ControllerUsuario.borrar(id);
		
		List list = ControllerUsuario.obtenerTodos();
		String text = "";
		
		for(int i = 0; i<list.size(); i++) {
			
			text += list.get(i).toString() +"\n";
			
		}
		
		System.out.println(text);
		System.out.println("-----------------------------------------------------------");
		

	}

}
