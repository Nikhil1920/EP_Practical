package labof6;

public class User {
	String name;
	String password;
	String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean validate ()
	{
		if (name.equals ("kalpana") && password.equals ("test"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
