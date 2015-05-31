import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Member object - superclass for all objects
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Member2
{
	protected String id;
	protected String familyname, givenname, middlename, nickname;
	protected String position;
	protected String address, addressvill, addresscity;
	protected Date birthday;
	protected boolean kfckid;
	protected String school, level, collegecourse, bloodtype;
	protected char gender;
	protected String cellphone, telephone, email;
	protected String fatherName, fatherOccupation, fatherOrganization, motherName, motherOccupation, motherOrganization;
	protected Contact[] emergencyContacts = new Contact[3];
	protected String retreatsAttended, specialSkills;
	protected String illnesses;
	protected Date dateLastUpdated;
	protected String username, password;
	private static int numberOfMembers = 0;
	private static final DateFormat format = new SimpleDateFormat("dd/MM/yy");

	/**
	 * Constructs Member object with position and names
	 */
	public Member2(String pos, String fn, String mn, String ln, String nn)
	{
		++numberOfMembers;
		setID(numberOfMembers);
		givenname = fn;
		middlename = mn;
		familyname = ln;
		nickname = nn;
		position = pos;
		setUsername();
		setDateUpdated();
	}

	/**
	 * Constructs Member object with names only
	 * @throws java.text.ParseException
	 */
	public Member2(Object[] array) throws ParseException
	{
		++numberOfMembers;
		setID(numberOfMembers);
		password 	= (String) array[2];
		position 	= (String) array[3];
		familyname 	= (String) array[4];
		givenname 	= (String) array[5];
		middlename 	= (String) array[6];
		nickname	= (String) array[7];
		address 	= (String) array[8];
		addressvill = (String) array[9];
		addresscity = (String) array[10];
		birthday 	= format.parse((String) array[11]);
		kfckid 		= Boolean.parseBoolean((String) array[12]);
		school 		= (String) array[13];
		level 		= (String) array[14];
		collegecourse = (String) array[15];
		bloodtype 	= (String) array[16];
		gender 		= ((String) array[17]).charAt(0);
		cellphone 	= (String) array[18];
		telephone 	= (String) array[19];
		email 		= (String) array[20];
		fatherName 	= (String) array[21];
		fatherOccupation = (String) array[22];
		fatherOrganization = (String) array[23];
		motherName 	= (String) array[24];
		motherOccupation = (String) array[25];
		fatherOrganization = (String) array[26];
		String[] contacts = ((String) array[27]).split(" ");
		for(int i = 0; i < contacts.length; ++i) {
			emergencyContacts[i] = new Contact(contacts[i].split(","));
		}
		specialSkills = (String) array[28];
		illnesses 	= (String) array[29];
		
		
		setUsername();
		setDateUpdated();
	}

	/**
	 * Constructs Member object with names only
	 */
	public Member2(String fn, String mn, String ln, String nn)
	{
		++numberOfMembers;
		setID(numberOfMembers);
		givenname = fn;
		middlename = mn;
		familyname = ln;
		nickname = nn;
		position = "Coordinator";
		setUsername();
		setDateUpdated();
	}

	public Member2() {
		++numberOfMembers;
		setID(numberOfMembers);
		setDateUpdated();
	}

	/**
	 * Sets first, middle, last and nick name of Member then timestamps update and changes username.
	 * @param fn    first name
	 * @param mn    middle name
	 * @param ln    last name
	 * @param nm    nickname
	 */
	public void setName(String fn, String mn, String ln, String nn)
	{
		givenname = fn;
		middlename = mn;
		familyname = ln;
		nickname = nn;
		setUsername();
		setDateUpdated();
	}

	/**
	 * overrides toString method of Object superclass
	 */
	public String toString()
	{
		return  familyname + ", " + givenname + " " + middlename.charAt(0) + ". '" + nickname + "' ";
	}

	/**
	 * @return	firstname first name of member
	 */
	public String getFirstname() { return givenname; }
	/**
	 * @return	middlename middle name of member
	 */
	public String getMiddlename() { return middlename; }
	/**
	 * @return	lastname last name of member
	 */
	public String getLastname() { return familyname; }
	/**
	 * @return	nickname nickname of member
	 */
	public String getNickname() { return nickname; }

	/**
	 * sets username and timestamps update
	 */
	public void setUsername()
	{
		username = getID();
		setDateUpdated();
	}

	/**
	 * @return username username of member
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * sets password and timestamps update
	 */
	public void setPassword(String pw)
	{
		password = pw;
		setDateUpdated();
	}

	/**
	 * @return password password of member
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * sets id of memeber and timestamps update
	 */
	public void setID(int rec)
	{
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		String memberNo = String.format("%04d", (rec));
		id = year + memberNo;
		setDateUpdated();
	}

	/**
	 * @return id id of member
	 */
	public String getID()
	{
		return id;
	}
	/**
	 * @return position position of member
	 */
	public String getPosition()
	{
		return position;
	}

	/**
	 * timestamps method whenever there is a change to member fields
	 */
	public void setDateUpdated()
	{
		//get current date time with Date()
		Date date = new Date();
		dateLastUpdated = date;
	}

	/**
	 * @return date last date record was changed
	 */
	public String getDateUpdated()
	{
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		String date = dateFormat.format(this.dateLastUpdated);
		return date;
	}
}
