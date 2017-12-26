package com.CVInfoSaver.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.CVInfoSaver.control.CourseFocusListener;


public class panelCourse extends JPanel{

	private JLabel lblSemester = new JLabel();
	private JLabel lblCourseNo = new JLabel();
	private JLabel lblCourseName = new JLabel();
	private JLabel lblProfessorName = new JLabel();
	private JLabel lblGrade = new JLabel();
	private JLabel lblCourseDescription = new JLabel();
	
	public panelCourse(String semester, String No, String Name,String Prof, String Grade, String Description)
	{
		lblSemester.setText(semester);
		lblCourseNo.setText(No);
		lblCourseName.setText(Name);
		lblProfessorName.setText(Prof);
		lblGrade.setText(Grade);
		lblCourseDescription.setText(Description);
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(820,30));
		this.setLayout(new GridLayout(1,0 , 2, 2));
		
		lblCourseName.setToolTipText(Name);
		lblProfessorName.setToolTipText(Prof);
		lblCourseDescription.setToolTipText(Description);
		
		this.add(lblSemester);
		
		this.add(lblCourseNo);
		
		this.add(lblCourseName);
		
		this.add(lblProfessorName);
		
		this.add(lblGrade);
		
		this.add(lblCourseDescription);
		
		this.addMouseListener(new CourseFocusListener());
		
	}
	
	public String getSemester() {
		return lblSemester.getText();
	}
	
	
	public String getCourseNo() {
		return lblCourseNo.getText();
	}
	
	
	public String getCourseName() {
		return lblCourseName.getText();
	}
	
	
	public String getProfessorName() {
		return lblProfessorName.getText();
	}
	
	
	public String getGrade() {
		return lblGrade.getText();
	}
	
	
	public String getCourseDescription() {
		return lblCourseDescription.getText();
	}
	
	
	
}
