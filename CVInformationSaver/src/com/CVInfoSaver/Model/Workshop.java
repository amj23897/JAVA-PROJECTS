package com.CVInfoSaver.Model;

public class Workshop extends CVData
{
	private String workshopTitle;
	private String workshopTeacher;
	private String workshopOrganizer;
	private String workshopDate;
	private String workshopDescription;
	private boolean Certified ;
	
	//NonParameterized Constructor
	public Workshop() 
	{	
	}
	
	//Parameterized Constructor
	public Workshop(int semester , boolean star ,String title , String teacher , String organizer ,String date, boolean isCertified)
	{
		super(semester,star);
		this.workshopTitle = title;
		this.workshopTeacher = teacher;
		this.workshopOrganizer = organizer;
		this.workshopDate = date;
		this.Certified = isCertified;
	}
	
	//Getter and Setter Functions
	public String getWorkshopTitle() {
		return workshopTitle;
	}

	public void setWorkshopTitle(String workshopTitle) {
		this.workshopTitle = workshopTitle;
	}

	public String getWorkshopTeacher() {
		return workshopTeacher;
	}

	public void setWorkshopTeacher(String workshopTeacher) {
		this.workshopTeacher = workshopTeacher;
	}

	public String getWorkshopOrganizer() {
		return workshopOrganizer;
	}

	public void setWorkshopOrganizer(String workshopOrganizer) {
		this.workshopOrganizer = workshopOrganizer;
	}

	public String getWorkshopDate() {
		return workshopDate;
	}

	public void setWorkshopDate(String workshopDate) {
		this.workshopDate = workshopDate;
	}

	public String getWorkshopDescription() {
		return workshopDescription;
	}

	public void setWorkshopDescription(String workshopDescription) {
		this.workshopDescription = workshopDescription;
	}

	public boolean isCertified() {
		return Certified;
	}

	public void setCertified(boolean isCertified) {
		this.Certified = isCertified;
	}
}
