package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CVInfoSaver.Connection.CV_DBConnection;

public class AchievementList extends Achievement implements Listable
{
	public AchievementList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Achievement> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Achievements ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    if(star)
 	    {
   	    	sql = "SELECT  Semester , `Achievement Description` , `Achievement Date` , `Certified Or Awarded` FROM cvinfosaver.achievement WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT Semester , `Achievement Description` , `Achievement Date` , `Certified Or Awarded` FROM cvinfosaver.achievement ORDER BY Semester ASC;";
   	    }
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    while(rs.next())
   	    {
		   Achievement ach = new Achievement();
		   
		   ach.setSemester(rs.getInt("Semester"));
		   ach.setAchievementDescription(rs.getString("Achievement Description"));
		   ach.setAchievementDate(rs.getString(("Achievement Date")));
		   ach.setCertifiedORAwarded(rs.getBoolean("Certified Or Awarded"));
		   
		   list.add(ach);
	   } 
	   return list;
	}
	
	public ArrayList<Achievement> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Achievement> list = new ArrayList<Achievement>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Achievements ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
 	    {
   	    	sql = "SELECT  Semester , `Achievement Description` , `Achievement Date` , `Certified Or Awarded` FROM cvinfosaver.achievementWHERE Star = 1 and Semester = "+semester+" ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT Semester , `Achievement Description` , `Achievement Date` , `Certified Or Awarded` FROM cvinfosaver.achievement WHERE Semester = "+semester+" ORDER BY Semester ASC;";
   	    }
		   
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Achievement ach = new Achievement();   
		   
		   ach.setSemester(rs.getInt("Semester"));
		   ach.setAchievementDescription(rs.getString("Achievement Description"));
		   ach.setAchievementDate(rs.getString(("Achievement Date")));
		   ach.setCertifiedORAwarded(rs.getBoolean("Certified Or Awarded"));
		   
		   list.add(ach);
	   }
	   return list;
	}
	
	public void addRecord(CVData newAchievement) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Achievement ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.achievement VALUES( '"
				   	+ ((Achievement)newAchievement).getSemester()  + "', '"
		   +((Achievement)newAchievement).getAchievementDescription()  + "', '"
		   			+ ((Achievement)newAchievement).getAchievementDate() + "'," ;
		   if( ((Achievement)newAchievement).isCertifiedORAwarded() )
			   sql+= "'1'";
		   else
			   sql+= "'0'";
		   
		   if(((Achievement)newAchievement).isStarred())
			   sql+=",'1'"+");";
		   else
			   sql+=",'0'"+");";
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());
		}
	}
	
	//Since achievement is being modified on basis achievement description ,old achievement description should also be passed (in case user edits achievement Description)
	public void updateRecord(CVData modAchievement , String oldAchievementDescription) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Achievement ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.achievement SET " +
		    "`Semester` ='" + String.valueOf(((Achievement)modAchievement).getSemester()) +"'"+
		    ",`Achievement Description` ='"+ ((Achievement)modAchievement).getAchievementDescription()+"'" +
		    ",`Achievement Date` ='"+ ((Achievement)modAchievement).getAchievementDate()+"'" +
		    ",`Certified Or Awarded`="; 
		   if( ((Achievement)modAchievement).isCertifiedORAwarded() )
			   sql+= "'1'";
		   else
			   sql+= "'0'";
		   if(((Achievement)modAchievement).isStarred())
			   sql+=",`Star`='1'";
		   else
			   sql+=",`Star`='0'";
		   
		   sql+= "WHERE `Achievement Description` = '" + oldAchievementDescription + "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String achievementDescription) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.achievement " +
		    "WHERE `Achievement Description` = '" + achievementDescription+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}
