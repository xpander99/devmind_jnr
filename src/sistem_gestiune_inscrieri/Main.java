package sistem_gestiune_inscrieri;

import java.util.Scanner;

public class Main {
	private static GuestsList gList;
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		init();
		mainMenu();
	}

	private static void add() {
		System.out.println("Se adauga o noua persoana…");
		System.out.println("Introduceti numele de familie: ");
		String lastName = scanner.nextLine();
		System.out.println("Introduceti prenumele: ");
		String firstName = scanner.nextLine();
		System.out.println("Introduceti email: ");
		String email = scanner.nextLine();
		System.out.println("Introduceti numar de telefon (format „+40733386463“): ");
		String telephoneNumber = scanner.nextLine();
		int check = gList.checkEmailOnParticipants(email) + gList.checkEmailOnWaiting(email);
		if (check == -2) {
			gList.add(new Guest(lastName, firstName, email, telephoneNumber));
		} else
			System.out.println("Persoana este deja inscrisa la eveniment.");
	}

	private static void guests() {
		gList.guests();
	}

	private static void init() {
		System.out.println("Bun venit! Introduceti numarul de locuri disponibile: ");
		String size = scanner.nextLine();
		gList = new GuestsList(Integer.parseInt(size));
	}

	private static void remove() {
		System.out.println("Se sterge o persoana existenta din lista…");
		System.out.println("	Alege modul de autentificare, tastand:\r\n" + "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n" + "\"3\" - Numar de telefon (format \"+40733386463\")");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1:
			System.out.println("Introduceti nume: ");
			String lastName = scanner.nextLine();
			System.out.println("Introduceti prenume: ");
			String firstName = scanner.nextLine();
			gList.removeLF(lastName, firstName);
			break;
		case 2:
			System.out.println("Introduceti email: ");
			String email = scanner.nextLine();
			gList.removeEmail(email);
			break;
		case 3:
			System.out.println("Introduceti numarul de telefon: ");
			String phoneNumber = scanner.nextLine();
			gList.removePhoneNumber(phoneNumber);
			break;
		}
	}

	private static void showHelp() {
		System.out.println("help - Afiseaza aceasta lista de comenzi\r\n"
				+ "add - Adauga o noua persoana (inscriere)\r\n"
				+ "check - Verifica daca o persoana este inscrisa la eveniment\r\n"
				+ "remove - Sterge o persoana existenta din lista\r\n"
				+ "update - Actualizeaza detaliile unei persoane\r\n"
				+ "guests - Lista de persoane care participa la eveniment\r\n"
				+ "waitlist - Persoanele din lista de asteptare\r\n" + "available - Numarul de locuri libere\r\n"
				+ "guests_no - Numarul de persoane care participa la eveniment\r\n"
				+ "waitlist_no - Numarul de persoane din lista de asteptare\r\n"
				+ "subscribe_no - Numarul total de persoane inscrise\r\n"
				+ "search - Cauta toti invitatii conform sirului de caractere introdus\r\n"
				+ "quit - Inchide aplicatia");
	}

	private static void update() {
		System.out.println("Se actualizeaza detaliile unei persoane…");
		System.out.println("	Alege modul de autentificare, tastand:\r\n" + "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n" + "\"3\" - Numar de telefon (format \"+40733386463\")");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1:
			System.out.println("Introduceti nume: ");
			String lastName = scanner.nextLine();
			System.out.println("Introduceti prenume: ");
			String firstName = scanner.nextLine();
			gList.updateLF(lastName, firstName);
			break;
		case 2:
			System.out.println("Introduceti email: ");
			String email = scanner.nextLine();
			gList.updateEmail(email);
			break;
		case 3:
			System.out.println("Introduceti numarul de telefon: ");
			String phoneNumber = scanner.nextLine();
			gList.updateTelephoneNumber(phoneNumber);
			break;
		}
	}

	private static void check() {
		System.out.println("Se verifica daca  o persoana este inscrisa la eveniment…");
		System.out.println("	Alege modul de autentificare, tastand:\r\n" + "\"1\" - Nume si prenume\r\n"
				+ "\"2\" - Email\r\n" + "\"3\" - Numar de telefon (format \"+40733386463\")");
		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
		case 1:
			System.out.println("Introduceti nume: ");
			String lastName = scanner.nextLine();
			System.out.println("Introduceti prenume: ");
			String firstName = scanner.nextLine();
			int check = gList.checkLFNameOnParticipants(lastName, firstName)
					+ gList.checkLFNameOnWaiting(lastName, firstName);
			String chk = check == -2 ? "nu este inscrisa la eveniment" : "este inscrisa la eveniment";
			System.out.println("Persoana " + chk);
			break;
		case 2:
			System.out.println("Introduceti email: ");
			String email = scanner.nextLine();
			int check1 = gList.checkEmailOnParticipants(email) + gList.checkEmailOnWaiting(email);
			String chk1 = check1 == -2 ? "nu este inscrisa la eveniment" : "este inscrisa la eveniment";
			System.out.println("Persoana " + chk1);
			break;
		case 3:
			System.out.println("Introduceti numarul de telefon: ");
			String phoneNumber = scanner.nextLine();
			int check2 = gList.checkPhoneNumberOnParticipants(phoneNumber)
					+ gList.checkPhoneNumberOnWaiting(phoneNumber);
			String chk2 = check2 == -2 ? "nu este inscrisa la eveniment" : "este inscrisa la eveniment";
			System.out.println("Persoana " + chk2);
			break;
		}
	}

	private static void search() {
		System.out.println("Introdu sirul de caractere: ");
		String str = scanner.nextLine();
		gList.search(str);
	}

	private static void mainMenu() {
		boolean quit = true;
		while (quit) {
			System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			String option = scanner.nextLine();
			switch (option) {
			case "help":
				showHelp();
				break;
			case "add":
				add();
				break;
			case "check":
				check();
				break;
			case "remove":
				remove();
				break;
			case "update":
				update();
				break;
			case "guests":
				guests();
				break;
			case "waitlist":
				gList.waitlist();
				break;
			case "available":
				System.out.println("Numarul de locuri ramase: " + gList.available());
				break;
			case "guests_no":
				System.out.println("Numarul de participanti: " + gList.guests_no());
				break;
			case "waitlist_no":
				System.out.println("Dimensiunea listei de asteptare:" + gList.waitlist_no());
				break;
			case "subscribe_no":
				System.out.println("Numarul total de persoane: " + gList.subscribe_no());
				break;
			case "search":
				search();
				break;
			case "quit":
				quit = false;
				System.out.println("Aplicatia se inchide...");
				break;
			default:
				System.out.println("Comanda introdusa nu este valida. ");
				System.out.println("Incercati inca o data.");
				break;

			}
		}
	}

}
