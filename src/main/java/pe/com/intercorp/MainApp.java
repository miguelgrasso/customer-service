package pe.com.intercorp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;  
import pe.com.intercorp.bean.Customer; 
import pe.com.intercorp.repository.CustomerRepository;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;  
 
/**
 * MainApp
 * @author mgrasso
 **/
 @SpringBootApplication
 @EnableSwagger2         //IMPORTANTE: 'SWAGGER' 
 public class MainApp{
 
	    public static final String PAQUETE_SCAN = "pe.com.intercorp.controller";
	 
	   /**
	    * main 
	    * @param argumentos
	    **/
	    public static void main( String[] argumentos ){
		 	   SpringApplication.run( MainApp.class, argumentos );
	    }
  
	    //---------------------------------------- [SWAGGER] ----------------------------------------// 
		public ApiInfo apiInfo(){
	           return new ApiInfoBuilder()
	                  .title( "CONTRATO/API PARA LA GESTION DEL MICROSERVICIO: customer-service" )
	                  .description( "CONTRATO/API DEL MICROSERVICIO: customer-service" )
	                  .license( "Apache 2.0" )
	                  .licenseUrl( "http://www.apache.org/licenses/LICENSE-2.0.html" )
	                  .termsOfServiceUrl( "" )
	                  .version( "1.0" )
	                  .contact( new Contact( "", "", "mgrassoaguinaga@gmail.com" ) )
	                  .build();
	    }

	    @Bean
	    public Docket customImplementation(){
	        return new Docket( DocumentationType.SWAGGER_2 ) 
	                .select()
	                .apis( RequestHandlerSelectors.basePackage( PAQUETE_SCAN ) )
	                .paths( PathSelectors.any() ) 
                    .build() 
                    .apiInfo( this.apiInfo() );
	    }
	    //---------------------------------------- [SWAGGER] ----------------------------------------// 
	    
		@Bean
		CustomerRepository repository(){
			
			CustomerRepository ojRepository = new CustomerRepository(); 
            
			//IMPORTANTE: 'CARGA INICIAL' (El campo: 'EDAD' es calculable dinamicamente): 
			ojRepository.agregarCustomer( new Customer( 1, "CESAR MARTIN", "CRIADO VERA",      0, "01/03/1993" ) );
			ojRepository.agregarCustomer( new Customer( 2, "PAULO JULIO",  "PEREZ RAIMOND",    0, "21/01/1992" ) );
			ojRepository.agregarCustomer( new Customer( 3, "PEDRO FELIPE", "CALAGUA JORDAN",   0, "15/07/1990" ) );
			ojRepository.agregarCustomer( new Customer( 4, "MIGUEL MARIO", "ESPINOZA CARCAMO", 0, "11/10/1987" ) );	
			
			return ojRepository;
		}
 	    
 }

