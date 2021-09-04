package workshop_AddressBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBook {
	
	protected static List<Contact> addressBook = new ArrayList<>();
	protected static Map<Contact, String> cityBook = new HashMap<>();
	protected static Map<Contact, String> stateBook = new HashMap<>();
	
	static String fileURL= "src\\main\\resources\\Addressbook.txt";
	static String csvFileURL= "src\\main\\resources\\csvFile.csv";
	static String jsonFileURL= "src\\main\\resources\\jsonAddressBook.json";
	
	
	static String databaseURL = "jdbc:mysql://localhost:3306/addressbooksystem";
	static String tableN = "addressbook";
	


	public static void main(String[] args) {
		System.out.println("Welcome to Address Book System!\n");
		
		DataBase.connectionToDatabase(databaseURL);
		
		Ability.addContact();
		Ability.editContact();
		Ability.deleteContact();
		
		Search.inCityOrState();
		
		ToMap.cityMap();
		ToMap.stateMap();
		
		Count.forCity();
		Count.forState();
		
		addressBook = Sort.byName();
		addressBook = Sort.byCityStateOrZip();
		
		IO.writeToFile(addressBook, fileURL);
		IO.readFromFile(fileURL);
		
		IO.writeInCSV(addressBook, csvFileURL);
		IO.readFromCSV(csvFileURL);
		
		IO.writeToJson(addressBook, jsonFileURL);
		IO.readFromJSon(jsonFileURL);
		
		DataBase.connectionToDatabase(databaseURL);
		DataBase.showtable(tableN);
		DataBase.countByCity(tableN);
		
	}
}
