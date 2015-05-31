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
    private int age;
    private boolean kfcToYfc;
    private BloodType bloodType;
    private Education education;
    private Parent mother, father;
    private ArrayList<EmergencyContact> emergencyContactList;
    private int yfcEntryYear;
    private String gender;
    private ShirtSize shirtSize;
    private Date birthday;
    private String specialSkills, illness;
    private ArrayList<SeminarRetreat> seminarRetreatList;
    private Position position;

    public Member() {
        position = Position.MEMBER;
        setUsername();
        setDateUpdated();
    }

    public Member(Position pos, String fn, String mn, String ln, String nn, YFCGroup group, Address address) {
        setID(numberOfMembers++);
        position = pos;
        firstname = fn;
        middlename = mn;
        lastname = ln;
        nickname = nn;
        this.group = group;
        this.address = address;

        education = new Education();
        father = new Parent();
        mother = new Parent();
        emergencyContactList = new ArrayList<EmergencyContact>();
        seminarRetreatList = new ArrayList<SeminarRetreat>();

        setUsername();
        setDateUpdated();
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

    public YFCGroup getGroup() {
        return group;
    }

    public void setGroup(YFCGroup group) {
        this.group = group;
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

    public int getAge() {
        Calendar calBirthday = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();
        calBirthday.setTime(birthday);

        int age = calToday.get(Calendar.YEAR) - calBirthday.get(Calendar.YEAR);

        if (calToday.get(Calendar.MONTH) < calBirthday.get(Calendar.MONTH)) {
            age--;
        } else if ((calToday.get(Calendar.MONTH) == calBirthday.get(Calendar.MONTH))
                && (calToday.get(Calendar.DAY_OF_MONTH) < calBirthday.get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        this.age = age;
        return age;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ShirtSize getShirtSize() {
        return shirtSize;
    }

    public void setShirtSize(ShirtSize shirtSize) {
        this.shirtSize = shirtSize;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month-1, day);
        this.birthday = c.getTime();
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    @Override
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String[] toAttendanceArray() {
        return new String[] {this.toString(), ""};
    }
}
