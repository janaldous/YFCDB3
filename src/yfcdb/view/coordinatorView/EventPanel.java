package yfcdb.view.coordinatorView;

import yfcdb.events.Event;
import yfcdb.events.EventType;
import yfcdb.member.Member;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 23/05/15.
 */
public class EventPanel extends EventFormPanel {
    private Event event;
    private final JTextField jtfEventName;
    private final JComboBox<EventType> jcbEventType;
    private final DatePan startDatePanel, endDatePanel;
    private final JTextField jtfVenue;
    private final JTextField jtfRegFee;
    private final JTextField jtfNotes;

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
            spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM dd yyyy HH: mm"));

            add(spinner);
        }

        private void setDate(Date date) {

        }

        private Date getDate() {
            return null;
        }
    }

    public EventPanel() {
        setLayout(new GridLayout(7,2));

        JLabel jlEventName = new JLabel("Name of Event *:");
        jtfEventName = new JTextField();

        JLabel jlEventType = new JLabel("Type of Event *:");
        jcbEventType = new JComboBox<EventType>(EventType.values());

        JLabel jlStartDate = new JLabel("Start Date *:");
        startDatePanel = new DatePan();

        JLabel jlEndDate = new JLabel("End Date *:");
        endDatePanel = new DatePan();

        JLabel jlVenue = new JLabel("Venue *:");
        jtfVenue = new JTextField();

        JLabel jlRegFee = new JLabel("Reg Fee:");
        jtfRegFee = new JTextField();

        JLabel jlNotes = new JLabel("Notes:");
        jtfNotes = new JTextField();

        add(jlEventName);
        add(jtfEventName);
        add(jlEventType);
        add(jcbEventType);
        add(jlStartDate);
        add(startDatePanel);
        add(jlEndDate);
        add(endDatePanel);
        add(jlVenue);
        add(jtfVenue);
        add(jlRegFee);
        add(jtfRegFee);
        add(jlNotes);
        add(jtfNotes);
    }

    @Override
    public void setInfo(Event event) {
        jtfEventName.setText(event.getName());
        jcbEventType.setSelectedItem(event.getType());
        startDatePanel.setDate(event.getStartDate());
        endDatePanel.setDate(event.getEndDate());
        jtfVenue.setText(event.getVenue());
        jtfRegFee.setText(String.valueOf(event.getRegFee()));
        jtfNotes.setText(event.getNotes());
    }

    @Override
    public Event getInfo(Event event) {
        String eventName = jtfEventName.getText();
        EventType eventType = (EventType) jcbEventType.getSelectedItem();
        Date start = startDatePanel.getDate();
        Date end = endDatePanel.getDate();
        String venue = jtfVenue.getText();
        int regFee = Integer.parseInt(jtfRegFee.getText());
        String notes = jtfNotes.getText();

        event.setName(eventName);
        event.setType(eventType);
        event.setStartDate(start);
        event.setEndDate(end);
        event.setVenue(venue);
        event.setRegFee(regFee);
        event.setNotes(notes);

        return event;
    }

    public void updateEvent(Event event) {
        getInfo(event);
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) { this.event = event; }
}
