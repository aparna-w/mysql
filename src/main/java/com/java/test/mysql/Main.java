package com.java.test.mysql;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		UserDAO userDAO = new UserDAO();
		
		ArrayList<UserDTO> users;
		
		try {
			users = userDAO.fetchAll();
		} catch (SQLException e) {
			users = null;
			e.printStackTrace();
		}
		
		for (UserDTO user: users) {
			System.out.println(user.toString());
		}
		
		UserDTO user = new UserDTO();
		user.setFirstName("Gaurav");
		user.setLastName("Gurdasani");
		user.setEmail("gaurav@gmail.com");
		user.setPhone(9876543210L);
		
//		try {
//			userDAO.save(user);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
