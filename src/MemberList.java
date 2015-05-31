/**
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Jat Torres
 * @version 2.0
 */
public class MemberList {
	private static ArrayList<Participant> participants = new ArrayList<Participant>();
	private static ArrayList<Coordinator> coordinators = new ArrayList<Coordinator>();
	
	public static void addParticipant(Participant m) {
		participants.add(m);
	}
	
	public static void addCoordinator(Coordinator c) {
		coordinators.add(c);
	}
	
	public static void deleteParticipant(Participant m) {
		participants.remove(m);
	}
	
	public static void deleteCoordinator(Coordinator c) {
		coordinators.remove(c);
	}
	
	public static void iterateParticipants() {
		Iterator<Participant> iterator = participants.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void iterateCoordinators() {
		Iterator<Coordinator> iterator = coordinators.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	
	public static void iterateMembers() {
		iterateParticipants();
		iterateCoordinators();
	}
}
