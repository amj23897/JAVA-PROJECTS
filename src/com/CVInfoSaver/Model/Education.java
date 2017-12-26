package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.CVInfoSaver.Connection.CV_DBConnection;
import com.CVInfoSaver.Exception.NoStudentException;

public class Education
{
	//10th
	private float sscPercentage ;
	private String sscBoard;
	private int sscPassingYear;
	//12th
	private float hscPercentage ;
	private String hscBoard;
	private int hscPassingYear;
	//College
	private String degree ;
	private String collegeName;
	private float cgpaObtained ;
	private float cgpaTot ;
	private String grade ; 
	
	//NonParameterized Constructor
	public Education() 
	{
		
	}
	
	//Parameterized Constructor
	public Education(float sscPercent ,String sscBoard , int sscPassYear , float hscPercent ,String hscBoard , int hscPassYear ,String degree , String collegeName, float cgpaObt , float cgpaTot , String Grade) 
	{
		this.sscPercentage = sscPercent;
		this.sscBoard = sscBoard;
		this.sscPassingYear = sscPassYear ;
		this.hscPercentage = hscPercent;
		this.hscBoard = hscBoard;
		this.hscPassingYear = hscPassYear ;
		this.degree = degree;
		this.collegeName = collegeName;
		this.cgpaObtained = cgpaObt ;
		this.cgpaTot = cgpaTot ;
		this.grade = Grade;
	}
	
	//Saving data of Single Education database 
	public void save() throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to save education details...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.education VALUES( '"
				   	+ this.sscPercentage + "', '"
		   + this.sscBoard+ "', '"
		   			+ this.sscPassingYear+ "', '"
		   + this.hscPercentage + "', '"
		   			+ this.hscBoard+ "', '"
		   + this.hscPassingYear+ "', '"
		   			+ this.degree+ "', '"
		   + this.collegeName+ "', '"
		   			+ String.valueOf(this.cgpaObtained)+ "', '"
		   + String.valueOf(this.cgpaTot)+ "', '"
		   			+this.grade +"');";
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());
		}
	}
	
	//Updating data of saved single student from database	
	//Since education info is being modified on basis college name , it should also be passed (in case user edits it also)
	public void update(String oldCollegeName) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to edit Edcation details...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.education SET " +
		    "`S.S.C Percentage` = '" +String.valueOf(this.sscPercentage)  +"'"+
			",`S.S.C Board` ='" + this.sscBoard +"'"+
		    ",`S.S.C Passing Year` ='"+ String.valueOf(this.sscPassingYear)+"'"+
		    ",`H.S.C Percentage` = '" +String.valueOf(this.hscPercentage)  +"'"+
			",`H.S.C Board` ='" + this.hscBoard +"'"+
		    ",`H.S.C Passing Year` ='"+ String.valueOf(this.hscPassingYear)+"'"+
		    ",`Degree` ='"+ this.degree+"'" +
		    ",`College Name`='"+ this.collegeName+"'"+
		    ",`CGPA Obtained` ='"+ this.cgpaObtained+"'"+ 
		    ",`CGPA Total` ='"+ this.cgpaTot+"'" +
		    ",`Grade` ='"+ this.grade+"';" ;
		    
		    sql+="WHERE College Name` = '" + oldCollegeName+ "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	//Fetch saved data
	public Education fetch() throws SQLException,NoStudentException,Exception
	{
		
		Education edu = new Education();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Education Data...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    	sql = "SELECT * FROM cvinfosaver.education;";
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    if(rs.next())
   	    {
		   edu.setSscPercentage(rs.getFloat("S.S.C Percentage"));
		   edu.setSscBoard(rs.getString("S.S.C Board"));
		   edu.setSscPassingYear(rs.getInt("S.S.C Passing Year"));
		   edu.setHscPercentage(rs.getFloat("H.S.C Percentage"));
		   edu.setHscBoard(rs.getString("H.S.C Board"));
		   edu.setHscPassingYear(rs.getInt("H.S.C Passing Year"));
		   edu.setDegree(rs.getString("Degree"));
		   edu.setCollegeName(rs.getString("College Name"));
		   edu.setCgpaObtained(rs.getFloat("CGPA Obtained"));
		   edu.setCgpaTot(rs.getFloat("CGPA Total"));
		   edu.setGrade(rs.getString("Grade"));
	   }
   	    else
   	    {
   	    	throw new NoStudentException();
   	    }
	   return edu;
	}
	
	//Getter and Setter Functions
	public float getHscPercentage() {
		return hscPercentage;
	}

	public void setHscPercentage(float hscPercentage) {
		this.hscPercentage = hscPercentage;
	}

	public float getSscPercentage() {
		return sscPercentage;
	}

	public void setSscPercentage(float sscPercentage) {
		this.sscPercentage = sscPercentage;
	}

	public float getCgpaObtained() {
		return cgpaObtained;
	}

	public void setCgpaObtained(float cgpaObtained) {
		this.cgpaObtained = cgpaObtained;
	}

	public float getCgpaTot() {
		return cgpaTot;
	}

	public void setCgpaTot(float cgpaTot) {
		this.cgpaTot = cgpaTot;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSscBoard() {
		return sscBoard;
	}

	public void setSscBoard(String sscBoard) {
		this.sscBoard = sscBoard;
	}

	public int getSscPassingYear() {
		return sscPassingYear;
	}

	public void setSscPassingYear(int sscPassingYear) {
		this.sscPassingYear = sscPassingYear;
	}

	public String getHscBoard() {
		return hscBoard;
	}

	public void setHscBoard(String hscBoard) {
		this.hscBoard = hscBoard;
	}

	public int getHscPassingYear() {
		return hscPassingYear;
	}

	public void setHscPassingYear(int hscPassingYear) {
		this.hscPassingYear = hscPassingYear;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
