package Methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Get {

	
	public static String getNewID(Connection conn) {
		String last = null;
		String newID = null;
		int temp;
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT ReservationID FROM MsReservation");
			while(rs.next()) {
				last = rs.getString("ReservationID");
			}
			temp = Integer.parseInt(last.replaceAll("[^0-9]", "")) + 1;
			newID = String.format("R%03d", temp);
			return newID;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return newID;
	}
	
	public static String getOrderID(Connection conn) {
		String last = null;
		String newID = null;
		int temp;
		int temp2=0;
		
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT OrderID FROM MsOrder");
			while(rs.next()) {
				last = rs.getString("OrderID");
				if(Integer.parseInt(last.replaceAll("[^0-9]", ""))>temp2) {
					temp2=Integer.parseInt(last.replaceAll("[^0-9]", ""));
				}
				
			}
			
			temp = temp2 + 1;
			newID = String.format("O%03d", temp);
			
			return newID;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		
		return newID;
	}
	
	public static String getMenuID(Connection conn, String tablename) {
		String last = null;
		String newID = null;
		int temp, temp1;
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery("SELECT MenuID FROM " + tablename);
			while(rs.next()) {
				last = rs.getString("MenuID");
			}
			System.out.println("Tablename: " + tablename);
			
			temp = Integer.parseInt(last.replaceAll("[^0-9]", "")) + 1;
			temp1 = Integer.parseInt(last.replaceAll("[^0-9]", "")) - 99;
			if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
				newID = String.format("M0%02d", temp);
			} else if (tablename.equals("menupadang") || tablename.equals("menusamarinda") || tablename.equals("menusurabaya")) {
				newID = String.format("M1%02d", temp1);
			} 

			return newID;
		} catch (Exception e) {
//			e.printStackTrace();
		}
		return newID;
	}
	
	



}
