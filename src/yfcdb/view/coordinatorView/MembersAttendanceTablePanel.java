package yfcdb.view.coordinatorView;

import yfcdb.events.Role;
import yfcdb.member.Member;
import yfcdb.member.MemberList;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class MembersAttendanceTablePanel extends JPanel {
    private DefaultTableModel defaultTableModel;

    public MembersAttendanceTablePanel() {
        setLayout(new BorderLayout());
        JLabel jlTitle = new JLabel("Members List");

        String[] columnNames = {"Name", "Role"};
        defaultTableModel = new DefaultTableModel(columnNames, 0);


        JTable jtMembers = new JTable(defaultTableModel);
        jtMembers.setPreferredScrollableViewportSize(new Dimension(200, 300));
        setUpRoleColumn(jtMembers.getColumnModel().getColumn(1));
        populateTable();

        add(jlTitle, BorderLayout.NORTH);
        add(new JScrollPane(jtMembers), BorderLayout.CENTER);
    }

    private void populateTable() {
        ArrayList<Member> memberList = MemberList.getMemberArrayList();
        for (Member member : memberList) {
            defaultTableModel.addRow(member.toAttendanceArray());
        }
    }

    private void setUpRoleColumn(TableColumn roleColumn) {
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("");
        for (Role role: Role.values()) {
            comboBox.addItem(role);
        }
        roleColumn.setCellEditor(new DefaultCellEditor(comboBox));

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click to mark present, leave blank for absent");
        roleColumn.setCellRenderer(renderer);
    }

    public void setInfo() {

    }

    public void getInfo() {

    }
}
