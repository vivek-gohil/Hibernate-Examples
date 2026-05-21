package com.borntocode.main;

import java.util.ArrayList;
import java.util.List;

import com.borntocode.main.entity.AddressDetails;
import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToManyBiDirectionalMain {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Mumbai", "400012", null);

		UserDetails userDetails1 = new UserDetails(0, "Vivek Gohil", addressDetails);
		UserDetails userDetails2 = new UserDetails(0, "Advait Gohil", addressDetails);
		UserDetails userDetails3 = new UserDetails(0, "Trupti Acharekar", addressDetails);

		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(userDetails3);
		userDetailsList.add(userDetails2);
		userDetailsList.add(userDetails1);

		addressDetails.setUserDetailsList(userDetailsList);

		entityManager.persist(addressDetails);
		entityManager.persist(userDetails1);
		entityManager.persist(userDetails2);
		entityManager.persist(userDetails3);

		entityTransaction.commit();
		entityManager.close();
	}
}
