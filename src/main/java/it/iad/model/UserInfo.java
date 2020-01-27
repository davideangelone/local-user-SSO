package it.iad.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * UserInfo
 */
public class UserInfo   {
  
  @Getter @Setter
  @ApiModelProperty(value = "The userid - Identifier for the End-User at the Issuer")
  private String username = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's full name in displayable form including all name parts, possibly including titles and suffixes, ordered according to the End-User's locale and preferences")
  private String name = null;

  @Getter @Setter
  @ApiModelProperty(value = "Given name(s) or first name(s) of the End-User")
  private String givenName = null;

  @Getter @Setter
  @ApiModelProperty(value = "Surname(s) or last name(s) of the End-User")
  private String familyName = null;

  @Getter @Setter
  @ApiModelProperty(value = "Middle name(s) of the End-User")
  private String middleName = null;

  @Getter @Setter
  @ApiModelProperty(value = "Casual name of the End-User that may or may not be the same as the given_name")
  private String nickname = null;

  @Getter @Setter
  @ApiModelProperty(value = "Shorthand name by which the End-User wishes to be referred to at the RP, such as janedoe or j.doe")
  private String preferredUsername = null;

  @Getter @Setter
  @ApiModelProperty(value = "URL of the End-User's profile page")
  private String profile = null;

  @Getter @Setter
  @ApiModelProperty(value = "URL of the End-User's profile picture")
  private String picture = null;

  @Getter @Setter
  @ApiModelProperty(value = "URL of the End-User's Web page or blog")
  private String website = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's preferred e-mail address")
  private String email = null;

  @Getter @Setter
  @ApiModelProperty(value = "User at the time the verification was performed")
  private Boolean emailVerified = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's gender")
  private String gender = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's birthday, represented as an ISO 8601:2004 [ISO8601‑2004] YYYY-MM-DD format")
  private String birthdate = null;

  @Getter @Setter
  @ApiModelProperty(value = "String from zoneinfo [zoneinfo] time zone database representing the End-User's time zone")
  private String zoneinfo = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's locale, represented as a BCP47 [RFC5646] language tag")
  private String locale = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's preferred telephone number")
  private String phoneNumber = null;

  @Getter @Setter
  @ApiModelProperty(value = "User at the time the verification was performed")
  private Boolean phoneNumberVerified = null;

  @Getter @Setter
  @ApiModelProperty(value = "End-User's preferred postal address")
  private String address = null;

  @Getter @Setter
  @ApiModelProperty(value = "Time the End-User's information was last updated")
  private Integer updatedAt = null;


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserInfo {\n");
    
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    givenName: ").append(toIndentedString(givenName)).append("\n");
    sb.append("    familyName: ").append(toIndentedString(familyName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    preferredUsername: ").append(toIndentedString(preferredUsername)).append("\n");
    sb.append("    profile: ").append(toIndentedString(profile)).append("\n");
    sb.append("    picture: ").append(toIndentedString(picture)).append("\n");
    sb.append("    website: ").append(toIndentedString(website)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    emailVerified: ").append(toIndentedString(emailVerified)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    zoneinfo: ").append(toIndentedString(zoneinfo)).append("\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    phoneNumberVerified: ").append(toIndentedString(phoneNumberVerified)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
