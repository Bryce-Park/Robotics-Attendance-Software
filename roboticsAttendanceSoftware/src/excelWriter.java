import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;
import java.util.ArrayList;

public class excelWriter
{
    public excelWriter() throws Throwable
    {
        /*
        SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
        Sheet sh = wb.createSheet();
        for(int rownum = 0; rownum < 1000; rownum++)
        {
            Row row = sh.createRow(rownum);
            for(int cellnum = 0; cellnum < 10; cellnum++)
            {
                Cell cell = row.createCell(cellnum); //sets cell's x value
                String address = new CellReference(cell).formatAsString();
                cell.setCellValue(address); //sets cell contents

            }

            // manually control how rows are flushed to disk
            if(rownum % 100 == 0)
            {
                ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others

                // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                // this method flushes all rows
            }

        }

        FileOutputStream out = new FileOutputStream("/temp/sxssf.xlsx");
        wb.write(out);
        out.close();

        // dispose of temporary files backing this workbook on disk
        wb.dispose();
        */
    }

        public static void editMasterList(header Header, ArrayList<student> studentList) throws Throwable
        {
            SXSSFWorkbook wb = new SXSSFWorkbook(-1); // turn off auto-flushing and accumulate all rows in memory
            Sheet sh = wb.createSheet();

            Row headerRow = sh.createRow(0);
            Cell cell = headerRow.createCell(0);
            cell.setCellValue(Header.getId());
            cell = headerRow.createCell(1);
            cell.setCellValue(Header.getLastName());
            cell = headerRow.createCell(2);
            cell.setCellValue(Header.getFirstName());

            for(int cellnum = 0; cellnum < Header.getDateList().size(); cellnum++)
            {
                cell = headerRow.createCell(cellnum+3); //sets cell's x value

                cell.setCellValue(Header.getDateList().get(cellnum).getDate()); //sets cell contents

            }

            for(int rownum = 0; rownum < studentList.size(); rownum++)
            {
                Row row = sh.createRow(rownum+1);
                cell = row.createCell(0);
                cell.setCellValue(studentList.get(rownum).getId());
                cell = row.createCell(1);
                cell.setCellValue(studentList.get(rownum).getLastName());
                cell = row.createCell(2);
                cell.setCellValue(studentList.get(rownum).getFirstName());

                System.out.println(studentList.get(rownum).getDateList().size());
                for(int cellnum = 0; cellnum < studentList.get(rownum).getDateList().size(); cellnum++)
                {
                    cell = row.createCell(cellnum+3); //sets cell's x value
                    //System.out.println("Error 1: " + studentList.get(rownum));
                    //System.out.println("Error 2: " + studentList.get(rownum).getDateList().get(cellnum));
                    cell.setCellValue(studentList.get(rownum).getDateList().get(cellnum).getWasPresent()); //sets cell contents

                }

                // manually control how rows are flushed to disk
                if(rownum % 100 == 0)
                {
                    ((SXSSFSheet)sh).flushRows(100); // retain 100 last rows and flush all others

                    // ((SXSSFSheet)sh).flushRows() is a shortcut for ((SXSSFSheet)sh).flushRows(0),
                    // this method flushes all rows
                }

            }

            FileOutputStream out = new FileOutputStream("sxssf.xlsx");
            //FileOutputStream out = new FileOutputStream("C:/Users/jpark/IdeaProjects/roboticsAttendanceSoftware");
            wb.write(out);
            out.close();

            // dispose of temporary files backing this workbook on disk
            wb.dispose();
        }

    /*
        public void editMasterList(ArrayList<student> studentList, header Header) throws IOException
    {
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
    }
     */

}


