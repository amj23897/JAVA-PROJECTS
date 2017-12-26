package com.CVInfoSaver.Model;

public class Course extends CVData
{
	private String courseNo ;
	private String courseName ;
	private String courseGrade ;
	private String courseProf ;
	private String courseDescription ;
	
	//NonParameterized Constructor
	public Course()
	{
	}
	
	//Parameterized Constructor
	public Course(int semester , boolean star ,String no , String name, String grade, String prof, String description)
	{
		super(semester,star);
		this.courseNo = no;
		this.courseName = name ;
		this.courseGrade = grade ;
		this.courseProf = prof ;
		this.courseDescription=description ;
	}
	//Getter and Setter Functions
	public String getCourseNo() {
		return courseNo;
	}

	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	
	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseGrade() {
		return courseGrade;
	}

	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	public String getCourseProf() {
		return courseProf;
	}

	public void setCourseProf(String courseProf) {
		this.courseProf = courseProf;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
}
