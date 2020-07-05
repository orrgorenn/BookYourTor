public class Person {

	private String fullName;
	private String phone;
	private String email;
	
	public Person(String fullName, String phone, String email) {
		this.fullName = fullName;
		this.phone = phone;
		this.email = email;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getFullName() {
		return this.fullName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
}