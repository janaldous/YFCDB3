package yfcdb.view.coordinatorView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import yfcdb.events.Event;

/**
 * Created by janaldoustorres on 31/05/15.
 */
public class EventsInfoPanel extends JPanel {
    private final EventPanel eventPanel;

    public EventsInfoPanel() {
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20) );

        JPanel centerPanel = new JPanel(new GridLayout(2,1));
        eventPanel = new EventPanel();
        MembersAttendanceTablePanel membersAttendanceTablePanel = new MembersAttendanceTablePanel();
        centerPanel.add(eventPanel);
        centerPanel.add(membersAttendanceTablePanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jbSave = new JButton("Save");
        EventInfoPanelListener eventInfoPanelListener = new EventInfoPanelListener(eventPanel, membersAttendanceTablePanel);
        jbSave.addActionListener(eventInfoPanelListener);
        JButton jbCancel = new JButton("Cancel");
        buttonPanel.add(jbCancel);
        buttonPanel.add(jbSave);

        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public EventsInfoPanel(String title) {
        this();
        String html = "<html><h1>" + title + "</h1></html>";
        add(new JLabel(html), BorderLayout.NORTH);
    }

    public EventsInfoPanel(Event event) {
        this();
        eventPanel.setEvent(event);
        eventPanel.setInfo(event);
    }
}
