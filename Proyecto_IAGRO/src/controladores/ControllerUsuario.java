package controladores;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.entities.Administrador;
import com.entities.Aficionado;
import com.entities.Investigador;
import com.entities.Usuario;
import com.exception.ServiciosException;

import com.servicios.UsuarioBeanRemote;

import vistas.AltaUsuario;

import vistas.ListadoUsuarios;

public class ControllerUsuario implements Constantes{


	//static AltaEstacion altaE;
	static ListadoUsuarios listU;
	static AltaUsuario altaU;


	//Ventana Alta Usuario
	public static void V_AltaUsuario() {

		altaU=new AltaUsuario();
		altaU.setVisible(true);
		altaU.btnRegistrar.setVisible(true);
		altaU.btnGuardar.setVisible(false);

	}

	//Ventana Modificar Usuario	
	public static void V_ModUsuario() {

		altaU=new AltaUsuario();
		altaU.lblAltaDeUsuarios.setText("MODIFICAR USUARIO");
		altaU.btnRegistrar.setVisible(false);
		altaU.btnGuardar.setVisible(true);

	}
	//CREAR USUARIO
	/*public static void crear(String ap, String nom, String mail, String user, String pass, String tipo) throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		Usuario usuario = new Usuario();
		usuario.setApellido(ap);
		usuario.setNombre(nom);
		usuario.setMail(mail);
		usuario.setNombreUsuario(user);
		usuario.setContraseña(pass);
		usuario.setTipo(tipo);

		try {
			usuarioBean.crear(usuario);
			System.out.println("Se creó exitosamente el usuario");
			actualizarListado(listU.modelo);
		} catch (ServiciosException | NamingException p) {

			System.out.println(p.getMessage());
		}

	}*/

	//ACTUALIZAR USUARIO
/*	public static void actualizar(Long id, String ap, String nom, String mail, String user, String pass, String tipo) throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(id);
		usuario.setApellido(ap);
		usuario.setNombre(nom);
		usuario.setMail(mail);
		usuario.setNombreUsuario(user);
		usuario.setContraseña(pass);
		usuario.setTipo(tipo);

		try {
			usuarioBean.actualizar(usuario);
			System.out.println("Se actualizó exitosamente el usuario");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}

	}*/

	//BORRAR USUARIO
	public static void borrar() throws NamingException {
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);


		int row = listU.table.getSelectedRow();

