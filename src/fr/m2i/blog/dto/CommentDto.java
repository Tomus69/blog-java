package fr.m2i.blog.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "comment")
@Table(name = "comment")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class CommentDto extends BlogObject {

	@Column
	private String content;

	@ManyToOne
	private UserDto user;

	@ManyToOne
	private ArticleDto article;

	@Column
	private LocalDateTime created_at;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

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

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "CommentDto [id=" + this.getId() + ", content=" + content + ", user=" + user + ", article="
				+ article.getTitle() + ", created_at=" + created_at + "]";
	}

	@Override
	public String getInformation() {
		return "Je suis un commentaire";
	}

}
