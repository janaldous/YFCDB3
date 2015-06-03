package yfcdb.files;

import yfcdb.events.Event;
import yfcdb.events.EventList;
import yfcdb.member.Person;
import yfcdb.member.PersonList;

import java.util.ArrayList;

/**
 * Created by janaldoustorres on 03/06/15.
 */
public class YFCFiles {
    private PersonList personList;
    private EventList eventList;

    public YFCFiles() {
        personList = PersonList.getInstance();
        eventList = EventList.getInstance();
    }

    public PersonList getPersonList() {
        return personList;
    }

    public EventList getEventList() {
        return eventList;
    }
}
