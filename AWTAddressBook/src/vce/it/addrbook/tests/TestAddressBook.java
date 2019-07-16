package vce.it.addrbook.tests;

import vce.it.addrbook.core.Address;
import vce.it.addrbook.core.AddressBook;

public class TestAddressBook {

	public static void main(String[] args) {
		
		Address a1 = new Address("Sam", "India", "Delhi", "Delhi", "Delhi", "Delhi", "Apartment No 4, Street 5", "Abc Apartments, Karol Bhag", 9090808080L, 600060);
		Address a2 = new Address("vasavi", "India", "Telangana", "Rangareddy", "Gandipet", "Ibrahimbagh", "IT Dept", "Vasavi Engg Coll", 8008800880L, 500052);
		
		AddressBook addressBook = new AddressBook(10);
		System.out.println("Adding 2 addresses to addressbook");
		addressBook.addAddress(a1);
		addressBook.addAddress(a2);
		
		Address[] addresses = new Address[addressBook.getAddrArrLength()];
		addresses = addressBook.getAddresses();
		
		System.out.println("Displaying contents of addressbook");
		for(Address a : addresses) {
			if(a!=null) {
				System.out.println(a);
			}
		}
		
		System.out.println("Searching for an address with name vasaVI");
		Address retAddress1 = addressBook.searchAddress("vasaVI");
		System.out.println(retAddress1);
		
		System.out.println("Searching for an address named student");
		Address retAddress2 = addressBook.searchAddress("student");
		System.out.println(retAddress2);
		
		System.out.println("Removing an address with name abc");
		boolean removed = addressBook.removeAddress("abc");
		System.out.println(removed);
		
		System.out.println("Removing an address with name sam");
		removed = addressBook.removeAddress("sam");
		System.out.println(removed);
		
		addresses = addressBook.getAddresses();
		
		System.out.println("Printing the contents of addrssbook");
		for(Address a : addresses) {
			if(a!=null) {
				System.out.println(a);
			}
		}
		
	}

}
