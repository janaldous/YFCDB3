/**
 * 
 */

/**
 * Provides methods to manipulate household records including appointing a household leader
 * @author Jat Torres
 * @version 2.0
 */
public interface HouseholdAdmin {
	public void addHousehold();
	public void editHousehold();
	public void deleteHousehold();
	public void setHouseholdLeader(Household group, HouseholdLeader hhl);
}
