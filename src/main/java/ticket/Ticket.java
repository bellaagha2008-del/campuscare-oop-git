package ticket;

public abstract class Ticket {
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
