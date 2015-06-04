package yfcdb;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import yfcdb.events.Event;
import yfcdb.events.EventList;
import yfcdb.events.EventType;
import yfcdb.files.Files;
import yfcdb.member.PersonList;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by janaldoustorres on 02/06/15.
 */
public class XSLXTrial {
    static EventType[] monthlyGatheringArr = {EventType.CHAPTER_ASSEMBLY, EventType.COLLECTIVE_HOUSEHOLD, EventType.KASSANGA_ASSEMBLY,
            EventType.CHAPTER_SERVICE_MEETING, EventType.CLUSTER_SERVICE_MEETING, EventType.PASTORAL_HOUSEHOLD};

    static EventType[] pastoralFormationArr = {EventType.YOUTH_CAMP_TRAINING, EventType.WORSHIP_WORKSHOP, EventType.HLT,
            EventType.YOUTH_CAMP, EventType.FAMILY_CULTURE, EventType.COVENANT_ORIENTATION, EventType.YOUTH_POWER,
            EventType.DISCOVERY_CAMP, EventType.PARENTS_HONORING, EventType.HUNDRED_PERCENT_FREE, EventType.STAKE_FOR_THE_NATION,
            EventType.VOCATION_RECOLLECTION, EventType.BEST_WEEKEND, EventType.CHURCH_AND_SACRAMENT, EventType.YOUTH_ADVOCATE};

    static EventType[] yfcConferences = {EventType.ILC, EventType.SECTOR_CONFERENCE, EventType.PROVINCIAL_CONFERENCE,
            EventType.REGIONAL_CONFERENCE};

    static ArrayList<Event> janEvents = EventList.getInstance().getEventsOn(Calendar.JANUARY, 2015);
    private static CellStyle borderStyle;

