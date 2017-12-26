package com.CVInfoSaver.Model;

//this class contains activities like other activities and extra curricular activities
public class Miscellaneous extends CVData
{
	private String description ;
	private String date;
	
	//NonParameterized Constructor
	public Miscellaneous()
	{
	}
	
	//Parameterized Constructor
	public Miscellaneous(int semester , String description , String date , boolean star)
	{
		super(semester, star);
		this.description = description ; 
		this.date = date ;
	}
	
	//Getter and Setter Functions
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
}
