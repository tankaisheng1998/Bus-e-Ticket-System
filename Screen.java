import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Screen {
	public String promptWelcomePage(Scanner sc, String companyName) {
		System.out.println("\n---------------------------");
		System.out.println("Welcome to " + companyName);

		System.out.println("\n1. Buy Ticket");
		System.out.println("2. Login");
		System.out.println("3. Exit");

		System.out.println("\nEnter your option: ");
		String option = sc.next();
		return option;
	}

	// input id
	public String promptMemberId(Scanner sc) {

		System.out.println("\n---------------------------");
		System.out.println("\nUsername: ");
		String username = sc.next();
		return username;
	}

	// input password
	public String promptPassword(Scanner sc) {
		System.out.println("Enter password: ");
		String password = sc.next();
		return password;
	}

	// incorrect password
	public void displayIdOrPasswordNotFound() {
		System.out.println("\nError: Invalid member id or password");
	}

	public String promptSearchBusPage1(Scanner sc) {
		System.out.println("\nBuy Ticket option was selected");
		System.out.println("---------------------------");
		System.out.println("Search Bus Trip");
		System.out.println("\nSelect Trip Type :");
		System.out.println("1. One Way");
		System.out.println("2. Round Trip");
		System.out.println("3. Exit");

		System.out.println("\nEnter your option: ");
		String option = sc.next();
		return option;
	}

	// select source
	public String promptSearchBusTripPage2(Scanner sc) {
		System.out.println("\n---------------------------");
		System.out.println("From (Insert place name) :");
		System.out.println("1.  Kangar");
		System.out.println("2.  Arau");
		System.out.println("3.  Alor_Setar");
		System.out.println("4.  Butterworth");
		System.out.println("5.  Sungai_Dua");
		System.out.println("6.  Pulau_Penang");
		System.out.println("7.  Taiping");
		System.out.println("8.  Kuala_Kangsar");
		System.out.println("9.  Ipoh");
		System.out.println("10. Kuala_Lumpur");
		System.out.println("11. Terminal_Bas_Selatan");
		System.out.println("12. Kajang");

		String option = sc.next();
		return option;

	}

	// select destination
	public String promptSearchBusTripPage3(Scanner sc) {

		System.out.println("\n---------------------------");
		System.out.println("To (Insert place name):");
		System.out.println("1.  Kangar");
		System.out.println("2.  Arau");
		System.out.println("3.  Alor_Setar");
		System.out.println("4.  Butterworth");
		System.out.println("5.  Sungai_Dua");
		System.out.println("6.  Pulau_Penang");
		System.out.println("7.  Taiping");
		System.out.println("8.  Kuala_Kangsar");
		System.out.println("9.  Ipoh");
		System.out.println("10. Kuala_Lumpur");
		System.out.println("11. Terminal_Bas_Selatan");
		System.out.println("12. Kajang");

		String option = sc.next();
		return option;

	}

	public String requestName(Scanner sc) {
		System.out.println("\n---------------------------");
		System.out.println("Insert the name of passenger :");
		String name = sc.next();
		return name;
	}

	public String requestContact(Scanner sc) {
		System.out.println("\n---------------------------");
		System.out.println("Insert the contact number of passenger :");
		String contact = sc.next();
		return contact;
	}

	public void selectSeatPage() {
		System.out.println("\n---------------------------");
		System.out.println("Insert seat ID :");

	}

	public String promptCheckoutOrRepeat(Scanner sc) {
		System.out.println("\nProceed to Checkout :");
		System.out.println("1. Yes");
		System.out.println("2. No");
		System.out.println("3. Exit");

		System.out.println("\nEnter your option: ");
		String option = sc.next();
		return option;
	}

	public void displaySearchResult(String from, String to) {

	}

	public void tripNotFound() {
		System.out.println("\nError: Trip not Found.");
	}

	public void displayUnderConstructionPage() {
		System.out.println("\nSorry, this feature is under construction");
	}

	public void displayInvalidOption() {
		System.out.println("\nError: Invalid option");
	}

	public void displayGoodByePage(String name) {
		System.out.println("\nThank you. Have a good day " + name);
	}

	public void displayGoodByePage() {
		System.out.println("\nThank you. Have a good day");
	}

	public void noSeatTrip() {
		System.out.println("Sorry no trip and seat was selected");
	}

	public void tripListHeader() {
		System.out.println("Trip ID |  Bus ID | ");
		System.out.println("-----------------------");
	}

	public void successLogin(String member) {
		System.out.println("You have succesful Login " + member);
	}

	public String selectPaymentMethod(Scanner sc) {

		System.out.println("Select payment method :");
		System.out.println("1. Debit card");
		System.out.println("2. Credit card");

		String option = sc.next();
		return option;

	}

	public void transactionSuccesful() {
		System.out.println("Your payment for the ticket(s) was successful.");
	}
}
