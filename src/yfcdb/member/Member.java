package yfcdb.member;

/**
 * Created by janaldoustorres on 19/05/15.
 */
import com.sun.javafx.geom.AreaOp;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Member extends Person {
    private Address address;
    private boolean kfcToYfc;
    private BloodType bloodType;
    private Education education;
    private Parent mother, father;
    private ArrayList<EmergencyContact> emergencyContactList;
    private int yfcEntryYear;
    private ShirtSize shirtSize;
    private String specialSkills, illness;
    private ArrayList<SeminarRetreat> seminarRetreatList;

    public Member() {
        super();
        position = Position.MEMBER;

        address = new Address();
        education = new Education();
        father = new Parent();
        mother = new Parent();
        emergencyContactList = new ArrayList<EmergencyContact>();
        seminarRetreatList = new ArrayList<SeminarRetreat>();
    }

    public Member(Position pos, String fn, String mn, String ln, String nn, YFCGroup group, Address address) {
        super(pos, fn, mn, ln, nn, group);
        this.address = address;
    }

    public Parent getMother() {
        return mother;
    }

    public void setMother(Parent mother) {
        this.mother = mother;
    }

    public Parent getFather() {
        return father;
    }

    public void setFather(Parent father) {
        this.father = father;
    }

    public void addEmergencyContact(EmergencyContact ec) {
        emergencyContactList.add(ec);
    }

    public ArrayList<EmergencyContact> getEmergencyContactList() { return emergencyContactList; }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String isKfcTransfer() {
        if (kfcToYfc == true) {
            return "Y";
        }
        return "N";
    }

    public void setKfcToYfc(boolean kfcToYfc) {
        this.kfcToYfc = kfcToYfc;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public int getYfcAge() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) - yfcEntryYear;
    }

    public int getYfcEntryYear() {
        return this.yfcEntryYear;
    }

    public void setYfcEntryYear(int yfcEntryYear) {
        this.yfcEntryYear = yfcEntryYear;
    }

    public ShirtSize getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(ShirtSize shirtSize) {
        this.shirtSize = shirtSize;
    }

    public String getSpecialSkills() {
        return specialSkills;
    }

    public void setSpecialSkills(String specialSkills) {
        this.specialSkills = specialSkills;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    public void addSeminarRetreatList(SeminarRetreat seminarRetreat) {
        this.seminarRetreatList.add(seminarRetreat);
    }

    public void setSeminarRetreatList(ArrayList<SeminarRetreat> seminarRetreatList) {
        this.seminarRetreatList = seminarRetreatList;
    }

    public ArrayList<SeminarRetreat> getSeminarRetreatList() {
        return seminarRetreatList;
    }
}
