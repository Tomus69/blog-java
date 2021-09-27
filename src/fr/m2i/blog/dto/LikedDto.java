package fr.m2i.blog.dto;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "liked")
@Table(name = "liked")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class LikedDto extends BlogObject {

	@ManyToOne
	private UserDto user;

	@ManyToOne
	private ArticleDto article;

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public ArticleDto getArticle() {
		return article;
	}

	public void setArticle(ArticleDto article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LikedDto [id=" + this.getId() + ", user=" + user.getName() + ", article=" + article.getTitle() + "]";
	}

	@Override
	public String getInformation() {
		return "Je suis un like";
	}
}
