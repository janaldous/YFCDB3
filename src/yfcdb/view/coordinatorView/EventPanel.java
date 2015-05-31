package yfcdb.view.coordinatorView;


import yfcdb.events.EventType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;

/**
 * Created by janaldoustorres on 23/05/15.
 */
public class EventPanel extends JPanel {
    private class TimePanel extends JPanel {
        private TimePanel() {
            JTextField jtfStartTime = new JTextField("0000am");
            JLabel jlDash = new JLabel("–");
            JTextField jtfEndTime = new JTextField("0000am");
            add(jtfStartTime);
            add(jlDash);
            add(jtfEndTime);
        }
    }

    public EventPanel() {
        setLayout(new GridLayout(7,2));

        JLabel jlEventName = new JLabel("Name of Event *:");
        JTextField jtfEventName = new JTextField("");

        JLabel jlEventType = new JLabel("Type of Event *:");
        JComboBox jcbEventType = new JComboBox<String>(EventType.getEventTypes());

        JLabel jlDate = new JLabel("Date *:");
        DatePanel datePanel = new DatePanel();

        JLabel jlTime = new JLabel("Time *:");
        TimePanel timePanel = new TimePanel();

        JLabel jlVenue = new JLabel("Venue *:");
        JTextField jtfVenue = new JTextField("");

        JLabel jlRegFee = new JLabel("Reg Fee:");
        JTextField jtfRegFee = new JTextField("");

        JLabel jlNotes = new JLabel("Notes:");
        JTextField jtfNotes = new JTextField("");

        add(jlEventName);
        add(jtfEventName);
        add(jlEventType);
        add(jcbEventType);
        add(jlDate);
        add(datePanel);
        add(jlTime);
        add(timePanel);
        add(jlVenue);
        add(jtfVenue);
        add(jlRegFee);
        add(jtfRegFee);
        add(jlNotes);
        add(jtfNotes);
    }
}
