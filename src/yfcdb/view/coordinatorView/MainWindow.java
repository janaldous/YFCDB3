package yfcdb.view.coordinatorView;

import yfcdb.member.Member;
import yfcdb.member.MemberList;
import yfcdb.member.Position;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by janaldoustorres on 23/05/15.
 */
public class MainWindow extends JFrame {
    private JPanel centerPanel;
    private final static Dimension preferredSize = new Dimension(900, 700);

    private class SidePanel extends JPanel {
        private JTextField jtfSearchBar;
        private DefaultListModel memberListModel, eventListModel;
        private JList jlistMembersList;
        private SidePanel() {
            setLayout(new BorderLayout());

            jtfSearchBar = new JTextField(15);

            memberListModel = new DefaultListModel();
            eventListModel = new DefaultListModel();

            populateMemberList();
            populateEventList();

            jlistMembersList = new JList(memberListModel);
            jlistMembersList.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int doubleClick = 2;
                    JList list = (JList)e.getSource();
                    if (e.getClickCount() == doubleClick) {// Double-click detected
                        int index = list.locationToIndex(e.getPoint());

                        Member memberToShow = (Member) memberListModel.getElementAt(index);
                        changeCenterPanel(memberToShow);
                    }
                }
            });


            add(jtfSearchBar, BorderLayout.NORTH);
            add(jlistMembersList, BorderLayout.CENTER);

            JPanel jpBottom = new JPanel(new GridLayout(1,2));
            JButton jbMember = new JButton("Members");
            jbMember.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jlistMembersList.setModel(memberListModel);
                }
            });
            jpBottom.add(jbMember);
            JButton jbEvent = new JButton("Events");
            jbEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jlistMembersList.setModel(eventListModel);
                }
            });
            jpBottom.add(jbEvent);

            add(jpBottom, BorderLayout.SOUTH);
        }

        private void populateMemberList() {
            MemberList memberList = MemberList.getInstance();
            for (Member member: memberList.getMemberArrayList()) {
                memberListModel.addElement(member);
            }
        }

        private void populateEventList() {
            eventListModel.addElement("YFC Camp");
            eventListModel.addElement("YFC Chapter Assembly");
        }
    }

    private class MembersTablePanel extends JPanel {
        private MembersTablePanel() {
            setLayout(new BorderLayout());
            JLabel jlTitle = new JLabel("Members List");

            String[] columnNames = {"Last Name", "First Name", "Age"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0);
            defaultTableModel.addRow(new Object[] {"Torres", "Jat", 3});
            defaultTableModel.addRow(new Object[] {"Torres", "Cheslie", 16});
            defaultTableModel.addRow(new Object[] {"Torres", "Elsie", 48798});

            JTable jtMembers = new JTable(defaultTableModel);
            ListSelectionModel listSelectionModel = jtMembers.getSelectionModel();
            listSelectionModel.addListSelectionListener(new ListSelectionHandler());
            jtMembers.setSelectionModel(listSelectionModel);


            add(jlTitle, BorderLayout.NORTH);
            add(new JScrollPane(jtMembers), BorderLayout.CENTER);
        }
    }

    private class LeadersTablePanel extends JPanel {
        private LeadersTablePanel() {
            setLayout(new BorderLayout());
            JLabel jlTitle = new JLabel("Leaders List");

            String[] columnNames = {"Position", "Last Name", "First Name", "Age"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0);
            defaultTableModel.addRow(new Object[] {Position.CHAPTER_HEAD, "Torres", "Jat", 3});
            defaultTableModel.addRow(new Object[] {Position.HOUSEHOLD_HEAD, "Torres", "Cheslie", 16});
            defaultTableModel.addRow(new Object[] {Position.HOUSEHOLD_HEAD, "Torres", "Elsie", 48798});

            JTable jtMembers = new JTable(defaultTableModel);

            add(jlTitle, BorderLayout.NORTH);
            add(new JScrollPane(jtMembers), BorderLayout.CENTER);
        }
    }

    private class EventsTablePanel extends JPanel {
        private EventsTablePanel() {
            setLayout(new BorderLayout());
            JLabel jlTitle = new JLabel("Events List");

            String[] columnNames = {"Date", "Name", "Type", "Venue", "Attendees"};
            DefaultTableModel defaultTableModel = new DefaultTableModel(columnNames, 0);
            defaultTableModel.addRow(new String[] {"2/15/2013", "Parents Honoring", "PF", "SRE clubhouse", "3"});
            defaultTableModel.addRow(new String[] {"2/14/2013", "Chapter Assembly", "CA", "JP2", "6"});
            defaultTableModel.addRow(new String[] {"11,25,2012", "Chapter Assembly", "CA", "JP2", "5"});


            JTable jtEventsTable = new JTable(defaultTableModel);
            jtEventsTable.setSelectionModel(new TableSelectionModel());


            add(jlTitle, BorderLayout.NORTH);
            add(new JScrollPane(jtEventsTable), BorderLayout.CENTER);
        }
    }

    private class TableSelectionModel extends DefaultListSelectionModel {
        @Override
        public void addListSelectionListener(ListSelectionListener l) {
            super.addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    System.out.println(e.getLastIndex());
                }
            });
        }
    }

    @Deprecated
    private class ListSelectionHandler implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMenuBar(setupMenuBar());
        setPreferredSize(preferredSize);

        centerPanel = new JPanel();

        add(new SidePanel(), BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);



        pack();
    }

    private MenuBar setupMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu mFile = new Menu("File");
        MenuItem miAbout = new MenuItem("About");
        MenuItem miAddMember = new MenuItem("Add member");
        miAddMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCenterPanel();
            }
        });
        mFile.add(miAbout);
        mFile.add(miAddMember);

        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");

        menuBar.add(mFile);
        menuBar.add(mEdit);
        menuBar.add(mView);

        return menuBar;
    }

    private void changeCenterPanel() {
        remove(centerPanel);
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("<html><h1>New Member</h1></html>"), BorderLayout.NORTH);
        panel.add(new MemberInfoPanel(), BorderLayout.CENTER);
        centerPanel = panel;
        add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void changeCenterPanel(Member member) {
        remove(centerPanel);
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        centerPanel = new MemberTabbedPanel(member);
        add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }
}
