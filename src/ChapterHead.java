/**
 * Chapter Head object: creates, edits and deletes Event objects
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class ChapterHead extends Participant implements EventAdmin, MemberAdmin, HouseholdAdmin
{
	/**
	 * Creates ChapterHead object
	 */
    public ChapterHead(String fn, String mn, String ln, String nn)
    {
        super("ch", fn, mn, ln, nn);
    }
    /**
     * Creates an Event
     */
    public void createEvent(String n, String t, String v, String nts, int rf, int dd, int mm, int yyyy, 
    	    int start, int end)
    {
        EventList.addEvent(new Event(n, t, v, nts, rf, dd, mm, yyyy, start, end));
    }
    
    public void deleteEvent(Event e)
    {
    	EventList.deleteEvent(e);
    }
    
    public void editEvent()
    {
    }
	/* (non-Javadoc)
	 * @see model.MemberAdmin#createMember()
	 */
	@Override
	public void createMember(String pos, String fn, String mn, String ln,
			String nn) {
		Participant p = new Participant(pos, fn, mn, ln, nn);
		MemberList.addParticipant(p);
	}
	/* (non-Javadoc)
	 * @see model.MemberAdmin#editMember()
	 */
	@Override
	public void editMember() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see model.MemberAdmin#deleteMember()
	 */
	@Override
	public void deleteMember(Participant p) {
		MemberList.deleteParticipant(p);
	}
	/* (non-Javadoc)
	 * @see model.EventAdmin#takeAttendance()
	 */
	@Override
	public void takeAttendance(EventRole r, Member m, Event e) {
		
	}
	/* (non-Javadoc)
	 * @see model.HouseholdAdmin#addHousehold()
	 */
	@Override
	public void addHousehold() {
		// TODO
		
	}
	/* (non-Javadoc)
	 * @see model.HouseholdAdmin#editHousehold()
	 */
	@Override
	public void editHousehold() {
		// TODO
	}
	/* (non-Javadoc)
	 * @see model.HouseholdAdmin#deleteHousehold()
	 */
	@Override
	public void deleteHousehold() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see model.HouseholdAdmin#setHouseholdLeader(model.Household, model.HouseholdLeader)
	 */
	@Override
	public void setHouseholdLeader(Household group, HouseholdLeader hhl) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see model.EventAdmin#createEvent()
	 */
	@Override
	public void createEvent() {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see model.EventAdmin#deleteEvent()
	 */
	@Override
	public void deleteEvent() {
		// TODO Auto-generated method stub
		
	}
}
