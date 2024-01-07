package main;

import java.sql.Connection;
import java.util.Scanner;

import Connection.ConnectionManager;
import Methods.Add;
import Methods.Update;
import Methods.Delete;
import Methods.Show;



public class Main {
	static Scanner sc = new Scanner(System.in);
	static Connection conn;

	public static void main(String[] args) {
		conn = ConnectionManager.createConnection();
		menu();
		ConnectionManager.closeConnection();
	} 
	
	public static void menu() {
		int select = 0;
		
		do {
			String tablename = Input.inputEmployee(conn);
			System.out.println("Restaurant LaperAh");
			System.out.println("1. Add Reservation");
			System.out.println("2. Update Reservation");
			System.out.println("3. Add Menu");
			System.out.println("4. Update Menu");
			System.out.println("5. Delete Menu");
			System.out.println("6. Add Order");
			System.out.println("7. Exit");
			System.out.print("Selection >> ");
			try {
				select = sc.nextInt();
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Invalid Input!!!!!");
			}
			
			switch(select) {
			case 1:
				Add.addReservation(conn, tablename);
				break;
			case 2:
				Update.updateReservation(conn, tablename);
				break;
			case 3:
				Add.addMenu(conn, tablename);
				break;
			case 4:
				Update.updateMenu(conn, tablename);
				break;
			case 5:
				Delete.deleteMenu(conn, tablename);
				break;
			case 6:
				Add.addOrder(conn, tablename);
			}
			
		} while (select != 7);
	}
	
}