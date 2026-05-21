package com.borntocode.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")

@NamedQuery(name = "UserDetails.findAll", query = "SELECT u FROM UserDetails u")

@NamedQuery(name = "UserDetails.findByName", query = "SELECT u FROM UserDetails u WHERE u.name = :name")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@OneToOne
	@JoinColumn(name = "address_id")
	private AddressDetails addressDetails;

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int userId, String name, AddressDetails addressDetails) {
		super();
		this.userId = userId;
		this.name = name;
		this.addressDetails = addressDetails;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", addressDetails=" + addressDetails + "]";
	}

}
