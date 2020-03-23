package pe.com.intercorp.bean;

import java.io.Serializable; 
import javax.xml.bind.annotation.XmlRootElement; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
/**
 * KpiCustomer
 * @author mgraso
 **/
 //@Getter            //Autogenerar GETTERs. 
 //@Setter            //Autogenerar SETTERs. 
 @NoArgsConstructor   //Autogenerar CONTRUCTOR sin parametros. 
 @AllArgsConstructor  //Autogenerar CONTRUCTOR con parametros. 
 @Builder             //Autogenerar BUILDER. 
 @Data                //Autogenerar TOSTRING/GETTERs/SETTERs & otros. 
 @XmlRootElement( name = "kpiCustomer" ) 
public class KpiCustomer implements Serializable{
		 
	   private static final long serialVersionUID = -2569051888525119808L;

	   private String  promedio; 
	   private String  desviacionEstandar;
	 
}

