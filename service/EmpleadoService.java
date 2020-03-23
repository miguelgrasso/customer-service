package pe.com.capacitacion.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;  
import org.springframework.web.client.RestTemplate; 
import com.google.gson.Gson;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand; 
import lombok.extern.slf4j.Slf4j;
import pe.com.capacitacion.bean.Auditoria;
import pe.com.capacitacion.bean.Empleado;
import pe.com.capacitacion.dto.ResponseEmplMsg;
import pe.com.capacitacion.exception.AuditoriaException;
import pe.com.capacitacion.properties.ConfigurationData_01;
import pe.com.capacitacion.util.Constantes;

/**
 * EmpleadoService
 * @author cguerra
 **/
 @Slf4j      //Autogenerar LOG4J. 
 @Service
 public class EmpleadoService extends AuditoriaException{
 
		@Autowired
		private Constantes constantes; 
		
		@Autowired
		private ConfigurationData_01 objConfigurationData01;  //ACCESO: inicia con [grupoconfig01]  		 
  		
		@Autowired
		private RestTemplateBuilder objTemplate;  
		
		@Autowired
		private EurekaClient objClient;
 
	   /**	
	    * agregarEmpleadoService	
	    * @param  empleado
	    * @return ResponseEntity<ResponseEmplMsg>
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseEmplMsg> agregarEmpleadoService( Empleado empleado ){
			   log.info( "-----> Empleado 'agregarEmpleadoService': {}", empleado );
		 
			   Gson   objGson = new Gson();
			   String vURI    = "/empleados";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
		 
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		
			   //Conectar con 'EUREKA': 
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_02 + vURI); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Transformar de OBJETO a JSON:                                         
			   String vParamRequestJSON = objGson.toJson( empleado );
			   log.info( "========>: vParamRequestJSON: " + vParamRequestJSON ); 
			   	       
			   //Definiendo Entity: 
			   HttpHeaders objHeader = new HttpHeaders(); 
			   objHeader.setContentType( MediaType.APPLICATION_JSON );		 
			   HttpEntity<Object> objEntityRequest = new HttpEntity<Object>( empleado, objHeader ); 
			   
			   //Enviar mensaje POST: 
			   ResponseEntity<String> vCadenaJSON_01 = objRspTmp.postForEntity( vURL01, objEntityRequest, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01.getBody() + "]" );
			   
			   //Transformar de JSON a OBJETO:    		
			   pe.com.capacitacion.dto.ResponseEmplMsg objResponseMsg = objGson.fromJson( vCadenaJSON_01.getBody(), pe.com.capacitacion.dto.ResponseEmplMsg.class );
			   log.info( "========>: objResponseMsg: " + objResponseMsg ); 
  
			   //Objeto Return: 
			   ResponseEntity<ResponseEmplMsg> objRetorno = new ResponseEntity<ResponseEmplMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno;
		}
				
	   /**	
	    * eliminarEmpleadoService	
	    * @param  id
	    * @return ResponseEmplMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseEmplMsg> eliminarEmpleadoService( Long id ){
			   log.info( "-----> Empleado 'eliminarEmpleadoService': {}", id );
 
			   String vURI = "/empleados/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			   
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		
			   //Conectar con 'EUREKA':
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_03 + vURI + id); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje DELETE: 
			   objRspTmp.delete( vURL01 );  //Es VOID. 
               
			   //Armando estructura RESPONSE: 
			   Auditoria       objAuditoria   = super.cargarDatosAuditoria( Constantes.IP_APP_NOK, Constantes.MSJ_APP_OK, Constantes.USUARIO_APP_NOK, Constantes.MSJ_APP_OK ); 
			   ResponseEmplMsg objResponseMsg = new ResponseEmplMsg();
			   objResponseMsg.setAuditoria( objAuditoria );
			   
			   //Objeto Return: 
			   ResponseEntity<ResponseEmplMsg> objRetorno = new ResponseEntity<ResponseEmplMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno;
		}
 		
	   /**
		* consultarEmpleadosAllService	
		* @return ResponseEmplMsg
		**/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarListaExceptionWS].
		public ResponseEntity<ResponseEmplMsg> consultarEmpleadosAllService(){ 
			   log.info( "-----> Empleado 'consultarEmpleadosAllService'" );
		 
			   Gson   objGson = new Gson();
			   String vURI    = "/empleados";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 ); 
			  
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA':
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET: 
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO:   
			   pe.com.capacitacion.dto.ResponseEmplMsg objResponseMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseEmplMsg.class );
			   log.info( "========>: objResponseMsg: " + objResponseMsg ); 
 
			   //Objeto Return: 
			   ResponseEntity<ResponseEmplMsg> objRetorno = new ResponseEntity<ResponseEmplMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno;
		}
 	
	   /**
		* consultarEmpleadosPorIdService	
		* @param  id
		* @return ResponseEmplMsg
		**/  
		@HystrixCommand( fallbackMethod = "lanzarExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarExceptionWS].
		public ResponseEntity<ResponseEmplMsg> consultarEmpleadosPorIdService( Long id ){ 
			   log.info( "-----> Empleado 'consultarEmpleadosPorIdService': id={}", id ); 
				 
			   Gson   objGson = new Gson();
			   String vURI    = "/empleados/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			  
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA':
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI + id); 
			   log.info( "========>: vURL0 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET: 
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO:   
			   pe.com.capacitacion.dto.ResponseEmplMsg objResponseMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseEmplMsg.class );
			   log.info( "========>: objResponseMsg: " + objResponseMsg ); 
 
			   //Objeto Return: 
			   ResponseEntity<ResponseEmplMsg> objRetorno = new ResponseEntity<ResponseEmplMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno; 
		}	
		
	   /**
	    * consultarEmpleadosPorDepartamentoService	
	    * @param  idDep
	    * @return ResponseEmplMsg
	    **/ 
		@HystrixCommand( fallbackMethod = "lanzarListaExceptionWS" )   //ANTE UNA FALLA LANZARPA EL M�TODO: [lanzarListaExceptionWS].
		public ResponseEntity<ResponseEmplMsg> consultarEmpleadosPorDepartamentoService( Long idDep ){
			   log.info( "-----> Departamento 'consultarEmpleadosPorDepartamentoService': idDep={}", idDep );
			   
			   Gson   objGson = new Gson();
			   String vURI    = "/empleados-departamento/";
			   
			   //Variables de Entorno: 
			   this.mostrarVariablesEntorno( this.constantes, this.objConfigurationData01 );
			   
			   RestTemplate objRspTmp = this.objTemplate.build(); 
		 		 
			   //Conectar con 'EUREKA':
			   InstanceInfo vIdIstanciaEureka_04 = this.objClient.getNextServerFromEureka( Constantes.INSTANCIA_EUREKA_04, false ); 		   
			   log.info( "========>: vIdIstanciaEureka_04 [" + vIdIstanciaEureka_04 + "]" );	 
			   
			   //Obtener INSTANCIA de 'EUREKA': 
			   String  vURLInst04 = vIdIstanciaEureka_04.getHomePageUrl();  
			   log.info( "========>: vURLInst [" + vURLInst04 + "]" ); 
 
			   //Armando URI: 
			   String vURL01 = (vURLInst04 + Constantes.SERVICE_NAME_04 + "/" + Constantes.HTTP_METHOD_01 + vURI + idDep); 
			   log.info( "========>: vURL01 [" + vURL01 + "]" );
			   
			   //Enviar mensaje GET: 
			   String vCadenaJSON_01 = objRspTmp.getForObject( vURL01, String.class );
			   log.info( "========>: vCadenaJSON_01 [" + vCadenaJSON_01 + "]" ); 
			   
			   //Transformar de JSON a OBJETO:   
			   pe.com.capacitacion.dto.ResponseEmplMsg objResponseMsg = objGson.fromJson( vCadenaJSON_01, pe.com.capacitacion.dto.ResponseEmplMsg.class );
			   log.info( "========>: objResponseMsg: " + objResponseMsg ); 
 
			   //Objeto Return: 
			   ResponseEntity<ResponseEmplMsg> objRetorno = new ResponseEntity<ResponseEmplMsg>( objResponseMsg, HttpStatus.OK ); 
			   return objRetorno; 
		}	
 
	   /**
	    * mostrarVariablesEntorno
	    * @param constantesParam
	    * @param objConfigurationData01Param 
	    **/
        private void mostrarVariablesEntorno( Constantes constantesParam, ConfigurationData_01 objConfigurationData01Param ){
        	    log.info( "-----> Empleado 'mostrarVariablesEntorno'" );
        	 
			    String vNombreServicio = constantesParam.nombreServicio; 
			    String vValor_01       = constantesParam.valor01; 
			    String vNombres        = objConfigurationData01Param.getNombres();
			    String vDni            =  objConfigurationData01Param.getDni(); 			
			    log.info( "vNombreServicio: [" + vNombreServicio + "], vValor_01: [" + vValor_01 + "], vNombres: [" + vNombres + "], vDni: [" + vDni + "]" ); 
        }
		
 }
 
