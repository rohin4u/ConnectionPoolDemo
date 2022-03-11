package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.pool.OracleConnectionPoolDataSource;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		OracleConnectionPoolDataSource ds = new OracleConnectionPoolDataSource();
		
		ds.setURL("jdbc:oracle:thin:@localhost:1521:XE");
		
		ds.setUser("system");
		ds.setPassword("password");
		
		Connection con=ds.getConnection();
		
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
