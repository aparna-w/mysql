package com.java.test.mysql.access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.java.test.mysql.MySqlClient;
import com.java.test.mysql.transfer.UserDTO;

public class UserDAO {
	
	private Connection connection;
	
	private static final String DB_NAME = "shopping";
	private static final String DB_TABLE_NAME = DB_NAME + ".user";
	private static final String DB_COLUMN_ID = "id";
	private static final String DB_COLUMN_FIRST_NAME = "first_name";
	private static final String DB_COLUMN_LAST_NAME = "last_name";
	private static final String DB_COLUMN_PHONE = "phone";
	private static final String DB_COLUMN_EMAIL = "email";
	
	
	private static final String QUERY_GET_USER = "select " + DB_COLUMN_ID + ", " + DB_COLUMN_FIRST_NAME + ", " + DB_COLUMN_LAST_NAME + ", " + DB_COLUMN_PHONE + ", " + DB_COLUMN_EMAIL + " from " + DB_TABLE_NAME;
	private static final String QUERY_GET_USER_ID = QUERY_GET_USER + " where " + DB_COLUMN_ID + " = ?";
	private static final String QUERY_GET_USER_NAME = QUERY_GET_USER + " where " + DB_COLUMN_FIRST_NAME + " like ? or " + DB_COLUMN_LAST_NAME + " like ?";
	private static final String QUERY_GET_USER_EMAIL = QUERY_GET_USER + " where " + DB_COLUMN_EMAIL + " = ?";
	private static final String QUERY_ADD_USER = "insert into " + DB_TABLE_NAME + " (" + DB_COLUMN_FIRST_NAME + ", " + DB_COLUMN_LAST_NAME + ", " + DB_COLUMN_EMAIL + ", " + DB_COLUMN_PHONE + ") values (?, ?, ?, ?)";
	private static final String QUERY_UPDATE_USER = "update " + DB_TABLE_NAME + " set " + DB_COLUMN_FIRST_NAME + " = ?, " + DB_COLUMN_LAST_NAME + " = ?, " + DB_COLUMN_EMAIL + " = ?, " + DB_COLUMN_PHONE + " = ? where " + DB_COLUMN_ID + " = ?";
	
	public UserDAO () {
		connection = MySqlClient.getInstance();
	}
	
	public void save(UserDTO user) throws SQLException {
		
			PreparedStatement query = connection.prepareStatement(QUERY_ADD_USER);
			query.setString(1, user.getFirstName());
			query.setString(2, user.getLastName());
			query.setString(3, user.getEmail());
			query.setLong(4, user.getPhone());
			
			query.executeUpdate();
	}
	
	public void update(UserDTO user) throws SQLException {
		
		PreparedStatement query = connection.prepareStatement(QUERY_UPDATE_USER);
		query.setString(1, user.getFirstName());
		query.setString(2, user.getLastName());
		query.setString(3, user.getEmail());
		query.setLong(4, user.getPhone());
		query.setInt(5, user.getId());
		
		query.executeUpdate();
}
	
	public UserDTO fetch(int id) throws SQLException {
		
		PreparedStatement query = connection.prepareStatement(QUERY_GET_USER_ID);
		
		query.setInt(1, id);
		
		ResultSet resultSet = query.executeQuery();
		
		if (resultSet.next()) {
			UserDTO user = new UserDTO();
			
			user.setId(resultSet.getInt(DB_COLUMN_ID));
			user.setFirstName(resultSet.getString(DB_COLUMN_FIRST_NAME));
			user.setLastName(resultSet.getString(DB_COLUMN_LAST_NAME));
			user.setEmail(resultSet.getString(DB_COLUMN_EMAIL));
			user.setPhone(resultSet.getLong(DB_COLUMN_PHONE));
			
			return user;
		} else {
			return null;
		}
	}
	
public UserDTO fetchByEmail(String email) throws SQLException {
		
		PreparedStatement query = connection.prepareStatement(QUERY_GET_USER_EMAIL);
		
		query.setString(1, email);
		
		ResultSet resultSet = query.executeQuery();
		
		if (resultSet.next()) {
			UserDTO user = new UserDTO();
			
			user.setId(resultSet.getInt(DB_COLUMN_ID));
			user.setFirstName(resultSet.getString(DB_COLUMN_FIRST_NAME));
			user.setLastName(resultSet.getString(DB_COLUMN_LAST_NAME));
			user.setEmail(resultSet.getString(DB_COLUMN_EMAIL));
			user.setPhone(resultSet.getLong(DB_COLUMN_PHONE));
			
			return user;
		} else {
			return null;
		}
	}
	
	public ArrayList<UserDTO> fetchAll() throws SQLException {
	
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		
		PreparedStatement query = connection.prepareStatement(QUERY_GET_USER);
		
		ResultSet resultSet = query.executeQuery();
		
		while(resultSet.next()) {
			
			UserDTO user = new UserDTO();
			
			user.setId(resultSet.getInt(DB_COLUMN_ID));
			user.setFirstName(resultSet.getString(DB_COLUMN_FIRST_NAME));
			user.setLastName(resultSet.getString(DB_COLUMN_LAST_NAME));
			user.setEmail(resultSet.getString(DB_COLUMN_EMAIL));
			user.setPhone(resultSet.getLong(DB_COLUMN_PHONE));
			
			users.add(user);
		}
		
		return users;
	}
	
	public ArrayList<UserDTO> fetchByName(String name) throws SQLException {
		
		ArrayList<UserDTO> users = new ArrayList<UserDTO>();
		
		PreparedStatement query = connection.prepareStatement(QUERY_GET_USER_NAME);
		
		query.setString(1, "%" + name + "%");
		query.setString(2, "%" + name + "%");
		
		ResultSet resultSet = query.executeQuery();
		
		while(resultSet.next()) {
			
			UserDTO user = new UserDTO();
			
			user.setId(resultSet.getInt(DB_COLUMN_ID));
			user.setFirstName(resultSet.getString(DB_COLUMN_FIRST_NAME));
			user.setLastName(resultSet.getString(DB_COLUMN_LAST_NAME));
			user.setEmail(resultSet.getString(DB_COLUMN_EMAIL));
			user.setPhone(resultSet.getLong(DB_COLUMN_PHONE));
			
			users.add(user);
		}
		
		return users;
	}

}
