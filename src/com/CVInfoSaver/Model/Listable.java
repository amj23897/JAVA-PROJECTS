package com.CVInfoSaver.Model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Listable 
{
	
	ArrayList fetchRecords(boolean star) throws SQLException, Exception ;
	ArrayList fetchRecords(int semester ,boolean star) throws SQLException, Exception ;
	void addRecord(CVData data) throws SQLException ;
	void updateRecord(CVData data , String parameter)  throws SQLException ;
	void deleteRecord(String parameter) throws SQLException ;
}
