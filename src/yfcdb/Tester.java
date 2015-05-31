package yfcdb;

import yfcdb.events.Event;
import yfcdb.events.EventType;
import yfcdb.events.Role;
import yfcdb.member.*;
import yfcdb.yfcdb.household.Household;

/**
 * Created by janaldoustorres on 19/05/15.
 */
public class Tester {
    public static void main(String[] args) {
        YFCGroup chapterC = new YFCGroup("C", "C");
        Address address = new Address("109 Mahogany", "Sta Rosa", "Laguna", "4026");
        Person jat = new Member(Position.MEMBER, "Jan Aldous", "Turla", "Torres", "Jat", chapterC, address);
        Person rese = new Member(Position.MEMBER, "therese", "a ", "catindig", "rhea", chapterC, address);
        Person mom = new Coordinator(Prefix.TITA, "Elsie", "Turla", "Torres", "Elsie", chapterC);
        Person chels = new HouseholdLeader("chelsie", "erica", "torres", "chels", chapterC);

        Event camp = new Event("Youthcamp2015", EventType.YOUTH_CAMP, "place", "notes", 200, 1, 2, 1994, 900, 1000);
        camp.addAttendee(jat, Role.PRESENT);
        camp.addAttendee(mom, Role.PRESENT);

        Household hh = new Household((HouseholdLeader)chels);
        hh.addMember(jat);
        hh.addMember(rese);

        System.out.println(jat);
        System.out.println(mom);
        System.out.println(chels);
        System.out.println(camp);
        System.out.println(hh);

        hh.removeMember(jat);
        System.out.println(hh);
    }
}
