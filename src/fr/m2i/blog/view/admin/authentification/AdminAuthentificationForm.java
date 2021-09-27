package fr.m2i.blog.view.admin.authentification;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import fr.m2i.blog.jdbc.BlogConnection;
import fr.m2i.blog.view.admin.ArticleView;

public class AdminAuthentificationForm extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AdminAuthentificationView view;

	private JLabel labelName = new JLabel("Name :", 10);
	private JTextField name = new JTextField("", 40);

	private JLabel labelPassword = new JLabel("Password :", 10);
	private JPasswordField password = new JPasswordField("", 40);

	public AdminAuthentificationForm(AdminAuthentificationView view) {
		this.view = view;

		JPanel content = new JPanel(new GridLayout(0, 2));
		this.add(content);

		JButton validateBtn = new JButton("Valider");
		validateBtn.addActionListener(e -> {
			try {
				authentification();
			} catch (ClassNotFoundException | SQLException e1) {
				e1.printStackTrace();
			}
		});

		JButton closeBtn = new JButton("Annuler");
		closeBtn.addActionListener(e -> close());

		content.add(labelName);
		content.add(name);

		content.add(labelPassword);
		content.add(password);

		content.add(closeBtn);
		content.add(validateBtn);

		this.setVisible(true);

	}

	private void authentification() throws ClassNotFoundException, SQLException {

		String nom = this.name.getText();
		String mdp = this.password.getText();

		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT PASSWORD FROM ADMIN WHERE NAME ='" + nom + "'");

		if (rs.next()) {
			String motDePasse = rs.getString(1);
			if (motDePasse.equals(mdp)) {
				JOptionPane.showMessageDialog(this, "Authentification réussie", "Success", JOptionPane.PLAIN_MESSAGE);
				try {
					new ArticleView();
					close();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Password Incorect", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "Name et/ou Password Incorect", "Error", JOptionPane.ERROR_MESSAGE);
		}

		rs.close();
		stmt.close();
		BlogConnection.closeConnection(c);
	}

	private void close() {
		this.view.setVisible(false);
		this.name.setText(null);
		this.password.setText(null);
	}

}
