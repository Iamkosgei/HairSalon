public class Stylist {
    private String firstName,secondName,email;
    private int age,id;

    public Stylist(String firstName, String secondName, String email, int age, int id) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
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
}
