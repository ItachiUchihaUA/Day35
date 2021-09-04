package workshop_AddressBook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;


public class IO {

	protected static void writeToFile(List<Contact> l, String s) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(s))) {
			for (int i = 0; i < l.size(); i++) {
				bw.write(l.get(i).toString() + "\n");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	protected static void readFromFile(String s) {
		try (BufferedReader br = new BufferedReader(new FileReader(s))) {
			String str;
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected static void readFromCSV(String s) {
		Path path = Paths.get(s);
		try (Reader r = Files.newBufferedReader(path); CSVReader csv = new CSVReader(r);) {

			String[] records;
			while ((records = csv.readNext()) != null) {
				System.out.println("First Name: " + records[0]);
				System.out.println("Last Name: " + records[1]);
				System.out.println("Address: " + records[2]);
				System.out.println("City: " + records[3]);
				System.out.println("State: " + records[4]);
				System.out.println("Email : " + records[5]);
				System.out.println("Phone : " + records[6]);
				System.out.println("ZIP : " + records[7]);
				System.out.println("-------------------------");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected static void writeInCSV(List<Contact> c , String s) {

		try (FileWriter fw = new FileWriter(s)) {

			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			for (int i = 0; i < c.size(); i++) {
				pw.print(c.get(i).getFirstName() + "," + c.get(i).getLastName() + "," + c.get(i).getAddress() + "," + c.get(i).getCity() + ","
						+ c.get(i).getState() + "," + c.get(i).getEmail() + "," + c.get(i).getPhone() + "," + c.get(i).getZip() + "\n");
			}
			pw.flush();
			pw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	protected static void writeToJson(List<Contact> c, String s) {
		
		Gson g = new GsonBuilder().setPrettyPrinting().create();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(s));
			g.toJson(c, bw);
			bw.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected static void readFromJSon(String s) {
		Gson g = new Gson();
		try {
			BufferedReader br = new BufferedReader(new FileReader(s));
			Contact[] c = g.fromJson(br, Contact[].class);
			for(int i =0; i< c.length ; i++ ) {
				System.out.println(c[i].toString());
			}
			br.close();
			
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			e.printStackTrace();
		}
	}
}
