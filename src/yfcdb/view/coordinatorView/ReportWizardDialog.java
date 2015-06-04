package yfcdb.view.coordinatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class ReportWizardDialog extends JDialog implements ActionListener {

    private final JTextField jtfReportTitle;
    private final JTextArea jtaReportFooter;
    private final DateSpinner fromDateSpinner;
    private final DateSpinner toDateSpinner;
    private final JComboBox jcbFileType;
    private MainWindow mainWindow;

    private class DateSpinner extends JPanel {
        private final JSpinner spinner;

        private DateSpinner() {
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
            spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM yyyy"));

            add(spinner);
        }

        private void setDate(Date date) {
            spinner.setValue(date);
        }

        private Date getDate() {
            Date date = (Date)spinner.getValue();
            return date;
        }
    }

    public ReportWizardDialog(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setLayout(new GridLayout(6, 2));
        setTitle("Report Wizard");

        JLabel jlReportTitle = new JLabel("Report title");
        jtfReportTitle = new JTextField("");

        JLabel jlReportFooter = new JLabel("Report notes");
        jtaReportFooter = new JTextArea("");
        jtaReportFooter.setToolTipText("Enter for notes");

        JLabel jlDateFrom = new JLabel("Date from");
        fromDateSpinner = new DateSpinner();

        JLabel jlDateTo = new JLabel("Date to");
        toDateSpinner = new DateSpinner();

        JLabel jlFileType = new JLabel("File type");
        jcbFileType = new JComboBox(new String[] {"xslx", "csv", "pdf"});

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jbCancel = new JButton("Cancel");
        JButton jbSave = new JButton("Create");
        jbSave.addActionListener(this);
        bottomPanel.add(jbCancel);
        bottomPanel.add(jbSave);

        add(jlReportTitle);
        add(jtfReportTitle);
        add(jlReportFooter);
        add(jtaReportFooter);
        add(jlDateFrom);
        add(fromDateSpinner);
        add(jlDateTo);
        add(toDateSpinner);
        add(jlFileType);
        add(jcbFileType);
        add(bottomPanel);

        pack();
    }

    private boolean isFilledOut() {
        if (jtfReportTitle.getText().isEmpty() || jtaReportFooter.getText().isEmpty()) {
            return false;
        } else if (fromDateSpinner.getDate().after(toDateSpinner.getDate())) {
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isFilledOut()) {
            String title = jtfReportTitle.getText().toUpperCase();
            String footer = jtaReportFooter.getText();
            Date start = fromDateSpinner.getDate();
            Date end = toDateSpinner.getDate();

            mainWindow.changeCenterPanelToReportTable(start, end);
        } else {
            JOptionPane.showMessageDialog(null, "not filled out or dates are wrong");
        }
    }
}
