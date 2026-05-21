package com.borntocode.main;

import com.borntocode.main.entity.AddressDetails;
import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToMany {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Mumbai", "400012");

		UserDetails userDetails1 = new UserDetails(0, "Vivek Gohil", addressDetails);
		UserDetails userDetails2 = new UserDetails(0, "Advait Gohil", addressDetails);
		UserDetails userDetails3 = new UserDetails(0, "Trupti Acharekar", addressDetails);

		entityManager.persist(addressDetails);
		entityManager.persist(userDetails1);
		entityManager.persist(userDetails2);
		entityManager.persist(userDetails3);

		entityTransaction.commit();
		entityManager.close();
	}
}
