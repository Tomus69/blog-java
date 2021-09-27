package fr.m2i.blog.data;

import fr.m2i.blog.dto.AdminDto;
import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.CommentDto;
import fr.m2i.blog.dto.LikedDto;
import fr.m2i.blog.dto.UserDto;
import fr.m2i.blog.service.AdminService;
import fr.m2i.blog.service.ArticleService;
import fr.m2i.blog.service.CommentService;
import fr.m2i.blog.service.LikedService;
import fr.m2i.blog.service.UserService;

public class GenerateData {

	public static void generate() throws Exception {
		AdminDto tom = AdminService.getInstance();
		tom.setName("Tom");
		System.out.println(">> ADMIN TOM : " + tom);

		AdminDto remy = AdminService.getInstance();
		remy.setName("Rémy");
		System.out.println(">> ADMIN REMY : " + remy);
		
		AdminDto gwen = AdminService.getInstance();
		gwen.setName("Gwen");
		System.out.println(">> ADMIN GWEN : " + gwen);
		
		ArticleDto article = ArticleService.getInstance();
		article.setAdmin(tom);
		System.out.println(">> ARTICLE : " + article);

		UserDto toto = UserService.getInstance();
		toto.setName("Toto");
		System.out.println(">> USER : " + toto);

		CommentDto comment = CommentService.getInstance();
		article.getListComments().add(comment);
		comment.setUser(toto);
		comment.setArticle(article);
		System.out.println(">> COMMENT : " + comment);

		LikedDto liked = LikedService.getInstance();
		article.getListLikeds().add(liked);
		liked.setUser(toto);
		liked.setArticle(article);
		System.out.println(">> LIKED : " + liked);
		System.out.println(">> ARTICLE LIKED : " + article);

		AdminService.save(tom);
		AdminService.save(remy);
		AdminService.save(gwen);
		UserService.save(toto);
		CommentService.save(comment);
		LikedService.save(liked);
		ArticleService.save(article);
		
		System.out.println(article.getListLikeds().size());
		System.out.println(article.getListComments());
	}
}
