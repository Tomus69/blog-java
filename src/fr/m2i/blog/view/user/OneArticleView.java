package fr.m2i.blog.view.user;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.dto.LikedDto;
import fr.m2i.blog.dto.UserDto;
import fr.m2i.blog.service.ArticleService;
import fr.m2i.blog.service.LikedService;
import fr.m2i.blog.view.comment.CommentTableModel;

public class OneArticleView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CommentTableModel tableModel = new CommentTableModel();

	private JTable table = new JTable(this.tableModel);

	private JScrollPane scroll = new JScrollPane(this.table);

	private UserArticleView view;
	private ArticleDto articleCourant;
	private UserDto userCourant;

	private JLabel labelTitle;
	private JLabel labelContent;
	private JLabel labelCreatedAt;
	private JLabel labelNbLiked;

	public OneArticleView(Long id, UserDto userCourant) {

		articleCourant = ArticleService.findById(id);

		labelTitle = new JLabel("Title : " + articleCourant.getTitle());
		labelContent = new JLabel("Content : " + articleCourant.getContent());
		labelCreatedAt = new JLabel("Date : " + articleCourant.getCreated_at());
		labelNbLiked = new JLabel(articleCourant.getListLikeds().size() + " like");

		JPanel content = new JPanel(new GridLayout(0, 2));
		this.add(content);

		JButton likedBtn = new JButton("<3");
		likedBtn.addActionListener(e -> {
			try {
				liked(userCourant);
				likedBtn.setVisible(false);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JButton commentBtn = new JButton("Comment");
		commentBtn.addActionListener(e -> {
			this.getTableModel().fireTableDataChanged();
			this.tableModel.getListComments().addAll(articleCourant.getListComments());
			System.out.println(articleCourant.getListComments());
			this.scroll.setVisible(true);
		});

		content.add(labelTitle);
		content.add(labelContent);
		content.add(labelCreatedAt);
		content.add(labelNbLiked);
		content.add(likedBtn);
		content.add(commentBtn);
		this.scroll.setVisible(false);
		content.add(this.scroll);

		this.setTitle("Article n°" + articleCourant.getId() + " : " + articleCourant.getTitle());
		this.setSize(1000, 1000);
		this.setVisible(true);
	}

	public CommentTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(CommentTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public ArticleDto getArticleCourant() {
		return articleCourant;
	}

	public void setArticleCourant(ArticleDto articleCourant) {
		this.articleCourant = articleCourant;
	}

	private void liked(UserDto userCourant) throws Exception {
		LikedDto liked = LikedService.getInstance();
		articleCourant.getListLikeds().add(liked);
		liked.setArticle(articleCourant);
		liked.setUser(userCourant);
		LikedService.save(liked);
		ArticleService.save(articleCourant);
		articleCourant = ArticleService.findById(articleCourant.getId());
		System.out.println(articleCourant.getListLikeds().size());
		labelNbLiked.setText(articleCourant.getListLikeds().size() + " like");
//		this.view.updateTable();
	}

	private void comment() {

	}

}
