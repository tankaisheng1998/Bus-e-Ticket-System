import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Controller {

	DecimalFormat dc = new DecimalFormat("0.00");
	Scanner sc = new Scanner(System.in);
	Screen screen = new Screen();
	Company company = new Company("Sri Maju");
	boolean login = false;

	public void runSystem() {
		String option = "default";
		String menuOption = "default";
		String name = "";
		String contact = "";

		while (!option.equals("3")) {
			option = screen.promptWelcomePage(sc, company.getName());

			String from, to;

			if (option.equals("1")) {
				menuOption = screen.promptSearchBusPage1(sc);

				while (!(menuOption.equals("3"))) {

					// One way
					if (menuOption.equals("1")) {
						String oneWay = "One Way";
						from = screen.promptSearchBusTripPage2(sc);
						to = screen.promptSearchBusTripPage3(sc);

						Trip trip = company.getTrip(from, to);
						if (trip == null) {
							screen.tripNotFound();

						} else {
							screen.tripListHeader();
							company.displayTrip(from, to);
							System.out.println();
							System.out.println("------------------------------");
							System.out.println("Select desire trip ID :");
							String tripId = sc.next();

							System.out.println();
							System.out.print("How many passenger(s) : ");
							int paxnum = sc.nextInt();

							for (int i = 0; i < paxnum; i++) {
								name = screen.requestName(sc);
								contact = screen.requestContact(sc);

								company.displayBusSeat(tripId);
								screen.selectSeatPage();
								String seatId = sc.next();

								company.bookSeat(tripId, name, contact, seatId);

							}
							company.addTicket();
							System.out.println(company.numberOfTicket());
						}

						if (company.numberOfTicket() > 0) {
							System.out.println();
							System.out.println("Your ticket(s))");
							System.out.println("-------------------------");

							company.displayAllTicket();

							String paymentOption = screen.promptCheckoutOrRepeat(sc);
							// yes
							Member member = null;
							if (paymentOption.equals("1") && login == false) {

								System.out.println("Login to proceed payment");
								while (login != true) {
									String memberId = screen.promptMemberId(sc);
									String password = screen.promptPassword(sc);

									member = company.getMember(memberId, password);

									if (member == null)
										screen.displayIdOrPasswordNotFound();

									else {
										login = true;

									}

								}

								// make payment
								screen.successLogin(member.getFirstName());
								System.out.println("Amount have to pay RM: " + dc.format(company.showTicketPrice()));
								System.out.println();
								screen.selectPaymentMethod(sc);
								screen.transactionSuccesful();
								company.displayAllTicket();

								menuOption = screen.promptSearchBusPage1(sc);
							}

							else if (paymentOption.equals("2")) {
								System.out.println("Your transaction is cancelled");

							}

						}

						else {
							screen.noSeatTrip();
						}

					}

					// Round Trip
					if (menuOption.equals("2")) {
						screen.displayUnderConstructionPage();
						menuOption = screen.promptSearchBusPage1(sc);
					}
				}
			} else if (option.equals("2")) {
				String memberId = screen.promptMemberId(sc);
				String password = screen.promptPassword(sc);

				Member member = company.getMember(memberId, password);

				if (member == null)
					screen.displayIdOrPasswordNotFound();
			}

			else {
				login = true;

			}
			break;
		}

		screen.displayGoodByePage();

	}
}
