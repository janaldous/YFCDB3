package yfcdb.view.coordinatorView;

import yfcdb.events.EventList;
import yfcdb.member.Member;
import yfcdb.member.Person;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by janaldoustorres on 22/05/15.
 */
public class MemberAttendancePanel extends JPanel {
    private Member member;
    private DefaultTableModel defaultTableModel;
    private int attendedEvents = 0;

    //TODO fix this=============================================================================
    public MemberAttendancePanel() {
        setLayout(new BorderLayout());
        String[] columnNames = {"Date", "Event", "Role"};
        defaultTableModel = new DefaultTableModel(columnNames, 0);
        populateTable();

        JTable jtTable = new JTable(defaultTableModel); //TODO fix this table

        JLabel jlPrompt = new JLabel("You have attended " + attendedEvents + " events");

        add(new JScrollPane(jtTable), BorderLayout.CENTER);
        add(jlPrompt, BorderLayout.SOUTH);
    }

    private void populateTable() {
        EventList eventList = EventList.getInstance();

        for (yfcdb.events.Event event: eventList.getEventArrayList()) {
            if (event.wasAttendedBy(member)) {
                defaultTableModel.addRow(event.toArray(member));
            }
        }
        attendedEvents = defaultTableModel.getRowCount();
    }

    public MemberAttendancePanel(Member member) {
        this();
        System.out.println("-"+member);
        this.member = member;
    }
}
