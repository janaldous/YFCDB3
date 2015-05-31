package yfcdb.view.coordinatorView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by janaldoustorres on 31/05/15.
 */
public class EventsInfoPanel extends JPanel {
    public EventsInfoPanel() {
        setLayout(new BorderLayout());

        EventPanel eventPanel = new EventPanel();
        MembersTablePanel membersTablePanel = new MembersTablePanel();

        add(eventPanel, BorderLayout.CENTER);
        add(membersTablePanel, BorderLayout.SOUTH);
    }

    public EventsInfoPanel(String title) {
        this();
        String html = "<html><h1>" + title + "</h1></html>";
        add(new JLabel(html), BorderLayout.NORTH);
    }
}
