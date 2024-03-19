package com.jdbc.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=null;
		Statement stm=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student", "postgres","Sandhy@123");
			System.out.println("connection established");
			stm=con.createStatement();
			stm.execute("insert into employee_details values('san',101,'100000')");
			System.out.println("Student Inserted");
			//stm.execute("insert into employee_details values(102,'sandy','500000')");
			stm.execute("update employee_details set name='JHope' where id=102");
			System.out.println("Student Updated");
			stm.execute("delete from employee_details where id=101");
			System.out.println("Student Deleted");
			System.out.println("Record saved");
			ResultSet rs=stm.executeQuery("select * from employee_details");
			while(rs.next()) {
				System.out.println(rs.getString("name")+" "+rs.getInt("id")+" "+rs.getInt("salary"));
			System.out.println("Record saved");
		}
		String sqlquery="insert into employee_details values(?,?,?)";
		pstmt=con.prepareStatement(sqlquery);
		pstmt.setString(1,"jk");
		pstmt.setInt(2,1);
		pstmt.setInt(3,60000);
		pstmt.execute();
		pstmt.setString(2,"rm");
		pstmt.setInt(2,2);
		pstmt.setInt(3,24797);
		pstmt.execute();
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


