package com.mycompany.campuscare;

import java.util.*;

// ---------------- PERSON CLASSES ----------------
class Person {
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

class Student extends Person {
    private String program;
    private int semester;

    public Student(int id, String name, String email, String program, int semester) {
        super(id, name, email);
        this.program = program;
        this.semester = semester;
    }
}

class Staff extends Person {
    private String department;

    public Staff(int id, String name, String email, String department) {
        super(id, name, email);
        this.department = department;
    }
}

// ---------------- TICKET CLASSES ----------------
abstract class Ticket {
    protected int ticketId;
    protected String title, description, location, status;

    public Ticket(int ticketId, String title, String description, String location) {
        this.ticketId = ticketId;
        this.title = title;
        this.description = description;
        this.location = location;
        this.status = "New";
    }

    public abstract double priorityScore();

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public int getTicketId() {
        return ticketId;
    }
}

class MaintenanceTicket extends Ticket {
    private String type;

    public MaintenanceTicket(int id, String title, String desc, String loc, String type) {
        super(id, title, desc, loc);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        if (location.toLowerCase().contains("lab")) {
            return 9.0;
        }
        return 5.0;
    }
}

class CleaningTicket extends Ticket {
    private String type;

    public CleaningTicket(int id, String title, String desc, String loc, String type) {
        super(id, title, desc, loc);
        this.type = type;
    }

    @Override
    public double priorityScore() {
        if (description.toLowerCase().contains("trash")) {
            return 8.0;
        }
        return 4.0;
    }
}

// ---------------- MAIN CLASS ----------------
public class CampusCare {

    static List<Person> persons = new ArrayList<>();
    static List<Ticket> tickets = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Add Person");
            System.out.println("2. Create Ticket");
            System.out.println("3. View Tickets");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addPerson(); break;
                case 2: createTicket(); break;
                case 3: viewTickets(); break;
                case 4: updateStatus(); break;
                case 5: return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addPerson() {
        System.out.println("1. Student  2. Staff");
        int type = sc.nextInt();

        System.out.print("ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();

        if (type == 1) {
            System.out.print("Program: "); String program = sc.nextLine();
            System.out.print("Semester: "); int sem = sc.nextInt();
            persons.add(new Student(id, name, email, program, sem));
        } else {
            System.out.print("Department: "); String dept = sc.nextLine();
            persons.add(new Staff(id, name, email, dept));
        }
    }

    static void createTicket() {
        System.out.println("1. Maintenance  2. Cleaning");
        int type = sc.nextInt();

        System.out.print("Ticket ID: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Description: "); String desc = sc.nextLine();
        System.out.print("Location: "); String loc = sc.nextLine();

        if (type == 1) {
            tickets.add(new MaintenanceTicket(id, title, desc, loc, "General"));
        } else {
            tickets.add(new CleaningTicket(id, title, desc, loc, "General"));
        }
    }

    static void viewTickets() {
        for (Ticket t : tickets) {
            System.out.println("ID: " + t.getTicketId()
                    + " Status: " + t.getStatus()
                    + " Priority: " + t.priorityScore());
        }
    }

    static void updateStatus() {
        System.out.print("Enter Ticket ID: ");
        int id = sc.nextInt();

        for (Ticket t : tickets) {
            if (t.getTicketId() == id) {
                System.out.println("1.New 2.Assigned 3.Resolved");
                int s = sc.nextInt();
                if (s == 1) t.setStatus("New");
                else if (s == 2) t.setStatus("Assigned");
                else t.setStatus("Resolved");
            }
        }
    }
}