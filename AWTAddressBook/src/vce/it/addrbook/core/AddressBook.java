package vce.it.addrbook.core;

import java.io.Serializable;

public class AddressBook implements Serializable {
	
	private static final long serialVersionUID = 3615732058501960745L;
	private Address[] addresses;
	private int addrArrLength;
	private int addressCount;
	
	public AddressBook() {
		
	}
	
	public AddressBook(int addrArrLength) {
		super();
		this.addrArrLength = addrArrLength;
		addresses = new Address[addrArrLength];
		countNSetAddressCount();
	}

		public Address[] getAddresses() {
		return addresses;
	}

	public void setAddresses(Address[] addresses) {
		this.addresses = addresses;
	}

	public int getAddrArrLength() {
		return addrArrLength;
	}

	public void setAddrArrLength(int addrArrLength) {
		this.addrArrLength = addrArrLength;
	}

	public int getAddressCount() {
		return addressCount;
	}

	public void setAddressCount(int addressCount) {
		this.addressCount = addressCount;
	}

		private void countNSetAddressCount() {
			int count = 0;
			for(Address a : addresses) {
				if(a!= null) {
					count++;
				}
			}
			addressCount = count;
		}
		
		public boolean addAddress(Address address) {
			boolean added = false;
			for(int i = 0; i < addrArrLength; i++) {
				if(addresses[i] == null) {
					addresses[i] = address;
					added = true;
					addressCount++;
					break;
				}
			}
			return added;
		}
		
		public boolean removeAddress(String name) {
			boolean removed  = false;
			for(int i = 0; i < addrArrLength; i++) {
				if(addresses[i] != null && addresses[i].getName().equalsIgnoreCase(name)) {
					addresses[i] = null;
					removed = true;
					break;
				}
			}
			return removed;
		}
		
		public Address searchAddress(String name) {
			Address address = null;
			if(addresses != null) {
				for(Address a : addresses) {
					if(a != null) {
						if(a.getName().equalsIgnoreCase(name)) {
							address = a;
						}
					}
				}
			}
			return address;
		}
		
		
}