		if( row != (-1)) {
			long id = (long) listU.table.getValueAt(row, 4);
			try {
				int confirmado = JOptionPane.showConfirmDialog(null,"¿Desea borrar el usuario seleccionado?");
				//Si el usuario elige sí se borra la fila
				if (JOptionPane.OK_OPTION == confirmado) {
					try {
						usuarioBean.borrar(id);
						System.out.println("Se borró exitosamente el usuario");
					} catch (ServiciosException e) {

						System.out.println(e.getMessage());
					}
					actualizarListado(listU.modelo);
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


	//LISTADO DE USUARIOS
	public static  List<Usuario> obtenerTodos() throws NamingException, ServiciosException{
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		List<Usuario> list = usuarioBean.obtenerTodos();
		return list;
	}

	//ACTUALIZAR LISTADO
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

	public static void  V_ListaUser () throws NamingException {

		listU=new ListadoUsuarios();
		listU.setVisible(true);
		listU.btnEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					borrar();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		//Nuevo Usuario
		listU.btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){

				//Guardar Cambios
				V_AltaUsuario();

				altaU.btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						String ap = altaU.apellido.getText();
						String nom = altaU.nombre.getText();
						String mail = altaU.email.getText();
						String user = altaU.nombreUsu.getText();
						String pass = altaU.contrasena.getText();
						String tipo = (String) altaU.comboRol.getSelectedItem();
						String cedula = altaU.cedula.getText();
						String ciudad = altaU.ciudad.getText();
						String domicilio = altaU.domicilio.getText();
						String telefono = altaU.telefono.getText();
						String ocupacion = altaU.ocupacion.getText();

						//hacer para los otros atributos
						try {
							crear(ap, nom, mail, user, pass, tipo, cedula, ciudad, domicilio, telefono, ocupacion); 
							JOptionPane.showMessageDialog(null,"Usuario creado correctamente");
							actualizarListado(listU.modelo);
						} catch (NamingException | ServiciosException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				//Volver al listado
				altaU.btnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listU.setVisible(true);
						altaU.setVisible(false);
					}
				});
			}

		});

		//Modificar un usuario
		listU.btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				V_ModUsuario();
				int row = listU.table.getSelectedRow();

				if( row != (-1)) {
					long id = (long) listU.table.getValueAt(row, 4);

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

					Usuario user =map.get(id);
					//Cargar datos de usuario
					altaU.apellido.setText(user.getApellido());
					altaU.nombre.setText(user.getNombre());
					altaU.email.setText(user.getMail());
					altaU.nombreUsu.setText(user.getNombre());
					altaU.contrasena.setText(user.getContraseña());
					altaU.comboRol.setName(user.getTipo());
					//ojo aca
					altaU.cedula.setText(null);
					altaU.ciudad.setText(null);
					altaU.domicilio.setText(null);
					altaU.telefono.setText(null);
					altaU.ocupacion.setText(null);


					switch(user.getTipo()) {

					case "ADMINISRADOR": altaU.comboRol.setSelectedIndex(0);
					break;

					case "INVESTIGADOR": altaU.comboRol.setSelectedIndex(1);
					break;

					case "AFICIONADO": altaU.comboRol.setSelectedIndex(2);
					break;

					}


					//Guardar Cambios
					altaU.btnGuardar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							int row = listU.table.getSelectedRow();
							long id = (long) listU.table.getValueAt(row, 4);

							String ap = altaU.apellido.getText();
							String nom = altaU.nombre.getText();
							String mail = altaU.email.getText();
							String user = altaU.nombreUsu.getText();
							String pass = altaU.contrasena.getText();
							String tipo = (String) altaU.comboRol.getSelectedItem();
							String cedula = altaU.cedula.getText();
							String ciudad = altaU.ciudad.getText();
							String domicilio = altaU.domicilio.getText();
							String telefono = altaU.telefono.getText();
							String ocupacion = altaU.ocupacion.getText();

							try {
								ControllerUsuario.actualizar(id,ap, nom, mail, user, pass, tipo, cedula, ciudad, domicilio,telefono, ocupacion); 
								JOptionPane.showMessageDialog(null,"Usuario actualizado correctamente");
								actualizarListado(listU.modelo);
							} catch (NamingException | ServiciosException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});

				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario", null, 1);
				}

				//Volver al listado
				altaU.btnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listU.setVisible(true);
						altaU.setVisible(false);
					}
				});

			}
		});


	}

	//CREAR USUARIOS 
	public static void crear(String ap, String nom, String mail, String user, String pass, String tipo,
			String ciudad, String documento, String domicilio, String telefono,String ocupacion) throws NamingException {
		
		System.out.println("entré a CREAR");
		
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		Usuario usuario = new Usuario();
		usuario.setApellido(ap);
		usuario.setNombre(nom);
		usuario.setMail(mail);
		usuario.setNombreUsuario(user);
		usuario.setContraseña(pass);
		usuario.setTipo(tipo);
		
		System.out.println(usuario);
	
		
		switch(tipo) {

		case "Administrador":
			
		Administrador admin= new Administrador();
		admin.setApellido(ap);
		admin.setNombre(nom);
		admin.setMail(mail);
		admin.setNombreUsuario(user);
		admin.setContraseña(pass);
		admin.setTipo(tipo);

		admin.setCiudad(ciudad);
		admin.setDocumento(documento);
		admin.setDomicilio(domicilio);
		admin.setTelefono(telefono);
		


		try {
			
			usuarioBean.crearAd(admin);
			System.out.println("Se creó exitosamente el usuario Administrador");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;

		case "Investigador":
		Investigador invest= new Investigador();
		invest.setApellido(ap);
		invest.setNombre(nom);
		invest.setMail(mail);
		invest.setNombreUsuario(user);
		invest.setContraseña(pass);
		invest.setTipo(tipo);

		invest.setCiudad(ciudad);
		invest.setDocumento(documento);
		invest.setDomicilio(domicilio);
		invest.setTelefono(telefono);

		try {
			usuarioBean.crearIn(invest);
			System.out.println("Se creó exitosamente el usuario Investigador");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;

		case "Aficionado":
		Aficionado aficionado= new Aficionado();
		aficionado.setApellido(ap);
		aficionado.setNombre(nom);
		aficionado.setMail(mail);
		aficionado.setNombreUsuario(user);
		aficionado.setContraseña(pass);
		aficionado.setTipo(tipo);
		aficionado.setOcupacion(ocupacion);

		try {
			usuarioBean.crearAf(aficionado);
			System.out.println("Se creó exitosamente el usuario");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;			   
		}

	}

	public static void actualizar(Long id, String ap, String nom, String mail, String user, String pass, String tipo,
			String ciudad, String documento, String domicilio, String telefono, String ocupacion) throws NamingException {
		
		System.out.println("entré a ACTUALIZAR");
	
		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);

		switch(tipo) {

		case "Administrador":
		Administrador admin= new Administrador();
		admin.setIdUsuario(id);
		admin.setApellido(ap);
		admin.setNombre(nom);
		admin.setMail(mail);
		admin.setNombreUsuario(user);
		admin.setContraseña(pass);
		admin.setTipo(tipo);

		admin.setCiudad(ciudad);
		admin.setDocumento(documento);
		admin.setDomicilio(domicilio);
		admin.setTelefono(telefono);



		try {
			usuarioBean.actualizar(admin);
			System.out.println(admin);
			System.out.println("Usuario ADMINISTRADOR Actualizado con exito");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;

		case "Investigador":
		Investigador invest=new Investigador();
		invest.setIdUsuario(id);
		invest.setApellido(ap);
		invest.setNombre(nom);
		invest.setMail(mail);
		invest.setNombreUsuario(user);
		invest.setContraseña(pass);
		invest.setTipo(tipo);

		invest.setCiudad(ciudad);
		invest.setDocumento(documento);
		invest.setDomicilio(domicilio);
		invest.setTelefono(telefono);

		try {
			usuarioBean.actualizar(invest);
			System.out.println(invest);
			System.out.println("Usuario INVESTIGADOR con exito");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;

		case "Aficionado":
		Aficionado aficionado = new Aficionado();
		aficionado.setIdUsuario(id);
		aficionado.setApellido(ap);
		aficionado.setNombre(nom);
		aficionado.setMail(mail);
		aficionado.setNombreUsuario(user);
		aficionado.setContraseña(pass);
		aficionado.setTipo(tipo);
		aficionado.setOcupacion(ocupacion);

		try {
			usuarioBean.actualizar(aficionado);
			System.out.println("Usuario AFICIONADO Actualizado con exito");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
		break;			   
		}
	}

}