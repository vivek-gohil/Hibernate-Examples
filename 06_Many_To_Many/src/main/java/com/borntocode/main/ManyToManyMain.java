package com.borntocode.main;

import java.util.ArrayList;
import java.util.List;

import com.borntocode.main.entity.AddressDetails;
import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ManyToManyMain {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Mumbai", "400012");
		AddressDetails addressDetails2 = new AddressDetails(0, "Pune", "400065");

		List<AddressDetails> addressDetailsList = new ArrayList<>();
		addressDetailsList.add(addressDetails2);
		addressDetailsList.add(addressDetails);

		UserDetails userDetails1 = new UserDetails(0, "Vivek", addressDetailsList);
		UserDetails userDetails2 = new UserDetails(0, "Advait", addressDetailsList);
		
		entityManager.persist(addressDetails);
		entityManager.persist(addressDetails2);
		
		entityManager.persist(userDetails1);
		entityManager.persist(userDetails2);

		entityTransaction.commit();
		entityManager.close();
	}
}
