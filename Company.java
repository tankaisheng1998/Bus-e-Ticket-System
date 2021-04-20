import java.util.ArrayList;

public class Company {
	private String name;
	private ArrayList<Ticket> ticketList = new ArrayList<Ticket>();
	private ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
	private ArrayList<Member> memberList = new ArrayList<Member>();
	private ArrayList<Bus> busList = new ArrayList<Bus>();
	private ArrayList<Trip> tripList = new ArrayList<Trip>();
	private String places[] = { "Kangar", "Arau", "Alor_Setar", "Sungai_Petani", "Sungai_Dua", "Pulau_Penang",
			"Taiping", "Kuala_Kangsar", "Ipoh", "Kuala_Lumpur", "Terminal_Bas_Selatan", "Kajang" };
	private String time[] = { "7:00", "7.30", "8:00", "8:20", "8:50", "9:35", "10:00", "10:30", "10:40", "12:30",
			"12:50", "13:00", "13:40", "14:10", "14:30", "15:00", "15:10", "16:40", "18:30", "19:10", "20:45", "21:55",
			"22:15", "23:11" };

	public String ETA[] = { "30mins", "1hrs", "6hrs30mins", "4hrs", "3hrs32mins", "4hrs21mins" };

	public Company(String n) {
		name = n;

		Member member1 = new Member("Jonathan", "Lee", "m001", "j123");
		Member member2 = new Member("Ryan", "Chong", "m002", "c123");

		Driver driver1 = new Driver("Hamsap", "D1");
		Driver driver2 = new Driver("Simon", "D2");
		Driver driver3 = new Driver("Doldo", "D3");

		Bus bus1 = new Bus("M1", driver1);
		Bus bus2 = new Bus("M2", driver2);
		Bus bus3 = new Bus("M3", driver3);
		Bus bus4 = new Bus("M4", driver1);

		memberList.add(member1);
		memberList.add(member2);
		busList.add(bus1);
		busList.add(bus2);
		busList.add(bus3);
		busList.add(bus4);

		// Kangar to Arau
		tripList.add(new Trip("T01", places[0], places[1], time[0], ETA[0], 5.60, bus1));
		tripList.add(new Trip("T02", places[0], places[1], time[1], ETA[0], 4.60, bus2));
		tripList.add(new Trip("T43", places[0], places[1], time[5], ETA[0], 6.00, bus1));
		// Arau to Kuala Lumpur
		tripList.add(new Trip("T74", places[1], places[9], time[0], ETA[2], 46.60, bus2));
		tripList.add(new Trip("T25", places[1], places[9], time[2], ETA[2], 51.60, bus3));
		tripList.add(new Trip("T06", places[1], places[9], time[23], ETA[2], 49.60, bus3));
		// Ipoh to Kuala Lumpur
		tripList.add(new Trip("T27", places[8], places[9], time[0], ETA[3], 25.60, bus1));
		tripList.add(new Trip("T48", places[8], places[9], time[2], ETA[3], 22.40, bus1));
		tripList.add(new Trip("T19", places[8], places[9], time[8], ETA[3], 24.00, bus2));
		tripList.add(new Trip("T80", places[8], places[9], time[18], ETA[3], 27.60, bus3));

		// Taiping to Kangar
		tripList.add(new Trip("T23", places[6], places[0], time[5], ETA[4], 19.80, bus1));
		tripList.add(new Trip("T14", places[6], places[0], time[13], ETA[4], 18.60, bus2));
		tripList.add(new Trip("T16", places[6], places[0], time[5], ETA[4], 19.00, bus1));

		// Kangar to Ipoh
		tripList.add(new Trip("T21", places[0], places[8], time[0], ETA[5], 23.60, bus1));
		tripList.add(new Trip("T32", places[0], places[8], time[1], ETA[5], 24.60, bus2));
		tripList.add(new Trip("T13", places[0], places[8], time[5], ETA[5], 26.70, bus1));
		tripList.add(new Trip("T91", places[0], places[8], time[7], ETA[5], 25.60, bus3));
		tripList.add(new Trip("T12", places[0], places[8], time[9], ETA[5], 24.60, bus2));
		tripList.add(new Trip("T63", places[0], places[8], time[12], ETA[5], 25.50, bus1));
	}

	public String getName() {
		return name;
	}

	public Member getMember(String id, String pwd) {
		for (Member member : memberList) {
			if (member.getMemberId().equals(id) && member.getPassword().equals(pwd))
				return member;
		}

		// if member with the same id and password not found in the library's member
		// list,
		// return null object
		return null;
	}

	public Trip getTrip(String from, String to) {
		for (Trip trip : tripList) {
			if (trip.getSource().equals(from) && trip.getDestination().equals(to)) {
				return trip;

			}
		}
		return null;
	}

	public void displayTrip(String from, String to) {
		for (Trip trip : tripList) {
			if (trip.getSource().equals(from) && trip.getDestination().equals(to)) {
				trip.displayDetail();
				;
			}
		}
	}

	public double showTicketPrice() {
		double price = 0;
		for (Ticket ticket : ticketList) {
			price += ticket.getPrice();

		}
		return price;

	}

	public int numberOfTicket() {
		return ticketList.size();
	}

	public void displayBusSeat(String tripId) {
		for (Trip trip : tripList) {
			if (trip.getTripId().equals(tripId)) {
				trip.displayBusSeat();
			}
		}

		System.out.println();
	}

	public void bookSeat(String tripId, String name, String contact, String seatId) {
		for (Trip trip : tripList) {
			if (trip.getTripId().equals(tripId)) {
				passengerList.add(new Passenger(name, contact, seatId, trip));
				trip.bookSeat(seatId);
			}
		}

	}

	public void addTicket() {
		for (Passenger passenger : passengerList) {
			Trip trip = passenger.getTrip();
			// int z=500*(int) Math.random();
			Ticket ticket = new Ticket(passenger, trip);
			ticketList.add(ticket);

		}
	}

	public void displayAllTicket() {
		for (Ticket ticket : ticketList) {
			ticket.displayTicketInfo();
		}
	}
}
