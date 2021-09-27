package fr.m2i.blog.hibernate;

import java.io.FileNotFoundException;

import fr.m2i.blog.singleton.BlogSingleton;

public class HibernateInit {

	public static void init() throws FileNotFoundException {
		HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
		BlogSingleton.getInstance().setHibernateConfiguration(hibernateConfiguration);
	}
}