    public static void upload() {
        try {
            Files.uploadFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        upload();

        Workbook wb = new HSSFWorkbook();  // or new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");

        //bold style created
        CellStyle boldStyle = wb.createCellStyle();
        Font font = wb.createFont();
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);
        boldStyle.setFont(font);
        boldStyle.setBorderTop(CellStyle.BORDER_DOUBLE);

        borderStyle = wb.createCellStyle();
        borderStyle.setBorderBottom(CellStyle.BORDER_THIN);
        borderStyle.setBorderLeft(CellStyle.BORDER_THIN);
        borderStyle.setBorderRight(CellStyle.BORDER_THIN);
        borderStyle.setBorderTop(CellStyle.BORDER_THIN);

        CellStyle titleStyle = wb.createCellStyle();
        Font bigFont = wb.createFont();
        bigFont.setFontHeightInPoints((short)18);
        titleStyle.setFont(bigFont);




        String title = "2012 WEST 2 YFC ACTIVITY REPORT";
        String yfcGroup = "CLUSTER: 2";
        String leaders = "CHAPTER LEADERS: " + PersonList.getInstance().getChapterLeaders();
        String activities = "Activities";
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, Calendar.JANUARY);
        cal.set(2015, Calendar.JANUARY, 1);
        Date start = cal.getTime();
        cal.set(2015, Calendar.JUNE, 1);
        Date end = cal.getTime();

        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] monthsStrArr = dfs.getMonths();

        Calendar cStart = Calendar.getInstance();
        cStart.setTime(start);
        int startMonth = cStart.get(Calendar.MONTH);
        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(end);
        int endMonth = cEnd.get(Calendar.MONTH);
        int yearDifference = cEnd.get(Calendar.YEAR) - cStart.get(Calendar.YEAR);
        endMonth += (yearDifference*12) +1;
        int noOfMonths = endMonth - startMonth;
        String[] headerArr = new String[noOfMonths];

        for (int i = 0; i < headerArr.length && startMonth < endMonth; i++, startMonth++) {
            headerArr[i] = monthsStrArr[startMonth];
            if (startMonth >= 12) {
                startMonth = 0;
            }
        }

        for (String s: headerArr) {
            System.out.print(s);
        }

        ///============================START OF SPREADSHEET=====================================
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue(createHelper.createRichTextString(title));
        sheet.addMergedRegion(new CellRangeAddress(
                0, //first row (0-based)
                0, //last row  (0-based)
                0, //first column (0-based)
                (noOfMonths*2+1)  //last column  (0-based)
        ));
        cell.setCellStyle(titleStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);


        Row row2 = sheet.createRow(2);
        row2.createCell(0).setCellValue(createHelper.createRichTextString(yfcGroup));

        Row row3 = sheet.createRow(3);
        row3.createCell(0).setCellValue(createHelper.createRichTextString(leaders));

        //header row1, months
        Row rHeader = sheet.createRow(5);
        cell = rHeader.createCell(0);
        cell.setCellValue(createHelper.createRichTextString(activities));
        sheet.addMergedRegion(new CellRangeAddress(
                5, //first row (0-based)
                6, //last row  (0-based)
                0, //first column (0-based)
                0  //last column  (0-based)
        ));
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);

        int j = 0;
        for (int i = 0; j < headerArr.length; i+=2) {
            cell = rHeader.createCell(i+1);
            cell.setCellValue(headerArr[j].toUpperCase());
            cell.setCellStyle(borderStyle);
            CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);
            sheet.addMergedRegion(new CellRangeAddress(
                    5, //first row (0-based)
                    5, //last row  (0-based)
                    i+1, //first column (0-based)
                    i+2  //last column  (0-based)
            ));
            j++;
        }

        //header row2, date, #ofattendees
        Row rHeader2 = sheet.createRow(6);
        for (int i = 0; i < headerArr.length*2; i+=2) {
            Cell c1 = rHeader2.createCell(i );
            c1.setCellValue("Date");
            c1.setCellStyle(borderStyle);
            Cell c2 = rHeader2.createCell(i + 1);
            c2.setCellValue("#ofAttendees");
            c2.setCellStyle(borderStyle);
        }


        Row rowMonthlyGathering = sheet.createRow(7);
        cell = rowMonthlyGathering.createCell(0);
        cell.setCellValue("Monthly Gathering");
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);

        int rowNum = 8;
        for (EventType type: monthlyGatheringArr) {
            Row row1 = sheet.createRow(rowNum++);
            cell = row1.createCell(0);
            cell.setCellValue(type.toString());
            cell.setCellStyle(borderStyle);

            for (Event event: janEvents) {
                if (event.getType().equals(type)) {
                    Cell c1 = row1.createCell(1);
                    c1.setCellValue(event.getDay());
                    Cell c2 = row1.createCell(2);
                    c2.setCellValue(event.getNoOfAttendees());
                    c1.setCellStyle(borderStyle);
                    c2.setCellStyle(borderStyle);
                }

            }

        }

        Row bufferRow = sheet.createRow(rowNum++);
        bufferRow.createCell(0);

        Row rowPastoralFormation = sheet.createRow(rowNum++);
        cell = rowPastoralFormation.createCell(0);
        cell.setCellValue("Pastoral Formation");
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);

        for (EventType type: pastoralFormationArr) {
            Row row1 = sheet.createRow(rowNum++);
            cell = row1.createCell(0);
            cell.setCellValue(type.toString());
            cell.setCellStyle(borderStyle);

            for (Event event: janEvents) {
                if (event.getType().equals(type)) {
                    Cell c1 = row1.createCell(1);
                    c1.setCellValue(event.getDay());
                    Cell c2 = row1.createCell(2);
                    c2.setCellValue(event.getNoOfAttendees());
                    c1.setCellStyle(borderStyle);
                    c2.setCellStyle(borderStyle);
                }

            }

        }

        bufferRow = sheet.createRow(rowNum++);
        bufferRow.createCell(0);

        Row rowYFCConference = sheet.createRow(rowNum++);
        cell = rowYFCConference.createCell(0);
        cell.setCellValue("YFC Conference");
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);

        for (EventType type: yfcConferences) {
            Row row1 = sheet.createRow(rowNum++);
            cell = row1.createCell(0);
            cell.setCellValue(type.toString());
            cell.setCellStyle(borderStyle);

            for (Event event: janEvents) {
                if (event.getType().equals(type)) {
                    Cell c1 = row1.createCell(1);
                    c1.setCellValue(event.getDay());
                    Cell c2 = row1.createCell(2);
                    c2.setCellValue(event.getNoOfAttendees());
                    c1.setCellStyle(borderStyle);
                    c2.setCellStyle(borderStyle);
                }

            }
        }

        bufferRow = sheet.createRow(rowNum++);
        bufferRow.createCell(0);

        Row rowParishLinkage = sheet.createRow(rowNum++);
        cell = rowParishLinkage.createCell(0);
        cell.setCellValue("Parish Linkage");
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);

        bufferRow = sheet.createRow(rowNum++);
        bufferRow.createCell(0);

        Row rowOthers = sheet.createRow(rowNum++);
        cell = rowOthers.createCell(0);
        cell.setCellValue("Others");
        cell.setCellStyle(boldStyle);
        CellUtil.setAlignment(cell, wb, CellStyle.ALIGN_CENTER);


        sheet.autoSizeColumn(0);


        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("trial.xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void populate(EventType type, Row row) {


        for (Event event: janEvents) {
            if (event.getType().equals(type)) {
                Cell c1 = row.createCell(1);
                c1.setCellValue(event.getDay());
                Cell c2 = row.createCell(2);
                c2.setCellValue(event.getNoOfAttendees());
                c1.setCellStyle(borderStyle);
                c2.setCellStyle(borderStyle);
            }

        }
    }
}
