/**
 * 
 */

/**
 * @author janaldoustorres
 * @version 2.0
 */
public interface MemberAdmin {
	public void createMember(String position, String fn, String mn, String ln,
                             String nn);
	public void editMember();
	public void deleteMember(Participant p);
}
