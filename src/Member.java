import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Member object - superclass for all objects
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Member
{
	protected int id;
	protected String firstname, middlename, lastname, nickname;
	protected String position;
	protected Date dateLastUpdated;
	protected String username, password;
    private static int numberOfMembers = 0;
    
    /**
     * Constructs Member object with position and names
     */
    public Member(String pos, String fn, String mn, String ln, String nn)
    {
        ++numberOfMembers;
        setID(numberOfMembers);
        firstname = fn;
        middlename = mn;
        lastname = ln;
        nickname = nn;
        position = pos;
        setUsername();
        setDateUpdated();
    }
    
    /**
     * Constructs Member object with names only
     */
    public Member(String fn, String mn, String ln, String nn)
    {
        ++numberOfMembers;
        setID(numberOfMembers);
        firstname = fn;
        middlename = mn;
        lastname = ln;
        nickname = nn;
        position = "Coordinator";
        setUsername();
        setDateUpdated();
    }
    
    public Member() {
    	++numberOfMembers;
        setID(numberOfMembers);
    	setDateUpdated();
    }

	/**
     * Sets first, middle, last and nick name of Member then timestamps update and changes username.
     * @param fn    first name
     * @param mn    middle name
     * @param ln    last name
     * @param nn    nickname
     */
    public void setName(String fn, String mn, String ln, String nn)
    {
        firstname = fn;
        middlename = mn;
        lastname = ln;
        nickname = nn;
        setUsername();
        setDateUpdated();
    }
    
    /**
     * overrides toString method of Object superclass
     */
    public String toString()
    {
        return firstname + " '" + nickname + "' " + middlename + " " + lastname;
    }
    
    /**
     * @return	firstname first name of member
     */
    public String getFirstname() { return firstname; }
    /**
     * @return	middlename middle name of member
     */
    public String getMiddlename() { return middlename; }
    /**
     * @return	lastname last name of member
     */
    public String getLastname() { return lastname; }
    /**
     * @return	nickname nickname of member
     */
    public String getNickname() { return nickname; }
    
    /**
     * sets username and timestamps update
     */
    public void setUsername()
    {
        username = Integer.toString(getID());
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
        id = year + Integer.parseInt(memberNo);
        setDateUpdated();
    }

    /**
     * @return id id of member
     */
    public int getID()
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
