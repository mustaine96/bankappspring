package com.capgemini.bankapp.dbutil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:database.properties")
public class DbUtil {
	
	@Autowired
	private Environment env;
	
	
	
	
	public Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(env.getProperty("database.url"), env.getProperty("database.uname"), env.getProperty("database.password"));
			if(connection != null)
				System.out.println("--connected -- ");
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("-- failed to connect --");
		}
		return connection;
	}
	
	public DbUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void read()
	{
		System.out.println(env.getProperty("database.url"));
	}
}