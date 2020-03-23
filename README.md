
SWAGGER:
--------

ACCEDER A LA DOCUMENTACIÓN DE LA 'API' INGRESANDO AL LINK:  
http://localhost:8080/swagger-ui.html

TOPDOWN APLICADO:
$ java -jar swagger-codegen-cli-3.0.9.jar generate -i API_customer-service.yaml --api-package pe.com.intercorp --model-package pe.com.intercorp.bean --group-id pe.com.intercorp --artifact-id customer-service --artifact-version 1.0.0 -l spring -o customer-service   
 


********************************************************************************
********************************** [CUSTOMER] **********************************
******************************************************************************** 

URLs: 
----  
GET: (HEALTH CHECK) 
- http://localhost:8080/customerservice/status


POST: 
- http://localhost:8080/customerservice/creacliente

{
  "nombre": "CATHERINE MAGALY",
  "apellido": "COTRINA VASQUEZ", 
  "fechaNacimiento": "21/04/1985" 
}


GET: 
- http://localhost:8080/customerservice/kpiclientes
- http://localhost:8080/customerservice/listclientes

