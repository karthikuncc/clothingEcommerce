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
import com.clothingcloset.models.Donation;
import com.clothingcloset.models.Item;
import com.clothingcloset.models.PBLStaff;
import com.clothingcloset.models.Purchases;

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

			// Inserting the Staff Member into the Person Database.
			String sqlperson = "INSERT INTO PERSON_TABLE (FIRST_NAME,LAST_NAME,GENDER,MOBILE_NUMBER,STREET,CITY,STATE,PINCODE) VALUES ( '"
					+ pblStaff.getFirstName() + "','" + pblStaff.getLastName() + "','" + pblStaff.getGender() + "',"
					+ pblStaff.getMobileNumber() + ",'" + pblStaff.getStreet() + "','" + pblStaff.getCity() + "','"
					+ pblStaff.getState() + "'," + pblStaff.getPincode() + ");";

			System.out.println(sqlperson);
			int i = stmt.executeUpdate(sqlperson);

			// Retrieving the Staff Member From the Person Database.
			if (i > 0) {
				String sql1 = "SELECT ID FROM PERSON_TABLE WHERE FIRST_NAME = '" + pblStaff.getFirstName()
						+ "' AND LAST_NAME= '" + pblStaff.getLastName() + "';";
				System.out.println(sql1);

				ResultSet resultSet = (ResultSet) stmt.executeQuery(sql1);
				int personId = 0;
				while (resultSet.next()) {
					personId = resultSet.getInt("ID");

				}

				// Insert the Staff Member into the PBL Staff Table.
				String staffMemberSql = "INSERT INTO PBLSTAFF_TABLE (EMAIL,PBLPOSITION,PASSWORD,ID) VALUES ( '"
						+ pblStaff.getEmail() + "','" + "staff" + "','" + pblStaff.getPassword() + "'," + personId + ");";
				System.out.println("SQL Query is : " + staffMemberSql);
				stmt.executeUpdate(staffMemberSql);
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

	public boolean checkInItems(Donation donation) {
		boolean isChecked = false;
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			// Get the Donation ID Record from the database.
			Integer id = donation.getId();

			String updateSql = "UPDATE DONATION_TABLE SET CHECKED=" + 1 + " WHERE DONATION_ID=" + id;
			System.out.println(updateSql);
			stmt.executeUpdate(updateSql);

			String categoryIdSql = "SELECT CATEGORY_ID FROM CATEGORY_TABLE WHERE CATEGORY_NAME= '"
					+ donation.getCategoryName() + "';";
			System.out.println(categoryIdSql);
			ResultSet results = stmt.executeQuery(categoryIdSql);
			Integer categoryId = 1;
			while (results.next()) {
				categoryId = results.getInt("CATEGORY_ID");
			}

			String itemInsertSQl = "INSERT INTO ITEM_TABLE (ITEM_NAME,SIZE,COLOR,QUANTITY,ITEM_CONDITION,DESCRIPTION,ITEM_ADDED_DATE,GENDER,BRAND,PRICE,CATEGORY_ID)"
					+ " VALUES ('" + donation.getItemName() + "','" + donation.getSize() + "','" + donation.getColor()
					+ "'," + donation.getQuantity() + ",'" + donation.getItem_Condition() + "','"
					+ donation.getDescription() + "','" + donation.getDateOfDonation() + "','" + donation.getGender()
					+ "','" + donation.getBrand() + "'," + donation.getPrice() + "," + categoryId + ");";

			System.out.println("SQL for Insert ITem: " + itemInsertSQl);

			stmt.executeUpdate(itemInsertSQl);
			isChecked = true;

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

		return isChecked;
	}

	public Boolean removePBLStaffMembers(PBLStaff pblStaff) {

		// int id;
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT ID FROM PBLSTAFF_TABLE WHERE EMAIL ='" + pblStaff.getEmail() + "';";

			System.out.println("SQL Query is : " + sql);
			ResultSet resultSet = stmt.executeQuery(sql);

			resultSet.next();
			int id = resultSet.getInt("ID");

			String removeCheckedInSql = "delete FROM  CHECKEDIN WHERE PBLEMAIL = '" + pblStaff.getEmail() + "';";

			String remoevPerson = "delete FROM PERSON_TABLE WHERE ID =" + id + ";";
			String removePBLStaffSql = "delete FROM PBLSTAFF_TABLE WHERE EMAIL ='" + pblStaff.getEmail() + "' AND ID= "+id+";";
			// String sql2 = "delete from CHECKED"

			System.out.println(remoevPerson);
			System.out.println(removeCheckedInSql);
			System.out.println(removePBLStaffSql);

			stmt.executeUpdate(removeCheckedInSql);
			stmt.executeUpdate(removePBLStaffSql);
			stmt.executeUpdate(remoevPerson);

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
	
	// Show all the Purchased Items.
	public List<Purchases> showAllPurchasedItems(){
		List<Purchases> purchases = new ArrayList<Purchases>();
	
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM PURCHASE ;";
			System.out.println(sql);
			
			ResultSet resultSet = (ResultSet) stmt.executeQuery(sql);
			
			while(resultSet.next()){
				Purchases purchase = new Purchases();
				purchase.setCost(resultSet.getFloat("COST"));
				purchase.setCustomerEmail(resultSet.getString("CUSTOMER_EMAIL"));
				purchase.setItemId(resultSet.getInt("ITEM_ID"));
				purchase.setPurchaseDate(resultSet.getDate("PURCHASE_DATE").toString());
				purchases.add(purchase);
			}
			
			
		}catch (Exception e) {
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
		
		return purchases;
	}
	
	// Display Items
	public List<Item> showAllItems(){
		List<Item> items = new ArrayList<Item>();
	
		try {
			conn = (Connection) connectionUtil.connectToDatabase();
			stmt = conn.createStatement();

			String sql = "SELECT * FROM ITEM_TABLE ;";
			System.out.println(sql);
			
			ResultSet resultSet = (ResultSet) stmt.executeQuery(sql);
			
			while(resultSet.next()){
				items.add(setItemDetails(resultSet));
			}
				
		}catch (Exception e) {
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
		
		return items;
	}
	
	private Item setItemDetails(ResultSet resultSet_item) throws SQLException {
		Item item = new Item();
		item.setCategoryId(resultSet_item.getInt("CATEGORY_ID"));
		item.setItemId(resultSet_item.getInt("ITEM_ID"));
		item.setItemName(resultSet_item.getString("ITEM_NAME"));
		item.setSize(resultSet_item.getString("SIZE"));
		item.setColor(resultSet_item.getString("COLOR"));
		item.setQuantity(resultSet_item.getInt("QUANTITY"));
		item.setItemCondition(resultSet_item.getString("ITEM_CONDITION"));
		item.setDescription(resultSet_item.getString("DESCRIPTION"));
		item.setItemDate(resultSet_item.getDate("ITEM_ADDED_DATE").toString());
		item.setBrand(resultSet_item.getString("BRAND"));
		item.setGender(resultSet_item.getString("GENDER"));
		item.setPrice(resultSet_item.getFloat("PRICE"));
		return item;
	}
	
}
