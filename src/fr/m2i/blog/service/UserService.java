package fr.m2i.blog.service;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.m2i.blog.dto.UserDto;
import fr.m2i.blog.hibernate.HibernateConfiguration;
import fr.m2i.blog.singleton.BlogSingleton;

public class UserService {

	public static UserDto getInstance() {
		UserDto user = new UserDto();
		user.setName("New User");
		user.setPassword("user");
		return user;
	}

	public static void save(UserDto user) throws Exception {
		if (user.getId() == null) {
			insert(user);
		} else {
			update(user);
		}
	}

	private static void insert(UserDto user) {

		user.setId(BlogSingleton.nextSequence());

		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(user);
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

	private static void update(UserDto user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(user);
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

	public static void delete(UserDto user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(user);
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

	public static UserDto findById(Long id) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(UserDto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}
	
	public static UserDto findByName(String name) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(UserDto.class, name);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static List<UserDto> findAll() {
		Session session = null;
		try {
			HibernateConfiguration hibernateConfiguration = BlogSingleton.getInstance().getHibernateConfiguration();
			SessionFactory factory = hibernateConfiguration.getFactory();
			session = factory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<UserDto> cq = cb.createQuery(UserDto.class);
			Root<UserDto> root = cq.from(UserDto.class);
			CriteriaQuery<UserDto> all = cq.select(root);
			TypedQuery<UserDto> resultQuery = session.createQuery(all);
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
