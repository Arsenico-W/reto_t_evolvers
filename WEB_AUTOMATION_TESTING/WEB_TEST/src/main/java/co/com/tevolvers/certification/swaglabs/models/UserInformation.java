package co.com.tevolvers.certification.swaglabs.models;

public class UserInformation {

    private String firstname;
    private String lastname;
    private String zipCode;

    public UserInformation(String firstname, String lastname, String zipCode) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.zipCode = zipCode;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
