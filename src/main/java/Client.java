import org.sql2o.Connection;

import java.util.List;

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

    public static List<Client> all() {
        String sql = "SELECT * FROM clients";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Client.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO clients (first_name, last_name, phone, email, country, county,stylistid) VALUES (:first_name, :last_name, :phone, :email, :country, :county, :stylistid)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("first_name", this.first_name)
                    .addParameter("last_name",this.last_name)
                    .addParameter("phone",this.phone)
                    .addParameter("email", this.email)
                    .addParameter("country", this.country)
                    .addParameter("county", this.county)
                    .addParameter("stylistid", this.stylistid)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Client find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM clients where id=:id";
            Client client= con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Client.class);
            return client;
        }
    }

    @Override
    public boolean equals(Object otherClient){
        if (!(otherClient instanceof Client)) {
            return false;
        } else {
            Client newClient = (Client) otherClient;
            return this.email.equals(((Client) otherClient).email) &&
                    this.getId() == newClient.id;
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM clients WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }

    public void update(String first_name,String last_name,String phone,String email,String country,String county,int stylistid) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE clients SET first_name = :first_name, last_name = :last_name, phone = :phone, email = :email, country = :country, county = :county, stylistid = :stylistid  WHERE id = :id";
            con.createQuery(sql)
                    .addParameter("first_name",first_name )
                    .addParameter("last_name",last_name )
                    .addParameter("phone",phone )
                    .addParameter("email",email )
                    .addParameter("country",country )
                    .addParameter("county", county)
                    .addParameter("stylistid", stylistid)
                    .addParameter("id", id)
                    .executeUpdate();
        }
    }
}
