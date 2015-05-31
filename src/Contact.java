/**
 * 
 */

/**
 * @author janaldoustorres
 * @version
 */
public class Contact {
	private String name;
	private String contactNo;
	
	public Contact(String name, String contactNo) {
		this.setName(name);
		this.setContactNo(contactNo);
	}
	
	public Contact(String[] array) {
		this.setName(array[0]);
		this.setContactNo(array[0]);
	}
	
	/**
	 * gets name
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * gets contactNo
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}

	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	public String toString() {
		return name + " " + contactNo;
	}
}
