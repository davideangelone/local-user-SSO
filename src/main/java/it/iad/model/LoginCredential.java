package it.iad.model;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginCredential
 */
public class LoginCredential   {
  
  @Getter @Setter
  @ApiModelProperty(required = true, value = "")
  @NotNull
  private String username = null;

  @Getter @Setter
  @ApiModelProperty(required = true, value = "")
  @NotNull
  private String password = null;



  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginCredential {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
