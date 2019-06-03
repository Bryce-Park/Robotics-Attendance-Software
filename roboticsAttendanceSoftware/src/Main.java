import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Throwable
    {
/*
        System.out.println("Hello World!");
        writeTest writeTester = new writeTest();

        ArrayList<date> tempDateHolder = new ArrayList<date>();
        date tempDate = new date(1);
        tempDateHolder.add(tempDate);
        header tempHeader = new header(tempDateHolder);

        ArrayList<student> tempStudentHolder = new ArrayList<student>();
        student tempStudent = new student();
        tempStudentHolder.add(tempStudent);

        excelWriter.editMasterList(tempHeader, tempStudentHolder);
        */
/*
        fileSorter mainFileSorter = new fileSorter();

        ArrayList<student> serializationList = new ArrayList<student>();
        fileSerialization mainFileSerialization = new fileSerialization();
        excelReader mainExcelReader = new excelReader();
        serializationList = mainExcelReader.createStudentListFromData(2606);
        serializationList = mainFileSorter.sortProvidedList(serializationList);
        System.out.println("List sorted");
        mainFileSerialization.saveList(serializationList);
*/

        //excelReader test = new excelReader();
        //test.setInputFile("C:/Users/bpar2710/workspace/Robotics Attendance Software/masterList.xls");
        fileSorter sorterTest = new fileSorter();
        sorterTest.reset();
        //sorterTest.addToMasterListGetIds();




    }
}
/*
package Reader;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException
	{
		System.out.println("yeet");
		//
		ReaderExcel test = new ReaderExcel();
		//test.setInputFile("C:/Users/bpar2710/workspace/Robotics Attendance Software/masterList.xls");
		FileSorter sorterTest = new FileSorter();
		sorterTest.reset();
		//sorterTest.addToMasterListGetIds();
	}
}


 */