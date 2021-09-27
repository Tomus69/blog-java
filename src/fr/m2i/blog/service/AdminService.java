package fr.m2i.blog.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.m2i.blog.dto.AdminDto;
import fr.m2i.blog.hibernate.HibernateConfiguration;
import fr.m2i.blog.singleton.BlogSingleton;

public class AdminService {

	public static AdminDto getInstance() {
		AdminDto admin = new AdminDto();
		admin.setName("New Admin");
		admin.setPassword("admin");
		return admin;
	}

	public static void save(AdminDto admin) throws Exception {
		if (admin.getId() == null) {
			insert(admin);
		} else {
			update(admin);
		}
	}

	private static void insert(AdminDto admin) {

		admin.setId(BlogSingleton.nextSequence());

		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(admin);
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	private static void update(AdminDto admin) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(admin);
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public static void delete(AdminDto admin) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(admin);
			session.flush();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static AdminDto findById(Long id) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(AdminDto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static List<AdminDto> findAll() {
		Session session = null;
		try {
			HibernateConfiguration hibernateConfiguration = BlogSingleton.getInstance().getHibernateConfiguration();
			SessionFactory factory = hibernateConfiguration.getFactory();
			session = factory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<AdminDto> cq = cb.createQuery(AdminDto.class);
			Root<AdminDto> root = cq.from(AdminDto.class);
			CriteriaQuery<AdminDto> all = cq.select(root);
			TypedQuery<AdminDto> resultQuery = session.createQuery(all);
			return resultQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
}
