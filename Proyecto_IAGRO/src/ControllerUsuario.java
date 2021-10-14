import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import model.Usuario;
import vistas.AltaUsuario;
import vistas.V_AltaUsuario;

public class ControllerUsuario {
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		
		
	
		
		
		String nom = "Karen";
		String ap = "Etchepare";
		String mail = "karen@utec.com";
		String usuario = "karenet";
		String contra = "contra";
		
		
			crear(ap, nom, mail, usuario, contra);
		
		

		AltaUsuario a = new AltaUsuario();
		V_AltaUsuario b = new V_AltaUsuario();
		a.setVisible(true);
		
		a.btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = a.table.getSelectedRow();
				long id = (long) a.table.getValueAt(row, 4);
				a.table.removeRowSelectionInterval(row, row);
				
				try {
					borrar(id);
				} catch (NamingException e1) {
				System.out.println("No se puede borrar el usuario");	
					e1.printStackTrace();
				}
			}
		});
		
		
		
		
		
	}

	public static void crear(String ap, String nom, String mail, String user, String pass) throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("Proyecto/UsuarioBean!com.servicios.UsuarioBeanRemote"); 
		
		Usuario usuario = new Usuario();
		usuario.setApellido(ap);
		usuario.setNombre(nom);
		usuario.setMail(mail);
		usuario.setNombreUsuario(user);
		usuario.setContraseña(pass);
		
		try {
			usuarioBean.crear(usuario);
			System.out.println("Se creó exitosamente el usuario");
		} catch (ServiciosException e) {
			
			System.out.println(e.getMessage());
		}

	}
	
	public static void actualizar(Long id, String ap, String nom, String mail, String user, String pass) throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("Proyecto/UsuarioBean!com.servicios.UsuarioBeanRemote"); 
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setApellido(ap);
		usuario.setNombre(nom);
		usuario.setMail(mail);
		usuario.setNombreUsuario(user);
		usuario.setContraseña(pass);
		
		try {
			usuarioBean.actualizar(usuario);
			System.out.println("Se actualizó exitosamente el usuario");
		} catch (ServiciosException e) {
			
			System.out.println(e.getMessage());
		}
	
	}
	
	public static void borrar(Long id) throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("Proyecto/UsuarioBean!com.servicios.UsuarioBeanRemote"); 
		
		
		try {
			usuarioBean.borrar(id);
			System.out.println("Se borró exitosamente el usuario");
		} catch (ServiciosException e) {
			
			System.out.println(e.getMessage());
		}
	
	}
	

	
	public static  List<Usuario> obtenerTodos() throws NamingException, ServiciosException{
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote) InitialContext.doLookup("Proyecto/UsuarioBean!com.servicios.UsuarioBeanRemote"); 
		
		List<Usuario> list = usuarioBean.obtenerTodos();
		return list;
	}
	
	public static void listarUsuarios(DefaultTableModel modelo) throws NamingException, ServiciosException {
		
		final String[] columnNames = {"Nombre","Apellido","Correo","Usuario"};
		// insertamos las columnas
		for(int column = 0; column < columnNames.length; column++){
			//agrega las columnas a la tabla
			modelo.addColumn(columnNames[column]);
		}
	
		Object [] fila = new Object[columnNames.length]; 
		// Se carga cada posición del array con una de las columnas de la tabla en base de datos.
		
		List<Usuario> usuarios = ControllerUsuario.obtenerTodos();
     	   for (Usuario u: usuarios) {
     		   fila[0]=u.getNombre();
     		   fila[1]=u.getApellido();
     		   fila[2]=u.getMail();
     		   fila[3]=u.getNombreUsuario();
     		   modelo.addRow(fila);
     		   System.out.println(u);
     	   }

}
}

