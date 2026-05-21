package com.borntocode.main.entity;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BIKE")

public class Bike extends Vehicle {

	private String bikeType;

	public String getBikeType() {
		return bikeType;
	}

	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}
}
