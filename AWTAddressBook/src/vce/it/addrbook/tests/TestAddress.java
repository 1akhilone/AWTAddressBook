package vce.it.addrbook.tests;

import vce.it.addrbook.core.Address;

public class TestAddress {

	public static void main(String[] args) {
		String name = "Sam";
		String country = "India";
		String stateOrUnionTerritory = "Telangana";
		String district = "Rangareddy";
		String mandalOrTehsilOrTaluk= "Rajendranagar";
		String cityOrTownOrVillage = "Suncity";
		String addrLine1 ="House No 25, Street No 5";
		String addrLine2 =" NEW RTC Colony";
		long mobileNumber= 9898918191L;
		long pin = 521000;
		
		Address a = new Address(name, country, stateOrUnionTerritory, district, mandalOrTehsilOrTaluk, cityOrTownOrVillage, addrLine1, addrLine2, mobileNumber, pin);
		System.out.println(a);
	}

}
