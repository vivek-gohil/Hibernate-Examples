package com.borntocode.main;

import com.borntocode.main.entity.AddressDetails;
import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToOneMain {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Mumbai", "400012", null);
		UserDetails userDetails = new UserDetails(0, "Vivek Gohil", addressDetails);

		addressDetails.setUserDetails(userDetails);

		entityManager.persist(addressDetails);
		entityManager.persist(userDetails);

		entityTransaction.commit();
		entityManager.close();

	}
}
