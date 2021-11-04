package controladores;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import com.entities.Departamento;
import com.entities.Estacion;
import com.entities.Usuario;
import com.exception.ServiciosException;
import com.servicios.DepartamentoBeanRemote;
import com.servicios.EstacionBean;
import com.servicios.EstacionBeanRemote;
import com.servicios.UsuarioBeanRemote;

import vistas.AltaEstacion;
import vistas.AltaUsuario;
import vistas.ListadoEstacion;
import vistas.ListadoUsuarios;

public class ControllerEstacion implements Constantes{

	public static AltaEstacion altaE;
	public static ListadoEstacion listE;


	//ventana Listado Estación
	public static void  V_ListaEst () throws NamingException, ServiciosException {

		listE=new ListadoEstacion();
		listE.setVisible(true);
		obtenerTodos();
		
		//Volver al Menú desde listado
				listE.btnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listE.setVisible(false);
						Main.menuP.setVisible(true);
					}
				});
		//Nueva Estación
		listE.btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){

			
				try {
					V_AltaEstacion();
					String usuario=Main.User.getNombre();
					altaE.lblNombreUser.setText(usuario);
					System.out.println(usuario);
				} catch (NamingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				altaE.btnRegistrar.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {

						String nom = altaE.textnombre.getText();
						int dpto=altaE.comboDpto.getSelectedIndex();
						float latitud = Float.valueOf(altaE.textLatitud.getText());
						float longitud = Float.valueOf(altaE.textLongitud.getText());
						float humedad = Float.valueOf(altaE.textHumedadRelativa.getText());
						float calAgua = Float.valueOf(altaE.textCalidadAgua.getText());

						try {
							crear(nom, Long.valueOf(dpto), latitud, longitud, humedad,calAgua,Main.User.getIdUsuario());
							JOptionPane.showMessageDialog(null,"Estación registrada correctamente");
							actualizarListado(listE.modelo);
						} catch (NamingException | ServiciosException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				//Volver al listado
				altaE.btnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listE.setVisible(true);
						altaE.setVisible(false);
					}
				});
			}

		});
		//Modificar una Estación
		listE.btnModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					V_ModEstacion();
				} catch (NamingException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ServiciosException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				String usuario=Main.User.getNombre();
				altaE.lblNombreUser.setText(usuario);
				int row = listE.table.getSelectedRow();

				if( row != (-1)) {
					long id = (long) listE.table.getValueAt(row, 4);

					HashMap<Long, Estacion> map = new HashMap<>();
					List<Estacion> estacion;
					try {
						estacion = ControllerEstacion.obtenerTodos();
						for (Estacion es: estacion) {

							map.put(es.getIdEstacion(), es);
						}
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ServiciosException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					Estacion est =map.get(id);
					//Cargar datos de usuario

					altaE.textnombre.setText(est.getNombre());
					//altaE.comboDpto.setSelectedItem(est.getDepartamento().toString());
					altaE.textLatitud.setText(Float.toString(est.getLatitud()));
					altaE.textLongitud.setText(Float.toString(est.getLongitud()));
					altaE.textHumedadRelativa.setText(Float.toString(est.getHumedadRelativa()));
					altaE.textCalidadAgua.setText(Float.toString(est.getHumedadRelativa()));

					int dp=Math.toIntExact(est.getDepartamento());
					altaE.comboDpto.setSelectedIndex(dp);

					//Guardar Cambios
					altaE.btnGuardar.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {

							int row = listE.table.getSelectedRow();
							long id = (long) listE.table.getValueAt(row, 4);

							String nom = altaE.textnombre.getText();
							Long dpto= (long) altaE.comboDpto.getSelectedIndex();
							float latitud = Float.valueOf(altaE.textLatitud.getText());
							float longitud = Float.valueOf(altaE.textLongitud.getText());
							float humedad = Float.valueOf(altaE.textHumedadRelativa.getText());
							float calAgua = Float.valueOf(altaE.textCalidadAgua.getText());


							try {
								ControllerEstacion.actualizar(id,nom, dpto, latitud, longitud, humedad, id);
								JOptionPane.showMessageDialog(null,"Estación actualizada correctamente");
								actualizarListado(listE.modelo);
							} catch (NamingException | ServiciosException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					});

				}
				else {
					JOptionPane.showMessageDialog(null, "Debe seleccionar una Estación", null, 1);
				}

				//Volver al listado
				altaE.btnVolver.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						listE.setVisible(true);
						altaE.setVisible(false);
					}
				});

			}
		});


	}

	//Ventana Alta Estación
	public static void V_AltaEstacion() throws NamingException, ServiciosException  {

		altaE=new AltaEstacion();
		altaE.setVisible(true);
		altaE.btnRegistrar.setVisible(true);
		altaE.btnGuardar.setVisible(false);

		Main.menuP.setVisible(false);
		altaE.comboDpto.setModel(new DefaultComboBoxModel (CompletarCombo()));


	}
	//Estaciones completar COMBOBOX CON DEPARTAMENTOS
	public static String [] CompletarCombo () throws NamingException, ServiciosException {

		List<Departamento> dptoList=obtenerDptos();
		String [] arrayDpto= new String [dptoList.size()];
		int i=0;
		for (Departamento d: dptoList) {
			arrayDpto[i]=d.getNombre();
			i++;

		}	
	
		return arrayDpto;	
	}

	//Ventana Modificar Estación	
	public static void V_ModEstacion() throws NamingException, ServiciosException {

		altaE=new AltaEstacion();
		altaE.setVisible(true);
		altaE.lblAltaEstacion.setText("MODIFICAR ESTACIÓN");
		altaE.btnRegistrar.setVisible(false);
		altaE.btnGuardar.setVisible(true);
	
		altaE.comboDpto.setModel(new DefaultComboBoxModel (CompletarCombo()));

		
	}

	//CREAR ESTACION
	public static void crear(String nombre, Long dpto,float latitud, float longitud, float humedadRelativa, float calidadAgua, Long usuarioCreador) throws NamingException {
		EstacionBeanRemote estacionBean = (EstacionBeanRemote)
				InitialContext.doLookup(RUTA_EstacionBean);

		Estacion estacion = new Estacion();
		estacion.setNombre(nombre);
		estacion.setDepartamento(dpto);
		estacion.setLatitud(latitud);
		estacion.setLongitud(longitud);
		estacion.setHumedadRelativa(humedadRelativa);
		estacion.setCalidadAgua(calidadAgua);
		estacion.setIdInvestigador(Main.User);

		try {
			estacionBean.crear(estacion);
			System.out.println(estacion.getIdEstacion());
			System.out.println("Se creó exitosamente la Estación");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}
	}

	//LISTADO DE DEPARTAMENTOS
	public static  List<Departamento> obtenerDptos() throws NamingException, ServiciosException{
		DepartamentoBeanRemote dptoBean = (DepartamentoBeanRemote)
				InitialContext.doLookup(RUTA_DepartamentoBean);

		List<Departamento> list = dptoBean.obtenerTodos();
		return list;
	}

	//ACTUALIZAR LISTADO
	public static void actualizarListado(DefaultTableModel modelo) throws NamingException, ServiciosException {

		//CompletarCombo();
		int filas = modelo.getRowCount();

		for(int i = filas-1; i>=0; i--) {
			modelo.removeRow(i);
		}


		final String[] columnNames = {"Nombre","Departamento","Latitud","Longitud","Identificador"};


		Object [] fila = new Object[columnNames.length]; 
		// Se carga cada posición del array con una de las columnas de la tabla en base de datos.

		List<Estacion> estaciones = obtenerTodos();
		for (Estacion e: estaciones) {
			int dp=Math.toIntExact(e.getDepartamento());

			fila[0]=e.getNombre();
			fila[1]=altaE.comboDpto.getItemAt(dp);
			fila[2]=e.getLatitud();
			fila[3]=e.getLongitud();
			fila[4]=e.getIdEstacion();
			modelo.addRow(fila);
		}

	}
	//LISTADO DE ESTACIONES
	public static  List<Estacion> obtenerTodos() throws NamingException, ServiciosException{
		EstacionBeanRemote estacionBean = (EstacionBeanRemote)
				InitialContext.doLookup(RUTA_EstacionBean);

		List<Estacion> list = estacionBean.obtenerTodos();
		return list;
	}

	//ACTUALIZAR ESTACIÓN
	public static void actualizar(Long id,String nombre, Long departamento,float latitud, float longitud, float humedadRelativa, float calidadAgua) throws NamingException {
		EstacionBeanRemote estacionBean = (EstacionBeanRemote)
				InitialContext.doLookup(RUTA_EstacionBean);


		Estacion estacion = new Estacion();
		estacion.setIdEstacion(id);
		estacion.setNombre(nombre);
		estacion.setDepartamento(departamento);
		estacion.setLatitud(latitud);
		estacion.setLongitud(longitud);
		estacion.setHumedadRelativa(humedadRelativa);
		estacion.setCalidadAgua(calidadAgua);


		try {
			
			estacionBean.actualizar(estacion);
			estacion=estacionBean.buscarEst(nombre);
			System.out.println(estacion.getIdEstacion() + " " +estacion.getNombre());
			System.out.println("Se actualizó exitosamente la estación");
		} catch (ServiciosException e) {

			System.out.println(e.getMessage());
		}

	}

}
