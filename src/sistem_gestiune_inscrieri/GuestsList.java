package sistem_gestiune_inscrieri;

import java.util.ArrayList;

public class GuestsList {
	private int noPlaces;
	private ArrayList<Guest> participantsList;
	private ArrayList<Guest> waitingList;

	public GuestsList(int noPlaces) {
		this.participantsList = new ArrayList<Guest>(noPlaces);
		this.waitingList = new ArrayList<Guest>();
		this.noPlaces = noPlaces;
	}

	public int checkEmailOnParticipants(String email) {
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getEmail().equalsIgnoreCase(email))
				return i;
		}
		return -1;
	}

	public int checkEmailOnWaiting(String email) {
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getEmail().equalsIgnoreCase(email))
				return i;
		}
		return -1;
	}

	public int checkPhoneNumberOnParticipants(String phoneNumber) {
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber))
				return i;
		}
		return -1;
	}

	public int checkPhoneNumberOnWaiting(String phoneNumber) {
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber))
				return i;
		}
		return -1;
	}

	public int checkLFNameOnParticipants(String lastName, String firstName) {
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getLastName().equalsIgnoreCase(lastName)
					&& participantsList.get(i).getFirstName().equalsIgnoreCase(firstName))
				return i;
		}
		return -1;
	}

	public int checkLFNameOnWaiting(String lastName, String firstName) {
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getLastName().equalsIgnoreCase(lastName)
					&& waitingList.get(i).getFirstName().equalsIgnoreCase(firstName))
				return i;
		}
		return -1;
	}

	public void guests() {
		if (participantsList.isEmpty() && waitingList.isEmpty()) {
			System.out.println("Niciun participant inscris…\r\n");
		}
		for (int i = 0; i < participantsList.size(); i++) {
			System.out.println(i + 1 + ". Nume: " + participantsList.get(i).getLastName() + " "
					+ participantsList.get(i).getFirstName() + ", " + "Email: " + participantsList.get(i).getEmail()
					+ ", " + "Telefon: " + participantsList.get(i).getPhoneNumber());
		}
		for (int i = 0; i < waitingList.size(); i++) {
			System.out.println(participantsList.size() + 1 + ". Nume: " + waitingList.get(i).getLastName() + " "
					+ waitingList.get(i).getFirstName() + ", " + "Email: " + waitingList.get(i).getEmail() + ", "
					+ "Telefon: " + waitingList.get(i).getPhoneNumber());

		}
	}

	public int waitlist_no() {
		return waitingList.size();
	}

	public int subscribe_no() {
		return participantsList.size();
	}

	public boolean removeEmail(String email) {
		if (checkEmailOnParticipants(email) != -1) {
			int index = checkEmailOnParticipants(email);
			participantsList.remove(index);
			this.noPlaces++;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if (waitlist_no() != 0) {
				participantsList.add(waitingList.get(0));
				this.noPlaces--;
				System.out.println("[" + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName()
						+ "]" + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
				waitingList.remove(0);
			}
			return true;
		} else if (checkEmailOnWaiting(email) != -1) {
			int index = checkEmailOnWaiting(email);
			waitingList.remove(index);
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
	}

	public boolean removePhoneNumber(String phoneNumber) {
		if (checkPhoneNumberOnParticipants(phoneNumber) != -1) {
			int index = checkPhoneNumberOnParticipants(phoneNumber);
			participantsList.remove(index);
			this.noPlaces++;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if (waitlist_no() != 0) {
				participantsList.add(waitingList.get(0));
				this.noPlaces--;
				System.out.println("[" + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName()
						+ "]" + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
				waitingList.remove(0);
			}
			return true;
		} else if (checkPhoneNumberOnParticipants(phoneNumber) != -1) {
			int index = checkEmailOnWaiting(phoneNumber);
			waitingList.remove(index);
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
	}

	public boolean removeLF(String lastName, String firstName) {
		if (checkLFNameOnParticipants(lastName, firstName) != -1) {
			int index = checkLFNameOnParticipants(lastName, firstName);
			participantsList.remove(index);
			this.noPlaces++;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if (waitlist_no() != 0) {
				participantsList.add(waitingList.get(0));
				this.noPlaces--;
				System.out.println("[" + waitingList.get(0).getLastName() + " " + waitingList.get(0).getFirstName()
						+ "]" + "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
				waitingList.remove(0);
			}
			return true;
		} else if (checkLFNameOnWaiting(lastName, firstName) != -1) {
			int index = checkLFNameOnWaiting(lastName, firstName);
			waitingList.remove(index);
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
	}

	public boolean search(String str) {
		int counter = 0;
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getEmail().contains(str) || participantsList.get(i).getFirstName().contains(str)
					|| participantsList.get(i).getLastName().contains(str)
					|| participantsList.get(i).getPhoneNumber().contains(str)) {
				counter++;
				System.out.println(counter + ". Nume: " + participantsList.get(i).getLastName() + " "
						+ participantsList.get(i).getFirstName() + ", " + "Email: " + participantsList.get(i).getEmail()
						+ ", " + "Telefon: " + participantsList.get(i).getPhoneNumber());
				return true;
			}
		}
		for (int i = 0; i < waitingList.size(); i++) {
			if (waitingList.get(i).getEmail().contains(str) || waitingList.get(i).getFirstName().contains(str)
					|| waitingList.get(i).getLastName().contains(str)
					|| waitingList.get(i).getPhoneNumber().contains(str)) {
				counter++;
				System.out.println(counter + ". Nume: " + waitingList.get(i).getLastName() + " "
						+ waitingList.get(i).getFirstName() + ", " + "Email: " + waitingList.get(i).getEmail() + ", "
						+ "Telefon: " + waitingList.get(i).getPhoneNumber());
				return true;
			}

		}
		return false;
	}

	public int add(Guest g) {
		if (available() != 0) {
			this.noPlaces--;
			participantsList.add(g);
			System.out.println("[" + g.getLastName() + " " + g.getFirstName() + "]"
					+ "Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		} else if (available() == 0) {
			waitingList.add(g);
			System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "
					+ waitingList.size() + ". Te vom notifica daca un loc devine disponibil");
			return waitingList.size();
		}
		return -1;
	}

	public void updateLF(String lastName, String firstName) {
		if (checkLFNameOnParticipants(lastName, firstName) != -1) {
			int index = checkLFNameOnParticipants(lastName, firstName);
			participantsList.get(index).setLastName(lastName);
			participantsList.get(index).setFirstName(firstName);
		} else if (checkLFNameOnWaiting(lastName, firstName) != -1) {
			int index = checkLFNameOnWaiting(lastName, firstName);
			waitingList.get(index).setLastName(lastName);
			waitingList.get(index).setFirstName(firstName);
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
	}

	public void waitlist() {
		if (waitingList.isEmpty()) {
			System.out.println("Lista de asteptare este goala…");
		}
		for (int i = 0; i < waitingList.size(); i++) {
			System.out.println(i + 1 + ". Nume: " + waitingList.get(i).getLastName() + " "
					+ waitingList.get(i).getFirstName() + ", " + "Email: " + waitingList.get(i).getEmail() + ", "
					+ "Telefon: " + waitingList.get(i).getPhoneNumber());
		}
	}

	public void updateEmail(String email) {
		if (checkEmailOnParticipants(email) != -1) {
			int index = checkEmailOnParticipants(email);
			participantsList.get(index).setEmail(email);
		} else if (checkEmailOnWaiting(email) != -1) {
			int index = checkEmailOnWaiting(email);
			waitingList.get(index).setEmail(email);
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
	}

	public int guests_no() {
		return participantsList.size();
	}

	public void updateTelephoneNumber(String telephoneNumber) {
		if (checkPhoneNumberOnParticipants(telephoneNumber) != -1) {
			int index = checkPhoneNumberOnParticipants(telephoneNumber);
			participantsList.get(index).setPhoneNumber(telephoneNumber);
		} else if (checkPhoneNumberOnWaiting(telephoneNumber) != -1) {
			int index = checkPhoneNumberOnWaiting(telephoneNumber);
			waitingList.get(index).setPhoneNumber(telephoneNumber);
		} else
			System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
	}

	public int available() {
		return this.noPlaces;
	}

}
