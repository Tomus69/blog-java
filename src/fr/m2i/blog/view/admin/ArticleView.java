package fr.m2i.blog.view.admin;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.service.ArticleService;

public class ArticleView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleDto articleCourant;

	private ArticleTableModel tableModel = new ArticleTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private ArticleForm form = new ArticleForm(this);

	public ArticleView() throws ClassNotFoundException, SQLException {

		this.tableModel.getListArticles().addAll(ArticleService.findAll());

		this.table.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				int row = table.getSelectedRow();
				ArticleDto article = (ArticleDto) tableModel.getListArticles().get(row);
				System.out.println("Ligne sélectionnée " + article);
				form.setArticleCourant(article);
			}

		});
		
		JPanel content = new JPanel();
		this.add(content);
		
		JButton addArticle = new JButton("Ajouter Article");
		addArticle.addActionListener(e -> {
			ArticleDto article = ArticleService.getInstance();
			this.setArticleCourant(article);
		});

		content.add(this.form);
		content.add(this.scroll);
		content.add(addArticle);

		this.setTitle("Création d'Article");
		this.setSize(1400, 800);
		this.setVisible(true);
	}

	public ArticleDto getArticleCourant() {
		return articleCourant;
	}

	public void setArticleCourant(ArticleDto article) {
		this.articleCourant = article;
		if (this.articleCourant != null) {
			this.form.setArticleCourant(article);
			this.setVisible(true);
		} else {
			this.form.setArticleCourant(null);
			this.setVisible(false);
		}
	}

	public ArticleTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(ArticleTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public void updateTable(ArticleDto article) {
		if (!this.getTableModel().getListArticles().contains(article)) {
			this.getTableModel().getListArticles().add(article);
		}
		this.getTableModel().fireTableDataChanged();
	}
	
	public void removeArticle(ArticleDto article) {
		if (this.getTableModel().getListArticles().contains(article)) {
			this.getTableModel().getListArticles().remove(article);
		}
		this.getTableModel().fireTableDataChanged();
	}

}
