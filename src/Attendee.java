/**
 * Write a description of class Attendance here.
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Attendee
{
    public Member member;
    private String role;
    
    public Attendee(Member m, String r)
    {
        member = m;
        role = r;
    }
    
    public String getAttendee()
    {
        return member + " \t - " + role;
    }
}
