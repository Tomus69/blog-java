package fr.m2i.blog.singleton;

import fr.m2i.blog.hibernate.HibernateConfiguration;

public class BlogSingleton {

	private static BlogSingleton blogSingleton;

	private HibernateConfiguration hibernateConfiguration;

	private static Long sequence = 0L;

	public static BlogSingleton getInstance() {
		if (blogSingleton == null) {
			blogSingleton = new BlogSingleton();
		}
		return blogSingleton;
	}

	public static Long nextSequence() {
		return sequence++;
	}

	public HibernateConfiguration getHibernateConfiguration() {
		return hibernateConfiguration;
	}

	public void setHibernateConfiguration(HibernateConfiguration hibernateConfiguration) {
		this.hibernateConfiguration = hibernateConfiguration;
	}

}
