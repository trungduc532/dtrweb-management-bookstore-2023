/**
 * 59102901
 */
package dtr.web.management.bookshop.web.action.systerm;

import java.util.Scanner;
import java.util.regex.Pattern;

import dtr.web.management.bookshop.web.common.DtrKey;

/**
 * Common handle
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class CommonHandle {
	/**
	 * Scanner
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Input your choice
	 * 
	 * @return
	 */
	public static int inputChoice() {
		System.out.print("INPUT YOUR CHOICE: ");
		int choice = Integer.parseInt(scanner.nextLine());
		return choice;
	}
	
	/**
	 * Clean screen console 
	 */
	public static final void cleanScreen() {
		for(int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Continue program
	 */
	public static boolean continueProgram() {
		System.out.print("DO YOU WANT TO CONTINUE ? (y/n): ");
		String answer = scanner.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	/**
	 * Input Password
	 */
	public static boolean checkPassword(String password) {
		String regex = DtrKey.PASSWORD_REGEX;
		boolean checkPass = Pattern.matches(regex, password);
		return checkPass;
		
	}
	
	/**
	 * Input password
	 */
	public static String inputPassword() {
		String password = scanner.nextLine();
		while(!checkPassword(password)) {
			System.out.println("Uppper & lowercase letters.");
			System.out.println("At least one number.");
			System.out.println("At least one capital letter.");
			System.out.print(DtrKey.CUSTOMER_PASSWORD + "AGGAIN: ");
			password = scanner.nextLine();
		}
		return password;
	}
}
