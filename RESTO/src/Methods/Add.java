package Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Add{
	static Scanner sc = new Scanner(System.in);
	
	public static void addMenu(Connection conn, String tablename) {	
		
		try {
			String menuname = null;
			System.out.print("Menu Name: ");
			menuname = sc.nextLine();
			
			int menuprice = 0;
			System.out.print("Menu Price: ");
			menuprice = sc.nextInt();
			sc.nextLine();
			
			String menutype = null;
			if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
				do {
					System.out.print("Menu Type (Main or SpecialMenu): ");
					menutype = sc.nextLine();
				} while (!menutype.equals("Main") && !menutype.equals("SpecialMenu"));
			} else if (tablename.equals("menupadang") || tablename.equals("menusamarinda") || tablename.equals("menusurabaya")) {
				do {
					System.out.print("Menu Type (Main or LocalSpecial): ");
					menutype = sc.nextLine();
				} while (!menutype.equals("Main") && !menutype.equals("LocalSpecial"));
			}
			
			String menunarasi = null;
			if (menutype.equals("SpecialMenu")) {
				System.out.print("Menu narasi: ");
				menunarasi = sc.nextLine();
			} 
			
			String menulocation = null;
			if (menutype.equals("LocalSpecial") && tablename.equals("menupadang") || tablename.equals("menusurabaya") || tablename.equals("menusamarinda")) {	
				System.out.print("Menu location: ");
				menulocation = sc.nextLine();
				System.out.print("Menu narasi: ");
				menunarasi = sc.nextLine();
			} 
			
			String menuID = null;
			menuID = Get.getMenuID(conn, tablename);
			
			if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
				PreparedStatement pt = conn.prepareStatement("INSERT INTO " + tablename + "(MenuID, MenuName, Price, MenuType, Narasi) VALUES (?,?,?,?,?)");
				pt.setString(1, menuID);
				pt.setString(2, menuname);
				pt.setInt(3, menuprice);
				pt.setString(4, menutype);
				pt.setString(5, menunarasi);
				int check = pt.executeUpdate();
				if (check != 0) {
					System.out.println("Menu successfully added!");
				} else {
					System.out.println("Failed to add menu");
				}
			} else {
				PreparedStatement pt = conn.prepareStatement("INSERT INTO " + tablename + "(MenuID, MenuName, Price, MenuType, Narasi, Location) VALUES (?,?,?,?,?,?)");
				pt.setString(1, menuID);
				pt.setString(2, menuname);
				pt.setInt(3, menuprice);
				pt.setString(4, menutype);
				pt.setString(5, menunarasi);
				pt.setString(6, menulocation);
				
				int check = pt.executeUpdate();
				if (check != 0) {
					System.out.println("Menu successfully added!");
				} else {
					System.out.println("Failed to add menu");
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
			e.printStackTrace();
		}
		
	}
	
	public static void addReservation(Connection conn, String tablename) {
		// insert
		String reservationName = null;
		System.out.print("Reservation Name: ");
		reservationName = sc.nextLine();
		
		String tableType;
		System.out.println("Table Type (input name of table type)");
		System.out.println("Romantic = max 2");
		System.out.println("General = max 4");
		System.out.println("Family = max 10");
		System.out.print("Table Type: ");
		tableType = sc.nextLine();
		
		int totalTable;
		System.out.print("Total Table: ");
		totalTable = sc.nextInt(); sc.nextLine();
		
		int totalPerson = 0, max = 0;
		int i = 0;
		
		do {
			if(i>0) {
				System.out.println("Total person exceeds the limit for the table type...");
			}
			System.out.print("Total Person: ");
			totalPerson = sc.nextInt();
			sc.nextLine();
			if(tableType.toLowerCase().equals("romantic")) {
				max = 2*totalTable;
			} else if(tableType.toLowerCase().equals("general")) {
				max = 4*totalTable;
			} else if(tableType.toLowerCase().equals("family")) {
				max = 10*totalTable;
			}
			i++;
		} while(totalPerson > max);
		
		String reservationStatus;
		reservationStatus = "in reserve";
		String newID = Get.getNewID(conn);
		
		try {
			PreparedStatement pt = conn.prepareStatement("INSERT INTO msreservation (ReservationID, ReservationName, TotalTable, TableType, TotalPerson, ReservationStatus) VALUES (?,?,?,?,?,?)");
			pt.setString(1, newID);
			pt.setString(2, reservationName);
			pt.setInt(3, totalTable);
			pt.setString(4, tableType);
			pt.setInt(5, totalPerson);
			pt.setString(6, reservationStatus);
			int j = pt.executeUpdate();
			if(j!=0) {
				System.out.println("Reservation successfully made...");
			} else {
				System.out.println("Failed to create reservation...");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void addOrder(Connection conn, String tablename) {
		String resID = null;
		String menuID = null;
		String newID = null;
		do {
			System.out.println("Enter Reservation ID: ");
			resID = sc.nextLine();
			if(!Search.searchReservation(conn, resID)) {
				System.out.println("Reservation ID not found...");
			}
		} while (!Search.searchReservation(conn, resID));
		
		if (tablename.equals("menujakarta") || tablename.equals("menubali") || tablename.equals("menubandung")) {
			Show.showMenuMain(conn, "SELECT * FROM " + tablename);
		} else if (tablename.equals("menupadang") || tablename.equals("menusamarinda") || tablename.equals("menusurabaya")) {
			Show.showMenuLocal(conn, "SELECT * FROM " + tablename);
		}
		
		do {
			System.out.println("Enter Menu ID: ");
			menuID = sc.nextLine();
			if(!Search.searchMenu(conn, menuID,tablename)) {
				System.out.println("Menu ID not found...");
			}
		}while(!Search.searchMenu(conn,menuID,tablename));
		newID = Get.getOrderID(conn);
		System.out.println(newID);
		try {
			
			PreparedStatement pt = conn.prepareStatement("INSERT INTO msorder VALUES (?,?,?)");
			pt.setString(1, newID);
			pt.setString(2, resID);
			pt.setString(3, menuID);
			int j = pt.executeUpdate();
			if(j!=0) {
				System.out.println("Order successfully made...");
			} else {
				System.out.println("Failed to create order...");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}



}
