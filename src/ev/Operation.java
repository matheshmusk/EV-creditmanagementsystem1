package ev;

public class Operation extends Details {
	EVdatabase database = new EVdatabase();

	public void displayProfile(Details name) {
		System.out.println("Name : " + name.getName());
		System.out.println("Vehicle no : " + name.getVehicle());
		System.out.println("Balance : " + name.getBalance());
	}

	public void creditAmount(Details name, int amount) {
		if (amount > 0) {
			name.setBalance(name.getBalance() + amount);
			database.update(name);
			database.updateTransactionc(name, amount);
			System.out.println("amount credited");
		} else {
			System.out.println("Invalid");
		}

	}

	public void debitAmount(Details name, int amount) {
		if (amount < name.getBalance()) {
			name.setBalance(name.getBalance() - amount);
			database.update(name);
			database.updateTransactiond(name, amount);
			System.out.println("amount debited");
		} else {
			System.out.println("insufficient balance");
		}

	}

	public void changePasswrd(Details detail, String passwrd) {
		detail.setPassword(passwrd);
		database.updatepassword(detail);
		System.out.println("password changed successfully!");
	}

	public void viewTransaction(Details detail) {
		System.out.println("Transaction report");
		database.gettransaction(detail);
	}
}
