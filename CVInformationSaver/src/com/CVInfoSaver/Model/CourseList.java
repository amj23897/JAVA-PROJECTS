package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CVInfoSaver.Connection.CV_DBConnection;

public class CourseList extends Course implements Listable
{
	public CourseList() //NonParameterized Constructor
	{	
	}
	
	public ArrayList<Course> fetchRecords(boolean star) throws SQLException, Exception		//Function fetches records of all semesters
	{
		ArrayList<Course> list = new ArrayList<Course>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Courses ...");
	   Connection conn = CV_DBConnection.getConnection();
	   Statement stmt = conn.createStatement();
	   String sql;
	   if(star)
	   {
		   sql = "SELECT `Course No` , Semester , `Course Name` , `Course Grade` , `Course Professor` , `Course Description`  FROM cvinfosaver.course WHERE Star = 1 ORDER BY Semester ASC;";
	   }
	   else
	   {
		   sql = "SELECT `Course No` , Semester , `Course Name` , `Course Grade` , `Course Professor` , `Course Description`  FROM cvinfosaver.course ORDER BY Semester ASC;";
	   }
	   
	   ResultSet rs = stmt.executeQuery(sql);
	   // Loop to extract data from result set
	   while(rs.next())
	   {
		   Course c = new Course();
		   
		   c.setCourseNo(rs.getString("Course No"));
		   c.setSemester(rs.getInt("Semester"));
		   c.setCourseName(rs.getString("Course Name"));
		   c.setCourseGrade(rs.getString("Course Grade"));
		   c.setCourseProf(rs.getString("Course Professor"));
		   c.setCourseDescription(rs.getString("Course Description"));
		   
		   list.add(c);
	   } 
	   return list;
	}
	
	public ArrayList<Course> fetchRecords(int semester ,boolean star) throws SQLException, Exception		//Function fetches records of specific semester
	{
		ArrayList<Course> list = new ArrayList<Course>();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Courses ...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
		if(star)
		{
			sql = "SELECT `Course No` , Semester , `Course Name` , `Course Grade` , `Course Professor` , `Course Description`  FROM cvinfosaver.course WHERE Star = 1 and Semester = "+semester+" ORDER BY Semester ASC;";
		}
		else
		{	
			sql = "SELECT `Course No` , Semester , `Course Name` , `Course Grade` , `Course Professor` , `Course Description`  FROM cvinfosaver.course WHERE Semester = "+semester+" ORDER BY Semester ASC;";
		}
		   
		ResultSet rs = stmt.executeQuery(sql);
		
		//Loop to extract data from result set
	   while(rs.next())
	   {
		   Course c = new Course();   
		   c.setCourseNo(rs.getString("Course No"));
		   c.setSemester(rs.getInt("Semester"));
		   c.setCourseName(rs.getString("Course Name"));
		   c.setCourseGrade("Course Grade");
		   c.setCourseProf("Course Professor");
		   c.setCourseDescription("Course Description");
		   list.add(c);
	   }
	   return list;
	}
	
	public void addRecord(CVData newCourse) throws SQLException			//Function to add record
	{
		try
		{
		   System.out.println("Creating statement to add Course ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.course VALUES( '"
				   	+ ((Course)newCourse).getCourseNo() + "', '"
		   + ((Course)newCourse).getSemester() + "', '"
		   			+ ((Course)newCourse).getCourseName()+ "', '"
		   + ((Course)newCourse).getCourseGrade() + "', '"
		           + ((Course)newCourse).getCourseProf() + "', '"
		   + ((Course)newCourse).getCourseDescription() + "'";
		   if( ((Course)newCourse).isStarred() )
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
	
	//Since course is being modified on basis course no old course no should also be passed (in case user edits course no)
	public void updateRecord(CVData modCourse , String oldCourseNo) throws SQLException
	{
		//STEP 4: Execute a query
		try
		{
		   System.out.println("Creating statement to update Course ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.course SET " +
		    "`Course No` = '" + ((Course)modCourse).getCourseNo()+"'"+
			",`Semester` ='" + String.valueOf(((Course)modCourse).getSemester()) +"'"+
		    ",`Course Name` ='"+ ((Course)modCourse).getCourseName() +"'"+
		    ",`Course Grade` ='"+ ((Course)modCourse).getCourseGrade()+"'" +
		    ",`Course Professor`='"+ ((Course)modCourse).getCourseProf() +"'"+
		    ",`Course Description` ='"+ ((Course)modCourse).getCourseDescription()+"'" ;
		    
		   if(((Course)modCourse).isStarred())
			   sql+=",`Star`='1'";
		   else
			   sql+=",`Star`='0'";
		      
		    sql+=" where `Course No` = '" + oldCourseNo + "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	public void deleteRecord(String courseNo) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to delete record...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for deleting
		   sql = "DELETE FROM cvinfosaver.course " +
		    "WHERE `Course No` = '" + courseNo+"';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
}
