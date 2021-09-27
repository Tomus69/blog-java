package fr.m2i.blog.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.m2i.blog.view.admin.authentification.AdminAuthentificationView;
import fr.m2i.blog.view.user.authentification.UserAuthentificationView;

public class MainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AdminAuthentificationView adminAuthentificationView;
	
	private UserAuthentificationView userAuthentificationView;

	public MainView() throws Exception {

		JPanel content = new JPanel();
		this.add(content);

		adminAuthentificationView = new AdminAuthentificationView();
		userAuthentificationView = new UserAuthentificationView();

		content.add(createPanelAdminAuthentification());
		content.add(createPanelUserAuthentification());

		this.setTitle("Blog");
		this.setSize(800, 500);
		this.setVisible(true);
	}

	public JPanel createPanelAdminAuthentification() {
		JPanel panel = new JPanel();

		JButton adminForm = new JButton("ADMIN");
		panel.add(adminForm);
		adminForm.addActionListener(e -> {
			this.adminAuthentificationView.setVisible(true);
		});

		return panel;
	}
	
	public JPanel createPanelUserAuthentification() {
		JPanel panel = new JPanel();

		JButton userForm = new JButton("USER");
		panel.add(userForm);
		userForm.addActionListener(e -> {
			this.userAuthentificationView.setVisible(true);
		});

		return panel;
	}
}
