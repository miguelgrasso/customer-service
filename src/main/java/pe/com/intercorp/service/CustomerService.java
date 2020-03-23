package pe.com.intercorp.service;
 
import java.math.BigDecimal; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service; 
import lombok.extern.slf4j.Slf4j;
import pe.com.intercorp.bean.Customer;
import pe.com.intercorp.bean.KpiCustomer;
import pe.com.intercorp.bean.ResponseCustMsg;
import pe.com.intercorp.bean.ResponseDataMsg;
import pe.com.intercorp.repository.CustomerRepository;
import pe.com.intercorp.util.Constantes;
import pe.com.intercorp.util.UtilCalculos;

/**
 * EmpleadoService
 * @author mgrasso
 **/
 @Slf4j      //Autogenerar LOG4J. 
 @Service
 public class CustomerService{
 
		@Autowired
		private CustomerRepository customerRepository; 
		
		@Autowired
		private UtilCalculos utilCalculos;
		
		
	   /**	
	    * creacliente	
	    * @param  customer
	    * @return ResponseEntity<ResponseEntity>
	    **/  
		public ResponseEntity<String> creacliente( Customer customer ){ 
			   log.info( "-----> Customer 'creacliente': {}", customer );
		       
			   String vMensajeReturn = Constantes.MENSAJE_OK;
			   
			   //Agregando el NUEVO customer: 
			   this.customerRepository.agregarCustomer( customer );
			   
			   //Objeto Return: 
			   ResponseEntity<String> objRetorno = new ResponseEntity<String>( vMensajeReturn, HttpStatus.OK ); 
			   return objRetorno;
		}
	 
	   /**
		* kpiclientes	
		* @return ResponseEntity<ResponseDataMsg>
		**/  
		public ResponseEntity<ResponseDataMsg> kpiclientes(){
			   log.info( "-----> Customer 'kpiclientes'" );
		  
			   List<Customer> listaClientes       = this.listclientes().getBody().getListCustomers(); 			   
			   BigDecimal     vPromedio           = this.utilCalculos.calcularPromedio( listaClientes ); 
			   Double         vDesviacionEstandar = this.utilCalculos.calcularDesviacionEstandar();   
	 
			   KpiCustomer objKpiCustomer = new KpiCustomer();
			   objKpiCustomer.setPromedio( vPromedio + "" );
			   objKpiCustomer.setDesviacionEstandar( vDesviacionEstandar + "" );
			   			   
			   ResponseDataMsg objResponseMsg = new ResponseDataMsg();
			   objResponseMsg.setKpiCustomer( objKpiCustomer );
			   
			   //Objeto Return: 
			   ResponseEntity<ResponseDataMsg> objRetorno = new ResponseEntity<ResponseDataMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno;
		}
 	
	   /**
		* listclientes 
		* @return ResponseEntity<ResponseCustMsg>
		**/   
		public ResponseEntity<ResponseCustMsg> listclientes(){ 
			   log.info( "-----> Customer 'listclientes'" ); 
				 
			   //Obteniendo la lista del REPOSITORY: 
			   List<Customer> listaCustomers = this.customerRepository.listaCustomer(); 
			   
			   ResponseCustMsg objResponseMsg = new ResponseCustMsg();
			   objResponseMsg.listCustomers( listaCustomers ); 
			   
			   //Objeto Return: 
			   ResponseEntity<ResponseCustMsg> objRetorno = new ResponseEntity<ResponseCustMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno;
		}	
	 
 }
 
