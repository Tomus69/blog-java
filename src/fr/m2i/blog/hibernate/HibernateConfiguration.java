package fr.m2i.blog.hibernate;

import java.io.File;
import java.io.FileNotFoundException;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import fr.m2i.blog.dto.AdminDto;
import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.CommentDto;
import fr.m2i.blog.dto.LikedDto;
import fr.m2i.blog.dto.UserDto;


public class HibernateConfiguration {

	private static final String FILE_NAME_HIBERNATE_CONFIGURATION = "blog.cfg.xml";

	private SessionFactory factory;

	File file = new File(FILE_NAME_HIBERNATE_CONFIGURATION);

	Configuration configuration;

	public HibernateConfiguration() throws FileNotFoundException {

		if (!file.exists()) {
			throw new FileNotFoundException("Le fichier de configuration nécessaire à hibernate, '"
					+ FILE_NAME_HIBERNATE_CONFIGURATION + "' n'existe pas !");
		}

		buildConfiguration(file);

		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();

		ServiceRegistry serviceRegistry = builder.applySettings(configuration.getProperties()).build();

		this.factory = configuration.buildSessionFactory(serviceRegistry);
	}

	public void buildConfiguration(File fileHibernateConfiguration) {
		this.configuration = new Configuration().configure(fileHibernateConfiguration);

		this.configuration.addAnnotatedClass(ArticleDto.class);
		this.configuration.addAnnotatedClass(AdminDto.class);
		this.configuration.addAnnotatedClass(UserDto.class);
		this.configuration.addAnnotatedClass(CommentDto.class);
		this.configuration.addAnnotatedClass(LikedDto.class);

	}

	public SessionFactory getFactory() {
		return factory;
	}
}
