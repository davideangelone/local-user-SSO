package it.iad.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * LoginResponse
 */
public class LoginResponse   {

  @Getter @Setter
  @ApiModelProperty(required = true, value = "")
  @NotNull
  private Boolean active = null;

  @Getter @Setter
  @ApiModelProperty(value = "")
  @Valid
  private List<UserActionRequired> userActionRequired = null;


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginResponse {\n");
    
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    userActionRequired: ").append(toIndentedString(userActionRequired)).append("\n");
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
