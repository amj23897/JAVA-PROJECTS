 package com.CVInfoSaver.Model ;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CVInfoSaver.Connection.CV_DBConnection;

public class InternshipList extends Internship implements Listable
{
	public InternshipList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Internship> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Internship> list = new ArrayList<Internship>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Internships ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    if(star)
 	    {
   	    	sql = "SELECT Semester , `Organization Name` , `Internship Period` ,`Internship Description` FROM cvinfosaver.internship WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT Semester , `Organization Name` , `Internship Period` ,`Internship Description` FROM cvinfosaver.internship WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    while(rs.next())
   	    {
		   Internship prj = new Internship();
		   
		   prj.setSemester(rs.getInt("Semester"));
		   prj.setOrganizationName(rs.getString("Internship Mentor"));
		   prj.setInternshipPeriod(rs.getString(("Internship Duration")));
		   prj.setInternshipDescription(rs.getString("Internship Description"));
		   
		   list.add(prj);
	   } 
	   return list;
	}
	
	public ArrayList<Internship> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Internship> list = new ArrayList<Internship>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Internships ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
		{
			sql = "SELECT Semester , `Organization Name` , `Internship Period` ,`Internship Description` FROM cvinfosaver.internship WHERE Star = 1 , Semester = '"+String.valueOf(semester)+"' ORDER BY Semester ASC;";
		}
		else
		{	
			sql = "SELECT Semester , `Organization Name` , `Internship Period` ,`Internship Description` FROM cvinfosaver.internship WHERE Star = 0 , Semester = '"+String.valueOf(semester)+"' ORDER BY Semester ASC;";
		}
		   
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Internship prj = new Internship();   
		   
		   prj.setSemester(rs.getInt("Semester"));
		   prj.setOrganizationName(rs.getString("Internship Mentor"));
		   prj.setInternshipPeriod(rs.getString(("Internship Duration")));
		   prj.setInternshipDescription(rs.getString("Internship Description"));
		   
		   list.add(prj);
	   }
	   return list;
	}
	
	public void addRecord(CVData newInternship) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Internship ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.internship VALUES( '"
				   	+ ((Internship)newInternship).getSemester() + "', '"
		   + ((Internship)newInternship).getOrganizationName() + "', '"
		   			+ ((Internship)newInternship).getInternshipPeriod() + "', '"
		   + ((Internship)newInternship).getInternshipDescription() + "'";
		   if(((Internship)newInternship).isStarred())
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
	
	//Since internship is being modified on basis internship description old internship description should also be passed (in case user edits internship description )
	public void updateRecord(CVData modInternship , String oldInternshipDescription ) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Internship ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.internship SET " +
		    "`Semester` ='" + String.valueOf(((Internship)modInternship).getSemester()) +"'"+
		    ",`Organization Name` ='"+ ((Internship)modInternship).getOrganizationName() +"'"+
		    ",`Internship Period` ='"+ ((Internship)modInternship).getInternshipPeriod()+"'" +
		    ",`Internship Description` ='"+ ((Internship)modInternship).getInternshipDescription()+"'" ;
		    if(((Internship)modInternship).isStarred())
				   sql+=",`Star`='1'";
			   else
				   sql+=",`Star`='0'";
		    sql+="where Internship Description` = '" + oldInternshipDescription+ "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String internshipDescription) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.internship " +
		    "WHERE `Internship Description` = '" + internshipDescription+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}
