package com.jdbc.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo3 {

	public static void main(String[] args, Connection stm) {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/student", "postgres","Sandhy@123");
			System.out.println("connection established");
			
			String sqlquery="insert into employee_details values(?,?,?)";
			pstmt=con.prepareStatement(sqlquery);
			pstmt.setString(1,"Electron");
			pstmt.setInt(2,1);
			pstmt.setInt(3,60000);
			pstmt.execute();
			pstmt.setString(1,"Snacks");
			pstmt.setInt(2,2);
			pstmt.setInt(3,60);
			pstmt.execute();
			
			System.out.println("Record Saved");
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		finally {
//			try {
//				if(stm!=null) {
//					stm.close();
//				}
//				if(con!=null) {
//					con.close();
//				}
//			}
//			catch(SQLException e) {
//				e.printStackTrace();
//			}
		finally {
			try {
				if(pstmt!=null) {
						pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		}

	}
// }
}

