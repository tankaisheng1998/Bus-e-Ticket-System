import java.text.DecimalFormat;

public class Ticket {
	DecimalFormat dc = new DecimalFormat("0.00");
	private int ticketId;
	private Passenger passenger;
	private Trip trip;
	private boolean paid = false;
	private String tripType;

	public Ticket(Passenger p, Trip t) {

		passenger = p;
		trip = t;
	}

	public void displayTicketInfo() {
		System.out.println("_________Ticket Details___________");
		System.out.println("Name           : " + passenger.getName());
		System.out.println("Contact Number : " + passenger.getContactNo());
		System.out.println("From           : " + trip.getSource());
		System.out.println("Destination    : " + trip.getDestination());
		System.out.println("Price          : RM" + dc.format((trip.getPrice())));
		System.out.println("Seat ID        : " + passenger.getSeatId());
		System.out.println("Depart time    : " + trip.getDepartTime());
		System.out.println("Estimate Time  : " + trip.getEtaTime());
	}

	public void paid() {
		paid = true;
	}

	public void unpaid() {
		paid = false;
	}

	public double getPrice() {
		return trip.getPrice();
	}

	public boolean getPaidStatus() {
		return paid;
	}

	public int getTicketId() {
		return ticketId;
	}
}
