package yfcdb.files;

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;
import yfcdb.events.EventList;
import yfcdb.member.PersonList;

import java.io.*;

/**
 * Created by janaldoustorres on 03/06/15.
 */
public class Files {
    private final static String filename = "yfc.json";

    public static void saveToFile() throws IOException {
        FileWriter file = new FileWriter(filename);
        file.write(JsonWriter.objectToJson(new YFCFiles()));
        file.flush();
        file.close();
    }

    public static void uploadFromFile() throws FileNotFoundException {
        JsonReader jr = new JsonReader(new FileInputStream(filename));
        YFCFiles yfcFiles = (YFCFiles)jr.readObject();
        PersonList personList = PersonList.getInstance();
        personList.setPersonArrayList(yfcFiles.getPersonArrayList());
        EventList eventList = EventList.getInstance();
        eventList.setEventArrayList(yfcFiles.getEventArrayList());

    }
}
