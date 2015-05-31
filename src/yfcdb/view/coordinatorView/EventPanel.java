package yfcdb.view.coordinatorView;


import yfcdb.events.EventType;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 23/05/15.
 */
public class EventPanel extends JPanel {
    private class TimePanel extends JPanel {
        private TimePanel() {
            JSpinner startSpinner = new JSpinner(new SpinnerDateModel());
            startSpinner.setEditor(new JSpinner.DateEditor(startSpinner, "h:mm a"));
            JSpinner endSpinner = new JSpinner(new SpinnerDateModel());
            endSpinner.setEditor(new JSpinner.DateEditor(endSpinner, "h:mm a"));
            JLabel jlDash = new JLabel("–");

            add(startSpinner);
            add(jlDash);
            add(endSpinner);
        }
    }

    private class DatePan extends JPanel {
        private DatePan() {
            Calendar calendar = Calendar.getInstance();
            Date initDate = calendar.getTime();
            calendar.add(Calendar.YEAR, -100);
            Date earliestDate = calendar.getTime();
            calendar.add(Calendar.YEAR, 200);
            Date latestDate = calendar.getTime();
            SpinnerDateModel model = new SpinnerDateModel(initDate,
                    earliestDate,
                    latestDate,
                    Calendar.YEAR);
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM dd yyyy"));

            add(spinner);
        }
    }

    public EventPanel() {
        setLayout(new GridLayout(7,2));

        JLabel jlEventName = new JLabel("Name of Event *:");
        JTextField jtfEventName = new JTextField();

        JLabel jlEventType = new JLabel("Type of Event *:");
        JComboBox jcbEventType = new JComboBox<String>(EventType.getEventTypes());

        JLabel jlDate = new JLabel("Date *:");
        DatePan datePanel = new DatePan();

        JLabel jlTime = new JLabel("Time *:");
        TimePanel timePanel = new TimePanel();

        JLabel jlVenue = new JLabel("Venue *:");
        JTextField jtfVenue = new JTextField();

        JLabel jlRegFee = new JLabel("Reg Fee:");
        JTextField jtfRegFee = new JTextField();

        JLabel jlNotes = new JLabel("Notes:");
        JTextField jtfNotes = new JTextField();

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
