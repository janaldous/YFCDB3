package yfcdb.view.coordinatorView;

import yfcdb.member.Member;
import yfcdb.member.MemberList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by janaldoustorres on 31/05/15.
 */
public class MembersTablePanel extends JPanel {
    private DefaultTableModel defaultTableModel;

    public MembersTablePanel() {
        setLayout(new BorderLayout());
        JLabel jlTitle = new JLabel("Members List");

        String[] columnNames = {"Last Name", "First Name", "Age"};
        defaultTableModel = new DefaultTableModel(columnNames, 0);


        JTable jtMembers = new JTable(defaultTableModel);
        populateTable();

        add(jlTitle, BorderLayout.NORTH);
        add(new JScrollPane(jtMembers), BorderLayout.CENTER);
    }

    private void populateTable() {
        ArrayList<Member> memberList = MemberList.getMemberArrayList();
        for (Member member: memberList) {
            defaultTableModel.addRow(member.toAttendanceArray());
        }
    }
}
