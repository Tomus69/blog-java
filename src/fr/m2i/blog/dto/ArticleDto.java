package fr.m2i.blog.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "article")
@Table(name = "article")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ArticleDto extends BlogObject {

	@Column
	private String title;

	@Column
	private String content;

	@ManyToOne
	private AdminDto admin;

	@Column
	private LocalDateTime created_at;

	@Column
	private LocalDateTime updated_at;

	@OneToMany(fetch = FetchType.EAGER)
	private List<CommentDto> listComments = new ArrayList<CommentDto>();

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<LikedDto> listLikeds = new ArrayList<LikedDto>();

	@Column
	private Long nbLiked;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public AdminDto getAdmin() {
		return admin;
	}

	public void setAdmin(AdminDto admin) {
		this.admin = admin;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public List<CommentDto> getListComments() {
		return listComments;
	}

	public void setListComments(List<CommentDto> listComments) {
		this.listComments = listComments;
	}

	public List<LikedDto> getListLikeds() {
		return listLikeds;
	}

	public void setListLikeds(List<LikedDto> listLikeds) {
		this.listLikeds = listLikeds;
	}

	public Long getNbLiked() {
		return nbLiked;
	}

	public void setNbLiked(Long nbLiked) {
		this.nbLiked = nbLiked;
	}

	@Override
	public String toString() {
		return "ArticleDto [id=" + this.getId() + ", title=" + title + ", content=" + content + ", admin=" + admin
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", listComments=" + listComments
				+ ", listLikeds=" + listLikeds + ", nbLiked=" + nbLiked + "]";
	}

	@Override
	public String getInformation() {
		return "Je suis un article";
	}

}
