package com.jdbc.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Connection con=null;
       Statement stm=null;
       try {
    	   Class.forName("org.postgresql.Driver");
		   con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student", "postgres","Sandhy@123");
		   System.out.println("connection established");
		   stm = con.createStatement();
		   ResultSet rs=stm.executeQuery("select * from employee_details");
		   while (rs.next()) {
			  System.out.println(rs.getString("name")+" "+ rs.getInt("id")+" "+ rs.getInt("salary")); 
		   }
		   System.out.println("Record saved");
       }
       catch(ClassNotFoundException e){
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(stm!=null) {
					stm.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
