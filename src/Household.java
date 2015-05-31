import java.util.ArrayList;

/**
 * Write a description of class HH here.
 * 
 * @author Jat Torres
 * @version 2.0
 */
public class Household
{
    private static int groupCtr = 0;
	private int groupNumber = 0;
    private HouseholdLeader hhLeader;
    private ArrayList<Participant> memberList = new ArrayList<Participant>();

    public Household(HouseholdLeader hhl)
    {
        groupCtr += groupCtr;
        groupNumber = groupCtr;
        hhLeader = hhl;
        HouseholdList.addHousehold(this);
    }
    
    public int getGroupNumber() {
    	return groupNumber;
    }

    public void setLeader(HouseholdLeader hhl)
    {
        hhLeader = hhl;
    }

    public void addMember(Participant m)
    {
        memberList.add(m);
    }

    public void removeMember(Participant m)
    {
    	memberList.remove(m);
    }

    public String getMembers()
    {
    	String stringList = "";
    	for(Participant item: memberList){
    		stringList += item + "\n";
    	}
        return stringList;
    }
    
    public String getContactInfo()
    {
    	String stringList = "";
    	for(Participant item: memberList){
    		stringList += item + ":" + item.getContactDetails() + "\n";
    	}
        return stringList;
    }

    public void print()
    {
        System.out.println(this.groupNumber);
        System.out.println(hhLeader);
        System.out.println(getMembers());
    }
}