package vce.it.addrbook.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import vce.it.addrbook.core.AddressBook;

public class AddressBookFileManager {
	
	private AddressBook addressBook;
	private File addressBookFile;
	private int addressBookLength;
	private FileInputStream fIn;
	private BufferedInputStream bIn;
	private ObjectInputStream oIn;
	private FileOutputStream fOut;
	private BufferedOutputStream bOut;
	private ObjectOutputStream oOut;

	// to be called when Open Menu item is selected
	public AddressBookFileManager(File addressBookFile){
		loadAddressBookFromAddressBookFile(addressBookFile);
	}
	
	// called when new option menu is selected
	public AddressBookFileManager(File addressBookFile, int addressBookLength){
		this.addressBookLength = addressBookLength;
		this.addressBookFile = addressBookFile;
		
		checkNCreateAddressBookFile();
		
	}
	
	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	public File getAddressBookFile() {
		return addressBookFile;
	}

	public void setAddressBookFile(File addressBookFile) {
		this.addressBookFile = addressBookFile;
	}

	private boolean checkNCreateAddressBookFile() {
		boolean fileCreated = false;
	
			try {
				fOut = new FileOutputStream(addressBookFile);
				bOut = new BufferedOutputStream(fOut);
				oOut = new ObjectOutputStream(bOut);
				addressBook = new AddressBook(addressBookLength);
				oOut.writeObject(addressBook);
				oOut.flush();
				fileCreated = true;
				oOut.close();
				bOut.close();
				fOut.close();
			} catch(FileNotFoundException e) {
				System.out.println("AddressBook File Dosent exist");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return fileCreated;
	}
	
	
	private boolean loadAddressBookFromAddressBookFile(File addressBookFile) {
		boolean loaded = false;

		this.addressBookFile = addressBookFile;
			try {
				fIn = new FileInputStream(addressBookFile);
				bIn = new BufferedInputStream(fIn);
				oIn = new ObjectInputStream(bIn);
				addressBook = (AddressBook) oIn.readObject();
				addressBookLength = addressBook.getAddrArrLength();
				System.out.println(addressBookLength);
				loaded = true;
				
				oIn.close();
				bIn.close();
				fIn.close();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		return loaded;
	}
	
	public boolean saveAdderssBook() {
		boolean saved = true;
		
		try {
			fOut = new FileOutputStream(addressBookFile);
			bOut = new BufferedOutputStream(fOut);
			oOut = new ObjectOutputStream(bOut);
			
			oOut.writeObject(addressBook);
			oOut.flush();
			saved = true;
			oOut.close();
			bOut.close();
			fOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return saved;
		
	}
	
}
