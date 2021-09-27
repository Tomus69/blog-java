package fr.m2i.blog.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.m2i.blog.dto.LikedDto;
import fr.m2i.blog.hibernate.HibernateConfiguration;
import fr.m2i.blog.singleton.BlogSingleton;

public class LikedService {

	public static LikedDto getInstance() {

		return new LikedDto();
	}

	public static void save(LikedDto liked) throws Exception {
		if (liked.getId() == null) {
			insert(liked);
		} else {
			update(liked);
		}
	}

	private static void insert(LikedDto liked) {

		liked.setId(BlogSingleton.nextSequence());

		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(liked);
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

	private static void update(LikedDto liked) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(liked);
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

	public static void delete(LikedDto liked) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(liked);
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

	public static LikedDto findById(Long id) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(LikedDto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static List<LikedDto> findAll() {
		Session session = null;
		try {
			HibernateConfiguration hibernateConfiguration = BlogSingleton.getInstance().getHibernateConfiguration();
			SessionFactory factory = hibernateConfiguration.getFactory();
			session = factory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<LikedDto> cq = cb.createQuery(LikedDto.class);
			Root<LikedDto> root = cq.from(LikedDto.class);
			CriteriaQuery<LikedDto> all = cq.select(root);
			TypedQuery<LikedDto> resultQuery = session.createQuery(all);
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
