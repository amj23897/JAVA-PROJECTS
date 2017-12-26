 package com.CVInfoSaver.Model;

public class Achievement extends CVData
{
	private String achievementDescription;		//user is expected to input all details in this
	private String achievementDate;		//at least month and year expected
	private boolean certifiedORAwarded ; 	//is this achievement certified or awarded
	
	//NonParameterized Constructor
	public Achievement() 
	{	
	}
	
	//Parameterized Constructor
	public Achievement(int semester , boolean star ,String info , String date , boolean certOrAward )
	{
		super(semester,star);
		this.achievementDescription = info ;
		this.achievementDate = date ;
		this.certifiedORAwarded = certOrAward ;
	}
	
	//Getter and Setter Functions
	public String getAchievementDescription() {
		return achievementDescription;
	}

	public void setAchievementDescription(String achievementDescription) {
		this.achievementDescription = achievementDescription;
	}

	public String getAchievementDate() {
		return achievementDate;
	}

	public void setAchievementDate(String achievementDate) {
		this.achievementDate = achievementDate;
	}

	public boolean isCertifiedORAwarded() {
		return certifiedORAwarded;
	}

	public void setCertifiedORAwarded(boolean certifiedORAwarded) {
		this.certifiedORAwarded = certifiedORAwarded;
	}
}
