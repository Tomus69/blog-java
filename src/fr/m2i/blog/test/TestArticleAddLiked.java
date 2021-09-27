package fr.m2i.blog.test;

import java.io.FileNotFoundException;

import fr.m2i.blog.dto.AdminDto;
import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.LikedDto;
import fr.m2i.blog.dto.UserDto;
import fr.m2i.blog.hibernate.HibernateInit;
import fr.m2i.blog.jdbc.DatabaseStructure;
import fr.m2i.blog.service.AdminService;
import fr.m2i.blog.service.ArticleService;
import fr.m2i.blog.service.LikedService;
import fr.m2i.blog.service.UserService;

public class TestArticleAddLiked {

	public static void main(String[] args) throws Exception {

		DatabaseStructure.createAllTable();

		try {

			HibernateInit.init();
			// GenerateData.generate();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AdminDto admin = AdminService.getInstance();
		AdminService.save(admin);

		UserDto user = UserService.getInstance();
		UserService.save(user);

		LikedDto liked = LikedService.getInstance();
		liked.setUser(user);
		ArticleDto article = ArticleService.getInstance();
		System.out.println(article);
		article.setAdmin(admin);
		article.getListLikeds().add(liked);
		liked.setArticle(article);

		likeArticle(user, admin);
		likeArticle(user, admin);
		likeArticle(user, admin);

		System.out.println(article);
		System.out.println(liked);

		System.out.println(UserService.findAll());

		System.out.println(ArticleService.findAll());
		System.out.println(LikedService.findAll());

	}

	public static void likeArticle(UserDto user, AdminDto admin) throws Exception {
		LikedDto liked = LikedService.getInstance();
		liked.setUser(user);
		ArticleDto article = ArticleService.getInstance();
		System.out.println(article);
		article.setAdmin(admin);
		article.getListLikeds().add(liked);
		liked.setArticle(article);
		LikedService.save(liked);
		ArticleService.save(article);
	}

}
