package com;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropDemo {

	public static void main(String[] args) throws IOException, SQLException {
		
		
		Properties p = new Properties();
		
		FileInputStream fis = new FileInputStream("db.properties");
		
		p.load(fis);// to load all properties from properties file into java Properties object
		String url=p.getProperty("url");
		String user=p.getProperty("username");
		 String pwd=p.getProperty("password");
		 
		 Connection con=DriverManager.getConnection(url,user,pwd);
		 
		 Statement st =con.createStatement();
		 
		 ResultSet rs=st.executeQuery("select * from employees");
		 
		 System.out.println("ENO\tENAME\tESAL\tEADDR");
		 System.out.println("---------------------------");
		 
		while(rs.next())
			{
			 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
			 }
			 con.close();

	}

}
