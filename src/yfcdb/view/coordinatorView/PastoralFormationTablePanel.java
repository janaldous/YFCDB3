package yfcdb.view.coordinatorView;

import yfcdb.events.Event;
import yfcdb.events.EventList;
import yfcdb.events.EventType;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by janaldoustorres on 05/06/15.
 */
public class PastoralFormationTablePanel extends JPanel implements TablePanelTemplate {
    private final DefaultTableModel defaultTableModel;

    public PastoralFormationTablePanel() {
        setLayout(new BorderLayout());

        JLabel jlTitle = new JLabel("<html><h1>Pastoral Formation Table</h1></html>");

        String[] columnNames = {"Date", "Type", "Event"};
        defaultTableModel = new DefaultTableModel(columnNames, 0);

        JTable jtMembers = new JTable(defaultTableModel);
        jtMembers.setAutoCreateRowSorter(true);
        populateTable();

        //if pastoral formation even type is typed in then show members who have attended that pastoral formation event

        JPanel jpFilter = new JPanel();
        final JComboBox<EventType> jcbPastoralFormation = new JComboBox<EventType>(EventType.pastoralValues());
        JButton jbFilter = new JButton("Filter");
        jbFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = (String) jcbPastoralFormation.getSelectedItem();
            }
        });
        jpFilter.add(jcbPastoralFormation);
        jpFilter.add(jbFilter);

        add(jlTitle, BorderLayout.NORTH);
        add(new JScrollPane(jtMembers), BorderLayout.CENTER);
        add(jpFilter, BorderLayout.SOUTH);
    }

    public void populateTable() {
        EventList eventList = EventList.getInstance();
        ArrayList<Event> arrayList = eventList.getPastoralFormationEvents();

        for (Event event: arrayList) {
            defaultTableModel.addRow(event.toArray());
        }
    }
}
