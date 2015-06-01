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

    @Deprecated
    public void populateList() {
        Date startDate = new Date();
        Date endDate = new Date();
        Event e1 = new Event("YFC Camp", EventType.YOUTH_CAMP, "Learning links", "", 100, startDate, endDate);

        eventArrayList.add(e1);
    }

    public void addEvent(Event event) {
        if (!eventArrayList.contains(event)) {
            eventArrayList.add(event);
        }
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

    public static void saveToFile() throws IOException {
        FileWriter file = null;
            file = new FileWriter("events.json");

            file.write(JsonWriter.objectToJson(eventArrayList));

            file.flush();
            file.close();

    }

    public static void uploadFromFile() throws IOException {
            BufferedReader br = new BufferedReader(new FileReader(new File("events.json")));
            String line;
            int c = 0;
            while ((line = br.readLine()) != null) {
                eventArrayList = (ArrayList<Event>) JsonReader.jsonToJava(line);
                c++;
            }
            System.out.println(c);
    }
}
