import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

public abstract class searchUsernameFile {
	private Scanner x;
	private String username, password;
	
	public searchUsernameFile(String username, char[] password) {
		this.username = username;
		this.password = String.valueOf(password);
	}
	
	public void openFile() {
		try{
			x = new Scanner(new File("username.jat.txt"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "An error occured");
		}
	}
	
	public boolean isValid() {
		boolean valid = false;
		while(x.hasNext()) {
			String un = x.next();
			String pw = x.next();
			System.out.println(un + " " + pw);
			if(un.equals(username) && pw.equals(password)) {
				JOptionPane.showMessageDialog(null, "Access granted");
				valid = true;
			 }
		}
		return valid;
	}
	
	public void closeFile() {
		x.close();
	}
}
