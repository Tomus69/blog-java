package fr.m2i.blog.view.admin.authentification;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AdminAuthentificationView  extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private AdminAuthentificationForm form = new AdminAuthentificationForm(this);
	
	public AdminAuthentificationView() {
		
		JPanel content = new JPanel();		
		this.add(content);
		
		content.add(form);
		
		this.setTitle("Admin Authentification");
		this.setSize(900, 400);
		this.setVisible(false);
	}

}
