package person;

public class Student extends Person {
    private String program;
    private int semester;

    public Student(int id, String name, String email, String program, int semester) {
        super(id, name, email);
        this.program = program;
        this.semester = semester;
    }
}