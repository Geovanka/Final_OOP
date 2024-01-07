package Methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class Search {

	public static boolean searchEmployeeID(Connection conn, String employeeID) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT EmployeeID FROM MsEmployee");
			
			while(rs.next()){
				if(employeeID.equals(rs.getString("EmployeeID"))) {
					return true;
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean searchColumnMenu(Connection conn, String column, String table) {
	    try {
	        Statement state = conn.createStatement();
	        ResultSet rs = state.executeQuery("SELECT * FROM " + table);

	        ResultSetMetaData metaData = rs.getMetaData();
	        int columnCount = metaData.getColumnCount();

	        for (int i = 1; i <= columnCount; i++) {
	            String columnName = metaData.getColumnName(i);
	            if (column.equals(columnName)) {
	                return true;
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("Column not available");
	    }
	    return false; 
	}
	
	public static boolean searchLikeMenu(Connection conn, String like, String where, String tablename) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT " + where + " FROM " + tablename);
			
			while(rs.next()){
				if(like.equals(rs.getString(where))) {
					return true;
				}
			}
		} catch (Exception e) {
//			System.out.println("Data not available in column");
		}
		return false;
	}
	
	public static boolean searchOrder(Connection conn, String like) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT ReservationID FROM MsOrder");
			
			while(rs.next()){
				if(like.equals(rs.getString("ReservationID"))) {
					return true;
				}
			}
		} catch (Exception e) {
//			System.out.println("Data not available in column");
		}
		return false;
	}
	
	public static boolean searchReservation(Connection conn, String resID) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT ReservationID FROM MsReservation");
			
			while(rs.next()){
				if(resID.equals(rs.getString("ReservationID"))) {
					return true;
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return false;
	}
	
	
	public static boolean searchMenu(Connection conn, String MenuID, String tablename) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT MenuID FROM "+tablename);
			
			while(rs.next()){
				if(MenuID.equals(rs.getString("MenuID"))) {
					return true;
				}
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return false;
	}
	
	

	
	

	
	

	
	

	
	

}
