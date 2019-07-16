package vce.it.addrbook.core;

import java.io.Serializable;

public class Address implements Serializable {

	private static final long serialVersionUID = 6544980205428957470L;
	private String name;
	private String country;
	private String stateOrUnionTerritory;
	private String district;
	private String mandalOrTehsilOrTaluk;
	private String cityOrTownOrVillage;
	private String addrLine1;
	private String addrLine2;
	private long mobileNumber;
	private long pin;
	
	public Address(String name, String country, String stateOrUnionTerritory, String district,
			String mandalOrTehsilOrTaluk, String cityOrTownOrVillage, String addrLine1, String addrLine2,
			long mobileNumber, long pin) {
		super();
		this.name = name;
		this.country = country;
		this.stateOrUnionTerritory = stateOrUnionTerritory;
		this.district = district;
		this.mandalOrTehsilOrTaluk = mandalOrTehsilOrTaluk;
		this.cityOrTownOrVillage = cityOrTownOrVillage;
		this.addrLine1 = addrLine1;
		this.addrLine2 = addrLine2;
		this.mobileNumber = mobileNumber;
		this.pin = pin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateOrUnionTerritory() {
		return stateOrUnionTerritory;
	}

	public void setStateOrUnionTerritory(String stateOrUnionTerritory) {
		this.stateOrUnionTerritory = stateOrUnionTerritory;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getMandalOrTehsilOrTaluk() {
		return mandalOrTehsilOrTaluk;
	}

	public void setMandalOrTehsilOrTaluk(String mandalOrTehsilOrTaluk) {
		this.mandalOrTehsilOrTaluk = mandalOrTehsilOrTaluk;
	}

	public String getCityOrTownOrVillage() {
		return cityOrTownOrVillage;
	}

	public void setCityOrTownOrVillage(String cityOrTownOrVillage) {
		this.cityOrTownOrVillage = cityOrTownOrVillage;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Address [name=" + name + ", country=" + country + ", stateOrUnionTerritory=" + stateOrUnionTerritory
				+ ", district=" + district + ", mandalOrTehsilOrTaluk=" + mandalOrTehsilOrTaluk
				+ ", cityOrTownOrVillage=" + cityOrTownOrVillage + ", addrLine1=" + addrLine1 + ", addrLine2="
				+ addrLine2 + ", mobileNumber=" + mobileNumber + ", pin=" + pin + "]";
	}
	
}
