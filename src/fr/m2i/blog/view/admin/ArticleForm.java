package fr.m2i.blog.view.admin;

import java.awt.GridLayout;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.m2i.blog.combobox.admin.AdminComboBox;
import fr.m2i.blog.dto.ArticleDto;
import fr.m2i.blog.exception.AdminAbsentException;
import fr.m2i.blog.service.ArticleService;

public class ArticleForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArticleView view;

	private ArticleDto articleCourant;

	private JLabel labelAdmin = new JLabel("Admin :", 10);
	private AdminComboBox admin = new AdminComboBox();

	private JLabel labelTitle = new JLabel("Title :", 10);
	private JTextField title = new JTextField("title", 50);

	private JLabel labelContent = new JLabel("Content :", 10);
	private JTextField content = new JTextField("content", 50);

	public ArticleForm(ArticleView view) {
		this.view = view;

		JPanel panel = new JPanel(new GridLayout(0, 2));
		this.add(panel);

		JButton closeBtn = new JButton("Annuler");
		closeBtn.addActionListener(e -> close());
		JButton saveBtn = new JButton("Enregistrer");
		saveBtn.addActionListener(e -> save());
		JButton deleteBtn = new JButton("Supprimer");
		deleteBtn.addActionListener(e -> delete());

		panel.add(labelAdmin);
		panel.add(admin);
		panel.add(labelTitle);
		panel.add(title);
		panel.add(labelContent);
		panel.add(content);
		panel.add(closeBtn);
		panel.add(saveBtn);
		panel.add(deleteBtn);

		this.setVisible(false);
	}

	private void save() {
		writeBean();
		try {
			ArticleService.save(this.articleCourant);
			this.view.updateTable(this.articleCourant);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (AdminAbsentException e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, e.getMessage() + ". Pensez à sélectionner un admin dans le sélecteur",
					"Enregistrement impossible", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Enregistrement impossible", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void delete() {
		int result = JOptionPane.showConfirmDialog(this,
				"Veuillez confirmer la suppression de l'article " + this.articleCourant.getTitle() + " ?",
				"Confirmation de suppression", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
			ArticleService.delete(this.articleCourant);
			this.view.removeArticle(this.articleCourant);
			close();
		}
	}

	private void close() {
		this.setArticleCourant(null);
	}

	public ArticleDto getArticleCourant() {
		return articleCourant;
	}

	public void setArticleCourant(ArticleDto articleCourant) {
		this.articleCourant = articleCourant;
		if (this.articleCourant != null) {
			readBean();
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}
	}

	public void readBean() {
		this.admin.updateComboBox();
		this.admin.setSelectedItem(this.articleCourant.getAdmin());
		this.title.setText(this.articleCourant.getTitle());
		this.content.setText(this.articleCourant.getContent());
	}

	public void writeBean() {
		this.articleCourant.setAdmin(admin.getSelectedItem());
		this.articleCourant.setTitle(this.title.getText());
		this.articleCourant.setContent(this.content.getText());
	}

}
