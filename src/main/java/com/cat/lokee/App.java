package com.cat.lokee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App{
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Class found");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/test";
		String name="root";
		String password="password";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(url,name,password);
			System.out.println("Connection successful");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql= "insert into person (name,age) values(?,?)";
		try {
			PreparedStatement prepStmt= con.prepareStatement(sql);
			prepStmt.setString(1, "Okka");
			prepStmt.setInt(2, 33);
			
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}