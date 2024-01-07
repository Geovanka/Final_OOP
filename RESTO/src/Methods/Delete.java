package Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	static Scanner sc = new Scanner(System.in);
	
	public static void deleteMenu(Connection conn, String tablename) {
		String like = null;
		
		try {
			if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
				Show.showMenuMain(conn, "SELECT * FROM " + tablename);
			} else if (tablename.equals("menupadang") || tablename.equals("menusamarinda") || tablename.equals("menusurabaya")) {
				Show.showMenuLocal(conn, "SELECT * FROM " + tablename);
			}
			
			String where = "MenuID";
			do {
				System.out.println("Delete using MenuID");
				System.out.print("Enter MenuID: ");
				like = sc.nextLine();
				if (!Search.searchLikeMenu(conn, like, where, tablename)) {
					System.out.println("Data not available in column");
				}
			} while (!Search.searchLikeMenu(conn, like, where, tablename));
			
			String sql = "DELETE FROM " + tablename + " WHERE MenuID = ? AND NOT EXISTS (SELECT * FROM msorder WHERE MenuID = ?)" ;
			PreparedStatement pt = conn.prepareStatement(sql);
			
			pt.setString(1, like);
			pt.setString(2, like);
			
			int check = pt.executeUpdate();
			if (check != 0) {
				System.out.println("Successfully deleted!");
			} else {
				System.out.println("Failed to delete, try checking if menu order is in progress");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error");
		}
	}
	
	public static void deleteOrder(Connection conn, String resID) {
		
		try {			
			String sql = "DELETE FROM msorder WHERE ReservationID = ?" ;
			PreparedStatement pt = conn.prepareStatement(sql);
			
			pt.setString(1, resID);
			
			int check = pt.executeUpdate();
			if (check != 0) {
				System.out.println("Order finalized!");
			} else {
				System.out.println("Failed to finalize");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error");
		}
	}
}

