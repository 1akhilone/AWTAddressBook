package vce.it.addrbook.tests;

import java.io.File;

import vce.it.addrbook.core.Address;
import vce.it.addrbook.core.AddressBook;
import vce.it.addrbook.io.AddressBookFileManager;

public class TestAddressBookFileManager {

	public static void main(String[] args) {
		File addressBookFile = new File("AddressBook.bin");
		AddressBookFileManager fileManager = new AddressBookFileManager(addressBookFile);
		System.out.println(addressBookFile.getAbsolutePath());
		
		System.out.println(fileManager.getAddressBook().getAddrArrLength());
		
		Address a1 = new Address("Sam", "India", "Delhi", "Delhi", "Delhi", "Delhi", "Apartment No 4, Street 5", "Abc Apartments, Karol Bhag", 9090808080L, 600060);
		Address a2 = new Address("vasavi", "India", "Telangana", "Rangareddy", "Gandipet", "Ibrahimbagh", "IT Dept", "Vasavi Engg Coll", 8008800880L, 500052);
		
		fileManager.getAddressBook().addAddress(a1);
		fileManager.getAddressBook().addAddress(a2);
		
		System.out.println("Addresses saved : " + fileManager.saveAdderssBook());
				
		addressBookFile = new File("AddressBook2.bin");
		fileManager = new AddressBookFileManager(addressBookFile, 20);
		System.out.println(addressBookFile.getAbsolutePath());
		System.out.println(fileManager.getAddressBook().getAddrArrLength());
		
		addressBookFile = new File("AddressBook3.bin");
		AddressBook ab = new AddressBook(30);
	//	fileManager = new AddressBookFileManager(addressBookFile, ab);
		ab.addAddress(a2);
		System.out.println(addressBookFile.getAbsolutePath());
		System.out.println(fileManager.getAddressBook().getAddrArrLength());
		
		
				
	}

}
