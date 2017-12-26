package com.CVInfoSaver.Model;

public class Internship extends CVData
{
	private String organizationName;
	private String internshipPeriod;
	private String internshipDescription;
	
	//NonParameterized Constructor
	public Internship()
	{
		
	}
	
	//Parameterized Constructor
	public Internship(int semester ,boolean star, String name, String period, String details )
	{
		super(semester, star);
		this.setOrganizationName(name);
		this.setInternshipPeriod(period);
		this.setInternshipDescription(details);
	}
	
	//Getter and Setter Functions
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getInternshipPeriod() {
		return internshipPeriod;
	}

	public void setInternshipPeriod(String internshipPeriod) {
		this.internshipPeriod = internshipPeriod;
	}

	public String getInternshipDescription() {
		return internshipDescription;
	}

	public void setInternshipDescription(String internshipDescription) {
		this.internshipDescription = internshipDescription;
	}

}