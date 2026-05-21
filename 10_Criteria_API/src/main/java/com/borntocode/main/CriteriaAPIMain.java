package com.borntocode.main;

import java.util.List;

import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CriteriaAPIMain {
	public static void main(String[] args) {

// Select ALL
//		EntityManager em = HibernateUtil.getEntityManager();
//
//		CriteriaBuilder cb = em.getCriteriaBuilder();
//
//		CriteriaQuery<UserDetails> cq = cb.createQuery(UserDetails.class);
//
//		Root<UserDetails> root = cq.from(UserDetails.class);
//
//		cq.select(root);
//
//		TypedQuery<UserDetails> query = em.createQuery(cq);
//
//		List<UserDetails> userDetailsList = query.getResultList();
//
//		for (UserDetails u : userDetailsList) {
//			System.out.println(u.getName());
//		}

// Where Condition
		EntityManager em = HibernateUtil.getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<UserDetails> cq = cb.createQuery(UserDetails.class);

		Root<UserDetails> root = cq.from(UserDetails.class);

		Predicate condition = cb.equal(root.get("name"), "Vivek Gohil");

		cq.select(root).where(condition);

		List<UserDetails> userDetailsList = em.createQuery(cq).getResultList();

		for (UserDetails u : userDetailsList) {
			System.out.println(u.getName());
		}

	}
}
