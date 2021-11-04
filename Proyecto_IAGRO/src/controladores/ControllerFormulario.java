package controladores;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JCheckBox;

import org.hibernate.mapping.Component;
import org.hibernate.mapping.List;

import com.entities.Casilla;
import com.entities.Formulario;
import com.exception.ServiciosException;
import com.servicios.UsuarioBeanRemote;

import vistas.Alta_Formulario;

import com.servicios.CasillasBeanRemote;
import com.servicios.FormulariosBeanRemote;

public class ControllerFormulario implements Constantes {
	
	public static void main(String[] args) {
		LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       // LocalDateTime localDateTime = LocalDateTime.from(formatDateTime.parse(dateTime));
        Timestamp ts = Timestamp.valueOf(dateTime);

        System.out.println(ts);
	}
	
	public static  ArrayList<Casilla> allCasillas;
	public static Alta_Formulario altaF;
	
	
	public static void crearForlumario() throws NamingException {
		
		FormulariosBeanRemote FormularioBean = (FormulariosBeanRemote)
				InitialContext.doLookup(RUTA_FormularioBean);
		
		CasillasBeanRemote CasillaBean = (CasillasBeanRemote)
				InitialContext.doLookup(RUTA_CasillaBean);
		
		Formulario f = new Formulario();
		ArrayList<Casilla> casillas = new ArrayList<>();
		
		for (Entry<Long, Casilla> entry : altaF.map.entrySet()) {
		   
			Casilla c = new Casilla();
			String nom = entry.getValue().getNombre();
			c = CasillaBean.buscar(nom);
			
			casillas.add(c);
			
			
			
		}
		
		f.setCasillas(casillas);
		
		
	
		
		try {FormularioBean.crear(f);} catch (ServiciosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
