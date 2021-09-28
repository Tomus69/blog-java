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
		AdminService.save(tom);
		System.out.println(">> ADMIN TOM : " + tom);

		AdminDto remy = AdminService.getInstance();
		remy.setName("Rémy");
		AdminService.save(remy);
		System.out.println(">> ADMIN REMY : " + remy);

		AdminDto gwen = AdminService.getInstance();
		gwen.setName("Gwen");
		AdminService.save(gwen);
		System.out.println(">> ADMIN GWEN : " + gwen);

		ArticleDto article = ArticleService.getInstance();
		article.setTitle("article 1");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(tom);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		article = ArticleService.getInstance();
		article.setTitle("article 2");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(remy);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		article = ArticleService.getInstance();
		article.setTitle("article 3");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(gwen);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		article = ArticleService.getInstance();
		article.setTitle("article 4");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(tom);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		article = ArticleService.getInstance();
		article.setTitle("article 5");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(remy);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		article = ArticleService.getInstance();
		article.setTitle("article 6");
		article.setContent(
				"On sait depuis longtemps que travailler avec du texte lisible et contenant du sens est source de distractions, et empêche de se concentrer sur la mise en page elle-même. L'avantage du Lorem Ipsum sur un texte générique comme 'Du texte. Du texte. Du texte.' est qu'il possède une distribution de lettres plus ou moins normale, et en tout cas comparable avec celle du français standard. De nombreuses suites logicielles de mise en page ou éditeurs de sites Web ont fait du Lorem Ipsum leur faux texte par défaut, et une recherche pour 'Lorem Ipsum' vous conduira vers de nombreux sites qui n'en sont encore qu'à leur phase de construction. Plusieurs versions sont apparues avec le temps, parfois par accident, souvent intentionnellement (histoire d'y rajouter de petits clins d'oeil, voire des phrases embarassantes)");
		article.setAdmin(tom);
		ArticleService.save(article);
		System.out.println(">> ARTICLE : " + article);

		UserDto toto = UserService.getInstance();
		toto.setName("Toto");
		UserService.save(toto);
		System.out.println(">> USER : " + toto);

		CommentDto comment = CommentService.getInstance();
		article.getListComments().add(comment);
		comment.setUser(toto);
		comment.setArticle(article);
		CommentService.save(comment);
		System.out.println(">> COMMENT : " + comment);

		LikedDto liked = LikedService.getInstance();
		article.getListLikeds().add(liked);
		liked.setUser(toto);
		liked.setArticle(article);
		LikedService.save(liked);
		System.out.println(">> LIKED : " + liked);
		System.out.println(">> ARTICLE LIKED : " + article);
		
		liked = LikedService.getInstance();
		article.getListLikeds().add(liked);
		liked.setUser(toto);
		liked.setArticle(article);
		LikedService.save(liked);
		
		liked = LikedService.getInstance();
		article.getListLikeds().add(liked);
		liked.setUser(toto);
		liked.setArticle(article);
		LikedService.save(liked);

		System.out.println(article.getListLikeds().size());
		System.out.println(LikedService.findAll());
		System.out.println(article.getListComments());
	}
}
