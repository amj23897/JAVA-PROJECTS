package com.CVInfoSaver.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.CVInfoSaver.Connection.CV_DBConnection;
import com.CVInfoSaver.Exception.NoStudentException;

public class Student
{
	//personal information
	private String studentName;
	private String gender;
	private String studentContactNo ;
	private String studentAddress ;
	private String studentEmailId ;
	private String studentDateOfBirth ;
	private String studentHobbies ;
	private String fatherName ;
	private String motherName ;
	
	//Education Details (Overall)
	Education overallEducation ;
	
	//CvData of the student
	private CVData data;
	
	//NonParameterized Constructor
	public Student()
	{
	}
	
	//Parameterized Constructor
	public Student(String name , String gender , String contactNo , String address , String email , String dob ,String hobbies , String fatherName , String motherName , Education edu , CVData data)
	{
		this.studentName = name ;
		this.gender = gender;
		this.studentContactNo = contactNo;
		this.studentAddress = address ;
		this.studentEmailId = email ;
		this.studentDateOfBirth = dob ;
		this.studentHobbies = hobbies ;
		this.fatherName = fatherName ;
		this.motherName = motherName ;
		this.overallEducation = edu ;
		this.data =data;
	}
	
	//Saving data of Single Student in database 
	public void save() throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to save student details...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		 
		   //Query Code for adding
		   sql = "INSERT INTO cvinfosaver.student VALUES( '"
				   	+ this.studentName+ "', '"
		   + this.gender+ "', '"
		   			+ this.studentContactNo+ "', '"
		   + this.studentAddress + "', '"
		   			+ this.studentEmailId + "', '"
		   + this.studentDateOfBirth+ "', '"
		   			+ this.studentHobbies+ "', '"
		   + this.fatherName+ "', '"
		   			+ this.motherName+ "');";
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());
		}
	}
	//Fetch saved data
	public Student fetch() throws SQLException,NoStudentException,Exception
	{
		
		Student s = new Student();
		
		//Fetch Records from Database
		System.out.println("Creating statement to fetch Student Data...");
		Connection conn = CV_DBConnection.getConnection();
		Statement stmt = conn.createStatement();
		String sql;
   	    	sql = "SELECT * FROM cvinfosaver.student;";
	   
   	    ResultSet rs = stmt.executeQuery(sql);
   	    // Loop to extract data from result set
   	    if(rs.next())
   	    {
		   s.setStudentName(rs.getString("Name"));
		   s.setGender(rs.getString("Gender"));
		   s.setStudentContactNo(rs.getString(("Contact No")));
		   s.setStudentAddress(rs.getString("Address"));
		   s.setStudentEmailId(rs.getString("Email ID"));
		   s.setStudentDateOfBirth(rs.getString("Date Of Birth"));
		   s.setStudentHobbies(rs.getString("Hobbies"));
		   s.setFatherName(rs.getString("Father Name"));
		   s.setMotherName(rs.getString("Mother Name"));
		   
	   }
   	    else
   	    {
   	    	throw new NoStudentException();
   	    }
	   return s;
	}
	//Updating data of saved single student from database
	
	//Since education info is being modified on basis contact no, it should also be passed (in case user edits it also)
	public void update(String oldContactNo) throws SQLException
	{
		try
		{
		   System.out.println("Creating statement to update Project ...");
		   Connection conn = CV_DBConnection.getConnection();
		   Statement stmt = conn.createStatement();
		   String sql;
		   
		   //Query Code for updating
		   sql = "UPDATE cvinfosaver.student SET " +
		    "`Name` = '" +this.studentName  +"'"+
			",`Gender` ='" + this.gender+"'"+
		    ",`Contact No` ='"+ this.studentContactNo+"'"+
		    ",`Address` ='"+ this.studentAddress+"'" +
		    ",`Email ID`='"+ this.studentEmailId+"'"+
		    ",`Date of Birth` ='"+ this.studentDateOfBirth+"'"+ 
		    ",`Hobbies` ='"+ this.studentHobbies+"'" +
		    ",`Father Name` ='"+ this.fatherName+"'" +
		    ",`Mother Name` ='"+ this.motherName+"' "  ;
		    
		    sql+="WHERE `Contact No` = '" + oldContactNo+ "';"	;
		   
		   stmt.execute(sql);
		}
		catch(SQLException | ClassNotFoundException err)
		{
			System.out.println(err.getMessage());
			throw new SQLException(err.getMessage());  
		}
	}
	
	//Getter and Setter Functions
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStudentContactNo() {
		return studentContactNo;
	}
	public void setStudentContactNo(String studentContactNo) {
		this.studentContactNo = studentContactNo;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}
	public String getStudentEmailId() {
		return studentEmailId;
	}
	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}
	public String getStudentDateOfBirth() {
		return studentDateOfBirth;
	}
	public void setStudentDateOfBirth(String studentDateOfBirth) {
		this.studentDateOfBirth = studentDateOfBirth;
	}
	public String getStudentHobbies() {
		return studentHobbies;
	}

	public void setStudentHobbies(String studentHobbies) {
		this.studentHobbies = studentHobbies;
	}

	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public Education getOverallEducation() {
		return overallEducation;
	}

	public CVData getDataCourse() {
		data = new Course();
		return data;
	}
	public CVData getDataProject() {
		data = new Project();
		return data;
	}
	public CVData getDataInternship() {
		data = new Internship();
		return data;
	}
	public CVData getDataWorkshop() {
		data = new Workshop();
		return data;
	}
	public CVData getDataAchievement() {
		data = new Achievement();
		return data;
	}
	public CVData getDataMiscellaneous() {
		data = new Miscellaneous();
		return data;
	}

	public void setOverallEducation(Education edu) {
		// TODO Auto-generated method stub
		this.overallEducation = edu;
	}


}
	
