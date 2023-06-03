package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AddressBook {
	public static void main(String[] args) {

	//conncetions
	String url = "jdbc:mysql://localhost:3306/addressbook";
	String username = "root";
	String password = "Deepak@123";

	try(Connection connection = DriverManager.getConnection(url,username,password)){
	// create a table
		try(Statement statement = connection.createStatement()){
			String createTableQuery = "create table addressbook (first_name varchar(20),last_name varchar(20),city varchar(20),state varchar(20),zip int,phone int,email varchar(20))";
			statement.executeUpdate(createTableQuery);
			System.out.println("Table is created successfully");
			}
		//insert
		try(Statement statement = connection.createStatement()){
			String insertQuery = "insert into addressbook (first_name,last_name,city,state,zip,phone,email) values ('Deepak','Rana','Hzb','jharkhand',825301,95916733,'deepak@gmail.com'),('Ravi','Prasad','Blore','Karnataka',63738,893883902,'ravi@gmail.com'),('Rohit','Raj','Kota','Rajasthan',28728,9837928,'rohit@gmail.com')";
			statement.executeUpdate(insertQuery);
			System.out.println("values inserted successfully");
			}
		//select
		try(Statement statement = connection.createStatement()){
			String selectQuery = "select * from addressbook";
			ResultSet resultSet = statement.executeQuery(selectQuery);

			while (resultSet.next()){
			int id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");

			System.out.println("ID :"+ id +",Name : " + name + ", Age: "+ age);
			}
			resultSet.close();
			System.out.println("Successful");
			}
		//update
		try(Statement statement = connection.createStatement()){
			String updateQuery = "update addressbook set city='Banglore' WHERE last_name ='Prasad'";
			statement.executeUpdate(updateQuery);
			System.out.println("values updated successfully");
			}
		//delete
		try(Statement statement = connection.createStatement()){
			String deleteQuery = "delete from addressbook WHERE first_name='Deepak'";
			statement.executeUpdate(deleteQuery);
			System.out.println("values deleted successfully");
			}
	}catch (SQLException e){
	e.printStackTrace();
	}
	}
}
