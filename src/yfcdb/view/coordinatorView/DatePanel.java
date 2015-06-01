package yfcdb.view.coordinatorView;

import yfcdb.member.Member;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 22/05/15.
 */
public class DatePanel extends JPanel implements ActionListener {
    private static final String[] monthList = {"January", "February", "March", "April", "May", "June", "July",
            "August", "September", "October", "November", "December"};
    private static final int yearRange = 23;

    private JComboBox jcbMonth, jcbDay, jcbYear;

    private MemberInfoPanel.BriefingPanel personalPanel;

    public DatePanel(MemberInfoPanel.BriefingPanel personalPanel) {
        this();
        this.personalPanel = personalPanel;
    }

    public DatePanel() {
        super(new FlowLayout(FlowLayout.LEFT));

        Calendar cal = Calendar.getInstance();
        final String[] dayList = new String[31];
        for (int i = 0; i < dayList.length; ++i) { dayList[i] = Integer.toString(i+1); }
        int currentYear = cal.get(Calendar.YEAR);
        String[] yearList = new String[yearRange];
        for (int i = 0; i < yearList.length; i++) { yearList[i] = Integer.toString(currentYear-i); }

        //month
        jcbMonth = new JComboBox(monthList);
        int currentMonth = cal.get(Calendar.MONTH);
        jcbMonth.setSelectedIndex(currentMonth);
        jcbMonth.addActionListener(this);

        //day
        jcbDay = new JComboBox(dayList);
        int currentDay = cal.get(Calendar.DATE);
        jcbDay.setSelectedItem(Integer.toString(currentDay));
        jcbDay.addActionListener(this);

        //year
        jcbYear = new JComboBox(yearList);
        jcbYear.addActionListener(this);

        add(jcbMonth);
        add(jcbDay);
        add(jcbYear);
    }

    public int getYearsFromToday() {
        int year = Integer.parseInt((String)jcbYear.getSelectedItem());
        int month = jcbMonth.getSelectedIndex() - 1;
        int day = Integer.parseInt((String)jcbYear.getSelectedItem());

        System.out.println(year);

        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        Date date = c.getTime();

        Calendar calBirthday = Calendar.getInstance();
        Calendar calToday = Calendar.getInstance();
        calBirthday.setTime(date);

        int difference_years = calToday.get(Calendar.YEAR) - calBirthday.get(Calendar.YEAR);

        if (calToday.get(Calendar.MONTH) < calBirthday.get(Calendar.MONTH)) {
            difference_years--;
        } else if ((calToday.get(Calendar.MONTH) == calBirthday.get(Calendar.MONTH))
                && (calToday.get(Calendar.DAY_OF_MONTH) < calBirthday.get(Calendar.DAY_OF_MONTH))) {
            difference_years--;
        }

        return difference_years;
    }

    public void setDate(Date birthday) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthday);
        jcbMonth.setSelectedIndex(cal.get(Calendar.MONTH));
        jcbDay.setSelectedIndex(cal.get(Calendar.DAY_OF_MONTH) - 1);
        jcbYear.setSelectedItem(String.valueOf(cal.get(Calendar.YEAR)));
    }

    public Date getDate() {
        Calendar cal = Calendar.getInstance();
        int year = Integer.parseInt((String)jcbYear.getSelectedItem());
        int month = jcbMonth.getSelectedIndex() - 1;
        int day = Integer.parseInt((String)jcbYear.getSelectedItem());

        cal.set(year, month-1, day);
        Date date = cal.getTime();

        return date;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        personalPanel.setAge(getYearsFromToday());
    }
}
