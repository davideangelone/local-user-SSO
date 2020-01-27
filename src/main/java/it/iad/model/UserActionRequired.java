package it.iad.model;

/**
 * Action available: |  * `NOOP` - NO OPeration required  * `CONFIGURE_TOTP` - User must configure TOTP  * `UPDATE_PASSWORD` - User must update PASSWORD  * `VERIFY_EMAIL` - User must Verify the email address  * `UPDATE_PROFILE` - User must update the profile     
 */
public enum UserActionRequired {
  NOOP("NOOP"),
    CONFIGURE_TOTP("CONFIGURE_TOTP"),
    UPDATE_PASSWORD("UPDATE_PASSWORD"),
    VERIFY_EMAIL("VERIFY_EMAIL"),
    UPDATE_PROFILE("UPDATE_PROFILE");

  private String value;

  UserActionRequired(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

}
