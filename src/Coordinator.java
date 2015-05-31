/**
 * Write a description of class Coordinator here.
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Coordinator extends Member implements EventAdmin, MemberAdmin, HouseholdAdmin
{
    private String prefix;
    
    public Coordinator(String p, String fn, String mn, String ln, String nn)
    {
    	super(fn, mn, ln, nn);
    	prefix = p;
    	MemberList.addCoordinator(this);
    }
    
    public void setPrefix(String p) { this.prefix = p; }
    
    public String setPrefix() { return this.prefix; }
    
    public void createEvent()
    {
    }
    
    public void deleteEvent()
    {
    }
    
    public void editEvent()
    {
    }
    
    public void takeAttendance(Event e, Member m, String r)
    {
        e.addAttendee(m, r);
    }
    
    public void createMember()
    {
    }
    
    public void editMember()
    {
    }
    
    public void deleteMember()
    {
    }
    
    public void addHousehold()
    {
    }
    
    public void editHousehold()
    {
    }
    
    public void deleteHousehold()
    {
    }
    
    public void setHouseholdLeader(Household group, HouseholdLeader hhl)
    {
        group.setLeader(hhl);
    }
	
	public String toString() {
		return prefix + " " + firstname + " '" + nickname + "' " + middlename + " " + lastname;
	}

	/* (non-Javadoc)
	 * @see model.MemberAdmin#createMember(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void createMember(String position, String fn, String mn, String ln,
			String nn) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see model.MemberAdmin#deleteMember(model.Participant)
	 */
	@Override
	public void deleteMember(Participant p) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void takeAttendance(EventRole r, Member m, Event e) {
		// TODO Auto-generated method stub
		
	}
}