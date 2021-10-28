package controladores;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

public class ControllerUsuario implements Constantes {


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
	@SuppressWarnings("deprecation")
	public static void V_ModUsuario() {

		altaU=new AltaUsuario();
		altaU.lblAltaDeUsuarios.setText("MODIFICAR USUARIO");
		altaU.btnRegistrar.setVisible(false);
		altaU.btnGuardar.setVisible(true);

		/***** BLOQUEAR CAMPOS KAREN 28-10******/
		altaU.nombreUsu.enable(false);
		altaU.email.enable(false);

	}

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


						try {
							crear(ap, nom, mail, user, pass, tipo, ciudad, cedula, domicilio, telefono, ocupacion); 
							//actualizarListado(listU.modelo);
						} catch (NamingException  e1) {
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

		listU.btnModificar.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 

			} 
		} );

		listU.btnModificar.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
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
					altaU.nombreUsu.setText(user.getNombreUsuario());
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
								//actualizarListado(listU.modelo);
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

		/***** NUEVAS LLAMADAS A MÉTODO KAREN 28-10******/
		boolean todoOK = camposVacios(ap, nom, mail, user, pass, tipo, ciudad, documento, domicilio, telefono, ocupacion);
		
		todoOK = validarFormatos(mail, user);
		todoOK = validarContraseña(pass);



		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)InitialContext.doLookup(RUTA_UsuarioBean);

		/***** NUEVA CONDICIÓN KAREN 28-10******/
		Usuario existeUser = usuarioBean.usuarioExistente(user);
		if(existeUser != null) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario ingresado ya existe", null, 1);
			todoOK = false;
		}

		/***** NUEVA CONDICIÓN KAREN 28-10******/
		Usuario existeMail = usuarioBean.correoExistente(mail);
		if(existeMail != null) {
			JOptionPane.showMessageDialog(null, "El correo ingresado ya existe", null, 1);
			todoOK = false;
		}

		/******TODO EL SWITCH VA DENTRO DEL IF KAREN 28-10******/
		if(todoOK) {
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
					JOptionPane.showMessageDialog(null,"Se creó exitosamente el usuario Administrador");
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
					JOptionPane.showMessageDialog(null,"Se creó exitosamente el usuario Investigador");
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
					JOptionPane.showMessageDialog(null,"Se creó exitosamente el usuario Aficionado");
				} catch (ServiciosException e) {

					System.out.println(e.getMessage());
				}
				break;			   
			}

		}

	}

	public static void actualizar(Long id, String ap, String nom, String mail, String user, String pass, String tipo,
			String ciudad, String documento, String domicilio, String telefono, String ocupacion) throws NamingException, ServiciosException {

		boolean todoOK = camposVacios(ap, nom, mail, user, pass, tipo, ciudad, documento, domicilio, telefono, ocupacion);

		todoOK = validarFormatos(mail, user);
		


		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup(RUTA_UsuarioBean);


		if(todoOK) {
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

			JOptionPane.showMessageDialog(null,"Usuario actualizado correctamente");
			actualizarListado(listU.modelo);
		}


	}

	/******METODO NUEVO KAREN 28-10******/

	public static boolean camposVacios(String ap, String nom, String mail, String user, String pass, String tipo,
			String ciudad, String documento, String domicilio, String telefono, String ocupacion) {

		boolean bandera = true;

		if(ap.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar el campo Apellido", null, 1);
			bandera = false;
		}
		if(nom.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar el campo Nombre", null, 1);
			bandera = false;
		}
		if(mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar el campo Correo", null, 1);
			bandera = false;
		}
		if(user.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar el campo Nombre de Usuario", null, 1);
			bandera = false;
		}
		if(pass.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Debe completar el campo Contraseña", null, 1);
			bandera = false;
		}

		if(tipo != "Aficionado") {

			if(ciudad.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe completar el campo Ciudad", null, 1);
				bandera = false;
			}

			if(documento.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe completar el campo Documento", null, 1);
				bandera = false;
			}

			if(telefono.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe completar el campo Telefono", null, 1);
				bandera = false;
			}

		}else {
			if(ocupacion.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debe completar el campo Ocupacion", null, 1);
				bandera = false;
			}
		}


		return bandera;

	}

	/******METODO NUEVO KAREN 28-10******/

	public static boolean validarFormatos(String mail, String user) {

		boolean bandera = true;

		//Minimo de caracteres
		if(user.length() <8) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario debe tener al menos 8 caracteres", null, 1);
			bandera = false;
		}


		//Usuario sin números
		if(user.matches("[0-9]+")) {
			JOptionPane.showMessageDialog(null, "El nombre de usuario no puede contener números", null, 1);
			bandera = false;
		}


		//correo no valido
		if(!mail.contains("@")) {
			JOptionPane.showMessageDialog(null, "El correo ingresado no es válido", null, 1);
			bandera = false;
		}


		return bandera;

	}

	public static boolean validarContraseña(String pass) {

		boolean bandera = true;

		//Minimo caracteres
		if(pass.length() <8) {
			JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres", null, 1);
			bandera = false;
		}

		//Contraseña con números y letras

		String letras = pass.replaceAll("[*0-9]", "");
		String numeros = pass.replaceAll("[*a-zA-ZÀ-ÿ\u00f1\u00d1]", "");


		if(!numeros.matches("[0-9]+") || !letras.matches("[a-zA-ZÀ-ÿ\u00f1\u00d1]+")) {
			JOptionPane.showMessageDialog(null, "La contraseña debe contener números y letras", null, 1);
			bandera = false;
		}

		return bandera;
	}

}

