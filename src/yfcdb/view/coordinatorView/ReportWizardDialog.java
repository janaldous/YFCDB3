package yfcdb.view.coordinatorView;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 01/06/15.
 */
public class ReportWizardDialog extends JDialog {
    private class DateSpinner extends JPanel {
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
            JSpinner spinner = new JSpinner(model);
            spinner.setEditor(new JSpinner.DateEditor(spinner, "MMM yyyy"));

            add(spinner);
        }

        private void setDate(Date date) {

        }

        private Date getDate() {
            return null;
        }
    }

    public ReportWizardDialog() {
        setLayout(new GridLayout(7, 2));
        setTitle("Report Wizard");

        JLabel jlReportTitle = new JLabel("Report title");
        JTextField jtfReportTitle = new JTextField();

        JLabel jlReportHeader = new JLabel("Report header");
        JTextArea jtaReportHeader = new JTextArea();

        JLabel jlReportFooter = new JLabel("Report header");
        JTextArea jtaReportFooter = new JTextArea();
        jtaReportFooter.setToolTipText("Enter for notes");

        JLabel jlDateFrom = new JLabel("Date from");
        DateSpinner fromDateSpinner = new DateSpinner();

        JLabel jlDateTo = new JLabel("Date to");
        DateSpinner toDateSpinner = new DateSpinner();

        JLabel jlFileType = new JLabel("File type");
        JComboBox jcbFileType = new JComboBox(new String[] {"pdf", "xslx", "csv"});

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jbCancel = new JButton("Cancel");
        JButton jbSave = new JButton("Create");
        bottomPanel.add(jbCancel);
        bottomPanel.add(jbSave);

        add(jlReportTitle);
        add(jtfReportTitle);
        add(jlReportHeader);
        add(jtaReportHeader);
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
}
