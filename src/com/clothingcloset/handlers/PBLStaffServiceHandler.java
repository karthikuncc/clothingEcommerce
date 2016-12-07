/**
 * 
 */
package com.clothingcloset.handlers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clothingcloset.databaseconnections.ConnectionUtil;
import com.clothingcloset.models.PBLStaff;
import com.mysql.jdbc.PreparedStatement;

/**
 * This class is responsible for all the login operations of the PBL Staff
 * members.
 * 
 * .
 *
 */
public class PBLStaffServiceHandler {

	private ConnectionUtil connectionUtil = new ConnectionUtil();
	private Statement stmt = null;
	private Connection conn = null;

	public void insertPBLStaffLoginDetails(PBLStaff pblStaff) throws ClassNotFoundException, SQLException {

		try {
			 int id;
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sqlperson = "INSERT INTO PERSON_TABLE (FIRST_NAME,LAST_NAME,GENDER,MOBILE_NUMBER,STREET,CITY,STATE,PINCODE) VALUES ( '"
					+ pblStaff.getFirstName() + "','" + pblStaff.getLastName() + "','" + pblStaff.getGender() + "',"
					+ pblStaff.getMobileNumber() + ",'" + pblStaff.getStreet() + "','" + pblStaff.getCity() + "','"
					+ pblStaff.getState() + "'," + pblStaff.getPincode() + ");";
			
			
			
			 PreparedStatement statement = (PreparedStatement) conn.prepareStatement(sqlperson,Statement.RETURN_GENERATED_KEYS);
			 int affectedRows = statement.executeUpdate();

		        if (affectedRows == 0) {
		            throw new SQLException("Creating user failed, no rows affected.");
		        }

		        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
		            if (generatedKeys.next()) {
		              id = (generatedKeys.getInt(1));
		            }
		            else {
		                throw new SQLException("Creating user failed, no ID obtained.");
		            }
		        }
		        String sql = "INSERT INTO PBLSTAFF_TABLE (EMAIL,PBLPOSITION,PASSWORD,ID) VALUES ( '" + pblStaff.getEmail()
						+ "','" + "staff" + "','" + pblStaff.getPassword() + "'," + id
						+ ");";
			System.out.println("SQL Query is : " + sql);
			stmt.executeUpdate(sql);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	public String validateStaffLogin(PBLStaff pblStaff) {

		String pblPosition = "";

		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM PBLSTAFF_TABLE WHERE EMAIL ='" + pblStaff.getEmail() + "'AND PASSWORD='"
					+ pblStaff.getPassword() + "';";

			System.out.println("SQL Query is : " + sql);
			ResultSet resultSet = stmt.executeQuery(sql);

			if (resultSet.next()) {
				pblPosition = (String) resultSet.getString("PBLPOSITION");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return pblPosition;
	}

	public List<PBLStaff> retrieveAllStaffMembers() {

		List<PBLStaff> staffMembers = new ArrayList<PBLStaff>();
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM PBLSTAFF_TABLE";

			System.out.println("SQL Query is : " + sql);
			ResultSet resultSet = stmt.executeQuery(sql);
			while (resultSet.next()) {
				String pblPosition = resultSet.getString("PBLPOSITION");
				if (!pblPosition.equalsIgnoreCase("ADMIN")) {
					PBLStaff pblStaff = new PBLStaff();
					pblStaff.setId(resultSet.getInt("ID"));
					pblStaff.setEmail(resultSet.getString("EMAIL"));
					pblStaff.setPblPosition(pblPosition);
					pblStaff.setPassword(resultSet.getString("PASSWORD"));
					staffMembers.add(pblStaff);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return staffMembers;

	}

	public Boolean removePBLStaffMembers(PBLStaff pblStaff) {
	 
		//int id;
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT ID FROM PBLSTAFF_TABLE WHERE EMAIL ='" + pblStaff.getEmail() + "';";

			System.out.println("SQL Query is : " + sql);
			ResultSet resultSet = stmt.executeQuery(sql);

			resultSet.next();
			int	id = resultSet.getInt("ID");
			

			String sql1 = "delete FROM PBLSTAFF_TABLE WHERE EMAIL ='" + pblStaff.getEmail() + "';";
			String sql2 = "delete FROM PERSON_TABLE WHERE ID =" + id + ";";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqlException) {
				sqlException.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

		return true;
	}
	
}
