package com.borntocode.main.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "name", nullable = false, length = 50)
	private String name;

	@ManyToMany
	@JoinTable(name = "user_address", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
	private List<AddressDetails> addresses = new ArrayList<>();

	public UserDetails() {
		// TODO Auto-generated constructor stub
	}

	public UserDetails(int userId, String name, List<AddressDetails> addresses) {
		super();
		this.userId = userId;
		this.name = name;
		this.addresses = addresses;
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

	public List<AddressDetails> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<AddressDetails> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", name=" + name + ", addresses=" + addresses + "]";
	}

}
