import java.io.IOException;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fileSorter
{
    //private ReaderExcel sheet;
    private excelReader sheet;
    private ArrayList<student> studentList;
    private ArrayList<Integer> studentIdList;
    private ArrayList<Integer> generatedIdList;
    private ArrayList<student> generatedList;
    private ArrayList<student> schoolStudentList;
    private ArrayList<Integer> schoolStudentIdList;
    private ArrayList<student> alreadyThere;
    private ArrayList<Integer> alreadyThereIdList;
    private header Header;

    private fileSerialization bob;

    public fileSorter (excelReader Isheet) throws IOException
    {
        sheet = Isheet;
        System.out.println("Created successfully");

        fileSerialization listCaller = new fileSerialization();
        alreadyThere = listCaller.getStudentList();
        alreadyThereIdList = makeIntList(alreadyThere);

        ArrayList<date> holderDate = new ArrayList<date>();

        Header = new header();

        studentList = new ArrayList<student>();
        generatedList = new ArrayList<student>();
        generatedIdList = new ArrayList<Integer>();
        alreadyThere = new ArrayList<student>();
        alreadyThereIdList = new ArrayList<Integer>();

        bob = new fileSerialization();

        this.pullStudentAndAlreadyThereLists();

    }
    public fileSorter () throws IOException
    {
        excelReader test = new excelReader();
        test.setInputFile("C:/Users/jpark/IdeaProjects/roboticsAttendanceSoftware/masterList.xls");
        sheet = test;
        System.out.println("Created successfully");

        fileSerialization listCaller = new fileSerialization();
        alreadyThere = listCaller.getStudentListWithName("");
        alreadyThereIdList = makeIntList(alreadyThere);
        for(int counter = 0;counter<alreadyThereIdList.size();counter++)
        {
            System.out.println(alreadyThereIdList.get(counter));
        }

        ArrayList<date> holderDate = new ArrayList<date>();

        Header = new header();

        studentList = new ArrayList<student>();
        generatedList = new ArrayList<student>();
        generatedIdList = new ArrayList<Integer>();
        alreadyThere = new ArrayList<student>();
        alreadyThereIdList = new ArrayList<Integer>();

        bob = new fileSerialization();

        this.pullStudentAndAlreadyThereLists();

    }



    public void reset() throws Throwable
    {
        this.saveNewAlreadyThereList(this.resetAlreadyThereList(),this.resetHeader());
        this.callEditMasterList(this.resetAlreadyThereList(), this.resetHeader());
    }

    private void initialize()
    {
        studentList = new ArrayList<student>();
        generatedList = new ArrayList<student>();
        generatedIdList = new ArrayList<Integer>();
        alreadyThere = new ArrayList<student>();
        alreadyThereIdList = new ArrayList<Integer>();
        bob = new fileSerialization();
    }

    public void receiveNewStudentList (ArrayList<student> received)
    {
        schoolStudentList = received;
        schoolStudentIdList = makeIntList(schoolStudentList);

        Header = new header();
    }

    public void receiveNewStudentAndAlreadyLists (ArrayList<student> received,ArrayList<student> there, header iHeader)
    {
        schoolStudentList = received;
        schoolStudentIdList = makeIntList(schoolStudentList);

        alreadyThere = there;
        alreadyThereIdList = makeIntList(alreadyThere);

        Header = iHeader;
    }

    public void pullNewStudentListFromFile() throws IOException
    {

        this.receiveNewStudentList(bob.getStudentList());//put into filesort class
        this.createListFromMasterList(68);
    }

    public ArrayList<student> resetAlreadyThereList()
    {
        ArrayList<student> newStudentList = new ArrayList<student>();
        return newStudentList;
    }

    public header resetHeader()
    {
        header newHeader = new header();
        return newHeader;
    }

    public void pullStudentAndAlreadyThereLists() throws IOException
    {
        String alreadyThereName = "savedAlreadyThereStudentList";
        fileSerialization bob = new fileSerialization();
        this.receiveNewStudentAndAlreadyLists(bob.getStudentList(),bob.getStudentListWithName(alreadyThereName),bob.getHeaderWithName("savedHeader"));//put into filesort class
    }

    public void saveNewAlreadyThereList(ArrayList<student> received,header Header)
    {
        fileSerialization bob = new fileSerialization();
        bob.saveListWithName(received, "savedAlreadyThereStudentList");
        bob.saveHeaderWithName(Header, "savedHeader");
    }

    public void createList() throws IOException
    {
        ArrayList<String> rStorage =  new ArrayList<String>();
        String testId;
        int tempId;
        String tempFirst;
        String tempLast;
        //String tempGender;
        //String testGrade;
        //int tempGrade;
        ArrayList<date> dateHolder;
        String tempDate;
        boolean isMore = true;
        Header = new header();

        int numRows = 2691;//change back to 2691 or 68 Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen!

        /////////////////////////////////////////////////////

        for (int i = 1; i < numRows; i++)
        {
            dateHolder = new ArrayList<date>();

            rStorage = sheet.getRow(i);

            testId = rStorage.get(0);
            tempLast = rStorage.get(1);
            tempFirst = rStorage.get(2);

            tempId = Integer.parseInt(testId);

            /*
            rStorage = rStorage.substring((rStorage.indexOf(" ")+1));

            testId = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());

            tempLast = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());

            tempFirst = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());
            */



			/*
			tempGender = rStorage.substring(0, rStorage.indexOf(" "));
			rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());

			testGrade = rStorage.substring(0, rStorage.length());
			rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());
			*/
            //tempGrade = Integer.parseInt(testGrade);

            //if(rStorage.indexOf(" ")>-1)
            System.out.println("Arraylist Size = "+rStorage.size());
            if(rStorage.size()>3)
            {
                int runCounter=3;
                while (runCounter <= rStorage.size())
                {
                    dateHolder.add(new date(Integer.parseInt(rStorage.get(runCounter))));

                    /*
                    if(rStorage.indexOf(" ")>-1)
                    {
                        tempDate = rStorage.substring(0, rStorage.indexOf(" "));
                        dateHolder.add(new date(Integer.parseInt(testId)));
                        rStorage = rStorage.substring(rStorage.indexOf(" ")+1,rStorage.length());
                    }
                    else
                    {
                        tempDate = rStorage.substring(0, rStorage.length());
                        dateHolder.add(new date(Integer.parseInt(testId)));
                        rStorage = " ";
                    }
                    if(rStorage.length()<1)
                    {
                        isMore = false;
                    }
                    runCounter++;
                    */
                }
            }


            studentList.add(new student(tempId,tempLast,tempFirst,dateHolder));
        }

        studentIdList = makeIntList(studentList);
        fileSerialization temper = new fileSerialization();
        temper.saveList(studentList);
    }

    public void createListFromMasterList(int iNumRows) throws IOException
    {
        ArrayList<String> rStorage;
        String testId;
        int tempId;
        String tempFirst;
        String tempLast;
        ArrayList<date> dateHolder;
        String tempDate;
        Header = new header();
        ArrayList<String> headerInfo;

        int numRows = 68;//change back to 2691 Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen! Hey! Listen!

        /////////////////////////////////////////////////////

        headerInfo = sheet.getRow(0);

        /*
        headerInfo = headerInfo.substring((headerInfo.indexOf(" ")+1));
        headerInfo = headerInfo.substring(headerInfo.indexOf(" ")+1, headerInfo.length());
        headerInfo = headerInfo.substring(headerInfo.indexOf(" ")+1, headerInfo.length());
        headerInfo = headerInfo.substring(headerInfo.indexOf(" ")+1, headerInfo.length());
        */

        if(headerInfo.size()>3)
        {
            boolean isMore = true;
            int runCounter=3;
            while (isMore)
            {
                /*
                if(headerInfo.indexOf(" ")>-1)
                {
                    tempDate = headerInfo.substring(0, headerInfo.indexOf(" "));
                    Header.addToDateList(new date(1,tempDate));
                    headerInfo = headerInfo.substring(headerInfo.indexOf(" ")+1,headerInfo.length());
                }
                else
                {
                    tempDate = headerInfo.substring(0, headerInfo.length());
                    Header.addToDateList(new date(1,tempDate));
                    headerInfo = " ";
                    isMore = false;
                }
                */
                Header.addToDateList(new date(0,headerInfo.get(runCounter)));
                /*
                if(headerInfo.length()<1)
                {
                    isMore = false;
                }
                */
                runCounter++;

            }
        }

        for (int i = 1; i < numRows; i++)
        {
            dateHolder = new ArrayList<date>();
            rStorage = sheet.getRow(i);
            testId = rStorage.get(0);
            tempLast = rStorage.get(1);
            tempFirst = rStorage.get(2);
            /*
            rStorage = rStorage.substring((rStorage.indexOf(" ")+1));
            testId = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());

            tempLast = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());

            tempFirst = rStorage.substring(0, rStorage.indexOf(" "));
            rStorage = rStorage.substring(rStorage.indexOf(" ")+1, rStorage.length());
            */
            tempId = Integer.parseInt(testId);
            if(rStorage.size()>3)
            {
                boolean isMore = true;
                int runCounter=3;
                while (rStorage.size()>runCounter)
                {
                    dateHolder.add(new date(Integer.parseInt(rStorage.get(runCounter)),sheet.getLabel(runCounter,0)));
                    /*
                    if(rStorage.indexOf(" ")>-1)
                    {
                        tempDate = rStorage.substring(0, rStorage.indexOf(" "));
                        dateHolder.add(new date(Integer.parseInt(tempDate),sheet.getLabel(3+runCounter, 0)));
                        rStorage = rStorage.substring(rStorage.indexOf(" ")+1,rStorage.length());
                    }
                    else
                    {
                        tempDate = rStorage.substring(0, rStorage.length());
                        dateHolder.add(new date(Integer.parseInt(tempDate),sheet.getLabel(3+runCounter, 0)));
                        rStorage = " ";
                        isMore = false;
                    }
                    if(rStorage.length()<1)
                    {
                        isMore = false;
                    }
                    */
                    runCounter++;

                }
            }

            alreadyThere.add(new student(tempId,tempFirst,tempLast,dateHolder));


        }
        alreadyThere = this.sortProvidedList(alreadyThere);

        alreadyThereIdList = makeIntList(alreadyThere);
        this.callMakeNewSheet(alreadyThere);

        fileSerialization bob = new fileSerialization();
        bob.saveListWithName(alreadyThere, "savedAlreadyThereStudentList");
    }

    public void getIds () throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int holder = -1;
        boolean isZero = false;

        System.out.println("Please enter the name of the new sheet. "
                + "(If it is the date, please use the format month/day/full year)");
        fileName = br.readLine();

        while(!isZero)
        {
            System.out.println("Please enter your Id");
            try
            {
                if(holder==0)
                {
                    break;
                }
                holder = Integer.parseInt(br.readLine());

                this.simpleProcessId(holder);
            }
            catch(NumberFormatException nfe){
                System.err.println("Please use numbers!");
            }
        }
        this.callMakeNewSheetWithName(generatedList,fileName);
    }

    public void addToMasterListGetIds () throws Throwable
    {
        Header.addToDateList(new date(1));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int holder = -1;
        boolean isZero = false;
        String temp;


        generatedList = alreadyThere;

        System.out.println("Begin Already There Date List Size");
        for(int counter = 0;counter<alreadyThere.size();counter++)
        {
            System.out.println("Already There Date List Size: "+alreadyThere.get(counter).getDateList().size());
        }
        while(!isZero)
        {
            System.out.println("Please enter your Id");
            try
            {
                if(holder==0)
                {
                    break;
                }
                holder = Integer.parseInt(br.readLine());

                this.simpleProcessIdMasterList(holder);
            }
            catch(NumberFormatException nfe)
            {
                System.err.println("Please use numbers!");
            }


        }
        System.out.println("Begin Already There Date List Size 1:");
        for(int counter = 0;counter<generatedList.size();counter++)
        {
            System.out.println("Already There Date List Size: "+generatedList.get(counter).getDateList().size());
        }

        //makes sure all students have the same number of dates in list
        date tempDate = new date(0);

        System.out.println("Header dateList size: "+Header.getDateList().size());

        for(int counter=0;counter<generatedList.size();counter++)
        {
            while(generatedList.get(counter).getDateList().size()<Header.getDateList().size())
            {
                System.out.println("Date adder ping");
                generatedList.get(counter).addDate(tempDate);
            }

            //	if(generatedList.get(counter).getDateList().size()!=Header.getDateList().size())
            //	{

            //		generatedList.get(counter).addDate(tempDate);
            //	}
        }

        this.sortProvidedList(generatedList);

        this.callEditMasterList(generatedList,Header);

        this.saveNewAlreadyThereList(generatedList,Header);

    }

    public void editHeaderDateList(int location, date newDate)
    {
        //Header.
    }

    private void sortStudentList()
    {
        int n = studentList.size();
        student temp = new student();

        for (int c1 = 0; c1 < n; c1++)
        {
            for (int j = 1; j < (n - c1); j++)
            {
                if (studentList.get(j-1).getId() > studentList.get(j).getId())
                {
                    temp = studentList.get(j-1);
                    studentList.set(j - 1,studentList.get(j));
                    studentList.set(j,temp);
                }

            }
        }
    }

    public ArrayList<student> sortProvidedList(ArrayList<student> providedList)
    {
        int n = providedList.size();
        student temp = new student();

        for (int c1 = 0; c1 < n; c1++)
        {
            for (int j = 1; j < (n - c1); j++)
            {
                if (providedList.get(j-1).getId() > providedList.get(j).getId())
                {
                    temp = providedList.get(j-1);
                    providedList.set(j - 1,providedList.get(j));
                    providedList.set(j,temp);
                }

            }
        }

        return providedList;
    }

    public ArrayList<Integer> sortProvidedIntegerList(ArrayList<Integer> providedList)
    {
        int n = providedList.size();
        int temp;

        for (int c1 = 0; c1 < n; c1++)
        {
            for (int j = 1; j < (n - c1); j++)
            {
                if (providedList.get(j-1) > providedList.get(j))
                {
                    temp = providedList.get(j-1);
                    providedList.set(j - 1,providedList.get(j));
                    providedList.set(j,temp);
                }

            }
        }

        return providedList;
    }

    private void callMakeNewSheet (ArrayList<student> processedList) throws IOException
    {
        //sheet.makeNewSheet(processedList);
    }

    private void callMakeNewSheetWithName (ArrayList<student> processedList, String fileName) throws IOException
    {
        //sheet.makeNewSheetWithName(processedList,fileName);
    }

    private void callEditMasterList(ArrayList<student> processedList,header Iheader) throws Throwable
    {
        sheet.editMasterList(processedList,Header);
    }

    private void callMakeNewSheetWithStudentList () throws IOException
    {
        //sheet.makeNewSheet(studentList);
    }

    private ArrayList<Integer> convertStringtoArray (String idString)
    {
        ArrayList<Integer> idList;
        idList = new ArrayList<Integer>();
        String tempId;
        int idAdd;
        boolean isMore = true;

        while(isMore)
        {
            tempId = idString.substring(0, idString.indexOf(" "));
            idString = idString.substring(idString.indexOf(" ")+1, idString.length());

            idAdd = Integer.parseInt(tempId);
            idList.add(idAdd);

            if(idString.indexOf(" ")==-1)
            {
                isMore = false;
            }
        }

        return idList;

    }

    public void turnIdsIntoSheet (String idString) throws IOException
    {
        processId(convertStringtoArray(idString));
    }

    public void processId (ArrayList<Integer> idArray) throws IOException
    {
        ArrayList<student> newStudentList;
        newStudentList = new ArrayList<student>();

        for(int counter=0;counter<idArray.size();counter++)
        {
            newStudentList.add(studentList.get(simpleBinarySearch(studentIdList,idArray.get(counter))));
        }

        sortProvidedList(newStudentList);

        this.callMakeNewSheet(newStudentList);
    }

    private void simpleProcessId (int idArray) throws IOException
    {
        int indexHolder = simpleBinarySearch(studentIdList,idArray);
        if(indexHolder>-1)
        {
            if(this.simpleBinarySearch(generatedIdList, studentList.get(indexHolder).getId())!=-1)
            {
                System.out.println("Please don't use a duplicate Id!");
            }
            else
            {
                generatedList.add(studentList.get(indexHolder));
                generatedIdList.add(studentList.get(indexHolder).getId());
            }
        }
        else
        {
            System.out.println("Please use a valid Id");
        }

    }

    private void simpleProcessIdMasterList (int idInput) throws IOException
    {
        int indexHolder = simpleBinarySearch(schoolStudentIdList,idInput);
        student tempStudent = new student();
        date tempDate = new date(1);
        date emptyTempDate = new date(0);
        ArrayList<student> tempStudentList = new ArrayList<student>();
        for(int counter=0;counter<generatedList.size();counter++)
        {
            tempStudentList.add(generatedList.get(counter));
        }

        if(indexHolder>-1)
        {
            int alreadyThereIdListBinaryResult = this.simpleBinarySearch(alreadyThereIdList, idInput);
            System.out.println("Begin generated list:");
            for(int counter=0;counter<generatedList.size();counter++)
            {
                System.out.println(generatedList.get(counter));
            }
            if(this.simpleBinarySearch(generatedIdList, idInput)!=-1)
            {
                System.out.println("Please don't use a duplicate Id!");
            }
            else if(alreadyThereIdListBinaryResult > -1)
            {
                /*
                System.out.println("Ping O0");
                System.out.println(tempStudentList.get(alreadyThereIdListBinaryResult));

                System.out.println("Begin generated list #0:");
                for(int counter=0;counter<tempStudentList.size();counter++)
                {
                    System.out.println(tempStudentList.get(counter));
                }
                */

                tempStudentList.get(alreadyThereIdListBinaryResult).addDate(tempDate);
                generatedIdList.add(idInput);
                System.out.println("Student added to generated list "+ tempStudentList.get(alreadyThereIdListBinaryResult));
/*
                System.out.println("Begin generated list #1:");
                for(int counter=0;counter<tempStudentList.size();counter++)
                {
                    System.out.println(tempStudentList.get(counter));
                }
                System.out.println("Student added to generated list "+ tempStudentList.get(alreadyThereIdListBinaryResult)+"Ping 0");
                */
            }
            else
            {
                student tempStudent0 = new student();
                //System.out.println("person to be added: "+schoolStudentList.get(indexHolder));
                tempStudent0 = schoolStudentList.get(indexHolder);
                ArrayList<date> replacementList = new ArrayList<date>();
                tempStudent0.resetDateList(replacementList);
                //System.out.println("Ping 4: "+tempStudent0.getDateList().size());
                for(int counter = 0;counter<Header.getDateList().size()-1;counter++)
                {
                    //System.out.println("Ping 2");
                    tempStudent0.addDate(new date(0,Header.getDateList().get(counter).getDate()));
                }
                if(tempStudent0.getDateList().size()<Header.getDateList().size())
                {
                    //System.out.println("Ping 3: "+tempStudent0.getDateList().size());
                    tempStudent0.addDate(tempDate);
                }

                tempStudentList.add(tempStudent0);
                //generatedIdList.add(schoolStudentList.get(indexHolder).getId());
                generatedIdList.add(idInput);
                System.out.println("Student added to generated list "+ tempStudent0);
                this.sortProvidedIntegerList(generatedIdList);
            }
        }
        else
        {
            System.out.println("Please use a valid Id");
        }

        generatedList = tempStudentList;

    }

    public ArrayList<Integer> makeIntList (ArrayList<student> processee)
    {
        ArrayList<Integer> returner;
        returner = new ArrayList<Integer>();
        for(int counter=0;counter<processee.size();counter++)
        {
            returner.add(processee.get(counter).getId());
        }

        return returner;
    }

    private int binarySearch(ArrayList<Integer> studentIdListFull, int key, int low, int high)
    {
        int index = Integer.MAX_VALUE;

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if(mid >= studentIdListFull.size())
            {
                index = -1;
                break;
            }
            if (studentIdListFull.get(mid) < key)
            {
                low = mid + 1;
            }
            else if (studentIdListFull.get(mid) > key)
            {
                high = mid - 1;
            } else if (studentIdListFull.get(mid) == key)
            {
                index = mid;
                break;
            }
        }
        if (index > 10000000)//change to variable derived from excel sheet
        {
            index = -1;
        }
        return index;
    }

    private int simpleBinarySearch(ArrayList<Integer> studentIdListFull, int key)
    {
        if(studentIdListFull.size()==0)
        {
            return -1;
        }
        return binarySearch(studentIdListFull,key,0,studentIdListFull.size());
    }

    public ArrayList<student> getStudentList ()
    {
        return alreadyThere;
    }

    public String toString()
    {
        String returner = "N/A";
        return returner;
    }
}
