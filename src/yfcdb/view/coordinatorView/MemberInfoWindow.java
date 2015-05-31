package yfcdb.view.coordinatorView;

import yfcdb.member.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by janaldoustorres on 22/05/15.
 */
public class MemberInfoWindow extends JFrame {
    private class TopPanel extends JPanel {
        private TopPanel() {
            JButton jbPrevious = new JButton("<<<<");
            JLabel jlCurrentMember = new JLabel("This Member");
            JButton jbNext = new JButton(">>>>");

            add(jbPrevious);
            add(jlCurrentMember);
            add(jbNext);
        }
    }

    public MemberInfoWindow() {
        super("Member Info");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //Sample data ===================================


        //System.out.println((jat.getEmergencyContactList().get(0)).equals(jat.getMother()));

        //=================================================

        JTabbedPane jtpTabs = new JTabbedPane();
        //jtpTabs.addTab("Personal", new JScrollPane(new MemberInfoPanel(jat)));
        //jtpTabs.addTab("Household", new MemberHouseholdPanel());
        jtpTabs.addTab("Attendance", new MemberAttendancePanel());
        jtpTabs.add("Upcoming events", new JScrollPane(new UpcomingEventsPanel()));


        add(new TopPanel(), BorderLayout.NORTH);
        add(jtpTabs, BorderLayout.CENTER);

        pack();
    }

    public static void main(String[] args) {
        new MemberInfoWindow().setVisible(true);
    }
}
