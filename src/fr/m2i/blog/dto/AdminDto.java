package fr.m2i.blog.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "admin")
@Table(name = "admin")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class AdminDto extends BlogObject {

	@Column
	private String name;

	@Column
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	private List<ArticleDto> listArticles = new ArrayList<ArticleDto>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<ArticleDto> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<ArticleDto> listArticles) {
		this.listArticles = listArticles;
	}

	@Override
	public String toString() {
		return "AdminDto [id=" + this.getId() + ", name=" + name + ", password=" + password + ", listArticles="
				+ listArticles + "]";
	}

	@Override
	public String getInformation() {
		return "Je suis un administrateur";
	}

}
