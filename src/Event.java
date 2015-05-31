import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Write a description of class Event here.
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Event
{
    private static int id = 0;
	private String name, type, venue, notes;
	private int regFee, noOfAttendees, timeStart, timeEnd;
    private Date date;
    private ArrayList<Attendee> attendees = new ArrayList<Attendee>();
    
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
	 * gets type
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * gets venue
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * @param venue the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * gets notes
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * gets regFee
	 * @return the regFee
	 */
	public int getRegFee() {
		return regFee;
	}

	/**
	 * @param regFee the regFee to set
	 */
	public void setRegFee(int regFee) {
		this.regFee = regFee;
	}

	/**
	 * gets noOfAttendees
	 * @return the noOfAttendees
	 */
	public int getNoOfAttendees() {
		return noOfAttendees;
	}

	/**
	 * @param noOfAttendees the noOfAttendees to set
	 */
	public void setNoOfAttendees(int noOfAttendees) {
		this.noOfAttendees = noOfAttendees;
	}

	/**
	 * gets timeStart
	 * @return the timeStart
	 */
	public int getTimeStart() {
		return timeStart;
	}

	/**
	 * @param timeStart the timeStart to set
	 */
	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}

	/**
	 * gets timeEnd
	 * @return the timeEnd
	 */
	public int getTimeEnd() {
		return timeEnd;
	}

	/**
	 * @param timeEnd the timeEnd to set
	 */
	public void setTimeEnd(int timeEnd) {
		this.timeEnd = timeEnd;
	}

	/**
	 * @param id the id to set
	 */
	public static void setId(int id) {
		Event.id = id;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

    public Event(String n, String t, String v, String nts, int rf, int dd, int mm, int yyyy, 
    int start, int end)
    {
        id += 1;
    	name = n;
        type = t;
        venue = v;
        notes = nts;
        regFee = rf;
        setDate(dd, mm, yyyy);
        setTimes(start, end);
        EventList.addEvent(this);
    }

    private void setDate(int mm, int dd, int yyyy)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, mm-1);
        cal.set(Calendar.DATE, dd);
        cal.set(Calendar.YEAR, yyyy);
        date = cal.getTime();
    }
    
    public String getId() {
    	return Integer.toString(id);
    }

    public String getStringDate()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String stringDate = dateFormat.format(this.date);
        return stringDate;
    }
    
    public Date getDate()
    {
        return this.date;
    }
    
    public String getTimes()
    {
        return timeStart + "-" + timeEnd;
    }

    private void setTimes(int start, int end)
    {
        timeStart = start;
        timeEnd = end;
    }
    
    public void addAttendee(Member m, String r)
    {
        Attendee a = new Attendee(m, r);
        attendees.add(a);
    }

    public void printEvent()
    {
        System.out.println(name);
        System.out.println(type);
        System.out.println(venue);
        System.out.println(notes);
        System.out.println(regFee);
        System.out.println(noOfAttendees);
        System.out.println(getDate());
        System.out.println(getTimes());
        
        for(Attendee attendee: attendees)
        {
            System.out.println(attendee.member.getID() + ":" + attendee.getAttendee());
        }
    }
}