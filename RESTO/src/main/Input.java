package main;
import java.sql.Connection;
import java.util.Scanner;

import Methods.Search;

public class Input {
	static Scanner sc = new Scanner(System.in);
	
	public static String inputEmployee(Connection conn) {
		String employeeID;
		String tablename = null;
		
		do {
			System.out.print("Input your Employee ID >> ");
			employeeID = sc.nextLine();
			
			Search.searchEmployeeID(conn, employeeID);
			
			if(!Search.searchEmployeeID(conn, employeeID)) {
				System.out.println("Employee ID not found...");
			}
		} while(!Search.searchEmployeeID(conn, employeeID));
		
		if(employeeID.charAt(0) == 'B' && employeeID.charAt(1) =='D') {
			tablename = "menubandung";
		} else if(employeeID.charAt(0) == 'J' && employeeID.charAt(1) =='K') {
			tablename = "menujakarta";
		} else if(employeeID.charAt(0) == 'B' && employeeID.charAt(1) =='L') {
			tablename = "menubali";
		} else if(employeeID.charAt(0) == 'S' && employeeID.charAt(1) =='B') {
			tablename = "menusurabaya";
		} else if(employeeID.charAt(0) == 'S' && employeeID.charAt(1) =='M') {
			tablename = "menusamarinda";
		} else if(employeeID.charAt(0) == 'P' && employeeID.charAt(1) =='D') {
			tablename = "menupadang";
		}
		
		return tablename;
	}
}
