package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CVInfoSaver.Connection.CV_DBConnection;

public class MiscellaneousList extends Miscellaneous implements Listable
{
	public MiscellaneousList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Miscellaneous> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Miscellaneous> list = new ArrayList<Miscellaneous>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Miscellaneouss ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    if(star)
 	    {
   	    	sql = "SELECT  Semester , `Description` , `Date` FROM cvinfosaver.miscellaneous WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT Semester , `Description` , `Date` FROM cvinfosaver.miscellaneous WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    while(rs.next())
   	    {
		   Miscellaneous misc = new Miscellaneous();
		   
		   misc.setSemester(rs.getInt("Semester"));
		   misc.setDescription(rs.getString("Description"));
		   misc.setDate(rs.getString(("Date")));
		   
		   list.add(misc);
	   } 
	   return list;
	}
	
	public ArrayList<Miscellaneous> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Miscellaneous> list = new ArrayList<Miscellaneous>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Miscellaneouss ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
 	    {
   	    	sql = "SELECT  Semester , `Description` , `Date` FROM cvinfosaver.miscellaneous WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT Semester , `Description` , `Date` FROM cvinfosaver.miscellaneous WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
		   
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Miscellaneous misc = new Miscellaneous();   
		   
		   misc.setSemester(rs.getInt("Semester"));
		   misc.setDescription(rs.getString("Description"));
		   misc.setDate(rs.getString(("Date")));
		   
		   list.add(misc);
	   }
	   return list;
	}
	
	public void addRecord(CVData newMiscellaneous) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Miscellaneous ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.miscellaneous VALUES( '"
				   	+ ((Miscellaneous)newMiscellaneous).getSemester()  + "', '"
		   +((Miscellaneous)newMiscellaneous).getDescription()  + "', '"
		   			+ ((Miscellaneous)newMiscellaneous).getDate() + "'," ;
		   if(((Miscellaneous)newMiscellaneous).isStarred())
			   sql+="'1');";
		   else
			   sql+="'0');";
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());
		}
	}
	
	//Since miscellaneous is being modified on basis miscellaneous description ,old miscellaneous description should also be passed (in case user edits miscellaneous Description)
	public void updateRecord(CVData modMiscellaneous , String oldMiscellaneousDescription) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Miscellaneous ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.miscellaneous SET " +
		    "`Semester` ='" + String.valueOf(((Miscellaneous)modMiscellaneous).getSemester()) +"'"+
		    ",`Description` ='"+ ((Miscellaneous)modMiscellaneous).getDescription()+"'" +
		    ",`Date` ='"+ ((Miscellaneous)modMiscellaneous).getDate()+"'" ;
		    
		   if(((Miscellaneous)modMiscellaneous).isStarred())
			   sql+=",`Star`='1' ";
		   else
			   sql+=",`Star`='0' ";
		   
		   sql+= "WHERE `Description` = '" + oldMiscellaneousDescription + "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String miscellaneousDescription) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.miscellaneous" +
		    " WHERE `Description` = '" + miscellaneousDescription+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}