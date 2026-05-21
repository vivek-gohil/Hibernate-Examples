package com.borntocode.main;

import com.borntocode.main.entity.AddressDetails;
import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class OneToOneMain {
	public static void main(String[] args) {
		// insert();
		// select();
		// update();
		// delete();
		// cascadePersist();
		// cascadeMerge();
		// cascadeRemove();
		// cascadeRefresh();
	}

	private static void cascadeDetach() {
//detach() means:
//Remove entity from persistence context/session.
//
//After detach:
//
//Hibernate stops tracking object changes
//Changes will NOT update database automatically
		EntityManager entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		// Fetch object
		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 1);

		// Initialize lazy object
		existingUserDetails.getAddressDetails().getCity();

		System.out.println("Before Detach:");
		System.out.println(existingUserDetails);

		/*
		 * Detach parent object Due to CascadeType.DETACH child also detached
		 */

		entityManager.detach(existingUserDetails);

		System.out.println("\nObjects Detached");

		/*
		 * Modify detached objects
		 */

		existingUserDetails.setName("Detached Vivek");

		existingUserDetails.getAddressDetails().setCity("Detached Mumbai");

		/*
		 * Commit transaction
		 */

		entityTransaction.commit();

		entityManager.close();

		System.out.println("\nAfter Changes On Detached Objects:");
		System.out.println(existingUserDetails);

		System.out.println("\nDatabase will NOT be updated!");
	}

	private static void cascadeRefresh() {
//		Suppose:
//			Object loaded in Java
//			Database updated externally
//			You want latest DB values again

		EntityManager entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		// Fetch existing user
		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 2);

		// Load lazy object before refresh
		existingUserDetails.getAddressDetails().getCity();

		System.out.println("Before Changes:");
		System.out.println(existingUserDetails);

		/*
		 * Local object changes NOT committed to database yet
		 */

		existingUserDetails.setName("Temporary Name");

		existingUserDetails.getAddressDetails().setCity("Temporary City");

		System.out.println("\nAfter Local Changes:");
		System.out.println(existingUserDetails);

		/*
		 * Refresh object from DB Local changes discarded
		 */

		entityManager.refresh(existingUserDetails);

		System.out.println("\nAfter Refresh:");
		System.out.println(existingUserDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void cascadeRemove() {
		EntityManager entityManager = HibernateUtil.getEntityManager();

		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 1);

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.remove(existingUserDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void cascadeMerge() {

		EntityManager entityManager = HibernateUtil.getEntityManager();

		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 1);

		// Initialize lazy object BEFORE close
		existingUserDetails.getAddressDetails().getCity();

		entityManager.close();

		existingUserDetails.setName("Vivek Gohil");
		existingUserDetails.getAddressDetails().setCity("Navi Mumbai");

		entityManager = HibernateUtil.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();

		entityManager.merge(existingUserDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void cascadePersist() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Kalyan", "421202");
		UserDetails userDetails = new UserDetails(0, "Seema", addressDetails);

		entityManager.persist(userDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void delete() {
		EntityManager entityManager = HibernateUtil.getEntityManager();

		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 1);

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.remove(existingUserDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void update() {
		EntityManager entityManager = HibernateUtil.getEntityManager();

		UserDetails existingUserDetails = entityManager.find(UserDetails.class, 1);
		AddressDetails existingAddressDetails = entityManager.find(AddressDetails.class, 2);

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		existingUserDetails.setAddressDetails(existingAddressDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void insert() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AddressDetails addressDetails = new AddressDetails(0, "Mumbai", "400012");
		UserDetails userDetails = new UserDetails(0, "Vivek Gohil", addressDetails);

		entityManager.persist(addressDetails);
		entityManager.persist(userDetails);

		entityTransaction.commit();
		entityManager.close();
	}

	private static void select() {
		EntityManager entityManager = HibernateUtil.getEntityManager();
		UserDetails userDetails = entityManager.find(UserDetails.class, 1);
		// System.out.println(userDetails.getName());
		System.out.println(userDetails);
		entityManager.close();
	}
}
