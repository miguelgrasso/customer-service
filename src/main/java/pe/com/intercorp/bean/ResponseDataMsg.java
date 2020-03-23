package pe.com.intercorp.bean;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ResponseDataMsg
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-23T12:15:54.600-05:00[America/Bogota]")
public class ResponseDataMsg   {
  @JsonProperty("kpiCustomer")
  private Object kpiCustomer = null;

  public ResponseDataMsg kpiCustomer(Object kpiCustomer) {
    this.kpiCustomer = kpiCustomer;
    return this;
  }

  /**
   * Get kpiCustomer
   * @return kpiCustomer
  **/
  @ApiModelProperty(value = "")

  public Object getKpiCustomer() {
    return kpiCustomer;
  }

  public void setKpiCustomer(Object kpiCustomer) {
    this.kpiCustomer = kpiCustomer;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResponseDataMsg responseDataMsg = (ResponseDataMsg) o;
    return Objects.equals(this.kpiCustomer, responseDataMsg.kpiCustomer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kpiCustomer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ResponseDataMsg {\n");
    
    sb.append("    kpiCustomer: ").append(toIndentedString(kpiCustomer)).append("\n");
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
