package com.java.test.mysql;

import java.sql.SQLException;
import java.util.ArrayList;

import com.java.test.mysql.access.UserDAO;
import com.java.test.mysql.transfer.ProductDTO;
import com.java.test.mysql.transfer.UserDTO;

public class Main {

	public static void main(String[] args) {
		
/*		UserDAO userDAO = new UserDAO();
		
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
		
		try {
			userDAO.save(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UserDTO aparna;
		
		try {
			aparna = userDAO.fetchByEmail("aparna@email.com");
		} catch (SQLException e) {
			aparna = null;
			e.printStackTrace();
		}
		
		System.out.println(aparna.toString());
		
		aparna.setEmail("aparna@gmail.com");
		
		try {
			userDAO.update(aparna);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			aparna = userDAO.fetchByEmail("aparna@gmail.com");
		} catch (SQLException e) {
			aparna = null;
			e.printStackTrace();
		}
		
		System.out.println(aparna.toString());
		
		
		ArrayList<UserDTO> usersByName;
		
		try {
			usersByName = userDAO.fetchByName("gurdasani");
		} catch (SQLException e) {
			usersByName = null;
			e.printStackTrace();
		}
		
		for (UserDTO userByName : usersByName) {
			System.out.println(userByName.toString());
		}*/
		
		
	}

}
