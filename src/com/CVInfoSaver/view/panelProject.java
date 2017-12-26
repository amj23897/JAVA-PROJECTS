package com.CVInfoSaver.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelProject extends JPanel{
	
	private JLabel lblSemester = new JLabel();
	private JLabel lblProjectName = new JLabel();
	private JLabel lblMentorName = new JLabel();
	private JLabel lblProjectDuration = new JLabel();
	private JLabel lblNoOfTeamMembers = new JLabel();
	private JLabel lblProjectDescription = new JLabel();
	
	public panelProject(String semester,String name,String mentor, String duration,String teamSize, String Description)
	{
		lblSemester.setText(semester);
		lblProjectName.setText(name);
		lblMentorName.setText(mentor);
		lblProjectDuration.setText(duration);
		lblNoOfTeamMembers.setText(teamSize);
		lblProjectDescription.setText(Description);
		
		this.setLayout(new GridLayout(0, 2, 2, 2));
		
		this.add(new JLabel("Semester: "));
		this.add(lblSemester);
		this.add(new JLabel("Project Name: "));
		this.add(lblProjectName);
		this.add(new JLabel("Mentor Name: "));
		this.add(lblMentorName);
		this.add(new JLabel("Project Duration: "));
		this.add(lblProjectDuration);
		this.add(new JLabel("Team Size: "));
		this.add(lblNoOfTeamMembers);
		this.add(new JLabel("Description: "));
		this.add(lblProjectDescription);
		
//		this.addMouseListener(new StudentFocusListner());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	public String getProjectName() {
		return lblProjectName.getText();
	}
	
	public String getMentorName() {
		return lblMentorName.getText();
	}
	
	public String getProjectDuration() {
		return lblProjectDuration.getText();
	}
	
	public String getNoOfTeamMembers() {
		return lblNoOfTeamMembers.getText();
	}

	public String getProjectDescription() {
		return lblProjectDescription.getText();
	}
}
