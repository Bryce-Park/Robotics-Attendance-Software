import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
/*
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.Number;
import jxl.write.biff.RowsExceededException;
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.ArrayList;

public class excelReader
{
    private String inputFile;
    private FileInputStream excelFile;
    private int numRows;
    private int currentRow;
    private int currentColumn;

    //private FileInputStream excelFile;
    Workbook workbook;
    Sheet datatypeSheet;
    /*
        public ReaderExcel()
        {
            this.inputFile = "";
            currentRow = 1;
            currentColumn = 0;
        }
    */
    public excelReader()
    {

    }

    public excelReader(String inputFile)
    {
        this.setInputFile(inputFile);
    }

    public void setInputFile(String inputFile)
    {
        this.inputFile = inputFile;
        currentRow = 1;
        currentColumn = 0;
    }


/*
    public void read() throws IOException
    {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try
        {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet =  w.getSheet(0);
            numRows = sheet.getRows();
        }
        catch (BiffException e)
        {
            e.printStackTrace();
        }
    }
*/

    public void read()
    {
        ArrayList<String> output = new ArrayList<String>();

        System.out.println("test start");

        try {

            excelFile = new FileInputStream(new File(inputFile));
            workbook = new XSSFWorkbook(excelFile);
            datatypeSheet = workbook.getSheetAt(0);
            /*
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(input);
            Iterator<Cell> cellIterator = testRow.iterator();

            while (cellIterator.hasNext()) {

                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.print(currentCell.toString());
                System.out.println(" Filler");
                output.add(currentCell.toString());
            }

            System.out.println("ping0");
            */


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<student> createStudentListFromData(int numRows)
    {
        ArrayList<student> outputList = new ArrayList<student>();
        ArrayList<String> receivingList = new ArrayList<String>();
        ArrayList<date> fillDateList = new ArrayList<date>();
        int tempInt;
        student tempStudent;
        for(int counter = 0; counter< numRows; counter++)
        {
            System.out.println("Ping:" + counter);
            receivingList = this.getRowFromIndicated(counter+1);
            System.out.println(receivingList.get(0));
            tempInt = Integer.parseInt(receivingList.get(0).substring(0,6));
            tempStudent = new student(tempInt, receivingList.get(2), receivingList.get(1), fillDateList);
            outputList.add(tempStudent);

        }

        return outputList;

    }

    public String getLabel(int x, int y)
    {
        String output = new String();

        System.out.println("test start");

        try {

            FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx"));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            Row testRow;
            testRow = datatypeSheet.getRow(y);
            Iterator<Cell> cellIterator = testRow.iterator();

            String contentTracker = new String();

            for(int tracker = 0; tracker<x; tracker++)
            {
                Cell currentCell = cellIterator.next();
                //getCellTypeEnum shown as deprecated for version 3.15
                //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                System.out.print(currentCell.toString());
                contentTracker = currentCell.toString();
                //output.add(currentCell.toString());
            }
            output = contentTracker;

            System.out.println("ping0");



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return output;

        /*
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String returner;
        try
        {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet =  w.getSheet(0);

            Cell cell = sheet.getCell(x,y);
            returner = cell.getContents();
            return returner;
        }
        catch (BiffException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Error";
        */
    }
    /*
    public ArrayList<String> getRow(int input)
{
    ArrayList<String> output = new ArrayList<String>();

    System.out.println("test start");

    try {

        FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        Row testRow;
        testRow = datatypeSheet.getRow(input);
        Iterator<Cell> cellIterator = testRow.iterator();

        while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            //getCellTypeEnum shown as deprecated for version 3.15
            //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
            System.out.print(currentCell.toString());
            System.out.println(" Filler");
            output.add(currentCell.toString());
        }

        System.out.println("ping0");



    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

     */

/*
    public int getNumRows() throws IOException
    {
        return numRows;
    }
*/
/*
    public void makeNewSheet(ArrayList<student> studentList) throws IOException
    {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try
        {

            WritableWorkbook workbook = Workbook.createWorkbook(new File("output.xls"));
            w = Workbook.getWorkbook(inputWorkbook);
            WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);
            Number number;
            Label label;

            for (int counter = 0; counter < studentList.size(); counter++)
            {
                number = new Number (0, counter, studentList.get(counter).getId());
                output.addCell(number);

                label = new Label (1,counter,studentList.get(counter).getLastName());
                output.addCell(label);

                label = new Label (2,counter,studentList.get(counter).getFirstName());
                output.addCell(label);

                label = new Label (3,counter,studentList.get(counter).getGender());
                output.addCell(label);

                number = new Number (4, counter, studentList.get(counter).getGrade());
                output.addCell(number);
            }

            workbook.write();
            workbook.close();
        }

        catch (BiffException e)
        {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
*/

    /*
    public void makeNewSheetWithName(ArrayList<student> studentList, String fileName, ArrayList<date> dateList) throws IOException
    {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String newFileName = fileName + ".xls";
        header top = new header(dateList);
        try
        {
            WritableWorkbook workbook = Workbook.createWorkbook(new File(fileName+".xls"));
            w = Workbook.getWorkbook(inputWorkbook);
            WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);
            Number number;
            Label label;
            int wasThereTemp;


            label = new Label(0,0,top.getId());
            output.addCell(label);
            label = new Label(1,0,top.getLastName());
            output.addCell(label);
            label = new Label(2,0,top.getFirstName());
            output.addCell(label);
            //label = new Label(3,0,"Gender");
            //output.addCell(label);
            //label = new Label(4,0,"Grade Level");
            //output.addCell(label);

            for (int counter = 0; counter < top.getDateList().size(); counter++)
            {
                number = new Number (0,counter+4,top.getDateList().get(counter).getWasPresent());
                output.addCell(number);
            }


            for (int counter = 0; counter < studentList.size(); counter++)
            {
                student tempHolder = studentList.get(counter);
                number = new Number (0, counter+1, tempHolder.getId());
                output.addCell(number);

                label = new Label (1,counter+1,tempHolder.getLastName());
                output.addCell(label);

                label = new Label (2,counter+1,tempHolder.getFirstName());
                output.addCell(label);

                label = new Label (3,counter+1,tempHolder.getGender());
                output.addCell(label);

                number = new Number (4, counter+1, tempHolder.getGrade());
                output.addCell(number);

                for (int dateCounter = 0; counter < dateList.size(); counter++)
                {
                    wasThereTemp = dateList.get(dateCounter).getWasPresent();
                    number = new Number (dateCounter+5,counter+1,wasThereTemp);
                    output.addCell(number);
                }
            }

            workbook.write();
            workbook.close();
        }

        catch (BiffException e)
        {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
*/

    public void editMasterList(ArrayList<student> studentList, header Header) throws Throwable
    {
        excelWriter accessibleExcelWriter = new excelWriter();
        accessibleExcelWriter.editMasterList(Header, studentList);

        /*
        File inputWorkbook = new File(inputFile);
        Workbook w;
        try
        {
            WritableWorkbook workbook = Workbook.createWorkbook(new File("masterList2.xls"));
            System.out.println(workbook);
            System.out.println(inputWorkbook);
            System.out.println(inputFile);
            System.out.println(Workbook.getWorkbook(inputWorkbook));
            w = Workbook.getWorkbook(inputWorkbook);
            WritableSheet output = workbook.createSheet("Reorganized Sheet", 0);



            Number number;
            Label label;
            int wasThereTemp;
            String wasThereDateTemp;
            boolean dateResortNeeded = false;

            label = new Label(0,0,Header.getId());
            output.addCell(label);
            label = new Label(1,0,Header.getLastName());
            output.addCell(label);
            label = new Label(2,0,Header.getFirstName());
            output.addCell(label);

            for (int counter = 0; counter < Header.getDateList().size(); counter++)
            {
                label = new Label (counter+3,0,Header.getDateList().get(counter).getDate());
                output.addCell(label);
            }


            for (int counter = 0; counter < studentList.size(); counter++)
            {

                student tempHolder = studentList.get(counter);
                number = new Number (0, counter+1, tempHolder.getId());
                output.addCell(number);

                label = new Label (1,counter+1,tempHolder.getLastName());
                output.addCell(label);

                label = new Label (2,counter+1,tempHolder.getFirstName());
                output.addCell(label);





                for (int dateCounter = 0; dateCounter < studentList.get(counter).getDateList().size(); dateCounter++)
                {
                    wasThereTemp = studentList.get(counter).getDateList().get(dateCounter).getWasPresent();

                    number = new Number (dateCounter+3,counter+1,wasThereTemp);
                    output.addCell(number);
                }
            }

            workbook.write();
            workbook.close();
        }

        catch (BiffException e)
        {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (WriteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
    }
/*
    public String getRow (int row)  throws IOException
    {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String returner = "";
        boolean isZero=false;
        if(row==0)
        {
            isZero = true;
        }
        try
        {
            w = Workbook.getWorkbook(inputWorkbook);
            // Get the first sheet
            Sheet sheet =  w.getSheet(0);

            for (int i = 0; i < sheet.getColumns(); i++)
            {
                Cell cell = sheet.getCell(i,row);
                CellType type = cell.getType();
                returner = returner + " " + cell.getContents();
            }
        }
        catch (BiffException e)
        {
            e.printStackTrace();
        }
        return returner;
    }
 */
public ArrayList<String> getRow(int input)
{
    ArrayList<String> output = new ArrayList<String>();

    System.out.println("test start");

    try {

        FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/Athletic Awards File Examples/athletic awards for Spring 2016.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        Row testRow;
        testRow = datatypeSheet.getRow(input);
        Iterator<Cell> cellIterator = testRow.iterator();

        while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            //getCellTypeEnum shown as deprecated for version 3.15
            //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
            System.out.print(currentCell.toString());
            System.out.println(" Filler");
            output.add(currentCell.toString());
        }

        System.out.println("ping0");



    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return output;
}

    public ArrayList<String> getRowFromIndicated(int input)
{
    ArrayList<java.lang.String> output = new ArrayList<java.lang.String>();

    System.out.println("test start");

    try {

        FileInputStream excelFile = new FileInputStream(new File("C:/Users/jpark/IdeaProjects/roboticsAttendanceSoftware/data.xlsx"));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);
        Iterator<Row> iterator = datatypeSheet.iterator();

        Row testRow;
        testRow = datatypeSheet.getRow(input);
        Iterator<Cell> cellIterator = testRow.iterator();

        while (cellIterator.hasNext()) {

            Cell currentCell = cellIterator.next();
            //getCellTypeEnum shown as deprecated for version 3.15
            //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
            System.out.print(currentCell.toString());
            System.out.println(" Filler");
            output.add(currentCell.toString());
        }

        System.out.println("ping0");



    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return output;
}
/*
    public String getNextString (int row)  throws IOException
    {
        File inputWorkbook = new File(inputFile);
        Workbook w;
        String returner = "";
        try
        {
            w = Workbook.getWorkbook(inputWorkbook);
            Sheet sheet =  w.getSheet(0);
            Cell cell = sheet.getCell(currentColumn,currentRow);
            returner = returner + " " + cell.getContents();
        }
        catch (BiffException e)
        {
            e.printStackTrace();
        }
        return returner;
    }
*/
}
