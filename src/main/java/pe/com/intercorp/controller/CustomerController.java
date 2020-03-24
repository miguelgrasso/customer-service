package pe.com.intercorp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 
import io.swagger.annotations.Api; 
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import pe.com.intercorp.bean.Customer;
import pe.com.intercorp.bean.ResponseCustMsg;
import pe.com.intercorp.bean.ResponseDataMsg;
import pe.com.intercorp.service.CustomerService; 

/**
 * CustomerController
 * @author mgrasso
 **/
 @Slf4j      //Autogenerar LOG4J. 
 @RestController
 @RequestMapping( "/customerservice" ) //NO USAR: [server.servlet.context-path], 'BOOT-ADMIN' reconocera el 'ACTUATOR'.
 @Api( value="CustomerController", description="'CONTRATO/API PARA LA GESTION DEL MICROSERVICIO: customer-service" )
 public class CustomerController{
	    
		@Autowired
		private CustomerService objCustomerService;  
		
       /**
        * checkStatus 
        * @return String
        **/
		@GetMapping( "/status" )
	    @ApiOperation( value="Funcionalidad para medi del HEALTH CHECK del servicio.", nickname="checkStatus", notes="Funcionalidad para medir del HEALTH CHECK del servicio." )
		public String checkStatus(){
               return "ok";
		}
		
	   /**
	    * creacliente	
	    * @param  empleado
	    * @return ResponseEntity<ResponseEmplMsg>
	    **/
		@PostMapping( "/creacliente" )
	    @ApiOperation( value="Funcionalidad para [REGISTRAR] una ENTIDAD de tipo Customer.", nickname="creacliente", notes="Funcionalidad para [REGISTRAR] una ENTIDAD de tipo Customer." )
		public ResponseEntity<String> creacliente( @RequestBody Customer customer ){ 
			   log.info( "Customer 'creacliente': {}", customer );
			   ResponseEntity<String> objResponseMsg = this.objCustomerService.creacliente( customer ); 
			   return objResponseMsg; 
		}
        
	   /**
	    * kpiclientes	  
	    * @return ResponseEntity<ResponseDataMsg>
	    **/
		@GetMapping( "/kpiclientes" )
	    @ApiOperation( value="Funcionalidad para [CONSULTAR] datos de una ENTIDAD de tipo Customer.", nickname="kpiclientes", notes="Funcionalidad para [CONSULTAR] datos de una ENTIDAD de tipo Customer." )
		public ResponseEntity<ResponseDataMsg> kpiclientes(){
			   log.info( "Customer 'kpiclientes'");
			   ResponseEntity<ResponseDataMsg> objResponseMsg = this.objCustomerService.kpiclientes();
			   return objResponseMsg; 
		}
		
	   /** 
	    * listclientes	
	    * @return ResponseEntity<ResponseCustMsg>
	    **/
		@GetMapping( "/listclientes" )
	    @ApiOperation( value="Funcionalidad para [CONSULTAR] la LISTA de una ENTIDAD de tipo Customer.", nickname="listclientes", notes="Funcionalidad para [CONSULTAR] la LISTA de una ENTIDAD de tipo Customer." )
		public ResponseEntity<ResponseCustMsg> listclientes(){
			   log.info( "Customer 'listclientes'");
			   ResponseEntity<ResponseCustMsg> objResponseMsg = this.objCustomerService.listclientes(); 
			   return objResponseMsg; 
		}
	    
 }

 