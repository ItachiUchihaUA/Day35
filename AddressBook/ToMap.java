package workshop_AddressBook;

import java.util.stream.Collectors;

public class ToMap {
	
	protected static void cityMap(){
		AddressBook.cityBook = AddressBook.addressBook.stream().collect(Collectors.toMap( n -> n , n -> n.getCity()));
	}
	protected static void stateMap(){
		AddressBook.stateBook = AddressBook.addressBook.stream().collect(Collectors.toMap( n -> n , n -> n.getState()));
	}
}
