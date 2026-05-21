package com.borntocode.main;

import com.borntocode.main.entity.Bike;
import com.borntocode.main.entity.Car;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class JoinedTableMain {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		Car car = new Car();
		car.setName("BMW");
		car.setCarType("Luxury");

		Bike bike = new Bike();
		bike.setName("Yamaha");
		bike.setBikeType("Sports");

		entityManager.persist(car);
		entityManager.persist(bike);

		entityTransaction.commit();
		entityManager.close();

	}
}
