package fr.m2i.blog.view.comment;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.m2i.blog.dto.CommentDto;
import fr.m2i.blog.dto.BlogObject;

public class CommentTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7716157448045176990L;

	private List<BlogObject> listComments = new ArrayList<BlogObject>();

	private String[] colonnes = { "content", "created_at" };

	public List<BlogObject> getListComments() {
		return listComments;
	}

	public void setListComments(List<BlogObject> listComments) {
		this.listComments = listComments;
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
		return this.listComments.size();
	}

	@Override
	public int getColumnCount() {
		return this.colonnes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CommentDto comment = (CommentDto) this.listComments.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return comment.getContent();
		case 1:
			return comment.getCreated_at();
		}
		throw new NullPointerException("Impossible de déterminer la colonne à afficher pour " + columnIndex);
	}
}
