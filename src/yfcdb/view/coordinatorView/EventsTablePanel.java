package yfcdb.view.coordinatorView;

import yfcdb.events.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class EventsTablePanel extends JPanel {
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
    private final DefaultTableModel defaultTableModel;

    public EventsTablePanel() {
        setLayout(new BorderLayout());
        JLabel jlTitle = new JLabel("Events List");

        String[] columnNames = {"Date", "Name", "Type", "Venue", "Topics", "Attendees"};
        defaultTableModel = new DefaultTableModel(columnNames, 0);

        populateTable();


        JTable jtEventsTable = new JTable(defaultTableModel);
        jtEventsTable.setSelectionModel(new TableSelectionModel());


        add(jlTitle, BorderLayout.NORTH);
        add(new JScrollPane(jtEventsTable), BorderLayout.CENTER);
    }

    private void populateTable() {
        EventList eventList = EventList.getInstance();
        for (yfcdb.events.Event event: eventList.getEventArrayList()) {
            defaultTableModel.addRow(event.toArray());
        }
    }


}
