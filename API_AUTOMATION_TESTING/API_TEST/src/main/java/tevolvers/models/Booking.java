package tevolvers.models;

public class Booking {

    private String contentType;
    private String accept;
    private String firstName;
    private String lastName;
    private Integer totalPrice;
    private Boolean depositPaid;

    private String checkIn;

    private String checkOut;
    private String additionalNeeds;

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Boolean getDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(Boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @Override
    public String toString() {
        return "{" +
                    "\"firstname\" : \"" + firstName + "\"," +
                    "\"lastname\" : \"" + lastName + "\"," +
                    "\"totalprice\" : " + totalPrice + "," +
                    "\"depositpaid\" : " + depositPaid + "," +
                    "\"bookingdates\" : {" +
                        "\"checkin\" : \"" + checkIn + "\"," +
                        "\"checkout\" : \"" + checkOut + "\"" +
                    "}," +
                    "\"additionalneeds\" : \"" + additionalNeeds + "\"" +
                '}';
    }
}
