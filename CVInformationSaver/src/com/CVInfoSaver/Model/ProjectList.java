package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CVInfoSaver.Connection.CV_DBConnection;

public class ProjectList extends Project implements Listable
{
	public ProjectList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Project> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Project> list = new ArrayList<Project>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Projects ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    if(star)
 	    {
   	    	sql = "SELECT `Project Title` , Semester , `Project Mentor` , `Project Duration` , `No Of Team Members` , `Project Description`  FROM cvinfosaver.project WHERE Star = 1  ORDER BY Semester ASC;";
    	}
   	    else
   	    {
   	    	sql = "SELECT `Project Title` , Semester , `Project Mentor` , `Project Duration` , `No Of Team Members` , `Project Description`  FROM cvinfosaver.project WHERE Star = 0  ORDER BY Semester ASC;";
   	    }
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    while(rs.next())
   	    {
		   Project prj = new Project();
		   
		   prj.setProjectTitle(rs.getString("Project Title"));
		   prj.setSemester(rs.getInt("Semester"));
		   prj.setProjectMentor(rs.getString("Project Mentor"));
		   prj.setProjectDuration(rs.getString(("Project Duration")));
		   prj.setNoOfTeamMembers(rs.getInt("Project Professor"));
		   prj.setProjectDescription(rs.getString("Project Description"));
		   
		   list.add(prj);
	   } 
	   return list;
	}
	
	public ArrayList<Project> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Project> list = new ArrayList<Project>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Projects ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
		{
			sql = "SELECT `Project No` , Semester , `Project Name` , `Project Grade` , `Project Professor` , `Project Description`  FROM cvinfosaver.project WHERE Star = 1 , Semester = '"+String.valueOf(semester)+"' ORDER BY Semester ASC;";
		}
		else
		{	
			sql = "SELECT `Project No` , Semester , `Project Name` , `Project Grade` , `Project Professor` , `Project Description`  FROM cvinfosaver.project WHERE Star = 0 , Semester = '"+String.valueOf(semester)+"' ORDER BY Semester ASC;";
		}
		   
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Project prj = new Project();   
		   
		   prj.setProjectTitle(rs.getString("Project Title"));
		   prj.setSemester(rs.getInt("Semester"));
		   prj.setProjectMentor(rs.getString("Project Mentor"));
		   prj.setProjectDuration(rs.getString(("Project Duration")));
		   prj.setNoOfTeamMembers(rs.getInt("Project Professor"));
		   prj.setProjectDescription(rs.getString("Project Description"));
		   
		   list.add(prj);
	   }
	   return list;
	}
	
	public void addRecord(CVData newProject) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Project ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.project VALUES( '"
				   	+ ((Project)newProject).getProjectTitle() + "', '"
		   + ((Project)newProject).getSemester() + "', '"
		   			+ ((Project)newProject).getProjectMentor()+ "', '"
		   + ((Project)newProject).getProjectDuration() + "', '"
		           + ((Project)newProject).getNoOfTeamMembers() + "', '"
		   + ((Project)newProject).getProjectDescription() + "'";
		   if(((Project)newProject).isStarred())
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
	
	//Since project is being modified on basis project title old project title should also be passed (in case user edits project title )
	public void updateRecord(CVData modProject , String oldProjectTitle) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Project ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.project SET " +
		    "`Project Title` = '" + ((Project)modProject).getProjectTitle()+"'"+
			",`Semester` ='" + String.valueOf(((Project)modProject).getSemester()) +"'"+
		    ",`Project Mentor` ='"+ ((Project)modProject).getProjectMentor() +"'"+
		    ",`Project Duration` ='"+ ((Project)modProject).getProjectDuration()+"'" +
		    ",`No Of Team Members`='"+ ((Project)modProject).getNoOfTeamMembers() +"'"+
		    ",`Project Description` ='"+ ((Project)modProject).getProjectDescription()+"'" ;
		    if(((Project)modProject).isStarred())
				   sql+=",`Star`='1'";
			   else
				   sql+=",`Star`='0'";
		    
		    sql+="WHERE Project Title` = '" + oldProjectTitle + "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String projectTitle) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.project " +
		    "WHERE `Project Title` = '" + projectTitle+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}
