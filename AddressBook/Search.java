package workshop_AddressBook;

import java.util.Optional;
import java.util.Scanner;

public class Search {
	protected static void allCity(String name) {
		AddressBook.addressBook.stream().filter(n -> n.getCity().equals(name)).forEach(n -> System.out.println("  " + n.getFirstName()));
	}
	
	protected static void allState(String name) {
		AddressBook.addressBook.stream().filter(n -> n.getState().equals(name)).forEach(n -> System.out.println("  " + n.getFirstName()));
	}
	
	protected static Contact contact(String name) {
		return AddressBook.addressBook.stream().filter(n -> n.getFirstName().equals(name)).findFirst().orElse(null);
	}
	
	static public void inCityOrState() {
		if (AddressBook.addressBook.isEmpty()) {
			System.err.println("Empty Book!");
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 to search in City or 2 to search in State");
		int temp = sc.nextInt();
		if (temp == 1) {
			System.out.println("Enter City Name: ");
			allCity(sc.next());
		}

		else if (temp == 2) {
			System.out.println("Enter State Name: ");
			allState(sc.next());
		} else {
			System.out.println("\nEnter 1 or 2 only!");
			inCityOrState();
		}
	}
}
