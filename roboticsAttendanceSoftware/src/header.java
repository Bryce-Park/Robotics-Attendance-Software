import java.util.ArrayList;
import java.io.Serializable;


public class header implements Serializable
{
    //private static final long serialVersionUID = 4822139227948683121L;
    private static final long serialVersionUID = 4686448020109114587L;
    private String id;
    private String firstName;
    private String lastName;
    private ArrayList<date> wasPresent;

    public header(String Iid, String IfirstName, String IlastName, ArrayList<date> IwasPresent)
    {
        id = Iid;
        firstName = IfirstName;
        lastName = IlastName;
        wasPresent = IwasPresent;
    }
    public header(ArrayList<date> IwasPresent)
    {
        id = "ID Number";
        firstName = "First Name";
        lastName = "Last Name";
        wasPresent = IwasPresent;
    }
    public header()
    {
        id = "ID Number";
        firstName = "First Name";
        lastName = "Last Name";
        wasPresent = new ArrayList<date>();
    }

    public void sortDateList()
    {
        int n = wasPresent.size();
        date temp;

        for (int c1 = 0; c1 < n; c1++)
        {
            for (int j = 1; j < (n - c1); j++)
            {
                if (wasPresent.get(j-1).getValue() > wasPresent.get(j).getValue())
                {
                    temp = wasPresent.get(j-1);
                    wasPresent.set(j - 1,wasPresent.get(j));
                    wasPresent.set(j,temp);
                }
            }
        }
    }

    public void addNewDateList(ArrayList<date> newDateList)
    {
        wasPresent = newDateList;
    }

    public void addToDateList(date Idate)
    {
        wasPresent.add(Idate);
    }

    public String getId()
    {
        return id;
    }
    public String getLastName()
    {
        return lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public ArrayList<date> getDateList()
    {
        return wasPresent;
    }
    public void editDate (date newDate, int location)
    {
        wasPresent.set(location, newDate);
    }
    public String toString()
    {
        String returner = id+" "+lastName+" "+firstName+" ";
        for(int counter=0;counter<wasPresent.size();counter++)
        {
            returner = returner+" "+wasPresent.get(counter).getDate()+" ";
        }
        return returner;
    }
}
