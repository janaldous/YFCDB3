package yfcdb.member;

/**
 * Created by janaldoustorres on 02/06/15.
 */

import com.cedarsoftware.util.io.JsonReader;
import com.cedarsoftware.util.io.JsonWriter;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by janaldoustorres on 29/05/15.
 */
public class PersonList {
    private static ArrayList<Person> personArrayList;
    private static PersonList personList = new PersonList();

    public PersonList() {
        personArrayList = new ArrayList<Person>();
        //uploadFromFile();
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public static PersonList getInstance() {
        return personList;
    }

    public void setPersonArrayList(ArrayList<Person> personArrayList) {
        this.personArrayList = personArrayList;
    }

    public void addPerson(Person person) {
        personArrayList.add(person);
    }

    public boolean contains(Person person) {
        if (personArrayList.contains(person)) return true;
        return false;
    }

    public boolean removePerson(Person person) {
        return personArrayList.remove(person);
    }

    public void print() {
        for (Person person: personArrayList) {
            System.out.println(person);
        }

        System.out.println(personArrayList.size());
    }

    public String getChapterLeaders() {
        String out = "";
        for (Person person: personArrayList) {
            System.out.println("+");
            if (person.getPosition().equals(Position.CHAPTER_LEADER)) {
                out += person.getFullName() + "/";
                System.out.println(out);
            }
        }
        return out;
    }
}

