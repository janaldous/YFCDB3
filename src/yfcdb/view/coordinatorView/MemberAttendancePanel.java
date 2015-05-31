package yfcdb.view.coordinatorView;

import yfcdb.member.Member;

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
        defaultTableModel.addRow(new String[]{"today", "breakfast", "P"});
        defaultTableModel.addRow(new String[]{"today", "breakfast", "P"});
        defaultTableModel.addRow(new String[]{"today", "breakfast", "P"});
    }

    public MemberAttendancePanel(Member member) {
        this();
        this.member = member;
    }
}
