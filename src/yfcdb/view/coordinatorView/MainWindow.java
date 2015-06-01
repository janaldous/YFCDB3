package yfcdb.view.coordinatorView;

import yfcdb.events.Event;
import yfcdb.events.EventList;
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
    private final static Dimension preferredSize = new Dimension(1000, 700);

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
                    if (list.getModel() == memberListModel) {
                        if (e.getClickCount() == doubleClick) {// Double-click detected
                            int index = list.locationToIndex(e.getPoint());

                            Member memberToShow = (Member) memberListModel.getElementAt(index);
                            changeCenterPanelToMember(memberToShow);
                        }
                    } else if (list.getModel() == eventListModel) {
                        if (e.getClickCount() == doubleClick) {// Double-click detected
                            int index = list.locationToIndex(e.getPoint());

                            Event eventToShow = (Event) eventListModel.getElementAt(index);
                            changeCenterPanelToEvent(eventToShow);
                        }
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
                    //TODO add observer here when a member is added/deleted
                    populateMemberList();
                    jlistMembersList.setModel(memberListModel);
                }
            });
            jpBottom.add(jbMember);
            JButton jbEvent = new JButton("Events");
            jbEvent.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    populateEventList();
                    jlistMembersList.setModel(eventListModel);
                }
            });
            jpBottom.add(jbEvent);

            add(jpBottom, BorderLayout.SOUTH);
        }

        private void populateMemberList() {
            memberListModel.clear();
            MemberList memberList = MemberList.getInstance();
            for (Member member: memberList.getMemberArrayList()) {
                memberListModel.addElement(member);
            }
        }

        private void populateEventList() {
            eventListModel.clear();
            EventList eventList = EventList.getInstance();
            for (Event event: eventList.getEventArrayList()) {
                eventListModel.addElement(event);
            }
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

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMenuBar(setupMenuBar());
        setPreferredSize(preferredSize);

        centerPanel = new JPanel();
        //centerPanel = new JP("New Event");

        add(new SidePanel(), BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);

        pack();
    }

    private MenuBar setupMenuBar() {
        MenuBar menuBar = new MenuBar();
        Menu mFile = new Menu("File");
        MenuItem miAbout = new MenuItem("About");
        mFile.add(miAbout);
        MenuItem miMakeReport = new MenuItem("Make report");
        miMakeReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReportWizardDialog().setVisible(true);
            }
        });
        mFile.add(miMakeReport);

        Menu mEdit = new Menu("Edit");
        Menu mView = new Menu("View");

        Menu mEvents = new Menu("Events");
        MenuItem miAddEvent = new MenuItem("Add event");
        miAddEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCenterPanelToNewEvent();
            }
        });
        mEvents.add(miAddEvent);
        MenuItem miViewEvents = new MenuItem("View events table");
        miViewEvents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCenterPanelToEventTable();
            }
        });
        mEvents.add(miViewEvents);

        Menu mMember = new Menu("Member");
        MenuItem miAddMember = new MenuItem("Add member");
        miAddMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCenterPanelToNewMember();
            }
        });
        mMember.add(miAddMember);
        MenuItem miViewMembers = new MenuItem("View member table");
        miViewMembers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeCenterPanelToMemberTable();
            }
        });
        mMember.add(miViewMembers);

        menuBar.add(mFile);
        menuBar.add(mEdit);
        menuBar.add(mView);
        menuBar.add(mEvents);
        menuBar.add(mMember);

        return menuBar;
    }

    private void changeCenterPanelToNewEvent() {
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("<html><h1>New Event</h1></html>"), BorderLayout.NORTH);
        panel.add(new EventsInfoPanel(), BorderLayout.CENTER);
        changeCenterPanel(panel);
    }

    private void changeCenterPanelToNewMember() {
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("<html><h1>New Member</h1></html>"), BorderLayout.NORTH);
        panel.add(new JScrollPane(new MemberInfoPanel(new Member())), BorderLayout.CENTER);
        changeCenterPanel(panel);
    }

    private void changeCenterPanelToMember(Member member) {
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        changeCenterPanel(new MemberTabbedPanel(member));
    }

    private void changeCenterPanelToEvent(Event event) {
        //TODO make MemberInfoPanel a singleton, to make it more efficient
        changeCenterPanel(new EventsInfoPanel(event));

    }

    private void changeCenterPanelToMemberTable() {
        changeCenterPanel(new MembersTablePanel());
    }

    private void changeCenterPanelToEventTable() {
        changeCenterPanel(new EventsTablePanel());
    }

    private void changeCenterPanel(JPanel panel) {
        remove(centerPanel);
        centerPanel = panel;
        add(centerPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        new MainWindow().setVisible(true);
    }
}
