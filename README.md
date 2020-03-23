
SWAGGER:
--------

ACCEDER A LA DOCUMENTACIÓN DE LA 'API' INGRESANDO A:  
http://localhost:8080/swagger-ui.html


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

