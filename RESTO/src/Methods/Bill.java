package Methods;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Bill {

	public static void bill(Connection conn, String resID, String tablename) {
		try {	
			int total = 0;
			Statement state = conn.createStatement();
			String Query = "SELECT m.MenuID, MenuName, Price, ReservationName FROM " + tablename + " m "
					+ "JOIN MsOrder mo ON m.MenuID = mo.MenuID "
					+ "JOIN MsReservation mr ON mo.ReservationID = mr.ReservationID "
					+ "WHERE mr.ReservationID LIKE '" + resID + "'";
			ResultSet rs = state.executeQuery(Query);
			
			System.out.println("Restaurant LaperAh");
			System.out.println("BILL");
			System.out.println("Reservation ID: " + resID);
			System.out.println("|" + String.format("%-6s", "MenuID") + "|" + String.format("%-15s", "MenuName") + 
					"|" + String.format("%-8s", "Price"));
			
			while (rs.next()) {
				System.out.print("|" + String.format("%-6s", rs.getString("m.MenuID")));
				System.out.print("|" + String.format("%-15s", rs.getString("MenuName")));
				System.out.print("|" + String.format("%-8s", rs.getInt("Price")));
				System.out.println("|");
				total += rs.getInt("Price");
			}
			System.out.println("Total: Rp" + total);
			System.out.println("Thank you!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error print bill");
			e.printStackTrace();
		}
	}


}
