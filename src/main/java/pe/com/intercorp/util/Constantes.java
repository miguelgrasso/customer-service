package pe.com.intercorp.util;
 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Constantes
 * @author cguerra
 **/
 @Component
 public class Constantes{
 
	    //@Value( "${ws.nombre.servicio}" )             //ACCESO: al valor REMOTO [ws.nombre.servicio]
	    //public String nombreServicio;
 
		@Value( "${propiedades.config.valor_01}" )    //ACCESO: [propiedades.config.valor_01:]
		public String valor01; 
 
		public static String SERVICE_NAME_01 = "departmentservice";  
		public static String SERVICE_NAME_02 = "employeeservice"; 
		public static String SERVICE_NAME_03 = "organizationservice";
		public static String SERVICE_NAME_04 = "utlcapadb";
		
		public static String HTTP_METHOD_01 = "get";  
		public static String HTTP_METHOD_02 = "post"; 
		public static String HTTP_METHOD_03 = "delete";
 
		public static String IP_APP_OK      = "1.1.1.1";
		public static String USUARIO_APP_OK = "RGUERRA"; 
 
		
 }
