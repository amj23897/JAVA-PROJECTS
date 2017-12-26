package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList; 

import com.CVInfoSaver.Connection.CV_DBConnection;

public class WorkshopList extends Workshop implements Listable
{
	public WorkshopList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Workshop> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Workshop> list = new ArrayList<Workshop>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Workshops ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    if(star)
 	    {
   	    	sql = "SELECT  Semester , `Workshop Title` ,`Workshop Teacher` ,`Workshop Organizer`,  `Workshop Date` , `Workshop Description` , `Certified` FROM cvinfosaver.workshop WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT  Semester , `Workshop Title` ,`Workshop Teacher` ,`Workshop Organizer`,  `Workshop Date` , `Workshop Description` , `Certified` FROM cvinfosaver.workshop WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    while(rs.next())
   	    {
		   Workshop wshp = new Workshop();
		   
		   wshp.setSemester(rs.getInt("Semester"));
		   wshp.setWorkshopTitle(rs.getString("Workshop Title"));
		   wshp.setWorkshopTeacher(rs.getString("Workshop Teacher"));
		   wshp.setWorkshopOrganizer(rs.getString("Workshop Organizer"));
		   wshp.setWorkshopDate(rs.getString(("Workshop Date")));
		   wshp.setWorkshopDescription(rs.getString("Workshop Description"));
		   wshp.setCertified(rs.getBoolean("Ceritfied"));
		   
		   list.add(wshp);
	   } 
	   return list;
	}
	
	public ArrayList<Workshop> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Workshop> list = new ArrayList<Workshop>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Workshops ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
 	    {
   	    	sql = "SELECT  Semester , `Workshop Title` ,`Workshop Teacher` ,`Workshop Organizer`,  `Workshop Date` , `Workshop Description` , `Certified` FROM cvinfosaver.workshop WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT  Semester , `Workshop Title` ,`Workshop Teacher` ,`Workshop Organizer`,  `Workshop Date` , `Workshop Description` , `Certified` FROM cvinfosaver.workshop WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
	      
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Workshop wshp = new Workshop();   
		   
		   wshp.setSemester(rs.getInt("Semester"));
		   wshp.setWorkshopTitle(rs.getString("Workshop Title"));
		   wshp.setWorkshopTeacher(rs.getString("Workshop Teacher"));
		   wshp.setWorkshopOrganizer(rs.getString("Workshop Organizer"));
		   wshp.setWorkshopDate(rs.getString(("Workshop Date")));
		   wshp.setWorkshopDescription(rs.getString("Workshop Description"));
		   wshp.setCertified(rs.getBoolean("Ceritfied"));
		   
		   list.add(wshp);
	   }
	   return list;
	}
	
	public void addRecord(CVData newWorkshop) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Workshop ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.workshop VALUES( '"
				   	+ ((Workshop)newWorkshop).getSemester()  + "', '"
		   +((Workshop)newWorkshop).getWorkshopTitle()  + "', '"
				   + ((Workshop)newWorkshop).getWorkshopTeacher() + "', '"
		   +((Workshop)newWorkshop).getWorkshopOrganizer()  + "', '"
		   			+((Workshop)newWorkshop).getWorkshopDate()  + "', '"
		   + ((Workshop)newWorkshop).getWorkshopDescription() + "', " ;
		   if( ((Workshop)newWorkshop).isCertified() )
			   sql+= "'1'";
		   else
			   sql+= "'0'";
		   
		   if(((Workshop)newWorkshop).isStarred())
			   sql+=",'1' );";
		   else
			   sql+=",'0' );";
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());
		}
	}
	
	//Since workshop is being modified on basis workshop title ,old workshop title should also be passed (in case user edits workshop title )
	public void updateRecord(CVData modWorkshop , String oldWorkshopTitle) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Workshop ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.workshop SET " +
		    "`Semester` ='" + String.valueOf(((Workshop)modWorkshop).getSemester()) +"'"+
		    ",`Workshop Title` ='"+ ((Workshop)modWorkshop).getWorkshopTitle()+"'" +
		    ",`Workshop Teacher` ='"+ ((Workshop)modWorkshop).getWorkshopTeacher()+"'" +
		    ",`Workshop Organizer` ='"+ ((Workshop)modWorkshop).getWorkshopOrganizer()+"'" +
		    ",`Workshop Date` ='"+ ((Workshop)modWorkshop).getWorkshopDate()+"'" +
		    ",`Workshop Description` ='"+ ((Workshop)modWorkshop).getWorkshopDescription()+"'" +
		    ",`Certified`="; 
		   if( ((Workshop)modWorkshop).isCertified())
			   sql+= "'1'";
		   else
			   sql+= "'0'";
		   if(((Workshop)modWorkshop).isStarred())
			   sql+=",`Star`='1' ";
		   else
			   sql+=",`Star`='0' ";
		   
		   sql+= "WHERE `Workshop Title` = '" + oldWorkshopTitle+ "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String workshopTitle) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.workshop " +
		    "WHERE `Workshop Title` = '" + workshopTitle+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}
