package yfcdb.view.coordinatorView;

import yfcdb.member.Member;

import javax.swing.*;
import java.awt.*;

/**
 * Created by janaldoustorres on 29/05/15.
 */
public class MemberTabbedPanel extends JPanel {
    private Member member;

    public MemberTabbedPanel(Member member) {
        this.member = member;

        setLayout(new BorderLayout());

        JTabbedPane jtpTabs = new JTabbedPane();
        jtpTabs.addTab("Personal", new JScrollPane(new MemberInfoPanel(member)));
        jtpTabs.addTab("Household", new MemberHouseholdPanel(member));
        jtpTabs.addTab("Attendance", new MemberAttendancePanel(member));
        //jtpTabs.add("Upcoming events", new JScrollPane(new UpcomingEventsPanel()));

        add(jtpTabs, BorderLayout.CENTER);
    }
}
