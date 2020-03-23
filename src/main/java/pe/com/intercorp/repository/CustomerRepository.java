package pe.com.intercorp.repository;

import java.util.ArrayList;
import java.util.List;  
import pe.com.intercorp.bean.Customer;

/** 
 * CustomerRepository
 * @author mgrasso
 **/
 public class CustomerRepository{
 
	    private List<Customer> listaClientes = new ArrayList<Customer>(); 
 
	   /**
	    * agregarCustomer 
	    * @param cliente
	    **/
		public void agregarCustomer( Customer cliente ){  
			   cliente.setId( this.listaClientes.size() + 1 );  //AUTOINCREMENTAR. 
			   this.listaClientes.add( cliente ); 
		}
 
	   /**
	    * listaCustomer 
	    * @param List<Customer>
	    **/
		public List<Customer> listaCustomer(){  
			   return listaClientes; 
		}	
}
