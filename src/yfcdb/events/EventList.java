package yfcdb.events;

import yfcdb.member.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class EventList {
    private ArrayList<Event> eventArrayList;
    private static EventList eventList = new EventList();

    public EventList() {
        eventArrayList = new ArrayList<Event>();
        populateList();
    }

    public static EventList getInstance() {
        return eventList;
    }

    public void populateList() {
        Date startDate = new Date();
        Date endDate = new Date();
        Event e1 = new Event("YFC Camp", EventType.YOUTH_CAMP, "Learning links", "", 100, startDate, endDate);

        eventArrayList.add(e1);
    }

    public void addEvent(Event event) {
        eventArrayList.add(event);
    }

    public boolean contains(Event event) {
        return eventArrayList.contains(event);
    }

    public void print() {
        for (Event event: eventArrayList) {
            System.out.println(event);
        }

        System.out.println(eventArrayList.size());
    }

    public ArrayList<Event> getEventArrayList() {
        return eventArrayList;
    }
}
