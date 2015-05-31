/**
 * 
 */

/**
 * @author Jat Torres
 * @version 2.0
 */
public class HouseholdLeader extends Participant {
	private Household group;
    
	/**
	 * 
	 * Constructs household leader using position and names
	 * @param fn
	 * @param mn
	 * @param ln
	 * @param nn
	 */
    public HouseholdLeader(String fn, String mn, String ln, String nn)
    {
        super("hh", fn, mn, ln, nn);
        group = new Household(this);
        setDateUpdated();
    }
    
    /**
     * Assigns group to household leader
     * @param g household group
     */
    public void setGroup(Household g)
    {
        group = g;
        setDateUpdated();
    }
    
    /**
     * 
     * prints list of contact info of each group member
     */
    public void getContacts()
    {
        System.out.println(group.getContactInfo());
    }
}
