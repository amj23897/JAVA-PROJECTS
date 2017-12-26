package com.CVInfoSaver.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelAchievement extends JPanel{
	
	private JLabel lblSemester = new JLabel();
	private JLabel lblAchievementDate = new JLabel();
	private JLabel lblAchievementDescription = new JLabel();
	private JLabel lblCertifiedOrAwarded = new JLabel();
	
	public panelAchievement(String semester,String date, String Description, String certified)
	{
		lblSemester.setText(semester);
		lblAchievementDate.setText(date);
		lblAchievementDescription.setText(Description);
		lblCertifiedOrAwarded.setText(certified);
		
		this.setLayout(new GridLayout(0, 2, 2, 2));
		
		this.add(new JLabel("Semester: "));
		this.add(lblSemester);
		this.add(new JLabel("Achievement Date: "));
		this.add(lblAchievementDate);
		this.add(new JLabel("Certified/Awarded: "));
		this.add(lblCertifiedOrAwarded);
		this.add(new JLabel("Description: "));
		this.add(lblAchievementDescription);
		
//		this.addMouseListener(new StudentFocusListner());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	public String getAchievementDate() {
		return lblAchievementDate.getText();
	}
	
	public String getAchievementDescription() {
		return lblAchievementDescription.getText();
	}
	
	public String getCertifiedOrAwarded() {
		return lblCertifiedOrAwarded.getText();
	}

}
