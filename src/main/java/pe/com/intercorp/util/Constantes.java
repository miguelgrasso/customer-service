package pe.com.intercorp.util;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constantes
 * @author mgrasso
 **/
 @Component
 public class Constantes{
 
	    @Value( "${spring.application.name}" )      
	    public String nombreServicio;
 
		public static String MENSAJE_OK = "PROCESO EXITOSO"; 
 }
