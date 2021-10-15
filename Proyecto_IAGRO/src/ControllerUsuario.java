import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import model.Usuario;
import vistas.ListadoUsuarios;
import vistas.V_AltaUsuario;

public class ControllerUsuario {
	
	public static void main(String[] args) throws NamingException, ServiciosException {
		
		
	
		
		
		/*String nom = "Karen";
		String ap = "Etchepare";
		String mail = "karen@utec.com";
		String usuario = "karenet";
		String contra = "contra";
		
		for(int i = 1; i<=28; i++) {
			actualizar((long)i,ap, nom, mail, usuario, contra);
		}*/
		
		//Instancia de listado de usuarios
		ListadoUsuarios a = new ListadoUsuarios();
		a.setVisible(true);
		
		//Borrar un usuario
		a.btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = a.table.getSelectedRow();
				
				if( row != (-1)) {
					long id = (long) a.table.getValueAt(row, 4);
					try {
						int confirmado = JOptionPane.showConfirmDialog(null,"¿Desea borrar el usuario seleccionado?");
								//Si el usuario elige sí se borra la fila
								if (JOptionPane.OK_OPTION == confirmado) {
									borrar(id);
									actualizarListado(a.modelo);
								}
						
					} catch (NamingException e1) {
					System.out.println("No se puede borrar el usuario");	
						e1.printStackTrace();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario", null, 1);
				}
				
			}
		});
		
		//Modificar un usuario
		a.btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			int row = a.table.getSelectedRow();
				
				if( row != (-1)) {
					long id = (long) a.table.getValueAt(row, 4);
					
					HashMap<Long, Usuario> map = new HashMap<>();
					List<Usuario> usuarios;
					try {
						usuarios = ControllerUsuario.obtenerTodos();
						for (Usuario u: usuarios) {
				     		   
				     		  map.put(u.getIdUsuario(), u);
				     	   }
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			     	   
			     	   
					Usuario user = map.get(id);
					V_AltaUsuario alta = new V_AltaUsuario();
					
					
					//Cargar datos de usuario
					alta.apellido.setText(user.getApellido());
					alta.nombre.setText(user.getNombre());
					alta.email.setText(user.getMail());
					alta.nombreUsu.setText(user.getNombreUsuario());
					alta.contrasena.setText(user.getContraseña());
					//alta.rol.setValue(a);
					
					a.setVisible(false);
					alta.main(args);
					
					
					
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario", null, 1);
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
	
	public static void actualizarListado(DefaultTableModel modelo) throws NamingException, ServiciosException {
		
		int filas = modelo.getRowCount();
		
		for(int i = filas-1; i>=0; i--) {
			modelo.removeRow(i);
		}
		
		
		final String[] columnNames = {"Nombre","Apellido","Correo","Usuario","Identificador"};
	
	
		Object [] fila = new Object[columnNames.length]; 
		// Se carga cada posición del array con una de las columnas de la tabla en base de datos.
		
		List<Usuario> usuarios = ControllerUsuario.obtenerTodos();
     	   for (Usuario u: usuarios) {
     		   fila[0]=u.getNombre();
     		   fila[1]=u.getApellido();
     		   fila[2]=u.getMail();
     		   fila[3]=u.getNombreUsuario();
     		   fila[4]=u.getIdUsuario();
     		   modelo.addRow(fila);
     	   }

}
}

