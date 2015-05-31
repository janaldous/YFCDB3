package yfcdb.events;

import yfcdb.member.Member;
import yfcdb.member.Person;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public class Event {
    private static int id = 0;
    private String name, venue, notes;
    private EventType type;
    private int regFee, noOfAttendees, timeStart, timeEnd;
    private Date date;
    private ArrayList<Attendee> attendees = new ArrayList<Attendee>();

    public Event(String name, EventType type, String venue, String notes, int regFee, int dd, int mm, int yyyy,
                 int time_start, int time_end)
    {
        id++;
        this.name = name;
        this.type = type;
        this.venue = venue;
        this.notes = notes;
        this.regFee = regFee;
        setDate(dd, mm, yyyy);
        setTimes(time_start, time_end);
        //EventList.addEvent(this);
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
     * gets type
     * @return the type
     */
    public EventType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(EventType type) {
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
        return attendees.size();
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
        return dateFormat.format(this.date);
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

    public void addAttendee(Person p, Role r)
    {
        Attendee a = new Attendee(p, r);
        attendees.add(a);
        noOfAttendees = attendees.size();
    }

    public String toString()
    {
        String message = "";

        message += "==================="
                + "\nEvent";
        message += "\nName: " + name
                + "\nType: " + type
                + "\nVenue: " + venue
                + "\nNotes: " + notes
                + "\nReg fee:" + regFee
                + "\nNo of attendees: " + noOfAttendees
                + "\nDate: " + getDate()
                + "\nTimes: " + getTimes();

        for(Attendee attendee: attendees)
        {
            message += "\n" + attendee;
        }
        message += "\n===================";
        return message;
    }
}
