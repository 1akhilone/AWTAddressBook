package vce.it.addrbook.tests;

import java.io.File;

import vce.it.addrbook.core.Address;
import vce.it.addrbook.io.AddressBookFileManager;

public class TestAddressBookFileContents {

	public static void main(String[] args) {
		File addressBookFile = new File("AddressBook.bin");
		AddressBookFileManager fileManager = new AddressBookFileManager(addressBookFile);
		System.out.println(addressBookFile.getAbsolutePath());
		
		System.out.println(fileManager.getAddressBook().getAddrArrLength());
		
		Address[] addresses = fileManager.getAddressBook().getAddresses();
		
		for(Address a : addresses){
			if(a!=null){
				System.out.println(a);
			}
		}
		
		
	}

}
