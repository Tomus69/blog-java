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

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.exception.AdminAbsentException;
import fr.m2i.blog.hibernate.HibernateConfiguration;
import fr.m2i.blog.singleton.BlogSingleton;

public class ArticleService {

	public static ArticleDto getInstance() {
		ArticleDto article = new ArticleDto();
		article.setTitle("New Article");
		article.setContent("Article Content !! Article Content");
		article.setCreated_at(LocalDateTime.now());
		article.setNbLiked(0L);
		return article;
	}

	public static void save(ArticleDto article) throws Exception {
		if (article.getAdmin() == null) {
			throw new AdminAbsentException();
		}
		if (article.getId() == null) {
			insert(article);
		} else {
			update(article);
		}
	}

	private static void insert(ArticleDto article) {

		article.setId(BlogSingleton.nextSequence());

		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(article);
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

	private static void update(ArticleDto article) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(article);
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
	
	public static void delete(ArticleDto article) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			transaction = session.beginTransaction();
			session.delete(article);
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

	public static ArticleDto findById(Long id) {
		Session session = null;
		try {
			session = BlogSingleton.getInstance().getHibernateConfiguration().getFactory().openSession();
			return session.get(ArticleDto.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	public static List<ArticleDto> findAll() {
		Session session = null;
		try {
			HibernateConfiguration hibernateConfiguration = BlogSingleton.getInstance().getHibernateConfiguration();
			SessionFactory factory = hibernateConfiguration.getFactory();
			session = factory.openSession();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<ArticleDto> cq = cb.createQuery(ArticleDto.class);
			Root<ArticleDto> root = cq.from(ArticleDto.class);
			CriteriaQuery<ArticleDto> all = cq.select(root);
			TypedQuery<ArticleDto> resultQuery = session.createQuery(all);
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
