package testing;

import Backend.Person;
import junit.framework.TestCase;

public class TestPerson extends TestCase {
	Person person1;
	
	public TestPerson() { }
	
	protected void setUp() throws Exception {
		person1 = new Person("name", "phone", "email");
	}
	
	public void testDetails() {
		assertEquals("Fullname should be 'name'.", "name", person1.getFullName());
		assertEquals("Phone should be 'phone'.", "phone", person1.getPhone());
		assertEquals("Fullname should be 'email'.", "email", person1.getEmail());
	}
	
	public void testSettersGetters() {
		String name = "name2";
		person1.setFullName(name);
		assertEquals("Name should be 'name2'.", name, person1.getFullName());
		String phone = "phone2";
		person1.setPhone(phone);
		assertEquals("Phone should be 'phone2'.", phone, person1.getPhone());
		String email = "email2";
		person1.setEmail(email);
		assertEquals("Email should be 'email2'.", email, person1.getEmail());
	}
}