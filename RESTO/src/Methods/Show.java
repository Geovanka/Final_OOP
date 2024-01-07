package Methods;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;


public class Show {
	
	public static void showMenuMain(Connection conn, String Query) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(Query);
			
			System.out.println("|" + String.format("%-6s", "MenuID") + 
					"|" + String.format("%-15s", "MenuName") + 
					"|" + String.format("%-7s", "Price") + 
					"|" + String.format("%-8s", "MenuType") + 
					"|" + String.format("%-10s", "Narasi") + "|");
			
			while(rs.next()){
				System.out.print("|" + String.format("%-6s", rs.getString("MenuID")));
				System.out.print("|" + String.format("%-15s", rs.getString("MenuName")));
				System.out.print("|" + String.format("%-7s", rs.getString("Price")));
				System.out.print("|" + String.format("%-8s", rs.getString("MenuType")));
				System.out.print("|" + String.format("%-10s", rs.getString("Narasi")));
				System.out.println("|");
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
	}

	
	public static void showMenuLocal(Connection conn, String Query) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(Query);
			
			System.out.println("|" + String.format("%-6s", "MenuID") + 
					"|" + String.format("%-15s", "MenuName") + 
					"|" + String.format("%-7s", "Price") + 
					"|" + String.format("%-8s", "MenuType") + 
					"|" + String.format("%-10s", "Narasi") + 
					"|" + String.format("%-10s", "Location") + "|");
			
			while(rs.next()){
				System.out.print("|" + String.format("%-6s", rs.getString("MenuID")));
				System.out.print("|" + String.format("%-15s", rs.getString("MenuName")));
				System.out.print("|" + String.format("%-7s", rs.getString("Price")));
				System.out.print("|" + String.format("%-8s", rs.getString("MenuType")));
				System.out.print("|" + String.format("%-10s", rs.getString("Narasi")));
				System.out.print("|" + String.format("%-10s", rs.getString("Location")));
				System.out.println("|");
			}
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
		}
	}

	public static void showReservation(Connection conn, String Query) {
		try {
			Statement state = conn.createStatement();
			ResultSet rs = state.executeQuery(Query);
			
			System.out.println("|" + String.format("%-13s", "ReservationID") + 
					"|" + String.format("%-15s", "ReservationName") + 
					"|" + String.format("%-10s", "TotalTable") + 
					"|" + String.format("%-10s", "TableType") + 
					"|" + String.format("%-11s", "TotalPerson") + 
					"|" + String.format("%-17s", "ReservationStatus") + "|");
			
			while (rs.next()) {
				System.out.print("|" + String.format("%-13s", rs.getString("ReservationID")));
				System.out.print("|" + String.format("%-15s", rs.getString("ReservationName")));
				System.out.print("|" + String.format("%-10s", rs.getString("TotalTable")));
				System.out.print("|" + String.format("%-10s", rs.getString("TableType")));
				System.out.print("|" + String.format("%-11s", rs.getString("TotalPerson")));
				System.out.print("|" + String.format("%-17s", rs.getString("ReservationStatus")));
				System.out.println("|");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
