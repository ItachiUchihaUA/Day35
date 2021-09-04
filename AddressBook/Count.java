package workshop_AddressBook;

import java.util.Scanner;

public class Count {
	protected static void forCity() {
		if (AddressBook.cityBook.isEmpty()) {
			System.out.println("Empty Book");
			return;
		}
		System.out.println("\nEnter City Nmae: ");
		Scanner sc = new Scanner(System.in);
		String city = sc.next();
		System.out.println("Count: " + AddressBook.cityBook.entrySet().stream().filter(n -> n.getValue().equals(city)).count());

	}

	protected static void forState() {
		if (AddressBook.stateBook.isEmpty()) {
			System.err.println("Empty Book");
			return;
		}
		System.out.println("\nEnter State Nmae: ");
		Scanner sc = new Scanner(System.in);
		String state = sc.next();
		System.out.println("Count: " + AddressBook.stateBook.entrySet().stream().filter(n -> n.getValue().equals(state)).count());

	}
}
