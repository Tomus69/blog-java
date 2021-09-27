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

@Entity(name = "user")
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserDto extends BlogObject {

	@Column
	private String name;

	@Column
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	private List<CommentDto> listComments = new ArrayList<CommentDto>();

	@OneToMany(fetch = FetchType.EAGER)
	private List<LikedDto> listLikeds = new ArrayList<LikedDto>();

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

	@Override
	public String toString() {
		return "UserDto [id=" + this.getId() + ", name=" + name + ", password=" + password + ", listComments="
				+ listComments + ", listLikeds=" + listLikeds + "]";
	}

	@Override
	public String getInformation() {
		return "Je suis un user";
	}

}
