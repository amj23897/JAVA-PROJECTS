package com.CVInfoSaver.Model;

public abstract class CVData implements Starrable
{
	private int semester ;
	private boolean star ;
	
	//NonParameterized Constructor
	public CVData()
	{
	}
	
	//Parameterized Constructor
	public CVData(int semester , boolean star)
	{
		this.semester = semester;
		this.star = star ;
	}
	@Override
	public void markStar() 
	{
		this.star=true;
	}
	
	//Getter and Setter Functions
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	public boolean isStarred() {
		return star;
	}
}
