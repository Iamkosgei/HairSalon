public class Client {
    private int id;
    private String first_name, last_name, phone, email, country , county;
    private int stylistid;

    public Client(String first_name, String last_name, String phone, String email, String country, String county, int stylistid) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
        this.country = country;
        this.county = county;
        this.stylistid = stylistid;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getCounty() {
        return county;
    }

    public int getStylistid() {
        return stylistid;
    }
}
