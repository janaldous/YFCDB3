/**
 * 
 */

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jat Torres
 * @version 2.0
 */
public class EventList {
	private static Map<Date,Event> events = new HashMap<Date, Event>();
	
	public static void addEvent(Event e) {
		events.put(e.getDate(), e);
	}

	public static void deleteEvent(Event e) {
		events.remove(e);
	}
}
