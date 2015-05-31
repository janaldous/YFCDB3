package yfcdb.member;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public class Person {
    protected Date dateLastUpdated;
    protected String username, password;
    protected static int numberOfMembers = 0;

    protected String id;
    protected Position position;
    protected String firstname, middlename, lastname, nickname;
    protected YFCGroup group;
    protected char gender;
    private String cellphoneNumber, email;
    protected Date birthday;

    public Person(Position pos, String fn, String mn, String ln, String nn, YFCGroup group) {
        setID(numberOfMembers++);
        position = pos;
        firstname = fn;
        middlename = mn;
        lastname = ln;
        nickname = nn;
        this.group = group;
        setUsername();
        setDateUpdated();
    }

    public Person() {
        setID(numberOfMembers++);
    }

    /**
     * overrides toString method of Object superclass
     */
    @Override
    public String toString() {

        return nickname + " " + lastname + " (" + id + ")";
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return	firstname first name of member
     */
    public String getFirstName() {
        return firstname;
    }
    /**
     * @return	middlename middle name of member
     */

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMiddlename() {
        return middlename;
    }
    /**
     * @return	lastname last name of member
     */

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }
    /**
     * @return	nickname nickname of member
     */

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

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
    public void setPassword(String pw) {
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
    public void setID(int rec) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String memberNo = String.format("%04d", (rec));
        id = year + "-" + memberNo;
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
    public Position getPosition() {

        return position;
    }

    /**
     * timestamps method whenever there is a change to member fields
     */
    public void setDateUpdated() {
        //get current date time with Date()
        Date date = new Date();
        dateLastUpdated = date;
    }

    /**
     * @return date last date record was changed
     */
    public String getDateUpdated() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(this.dateLastUpdated);
        return date;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return firstname + " '" + nickname + "' " + middlename + " " + lastname;
    }
}
