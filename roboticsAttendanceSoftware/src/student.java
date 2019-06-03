import java.io.Serializable;
import java.util.ArrayList;


public class student implements Serializable
{
    private static final long serialVersionUID = 1510030108240529906L;

    private int id;
    private int grade;
    private String firstName;
    private String lastName;
    private String gender;
    private ArrayList<date> wasPresent;

    public student (int Iid, String IfirstName, String IlastName, String Igender, int Igrade)
    {
        id = Iid;
        grade = Igrade;
        firstName = IfirstName;
        lastName = IlastName;
        gender = Igender;
        wasPresent = new ArrayList<date>();
    }

    public student (int Iid, String IfirstName, String IlastName, String Igender, int Igrade, ArrayList<date> IwasPresent)
    {
        id = Iid;
        grade = Igrade;
        firstName = IfirstName;
        lastName = IlastName;
        gender = Igender;
        wasPresent = new ArrayList<date>();
        wasPresent = IwasPresent;
    }

    public student(int Iid, String IfirstName, String IlastName, ArrayList<date> IwasPresent)
    {
        id = Iid;
        grade = 0;
        firstName = IfirstName;
        lastName = IlastName;
        gender = "N/A";
        wasPresent = new ArrayList<date>();
        wasPresent = IwasPresent;
    }

    public student ()
    {
        id = 0;
        grade = 0;
        firstName = "0";
        lastName = "0";
        gender = "0";
        wasPresent = new ArrayList<date>();
    }

    public int getId()
    {
        return id;
    }

    public int getGrade()
    {
        return grade;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public void changeId(int replace)
    {
        id = replace;
    }

    public void changeGrade(int replace)
    {
        grade = replace;
    }

    public void changeFirstName(String replace)
    {
        firstName = replace;
    }

    public void changeLastName(String replace)
    {
        lastName = replace;
    }

    public void changeGender(String replace)
    {
        gender = replace;
    }

    public void addDate(date Idate)
    {
        wasPresent.add(Idate);
    }

    public date getDate(int Iindex)
    {
        return wasPresent.get(Iindex);
    }

    public ArrayList<date> getDateList()
    {
        return wasPresent;
    }

    public void resetDateList (ArrayList<date> replacement)
    {
        wasPresent = replacement;
    }


    public String toString()
    {
        String returner = id + " " + lastName + " " + firstName + " ";
        if(wasPresent.size()==0)
        {
            System.out.println("Nothing in date list");
        }
        for(int counter=0;counter<wasPresent.size();counter++)
        {
            returner = returner + wasPresent.get(counter).getWasPresent()+" ";
        }
        return returner;
    }
}

/*
package Reader;

import java.io.Serializable;
import java.util.ArrayList;

public class student implements Serializable
{
	private static final long serialVersionUID = 9009336582624157865L;

	private int id;
	private int grade;
	private String firstName;
	private String lastName;
	private String gender;
	private ArrayList<date> wasPresent;

	public student (int Iid, String IfirstName, String IlastName, String Igender, int Igrade)
	{
		id = Iid;
		grade = Igrade;
		firstName = IfirstName;
		lastName = IlastName;
		gender = Igender;
		wasPresent = new ArrayList<date>();
	}

	public student (int Iid, String IfirstName, String IlastName, String Igender, int Igrade, ArrayList<date> IwasPresent)
	{
		id = Iid;
		grade = Igrade;
		firstName = IfirstName;
		lastName = IlastName;
		gender = Igender;
		wasPresent = new ArrayList<date>();
		wasPresent = IwasPresent;
	}

	public student(int Iid, String IfirstName, String IlastName, ArrayList<date> IwasPresent)
	{
		id = Iid;
		grade = 0;
		firstName = IfirstName;
		lastName = IlastName;
		gender = "N/A";
		wasPresent = new ArrayList<date>();
		wasPresent = IwasPresent;
	}

	public student ()
	{
		id = 0;
		grade = 0;
		firstName = "0";
		lastName = "0";
		gender = "0";
		wasPresent = new ArrayList<date>();
	}

	public int getId()
	{
		return id;
	}

	public int getGrade()
	{
		return grade;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public String getGender()
	{
		return gender;
	}

	public void changeId(int replace)
	{
		id = replace;
	}

	public void changeGrade(int replace)
	{
		grade = replace;
	}

	public void changeFirstName(String replace)
	{
		firstName = replace;
	}

	public void changeLastName(String replace)
	{
		lastName = replace;
	}

	public void changeGender(String replace)
	{
		gender = replace;
	}

	public void addDate(date Idate)
	{
		wasPresent.add(Idate);
	}

	public date getDate(int Iindex)
	{
		return wasPresent.get(Iindex);
	}

	public ArrayList<date> getDateList()
	{
		return wasPresent;
	}


	public String toString()
	{
		String returner = id + " " + lastName + " " + firstName + " ";
		if(wasPresent.size()==0)
		{
			System.out.println("Nothing in date list");
		}
		for(int counter=0;counter<wasPresent.size();counter++)
		{
			returner = returner + "(" + wasPresent.get(counter).getDate()+" "+wasPresent.get(counter).getWasPresent()+") ";
		}
		return returner;
	}

}

 */