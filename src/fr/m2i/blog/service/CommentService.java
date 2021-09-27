package fr.m2i.blog.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.m2i.blog.dto.CommentDto;
import fr.m2i.blog.hibernate.HibernateConfiguration;
import fr.m2i.blog.singleton.BlogSingleton;

public class CommentService {

	public static CommentDto getInstance() {
		CommentDto comment = new CommentDto();
		comment.setContent("New Comment");
		comment.setCreated_at(LocalDateTime.now());
		return comment;
	}

	public static void save(CommentDto comment) throws Exception {
		if (comment.getId() == null) {
			insert(comment);
		} else {
			update(comment);
		}
	}

	private static void insert(CommentDto comment) {

		comment.setId(BlogSingleton.nextSequence());

		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(comment);
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

	private static void update(CommentDto comment) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(comment);
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

	public static void delete(CommentDto comment) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(comment);
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

	public static CommentDto findById(Long id) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(CommentDto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static List<CommentDto> findAll() {
		Session session = null;
		try {
			HibernateConfiguration hibernateConfiguration = BlogSingleton.getInstance().getHibernateConfiguration();
			SessionFactory factory = hibernateConfiguration.getFactory();
			session = factory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<CommentDto> cq = cb.createQuery(CommentDto.class);
			Root<CommentDto> root = cq.from(CommentDto.class);
			CriteriaQuery<CommentDto> all = cq.select(root);
			TypedQuery<CommentDto> resultQuery = session.createQuery(all);
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
