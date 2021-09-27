package fr.m2i.blog.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseStructure {
	
	public static void createAllTable() throws ClassNotFoundException, SQLException {
		createTableAdmin();
		createTableUser();
		createTableArticle();
		createTableComment();
		createTableLiked();
		createTableRelationAdminArticle();
		createTableRelationArticleComment();
		createTableRelationArticleLiked();
		createTableRelationUserComment();
		createTableRelationUserLiked();
	}

	private static void createTableAdmin() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ADMIN(ID BIGINT,NAME VARCHAR(100),PASSWORD VARCHAR(100))";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableUser() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE USER(ID BIGINT,NAME VARCHAR(100),PASSWORD VARCHAR(100))";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableArticle() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLE(ID BIGINT,TITLE VARCHAR(100),CONTENT VARCHAR(1000),ADMIN_ID BIGINT,CREATED_AT TIMESTAMP,UPDATED_AT TIMESTAMP,NBLIKED BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableComment() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE COMMENT(ID BIGINT,CONTENT VARCHAR(200),USER_ID BIGINT,ARTICLE_ID BIGINT,CREATED_AT TIMESTAMP)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableLiked() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE LIKED(ID BIGINT,USER_ID BIGINT,ARTICLE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableRelationAdminArticle() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ADMIN_ARTICLE(LISTARTICLES_ID BIGINT,ADMIN_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableRelationArticleComment() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLE_COMMENT(LISTCOMMENTS_ID BIGINT,ARTICLE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableRelationArticleLiked() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE ARTICLE_LIKED(LISTLIKEDS_ID BIGINT,ARTICLE_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableRelationUserComment() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE USER_COMMENT(LISTCOMMENTS_ID BIGINT,USER_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
	
	private static void createTableRelationUserLiked() throws ClassNotFoundException, SQLException {
		Connection c = BlogConnection.getConnection();
		Statement stmt = c.createStatement();
		String requeteCreationTable = "CREATE TABLE USER_LIKED(LISTLIKEDS_ID BIGINT,USER_ID BIGINT)";
		stmt.executeUpdate(requeteCreationTable);
		stmt.close();
		BlogConnection.closeConnection(c);
	}
}
