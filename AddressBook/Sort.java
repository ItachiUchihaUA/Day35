package workshop_AddressBook;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Sort {
	
	protected static List<Contact> byName() {
		return 	AddressBook.addressBook.stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());
	}
	
	protected static List<Contact> byCityStateOrZip() {
		System.out.println("Enter 1 to sort by City \n\t 2 to sort by State \n\t 2 to sort by Zip");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		if (select == 1) {
			return AddressBook.addressBook.stream().sorted(Comparator.comparing(Contact::getCity))
					.collect(Collectors.toList());
			
		} else if (select == 2) {
			return AddressBook.addressBook.stream().sorted(Comparator.comparing(Contact::getState))
					.collect(Collectors.toList());
			
		} else if (select == 3) {
			return AddressBook.addressBook.stream().sorted(Comparator.comparing(Contact::getZip))
					.collect(Collectors.toList());
			
		} else {
			System.err.println("Wrong Entry!");
			return byCityStateOrZip();
		}

	}
}
