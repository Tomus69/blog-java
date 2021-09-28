package fr.m2i.blog.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.service.ArticleService;

public class BlogList extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogList() {

		List<ArticleDto> listArticles = ArticleService.findAll();
		System.out.println(listArticles.size());

		JPanel content = new JPanel(new GridLayout(0, 1));
		this.setPreferredSize(new Dimension(800, 800));
		this.add(content);

		for (ArticleDto article : listArticles) {
			System.out.println("article " + article.getId());
			content.add(createRow(article));
		}
	}

	public JPanel createRow(ArticleDto article) {

		JPanel panel = new JPanel(new FlowLayout());
		panel.setPreferredSize(new Dimension(400, 100));

		JLabel title = new JLabel(article.getTitle());
		title.setFont(new Font("Lucida Grande", Font.BOLD, 24));

		JLabel content = new JLabel(article.getContent());

		JLabel author = new JLabel(article.getAdmin().getName());
		author.setFont(new Font("Lucida Grande", Font.ITALIC, 12));

		int l = article.getListLikeds().size();
		String likes = "*";

		System.out.println("l" + l);

		for (int i = 0; i < l; i++) {
			likes += "*";
		}

		JLabel liked = new JLabel(likes);

		panel.add(title);
		panel.add(content);
		panel.add(author);
		panel.add(liked);

		return panel;
	}

}
