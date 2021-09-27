package fr.m2i.blog;

import fr.m2i.blog.data.GenerateData;
import fr.m2i.blog.hibernate.HibernateInit;
import fr.m2i.blog.jdbc.DatabaseStructure;
import fr.m2i.blog.view.MainView;

public class ApplicationLauncher {

	public static void main(String[] args) throws Exception {

		System.out.println("Hello Blog");
		
		DatabaseStructure.createAllTable();
		
		HibernateInit.init();		
		
		GenerateData.generate();

		new MainView();
	}

}
