package pe.com.intercorp.bean;

import java.io.Serializable;
import java.util.Calendar; 
import javax.xml.bind.annotation.XmlRootElement; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
/**
 * Customer
 * @author mgraso
 **/
 //@Getter            //Autogenerar GETTERs. 
 //@Setter            //Autogenerar SETTERs. 
 @NoArgsConstructor   //Autogenerar CONSTRUCTOR sin parametros. 
 @AllArgsConstructor  //Autogenerar CONSTRUCTOR con parametros. 
 @Builder             //Autogenerar BUILDER. 
 @Data                //Autogenerar TOSTRING/GETTERs/SETTERs & otros. 
 @XmlRootElement( name = "customer" ) 
public class Customer implements Serializable{
		 
	   private static final long serialVersionUID = -2569051539525119808L;
	 
	   private Integer id; 
	   private String  nombre; 
	   private String  apellido;  
	   private Integer edad;
	   private String  fechaNacimiento;
	   
	   public Integer getEdad(){ 
			  String[] vArreglo         = this.getFechaNacimiento().split( "/"); 
		      int      vAniNacimiento   = Integer.parseInt( vArreglo[2] );
		      int      vAnioActual      = Calendar.getInstance().get( Calendar.YEAR );
		 	  int      vEdadActual      = (vAnioActual - vAniNacimiento);
			   
			  return vEdadActual;
	   }
	   
}

