package com.CVInfoSaver.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelWorkshop extends JPanel{
	
	private JLabel lblSemester = new JLabel();
	private JLabel lblWorkshopTitle = new JLabel();
	private JLabel lblWorkshopTeacher = new JLabel();
	private JLabel lblWorkshopOrganizer = new JLabel();
	private JLabel lblWorkshopDate = new JLabel();
	private JLabel lblCertified = new JLabel();
	private JLabel lblWorkshopDescription = new JLabel();
	
	public panelWorkshop(String semester,String title,String teacher, String organizer,String date,String certified, String description)
	{
		lblSemester.setText(semester);
		lblWorkshopTitle.setText(title);
		lblWorkshopTeacher.setText(teacher);
		lblWorkshopOrganizer.setText(organizer);
		lblWorkshopDate.setText(date);
		lblCertified.setText(certified);
		lblWorkshopDescription.setText(description);
		
		this.setLayout(new GridLayout(0, 2, 2, 2));
		
		this.add(new JLabel("Semester: "));
		this.add(lblSemester);
		this.add(new JLabel("Workshop Title: "));
		this.add(lblWorkshopTitle);
		this.add(new JLabel("Organizer: "));
		this.add(lblWorkshopOrganizer);
		this.add(new JLabel("Teacher: "));
		this.add(lblWorkshopTeacher);
		this.add(new JLabel("Date: "));
		this.add(lblWorkshopDate);
		this.add(new JLabel("Certified: "));
		this.add(lblCertified);
		this.add(new JLabel("Description: "));
		this.add(lblWorkshopDescription);
		
//		this.addMouseListener(new StudentFocusListner());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	public String getWorkshopTitle() {
		return lblWorkshopTitle.getText();
	}
	
	public String getWorkshopOrganizer() {
		return lblWorkshopOrganizer.getText();
	}
	
	public String getWorkshopTeacher() {
		return lblWorkshopTeacher.getText();
	}
	
	public String getWorkshopDate() {
		return lblWorkshopDate.getText();
	}
	
	public String getCertified() {
		return lblCertified.getText();
	}

	public String getWorkshopDescription() {
		return lblWorkshopDescription.getText();
	}

	

}
