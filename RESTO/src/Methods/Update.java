package Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import Methods.Show;
//import Methods.Search;
//import Methods.Bill;

public class Update {
	static Scanner sc = new Scanner(System.in);
	
	public static void updateReservation(Connection conn, String tablename) {      
	    int select = 0;
	    
	    Show.showReservation(conn, "SELECT * FROM MsReservation");
	    	    
	    try {
	        System.out.println("1. Manual Change");
	        System.out.println("2. Checkout");
	        System.out.print("Selection >> ");
	        select = sc.nextInt();
	        sc.nextLine();
	        
	        System.out.print("Enter ReservationID: ");
	        String resID = sc.nextLine();
	        
	        PreparedStatement ps = conn.prepareStatement("SELECT ReservationStatus FROM MsReservation WHERE ReservationID LIKE ?");
	        ps.setString(1, resID);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            String reservationStatus = rs.getString("ReservationStatus");

	            PreparedStatement pt = conn.prepareStatement("UPDATE MsReservation SET ReservationStatus = ? WHERE ReservationID = ?");
	            
	            if (select == 1) {              
	                if (reservationStatus.equals("in order")) {
	                    System.out.println("Reservation Status already in order!");
	                } else if (reservationStatus.equals("in reserve")) {
	                    if (Search.searchOrder(conn, resID)) {
	                    	pt.setString(1, "in order");
		                    pt.setString(2, resID);

		                    int check = pt.executeUpdate();
		                    if (check != 0) {
		                        System.out.println("ReservationStatus changed to in order!");
		                    } else {
		                        System.out.println("Failed to update ReservationStatus!");
		                    }
	                    } else {
	                    	System.out.println("Customer has not ordered yet!");
	                    }

	                } else if (reservationStatus.equals("finalized")) {
	                    System.out.println("Reservation is already finalized!");
	                }
	                
	            } else if (select == 2) {
	                if (reservationStatus.equals("in reserve")) {
	                    System.out.println("Customer is in reserve!");
	                } else if (reservationStatus.equals("finalized")) {
	                    System.out.println("Customer already finalized!");
	                } else {
	                    pt.setString(1, "finalized");
	                    pt.setString(2, resID);

	                    int check = pt.executeUpdate();
	                    if (check != 0) {
	                        System.out.println("Customer finalized!");
	                        Bill.bill(conn, resID, tablename);
	                        String where = "ReservationID";
	                        String tbn = "MsOrder";
	                        do {
	                        	Delete.deleteOrder(conn, resID);
	                        } while (Search.searchLikeMenu(conn, resID, where, tbn));
	                    } else {
	                        System.out.println("Failed to update ReservationStatus!");
	                    }
	                }
	            }
	        } else {
	            System.out.println("No matching reservation found for ReservationID: " + resID);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    } catch (Exception e) {
	        // TODO: handle exception
	        System.out.println("Update Reservation error");
	    } 
	}
	
	public static void updateMenu(Connection conn, String tablename) {
		int column = 0;
		String where = null;
		String like = null;
		String namechange = null;
		int pricechange = 0;
		String columnname = null;
		
		try {
			if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
				Show.showMenuMain(conn, "SELECT * FROM " + tablename);
			} else if (tablename.equals("menupadang") || tablename.equals("menusamarinda") || tablename.equals("menusurabaya")) {
				Show.showMenuLocal(conn, "SELECT * FROM " + tablename);
			}
			
			do {
				System.out.println("What to update?");
				System.out.println("1. Menu Name");
				System.out.println("2. Menu Price");
				System.out.print("Selection >> ");
				column = sc.nextInt();
				sc.nextLine();
			} while (column != 2 && column != 1);
			
			System.out.print("Updated data: ");
			if (column == 1) {
				namechange = sc.nextLine();
				columnname = "MenuName";
			} else if (column == 2) {
				pricechange = sc.nextInt();
				sc.nextLine();
				columnname = "Price";
			}
			
			do {
				System.out.print("Where column: ");
				where = sc.nextLine();
			} while (!Search.searchColumnMenu(conn, where, tablename));
			
			do {
				System.out.print("Like: ");
				like = sc.nextLine();
				if (!Search.searchLikeMenu(conn, like, where, tablename)) {
					System.out.println("Data not available in column");
				}
			} while (!Search.searchLikeMenu(conn, like, where, tablename));
			
			String sql = "UPDATE " + tablename + " SET " + columnname + " = ? WHERE " + where + " = ?";
			PreparedStatement pt = conn.prepareStatement(sql);

			if (column == 1) {
				pt.setString(1, namechange);
			} else if (column == 2) {
				pt.setInt(1, pricechange);
			}
			
			pt.setString(2, like);
			
			int check = pt.executeUpdate();
			if (check != 0) {
				System.out.println("Successfully updated!");
			} else {
				System.out.println("Failed to update.");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("error");
		}
	}
	
	


}
