package person;

public class Person {
    private int id;
    private String name;
    private String email;

    public Person(int id, String name, String email) {
        this.id = id;
        this.name = name;
        setEmail(email);
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        if (email.contains("@")) {
            this.email = email;
        } else {
            System.out.println("Invalid email!");
        }
    }
}