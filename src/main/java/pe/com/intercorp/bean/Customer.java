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
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-03-23T12:15:54.600-05:00[America/Bogota]")
public class Customer   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("nombre")
  private String nombre = null;

  @JsonProperty("apellido")
  private String apellido = null;

  @JsonProperty("edad")
  private Integer edad = null;

  @JsonProperty("fechaNacimiento")
  private String fechaNacimiento = null;

  public Customer id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Customer nombre(String nombre) {
    this.nombre = nombre;
    return this;
  }

  /**
   * Get nombre
   * @return nombre
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Customer apellido(String apellido) {
    this.apellido = apellido;
    return this;
  }

  /**
   * Get apellido
   * @return apellido
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public Customer edad(Integer edad) {
    this.edad = edad;
    return this;
  }

  /**
   * Get edad
   * @return edad
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getEdad() {
    return edad;
  }

  public void setEdad(Integer edad) {
    this.edad = edad;
  }

  public Customer fechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
    return this;
  }

  /**
   * Get fechaNacimiento
   * @return fechaNacimiento
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.nombre, customer.nombre) &&
        Objects.equals(this.apellido, customer.apellido) &&
        Objects.equals(this.edad, customer.edad) &&
        Objects.equals(this.fechaNacimiento, customer.fechaNacimiento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nombre, apellido, edad, fechaNacimiento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nombre: ").append(toIndentedString(nombre)).append("\n");
    sb.append("    apellido: ").append(toIndentedString(apellido)).append("\n");
    sb.append("    edad: ").append(toIndentedString(edad)).append("\n");
    sb.append("    fechaNacimiento: ").append(toIndentedString(fechaNacimiento)).append("\n");
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
