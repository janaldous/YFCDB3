/**
 * 
 */

import java.util.ArrayList;

/**
 * @author Jat Torres
 * @version 2.0
 */
public class HouseholdList {
	private static ArrayList<Household> households = new ArrayList<Household>();
	
	public static void addHousehold(Household h) {
		households.add(h);
	}
}
