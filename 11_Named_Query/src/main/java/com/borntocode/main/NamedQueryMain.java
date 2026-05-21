package com.borntocode.main;

import java.util.List;

import com.borntocode.main.entity.UserDetails;
import com.borntocode.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class NamedQueryMain {
	public static void main(String[] args) {

//Find All Employees
//		EntityManager em = HibernateUtil.getEntityManager();
//
//		TypedQuery<UserDetails> query = em.createNamedQuery("UserDetails.findAll", UserDetails.class);
//
//		List<UserDetails> list = query.getResultList();
//
//		for (UserDetails u : list) {
//			System.out.println(u.getName());
//		}

// With Where Condition
		EntityManager em = HibernateUtil.getEntityManager();

		TypedQuery<UserDetails> query = em.createNamedQuery("UserDetails.findByName", UserDetails.class);

		query.setParameter("name", "Vivek Gohil");
		List<UserDetails> list = query.getResultList();

		for (UserDetails u : list) {
			System.out.println(u.getName());
		}
	}
}
