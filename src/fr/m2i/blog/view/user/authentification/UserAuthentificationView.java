package fr.m2i.blog.view.user.authentification;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class UserAuthentificationView  extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UserAuthentificationForm form = new UserAuthentificationForm(this);
	
	public UserAuthentificationView() {
		
		JPanel content = new JPanel();		
		this.add(content);
		
		content.add(form);
		
		this.setTitle("User Authentification");
		this.setSize(900, 400);
		this.setVisible(false);
	}

}
