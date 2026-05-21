package com.borntocode.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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

	@OneToOne(mappedBy = "addressDetails")
	private UserDetails userDetails;

	public AddressDetails() {
		// TODO Auto-generated constructor stub
	}

	public AddressDetails(int addressId, String city, String pincode, UserDetails userDetails) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
		this.userDetails = userDetails;
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

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "AddressDetails [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode + ", userDetails="
				+ userDetails + "]";
	}

}
