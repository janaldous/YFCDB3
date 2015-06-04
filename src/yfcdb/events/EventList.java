package yfcdb.events;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import yfcdb.member.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class EventList {
    private static ArrayList<Event> eventArrayList;
    private static EventList eventList = new EventList();

    public EventList() {
        eventArrayList = new ArrayList<Event>();
        //uploadFromFile();
    }

    public static EventList getInstance() {
        return eventList;
    }

    public void setEventArrayList(ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
    }

    public void addEvent(Event event) {
        if (!eventArrayList.contains(event)) {
            eventArrayList.add(event);
        }
    }

    public boolean contains(Event event) {
        return eventArrayList.contains(event);
    }

    public boolean removeEvent(Event event) {
        return eventArrayList.remove(event);
    }

    public void print() {
        for (Event event: eventArrayList) {
            System.out.println(event);
        }

        System.out.println(eventArrayList.size());
    }

    //TODO potentially dangerous to do this. should not reveal insides
    public ArrayList<Event> getEventArrayList() {
        return eventArrayList;
    }

    public ArrayList<Event> getEventsOn(int month, int year) {
        ArrayList<Event> list = new ArrayList<Event>();
        for (Event event: eventArrayList) {
            if (event.wasOn(month, year)) {
                list.add(event);
            }
        }
        return list;
    }

    public ArrayList<Event> getEventsOfType(EventType type, Date start, Date end) {
        ArrayList<Event> list = new ArrayList<Event>();
        for (Event event: eventArrayList) {
            if (event.getType().equals(type)
                    && event.getStartDate().after(start) && event.getEndDate().before(end)) {
                list.add(event);
            }
        }
        return list;
    }
}
