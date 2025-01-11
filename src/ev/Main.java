package ev;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		EVdatabase database = new EVdatabase();
		Operation op = new Operation();	
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Enter the username: ");
			String username = sc.next();
			System.out.println("Enter the password: ");
			String password = sc.next();

			Details details = database.getDetails(username, password);

			if (details == null) {
				System.out.println("Incorrect username or Password");
				return;
			}
			System.out.println("WELCOME " + details.getName());

			while (true) {
				System.out.println("Select one option");
				System.out.println("1. Display Profile");
				System.out.println("2. Credit Amount");
				System.out.println("3. Deduct Credits");
				System.out.println("4. Change Password");
				System.out.println("5. View transaction");
				System.out.println("6. Logout");
				System.out.print("Enter Your Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					op.displayProfile(details);
					break;
				case 2:
					System.out.println("Enter the amount to credit : ");
					int amount = sc.nextInt();
					op.creditAmount(details, amount);
					break;
				case 3:
					System.out.println("Enter the amount to debit : ");
					int amount1 = sc.nextInt();
					op.debitAmount(details, amount1);
					break;
				case 4:
					System.out.println("Enter the new password");
					String pass = sc.next();
					op.changePasswrd(details, pass);
					break;
				case 5:
					op.viewTransaction(details);
					break;
				case 6:
					System.out.println("Thank You!");
					return;
				default:
					System.out.println("Invalid choice");
					sc.close();

				}
			}
			
		}
		

	}
