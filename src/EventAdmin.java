/**
 * 
 */

/**
 * @author janaldoustorres
 * @version 2.0
 */
public interface EventAdmin {
	public void createEvent();
	public void editEvent();
	public void deleteEvent();
	public void takeAttendance(EventRole r, Member m, Event e);
}
