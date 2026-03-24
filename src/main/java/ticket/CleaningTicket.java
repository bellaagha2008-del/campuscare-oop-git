package ticket;

public class CleaningTicket extends Ticket {
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