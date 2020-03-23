package pe.com.intercorp.bean;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import pe.com.intercorp.bean.Customer;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ResponseCustMsg
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-23T12:15:54.600-05:00[America/Bogota]")
public class ResponseCustMsg   {
	  
	  @JsonProperty("listCustomers")
	  @Valid
	  private List<Customer> listCustomers = null;
	
	  public ResponseCustMsg listCustomers(List<Customer> listCustomers) {
	    this.listCustomers = listCustomers;
	    return this;
	  }
	
	  public ResponseCustMsg addListCustomersItem(Customer listCustomersItem) {
	    if (this.listCustomers == null) {
	      this.listCustomers = new ArrayList<Customer>();
	    }
	    this.listCustomers.add(listCustomersItem);
	    return this;
	  }
	
	  /**
	   * Get listCustomers
	   * @return listCustomers
	  **/
	  @ApiModelProperty(value = "")
	  @Valid
		public List<Customer> getListCustomers() {
	    return listCustomers;
	  }
	
	  public void setListCustomers(List<Customer> listCustomers) {
	    this.listCustomers = listCustomers;
	  }
	
	
	  @Override
	  public boolean equals(java.lang.Object o) {
	    if (this == o) {
	      return true;
	    }
	    if (o == null || getClass() != o.getClass()) {
	      return false;
	    }
	    ResponseCustMsg responseCustMsg = (ResponseCustMsg) o;
	    return Objects.equals(this.listCustomers, responseCustMsg.listCustomers);
	  }
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(listCustomers);
	  }
	
	  @Override
	  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("class ResponseCustMsg {\n");
	    
	    sb.append("    listCustomers: ").append(toIndentedString(listCustomers)).append("\n");
	    sb.append("}");
	    return sb.toString();
	  }
	
	  /**
	   * Convert the given object to string with each line indented by 4 spaces
	   * (except the first line).
	   */
	  private String toIndentedString(java.lang.Object o) {
	    if (o == null) {
	      return "null";
	    }
	    return o.toString().replace("\n", "\n    ");
	  }
	  
}

