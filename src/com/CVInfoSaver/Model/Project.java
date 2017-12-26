package com.CVInfoSaver.Model;

public class Project extends CVData
{
	private String projectTitle ;
	private String projectDescription ; 
	private String projectMentor ; 
	private String projectDuration;
	private int noOfTeamMembers ; 
	//NonParameterized Constructor
	public Project()
	{
	}
	
	//Parameterized Constructor
	public Project(int semester , boolean star , String title  ,  String description , String mentor , String duration , int totMembers )
	{
		super(semester,star);
		this.projectTitle= title ; 
		this.projectDescription = description;
		this.projectMentor = mentor ;
		this.projectDuration = duration ;
		this.noOfTeamMembers= totMembers;
	}
	
	//Getter and Setter Functions
	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectMentor() {
		return projectMentor;
	}

	public void setProjectMentor(String projectMentor) {
		this.projectMentor = projectMentor;
	}

	public String getProjectDuration() {
		return projectDuration;
	}

	public void setProjectDuration(String projectDuration) {
		this.projectDuration = projectDuration;
	}

	public int getNoOfTeamMembers() {
		return noOfTeamMembers;
	}

	public void setNoOfTeamMembers(int noOfTeamMembers) {
		this.noOfTeamMembers = noOfTeamMembers;
	}
}
