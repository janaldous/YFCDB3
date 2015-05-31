/**
 * 
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Jat Torres
 * @version 2.0
 */
public class Participant extends Member {
	protected Calendar birthday;
	private String school, collegeCourse, email, addressSt, addressVill, 
    addressCity, motherName, motherEmail, motherOccupation, fatherName, fatherEmail, fatherOccupation, notes, 
    allergies, gradeLevel, shirtSize;
    private HouseholdLeader hhLeader;
    public int age, yfcAge, entryYear, contactNo, fatherContact, motherContact;
    public char gender, kfc2yfc;
    
	/**
	 * Description
	 * @param position
	 * @param fn
	 * @param mn
	 * @param ln
	 * @param nn
	 */
	public Participant(String position, String fn, String mn, String ln,
			String nn) {
		super(position, fn, mn, ln, nn);
		MemberList.addParticipant(this);
	}
	
	public void setPersonalDetails(String s, String cc, String e, String as, String av, String n,
			String a, String gl, String ss, int ey, int cno, char g, char k2y)
	{
		school = s;
		collegeCourse = cc;
		email = e;
		addressSt = as;
		addressVill = av;
		notes = n;
		allergies = a;
		gradeLevel = gl;
		shirtSize = ss;
		entryYear = ey;
		contactNo = cno;
		gender = g;
		kfc2yfc = k2y;
		setDateUpdated();
	}

	public String getSchool() { return school; }
	public String getCollegeCourse() { return collegeCourse; }
	public String getEmail() { return email; }
	public String getAddressSt() { return addressSt; }
	public String getAddressVill() { return addressVill; }
	/**
	 * @return addressCity city of member
	 */
	public String getAddressCity() {
		return addressCity;
	}

	/**
	 * @param addressCity city of member
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getNotes() { return notes; }
	public String getAllergies() { return allergies; }
	public String getGradeLevel() { return gradeLevel; }
	public String getShirtSize() { return shirtSize; }
	public int getEntryYear() { return entryYear; }
	public char getGender() { return gender; }
	public char getKfc2Yfc() { return kfc2yfc; }

	public int getYfcAge() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR)-entryYear;
	}


	public void setBirthday(int mm, int dd, int yyyy) {

		birthday.set(Calendar.YEAR, yyyy);
		birthday.set(Calendar.MONTH, mm);
		birthday.set(Calendar.DAY_OF_MONTH, dd);
		this.setAge();
	}

	public int getBirthYear() {
		Date bday = birthday.getTime();
		birthday.setTime(bday);
		return birthday.get(Calendar.YEAR);
	}

	public String getBirthMonth() {
		return new SimpleDateFormat("MMMMM").format(birthday.getTime());
	}

	public int getBirthDate() {
		Date bday = birthday.getTime();
		birthday.setTime(bday);
		return birthday.get(Calendar.DAY_OF_MONTH);
	}

	public void setAge()
	{
		Calendar cal = Calendar.getInstance();
		Date bday = birthday.getTime();
		birthday.setTime(bday);
		int yearNow = cal.get(Calendar.YEAR);
		int yearDob = birthday.get(Calendar.YEAR);
		int age = yearNow - yearDob;
		int monthNow = cal.get(Calendar.MONTH)+1;
		int monthDob = birthday.get(Calendar.MONTH)+1;

		if (monthDob > monthNow) 
		{
			age--;
		} else if (monthDob == monthNow) 
		{
			int dayNow = cal.get(Calendar.DAY_OF_MONTH);
			int dayDob = birthday.get(Calendar.DAY_OF_MONTH);
			if (dayDob > dayNow) 
			{
				age--;
			}
		}

		this.age = age;
	}

	public int getAge()
	{
		return age;
	}

	public void setParentalDetails(String mon, String me, String mo, int mc, String fan, String fe, String fo,
			int fc)
	{
		motherName = mon;
		motherEmail = me;
		motherOccupation = mo;
		motherContact = mc;
		fatherName = fan;
		fatherEmail = fe;
		fatherOccupation = fo;
		fatherContact = fc;
		setDateUpdated();
	}

	public String getMotherName() { return motherName; }
	public String getMotherEmail() { return motherEmail;}
	public String getMotherOccupation() { return motherOccupation; }
	public int getMotherContact() { return motherContact; }
	public String getFatherName() { return fatherName; }
	public String getFatherEmail() { return fatherEmail;}
	public String getFatherOccupation() { return fatherOccupation; }
	public int getFatherContact() { return fatherContact; }

	public void setHHLeader(HouseholdLeader hhl)
	{
		hhLeader = hhl;
		setDateUpdated();
	}

	public HouseholdLeader getHHLeader()
	{
		return hhLeader;
	}

	public void setContactDetails(int cn)
	{
		contactNo = cn;
		setDateUpdated();
	}

	public int getContactDetails()
	{
		return contactNo;
	}
}
