package com.borntocode.main.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "address_details")
public class AddressDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private int addressId;

	@Column(name = "city", nullable = false, length = 50)
	private String city;

	@Column(name = "pincode", nullable = false, length = 10)
	private String pincode;

	@OneToMany(mappedBy = "addressDetails")
	private List<UserDetails> userDetailsList = new ArrayList<>();

	public AddressDetails() {
		// TODO Auto-generated constructor stub
	}

	public AddressDetails(int addressId, String city, String pincode, List<UserDetails> userDetailsList) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
		this.userDetailsList = userDetailsList;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public List<UserDetails> getUserDetailsList() {
		return userDetailsList;
	}

	public void setUserDetailsList(List<UserDetails> userDetailsList) {
		this.userDetailsList = userDetailsList;
	}

	@Override
	public String toString() {
		return "AddressDetails [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode
				+ ", userDetailsList=" + userDetailsList + "]";
	}

}
