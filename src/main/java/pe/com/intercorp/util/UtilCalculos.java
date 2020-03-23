package pe.com.intercorp.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import pe.com.intercorp.bean.Customer;
 
/**
 * UtilCalculos
 * @author mgrasso
 **/
 @Slf4j      //Autogenerar LOG4J.
 @Component
 public class UtilCalculos{
	
	   private Integer[] arregloEdades = null;
  
	  /**
	   * calcularPromedio 
	   * @param  listaTotalClientes
	   * @return BigDecimal
	   **/
	   public BigDecimal calcularPromedio( List<Customer> listaTotalClientes ){ 
		      log.info( "-----> Customer 'calcularPromedio'" );
 
		      
		      int      vTotalClientes = listaTotalClientes.size(); 
		      int      vSumaEdades    = 0;
		      Customer objCustomer    = null;
		   
			  log.info( "-----> vTotalClientes: [" + vTotalClientes + "]" );

			  List<Integer> listaEdades = new ArrayList<Integer>(); 
			  
			  for( int i=0; i<vTotalClientes; i++ ){
				   objCustomer = listaTotalClientes.get( i );
				   //int    vEdad            = objCustomer.getEdad();
				   String   vFechaCumplenios = objCustomer.getFechaNacimiento(); 
				 
				   String[] vArreglo         = vFechaCumplenios.split( "/"); 
			       int      vAniNacimiento   = Integer.parseInt( vArreglo[2] );
			       int      vAnioActual      = Calendar.getInstance().get( Calendar.YEAR );
			 	   int      vEdadActual      = (vAnioActual - vAniNacimiento);
				   
			 	   log.info( "-----> vFechaCumplenios: [" + vFechaCumplenios + "]" );
			 	   log.info( "-----> vAniNacimiento: ["   + vAniNacimiento   + "]" );
			       log.info( "-----> vAnioActual: ["      + vAnioActual      + "]" );
			       log.info( "-----> vEdadActual: ["      + vEdadActual      + "]" );
				   
				   vSumaEdades = (vSumaEdades + vEdadActual); 
				   listaEdades.add( vEdadActual ); 
			  }
			   
			  log.info( "-----> vSumaEdades: [" + vSumaEdades + "]" );
			   
			  BigDecimal vPromedio = BigDecimal.valueOf( vSumaEdades/vTotalClientes );
			  log.info( "-----> vPromedio: [" + vPromedio + "]" );
		  
			  this.arregloEdades = new Integer[ listaEdades.size() ];
			  this.arregloEdades = listaEdades.toArray( this.arregloEdades );
		      
			  return vPromedio;
	   }
	   
	   
	   /**
	    * calcularDesviacionEstandar 
	    * @return double
	    **/
		public double calcularDesviacionEstandar(){ 
		       log.info( "-----> Customer 'calcularDesviacionEstandar'" );
			
		       double vSum  = 0.0;
		       double vMean = 0.0;
		       double vNum  = 0.0;
		       double vNumi = 0.0; 
	 
		       for( int i : this.arregloEdades ){
		            vSum+=i;
		       }
		        
		       vMean = vSum/this.arregloEdades.length;
		
		       for( int i : this.arregloEdades ){
		            vNumi = Math.pow( (double) i - vMean, 2 );
		            vNum+=vNumi;
		       }
		
		       double vDesviacionEstandar = Math.sqrt( vNum/this.arregloEdades.length );
		       log.info( "-----> vDesviacionEstandar: [" + vDesviacionEstandar + "]" );
		       
		       return vDesviacionEstandar; 
	    }
	
 }

