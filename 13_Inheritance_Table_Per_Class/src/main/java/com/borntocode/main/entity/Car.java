package com.borntocode.main.entity;

import jakarta.persistence.Entity;

@Entity
public class Car extends Vehicle {

	private String carType;

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}
}
