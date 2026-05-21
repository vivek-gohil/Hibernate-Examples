package com.borntocode.main;

import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class JPQLMain {
	public static void main(String[] args) {
		EntityManager entityManager = HibernateUtil.getEntityManager();

// JPQL Select Example
// String jpql = "SELECT u FROM UserDetails u";
//		String jpql = "SELECT u FROM UserDetails u WHERE u.name = 'Advaot Gohil'";
//		TypedQuery<UserDetails> query = entityManager.createQuery(jpql, UserDetails.class);
//
//		List<UserDetails> userDetailsList = query.getResultList();
//
//		for (UserDetails u : userDetailsList) {
//			System.out.println(u.getName());
//		}

// JPQL With Parameter
//		String jpql = "SELECT u FROM UserDetails u WHERE u.name = :name";
//
//		TypedQuery<UserDetails> query = entityManager.createQuery(jpql, UserDetails.class);
//
//		query.setParameter("name", "Vivek Gohil");
//
//		List<UserDetails> userDetails = query.getResultList();
//
//		for (UserDetails u : userDetails) {
//			System.out.println(u);
//		}

// JPQL Update and Delete Query
		entityManager.getTransaction().begin();

		String jpql = "UPDATE UserDetails e SET e.name = 'Advait' WHERE e.userId = 4";

		Query query = entityManager.createQuery(jpql);

		query.executeUpdate();

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}

//| Use Case         | Query                       |
//| ---------------- | --------------------------- |
//| Find all records | `SELECT e FROM Employee e`  |
//| Find by id       | `WHERE e.id = :id`          |
//| Update           | `UPDATE Employee e SET ...` |
//| Delete           | `DELETE FROM Employee e`    |
//| Count            | `SELECT COUNT(e)`           |
//| Join             | `JOIN e.department`         |
