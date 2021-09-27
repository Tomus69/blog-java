package fr.m2i.blog.view.user;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.UserDto;
import fr.m2i.blog.service.ArticleService;

public class UserArticleView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UserArticleTableModel tableModel = new UserArticleTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	public UserArticleView(UserDto userCourant) {

		this.tableModel.getListArticles().addAll(ArticleService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				ArticleDto article = (ArticleDto) tableModel.getListArticles().get(row);
				System.out.println("Ligne sélectionnée " + article);
				new OneArticleView(article.getId(), userCourant);
			}

		});

		JPanel content = new JPanel();
		this.add(content);

		content.add(this.scroll);

		this.setTitle("Les Articles");
		this.setSize(1400, 800);
		this.setVisible(true);
	}

	public UserArticleTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(UserArticleTableModel tableModel) {
		this.tableModel = tableModel;
	}

//	public void updateTable() {
//		this.getTableModel().fireTableDataChanged();
//	}

}
