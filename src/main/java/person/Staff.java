package person;

public class Staff extends Person {
    private String department;

    public Staff(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }
}