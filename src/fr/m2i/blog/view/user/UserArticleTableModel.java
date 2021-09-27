package fr.m2i.blog.view.user;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.BlogObject;

public class UserArticleTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7716157448045176990L;

	private List<BlogObject> listArticles = new ArrayList<BlogObject>();

	private String[] colonnes = { "title", "content", "created_at", "updated_at", "nbLiked" };

	public List<BlogObject> getListArticles() {
		return listArticles;
	}

	public void setListArticles(List<BlogObject> listArticles) {
		this.listArticles = listArticles;
	}

	public String[] getColonnes() {
		return colonnes;
	}

	public void setColonnes(String[] colonnes) {
		this.colonnes = colonnes;
	}

	public String getColumnName(int column) {
		return this.colonnes[column];
	}

	@Override
	public int getRowCount() {
		return this.listArticles.size();
	}

	@Override
	public int getColumnCount() {
		return this.colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ArticleDto article = (ArticleDto) this.listArticles.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return article.getTitle();
		case 1:
			return article.getContent();
		case 2:
			return article.getCreated_at();
		case 3:
			return article.getUpdated_at();
		case 4:
			return article.getListLikeds().size();
		}
		throw new NullPointerException("Impossible de déterminer la colonne à afficher pour " + columnIndex);
	}
}
