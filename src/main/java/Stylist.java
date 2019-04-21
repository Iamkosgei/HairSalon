import org.sql2o.Connection;

import java.util.List;

public class Stylist {
    private String firstname,lastname,email;
    private int age;
    private int id;

    public Stylist(String firstname, String lastname, String email, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getSecondName() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public static List<Stylist> all() {
        String sql = "SELECT * FROM stylists";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Stylist.class);
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open())  {
            String sql = "INSERT INTO stylists (firstname, lastname, email,age) VALUES (:firstname, :lastname, :email, :age)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("firstname", this.firstname)
                    .addParameter("lastname",this.lastname)
                    .addParameter("email",this.email)
                    .addParameter("age", this.age)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static Stylist find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM stylists where id=:id";
            Stylist stylist= con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Stylist.class);
            return stylist;
        }
    }

    @Override
    public boolean equals(Object otherStylist){
        if (!(otherStylist instanceof Stylist)) {
            return false;
        } else {
            Stylist newStylist = (Stylist) otherStylist;
            return this.email.equals(((Stylist) otherStylist).email) &&
                    this.getId() == newStylist.id;
        }
    }

}
