package ev;

public class Details {
	private String vehicle;
	private int balance;
	private String name;
	private String username;
	private String password;

	Details(String name, String vehicle, int balance, String password, String username) {

		this.vehicle = vehicle;
		this.name = name;
		this.balance = balance;
		this.password = password;
		this.username = username;
	}

	Details() {

	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
